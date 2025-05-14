package com.portfolio.bookclub.bookclub.config.security.auth;

import lombok.RequiredArgsConstructor;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.login(request));
    }
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }
    @GetMapping(value = "verify")
    public ResponseEntity<?> verify(@RequestParam String token) {
        authService.verifyAccount(token);
        return ResponseEntity.ok("Account verified successfully");
    }
    @PostMapping(value = "resend-verification")
    public ResponseEntity<?> resend(@RequestBody Map<String, String> body){
        authService.resendVerification(body.get("email"));
        return ResponseEntity.ok("Verification email resent successfully");
    }
    
}
