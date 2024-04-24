package id.ac.ui.cs.advprog.userservice.repository;

import org.springframework.stereotype.Repository;

import id.ac.ui.cs.advprog.userservice.model.User;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, User> usersByEmail;

    public UserRepository() {
        this.usersByEmail = new HashMap<>();
    }

    public User findByEmail(String email) {
        return usersByEmail.get(email);
    }

    public void save(User user) {
        usersByEmail.put(user.getEmail(), user);
    }
}
