package id.ac.ui.cs.advprog.userservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RegisterTest {

    private Register register;

    @BeforeEach
    public void setUp() {
        register = new Register(); // Instantiate Register without UserRepository
    }

    @Test
    public void testRegisterUser_Success() {
        // Given
        String username = "testuser";
        String password = "password123";
        String role = "customer";

        // When
        User registeredUser = register.registerUser(new RegisterRequest(username, password, role));

        // Then
        assertNotNull(registeredUser);
        assertEquals(username, registeredUser.getUsername());
        assertEquals(password, registeredUser.getPassword());
        assertEquals(role, registeredUser.getRole());
    }

    @Test
    public void testRegisterUser_NullUsername() {
        // Given
        String password = "password123";
        String role = "customer";

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> {
            register.registerUser(new RegisterRequest(null, password, role));
        });
    }

    @Test
    public void testRegisterUser_NullPassword() {
        // Given
        String username = "testuser";
        String role = "customer";

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> {
            register.registerUser(new RegisterRequest(username, null, role));
        });
    }
}
