package its181.sa3.backend.dogadoptionbackend.controller;

import its181.sa3.backend.dogadoptionbackend.model.users.User;
import its181.sa3.backend.dogadoptionbackend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestParam String email,
                                         @RequestParam String password,
                                         @RequestParam String role) {
        User user = userService.registerUser(email, password, role);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/check-role")
    public ResponseEntity<String> checkRole(@RequestParam String email) {
        return userService.getUserByEmail(email)
                .map(user -> ResponseEntity.ok("Role: " + user.getRole()))
                .orElse(ResponseEntity.badRequest().body("User not found"));
    }
}
