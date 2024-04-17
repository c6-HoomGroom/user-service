package id.ac.ui.cs.advprog.userservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("testuser", "password123");
    }

    @Test
    public void testGetUsername() {
        assertEquals("testuser", user.getUsername());
    }

    @Test
    public void testSetUsername() {
        user.setUsername("newuser");
        assertEquals("newuser", user.getUsername());
    }

    @Test
    public void testGetPassword() {
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testSetPassword() {
        user.setPassword("newpassword");
        assertEquals("newpassword", user.getPassword());
    }

    @Test
    public void testSetUsername_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            user.setUsername(null);
        });
    }

    @Test
    public void testSetPassword_Null() {
        assertThrows(IllegalArgumentException.class, () -> {
            user.setPassword(null);
        });
    }
}
