package apiecommerce.apiecommerce.service;

import apiecommerce.apiecommerce.model.User;
import apiecommerce.apiecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user){
        return userRepository.save(user);
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
    
        if (data.getPassword() != null) {
            user.setPassword(data.getPassword());
        }

        return userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }
}
