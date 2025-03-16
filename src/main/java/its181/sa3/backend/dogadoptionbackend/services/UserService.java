package its181.sa3.backend.dogadoptionbackend.services;

import its181.sa3.backend.dogadoptionbackend.model.users.User;
import its181.sa3.backend.dogadoptionbackend.model.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String email, String password, String role) {
        User user = new User();
        user.setPassword(password);
        user.setRole(role);

        return userRepository.save(user);
    }

    public java.util.Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
