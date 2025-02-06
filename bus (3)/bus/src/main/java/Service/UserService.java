package com.example.bus.Service;

import com.example.bus.DTO.UserDTO;
import com.example.bus.Entity.User;
import com.example.bus.Entity.Role;
import com.example.bus.Repository.UserRepository;
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
                new UserDTO(user.getUsername(), null, user.getRole().name())
        ).collect(Collectors.toList());
    }

    public UserDTO getUserById(Integer id) {
        return userRepository.findById(id).map(user ->
                new UserDTO(user.getUsername(), null, user.getRole().name())
        ).orElse(null);
    }

    public UserDTO createUser(String username, String password, String role) {
        // Kiểm tra nếu username đã tồn tại
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.valueOf(role));

        userRepository.save(user);

        return new UserDTO(user.getUsername(), null, user.getRole().name());
    }

    public void deleteUser(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("User not found");
        }
        userRepository.deleteById(id);
    }
}
