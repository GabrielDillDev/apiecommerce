package apiecommerce.apiecommerce.controller;

import apiecommerce.apiecommerce.model.User;
import apiecommerce.apiecommerce.service.UserService;
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

    @PostMapping
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user){
        user.setId(id);
        return userService.save(user);
    }

    @PatchMapping("/{id}")
    public User patch(@PathVariable Long id, @RequestBody User user){
        return userService.patch(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }
}
