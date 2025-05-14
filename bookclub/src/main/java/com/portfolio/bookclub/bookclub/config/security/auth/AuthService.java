package com.portfolio.bookclub.bookclub.config.security.auth;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.portfolio.bookclub.bookclub.config.security.jwt.JwtService;
import com.portfolio.bookclub.bookclub.persistance.entity.User;
import com.portfolio.bookclub.bookclub.persistance.entity.VerificationToken;
import com.portfolio.bookclub.bookclub.persistance.entity.enums.Role;
import com.portfolio.bookclub.bookclub.persistance.repository.UserRepo;
import com.portfolio.bookclub.bookclub.persistance.repository.VerificationTokenRepo;

import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepo userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JavaMailSender mailSender;
    private final VerificationTokenRepo tokenRepo;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user =  userRepository.findByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    @Transactional
    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.valueOf(request.getRole().toUpperCase()))
                .build();
        userRepository.save(user);

        setVerificationToken(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }

    @Transactional
    public void verifyAccount(String token) {
        VerificationToken vt = tokenRepo.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Token inválido o expirado"));

        if (vt.getExpiryDate().isBefore(LocalDateTime.now()))
            throw new RuntimeException("Token expirado");

        User user = vt.getUser();
        user.setEnabled(true);
        userRepository.save(user);
        tokenRepo.delete(vt);
    }

    @Transactional
    public void resendVerification(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email no registrado"));

        if (user.isEnabled())
            throw new RuntimeException("La cuenta ya está verificada");
        
        setVerificationToken(user);
    }

    private void setVerificationToken(User user) {
        tokenRepo.deleteByUserId(user.getId());
        String token = UUID.randomUUID().toString();
        VerificationToken vt = new VerificationToken();
        vt.setToken(token);
        vt.setUser(user);
        vt.setExpiryDate(LocalDateTime.now().plusHours(24));
        tokenRepo.save(vt);

        sendMessage(user, token);
    }

    private void sendMessage(User user, String token) {
        String link = "http://localhost:8080/auth/verify?token=" + token;

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Email Verification");
        message.setText("Hola " + user.getUsername() + ",\n\n" +
                "Haz clic aquí para activar tu cuenta:\n" + link + "\n\n" +
                "Este enlace expira en 24 horas.");
        mailSender.send(message);
    }
}