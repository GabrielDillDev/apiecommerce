package apiecommerce.apiecommerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import apiecommerce.apiecommerce.dto.AuthenticationRequest;
import apiecommerce.apiecommerce.dto.AuthenticationResponse;
import apiecommerce.apiecommerce.dto.RegisterRequest;
import apiecommerce.apiecommerce.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    private final AuthService authService;

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public AuthenticationResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}
