package id.ac.ui.cs.advprog.userservice.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testLogin_Success() {
        // Given
        String username = "testuser";
        String password = "password123";
        String role = "customer";
        User user = new User(username, password, role);

        // When/Then
        assertTrue(user.login(username, password));
    }

    @Test
    public void testLogin_Failure_WrongUsername() {
        // Given
        String username = "testuser";
        String password = "password123";
        String role = "customer";
        User user = new User(username, password, role);

        // When/Then
        assertFalse(user.login("wrongusername", password));
    }

    @Test
    public void testLogin_Failure_WrongPassword() {
        // Given
        String username = "testuser";
        String password = "password123";
        String role = "customer";
        User user = new User(username, password, role);

        // When/Then
        assertFalse(user.login(username, "wrongpassword"));
    }
}
