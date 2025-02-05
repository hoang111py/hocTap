package Service;

import DTO.UserDTO;
import Entity.User;
import Entity.Role;
import Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(user ->
                new UserDTO(user.getUsername(), null, user.getRole().name()) // Don't return password
        ).collect(Collectors.toList());
    }

    public UserDTO getUserById(Integer id) {
        return userRepository.findById(id).map(user ->
                new UserDTO(user.getUsername(), null, user.getRole().name()) // Hide password
        ).orElse(null);
    }

    public UserDTO createUser(String username, String password, String role) {
        // Check if username already exists
        if (userRepository.findByUsername(username) != null) {
            return null; // Return null to indicate username is taken
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));  // Encrypt password
        user.setRole(Role.valueOf(role));
        userRepository.save(user);

        return new UserDTO(user.getUsername(), null, user.getRole().name()); // Hide password in response
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
