package id.ac.ui.cs.advprog.userservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private Register register;

    @BeforeEach
    public void setUp() {
        register = new Register(new UserRepository());
    }

    @Test
    public void testRegisterUser_Success() {
        // Given
        String username = "testuser";
        String password = "password123";
        String role = "customer";
        RegisterRequest registerRequest = new RegisterRequest(username, password, role);

        // When
        User registeredUser = register.registerUser(registerRequest);

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
        RegisterRequest registerRequest = new RegisterRequest(null, password, role);

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> {
            register.registerUser(registerRequest);
        });
    }

    @Test
    public void testRegisterUser_NullPassword() {
        // Given
        String username = "testuser";
        String role = "customer";
        RegisterRequest registerRequest = new RegisterRequest(username, null, role);

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> {
            register.registerUser(registerRequest);
        });
    }

    @Test
    public void testRegisterUser_NullRole() {
        // Given
        String username = "testuser";
        String password = "password123";
        RegisterRequest registerRequest = new RegisterRequest(username, password, null);

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> {
            register.registerUser(registerRequest);
        });
    }

    @Test
    public void testRegisterUser_InvalidRole() {
        // Given
        String username = "testuser";
        String password = "password123";
        String invalidRole = "invalid_role";
        RegisterRequest registerRequest = new RegisterRequest(username, password, invalidRole);

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> {
            register.registerUser(registerRequest);
        });
    }
}
