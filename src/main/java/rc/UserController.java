package rc;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/id")
    public User getById(String id) {
        return userRepository.findById(id).get();
    }

    @PostMapping()
    public User update(@RequestBody User user) {
        return userRepository.save(user);
    }
}
