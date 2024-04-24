package id.ac.service;

import org.springframework.beans.factory.annotation.Autowired;

import id.ac.ui.cs.advprog.userservice.model.User;

public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User register(UserRegistrationRequest request, String role) {
        // Implement registration logic here
        return null; // Temporary return value
    }

    @Override
    public User login(UserLoginRequest request) {
        // Implement login logic here
        return null; // Temporary return value
    }
}
