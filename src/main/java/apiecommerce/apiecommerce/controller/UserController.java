package apiecommerce.apiecommerce.controller;

import apiecommerce.apiecommerce.dto.UpdatePasswordRequest;
import apiecommerce.apiecommerce.model.User;
import apiecommerce.apiecommerce.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PatchMapping("/{id}")
    public User patch(@PathVariable Long id, @RequestBody User user){
        return userService.patch(id, user);
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<Void> updatePassword(
        @PathVariable Long id, 
        @RequestBody UpdatePasswordRequest request){
            
            userService.updatePassword(id, request.getPassword());
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
}
