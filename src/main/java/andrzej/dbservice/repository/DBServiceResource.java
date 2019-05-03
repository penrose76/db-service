package andrzej.dbservice.repository;

import andrzej.dbservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    public DBServiceResource(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/{email}")
    private List<String> getUsers(@PathVariable("email") final String email) {
        return getUsersByUsername(email);
    }

    @GetMapping("/all")
    private List<User> getAll() {
        return getAllUsers();
    }

    @PostMapping("/adduser")
    private List<String> addUser(@RequestBody final User user) {
        System.out.println(user);
        userService.saveUser(user);
        return getUsersByUsername(user.getEmail());
    }

    private List<String> getUsersByUsername(@PathVariable("email") final String email) {
        return userRepository.findByEmail(email).stream().map(User::getLastName).collect(Collectors.toList());
    }

    private List<User> getAllUsers() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }
}
