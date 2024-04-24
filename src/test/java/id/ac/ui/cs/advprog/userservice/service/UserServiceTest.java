package id.ac.ui.cs.advprog.userservice.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @InjectMocks
    UserService userService;

    @Mock
    UserRepository UserRepository

    @Test
    public void testRegisterUser() {
        // Given
        UserRegistrationRequest request = new UserRegistrationRequest("John", "Doe", "john@example.com", "password", "ROLE_USER");
        User user = new User("John", "Doe", "john@example.com", "password", "ROLE_USER");

        // When
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Then
        User registeredUser = userService.register(request, "ROLE_USER");
        assertThat(registeredUser).isNotNull();
        assertThat(registeredUser.getId()).isNotNull(); // Assuming ID is generated during registration
        assertThat(registeredUser.getRole()).isEqualTo("ROLE_USER");
    }

    @Test
    public void testLoginUser() {
        // Given
        String email = "john@example.com";
        String password = "password";
        String role = "ROLE_USER";
        User user = new User("John", "Doe", email, password, role);
        UserLoginRequest request = new UserLoginRequest(email, password);

        // When
        when(userRepository.findByEmail(email)).thenReturn(user);

        // Then
        User loggedInUser = userService.login(request);
        assertThat(loggedInUser).isNotNull();
        assertThat(loggedInUser.getEmail()).isEqualTo(email);
        assertThat(loggedInUser.getRole()).isEqualTo(role);
    }
}
