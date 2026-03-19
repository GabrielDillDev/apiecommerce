package apiecommerce.apiecommerce.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import apiecommerce.apiecommerce.dto.AuthenticationRequest;
import apiecommerce.apiecommerce.dto.AuthenticationResponse;
import apiecommerce.apiecommerce.dto.RegisterRequest;
import apiecommerce.apiecommerce.model.User;
import apiecommerce.apiecommerce.repository.UserRepository;
import apiecommerce.apiecommerce.security.JwtService;


@Service
@RequiredArgsConstructor
public class AuthService {
    
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse login(AuthenticationRequest request) {
        
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(), 
                request.getPassword()
            )
        );

        String token = jwtService.generateToken(request.getEmail());

        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse register(RegisterRequest request) {
        
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("USER");

        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail());

        return new AuthenticationResponse(token);
    }
}
