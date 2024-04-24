package id.ac.ui.cs.advprog.userservice.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import id.ac.ui.cs.advprog.userservice.model.User;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByEmail() {
        // Given
        User user = new User("John", "Doe", "john@example.com");
        userRepository.save(user);

        // When
        User foundUser = userRepository.findByEmail("john@example.com");

        // Then
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getEmail()).isEqualTo("john@example.com");
    }

    @Test
    public void testFindByNonExistingEmail() {
        // Given
        String nonExistingEmail = "nonexisting@example.com";

        // When & Then
        assertThat(userRepository.findByEmail(nonExistingEmail)).isNull();
    }
}
