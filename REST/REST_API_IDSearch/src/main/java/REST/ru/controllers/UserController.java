package REST.ru.controllers;

import REST.ru.models.entitys.users.User;
import REST.ru.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//@Tag(name = "User Controller", description = "User Operations")

@RestController
@RequestMapping(path = "api/user")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId) {
        User user = userService.findById(userId);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> editUser(@PathVariable long userId, @RequestBody User newUser) {
        User updatedUser = userService.edit(userId, newUser);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {
        userService.delete(userId);
        return ResponseEntity.ok("User with id=" + userId + " deleted successfully");
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAllUsers(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userService.getUsers(pageable));
    }

    @GetMapping("/search")
    public ResponseEntity<Page<User>> getUsersByUsername(@RequestParam String username,
                                                         @RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userService.getUsersSearchByUsername(username, pageable));
    }

    @GetMapping("/find/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable long userId) {
        User user = userService.findUserById(userId);
        return ResponseEntity.ok(user);
    }
}
