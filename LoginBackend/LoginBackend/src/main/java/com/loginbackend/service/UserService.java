package com.loginbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginbackend.entity.User;
import com.loginbackend.repository.UserRepository;
// import com.loginbackend.security.JwtTokenProvider; // Adjust the package path if necessary

@Service
public class UserService {
    
    private final UserRepository userRepository;
    // private final passwordEncoder passwordEncoder;
    // private final JwtTokenProvider jwtTokenProvider;
    // private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        // this.passwordEncoder = passwordEncoder;
        // this.jwtTokenProvider = jwtTokenProvider;
    }

    public boolean isEmailRegistered(String email) {
        return userRepository.existsByEmail(email);
    }
    public boolean isNameRegistered(String name) {
        return userRepository.existsByName(name);
    }
    public User registerUser(User user) {
        // Hash the password before saving
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    public boolean validateUser(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            // return passwordEncoder.matches(password, user.getPassword());
            return true; // Placeholder for actual password validation logic
        }
        return false;
    }
    public String generateToken(User user) {
        // return jwtTokenProvider.generateToken(user.getEmail());
        return "token"; // Placeholder for actual token generation logic
    }   
    // public String refreshToken(String token) {
    //     // return jwtTokenProvider.refreshToken(token);
    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null && validateUser(email, password)) {
            // String token = generateToken(user);
            // return new LoginResponse(user, token);
            return user; // Placeholder for actual login response logic
        }
        return null;
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


}
