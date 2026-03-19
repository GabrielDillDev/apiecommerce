package apiecommerce.apiecommerce.service;

import apiecommerce.apiecommerce.model.User;
import apiecommerce.apiecommerce.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User patch(Long id, User data){
        User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("User não encontrado"));

        if (data.getName() != null) {
            user.setName(data.getName());
        }

        if (data.getEmail() != null) {
            user.setEmail(data.getEmail());
        }

        return userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public void updatePassword(Long id, String newPassword){
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User não encontrado"));

        user.setPassword(passwordEncoder.encode(newPassword));

        userRepository.save(user);
    }
}
