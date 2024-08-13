package com.isaiah.services;

import com.isaiah.main.objects.User;
import com.isaiah.main.repositories.UserRepository;
import com.isaiah.main.services.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Mock // Creates a mock version of UserRepository
    private UserRepository userRepository;

    @InjectMocks // Injects the mock UserRepository into UserService
    private UserService userService;

    private User user;

    @BeforeEach // This method runs before each test to set up the common test data
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes the mocks
        user = new User(); // Creates a new User object
        user.setUsername("testuser");
        user.setPassword("testPassword");
        user.setEmail("testuser@example.com");
    }

    @Test
    void createUser_shouldCreateUserIfNotExists() {
        user.setUsername("test4");

        /* Arrange: 
         * Simulates the scenario where the username "test4" does not exist in the database.
         * The mock repository will return an empty Optional when findByUsername is called.
         */
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.empty());

        // Act: Calls the createUser method to attempt to create the user
        userService.createUser(user);

        /* Assert:
         * Verifies that the save method on the repository was called exactly once with the user object as the argument.
         * This ensures that the user was saved to the database.
         */
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void createUser_shouldThrowExceptionIfUserExists() {
        user.setUsername("test4");

        /* Arrange:
         * Simulates the scenario where the username "test4" already exists in the database.
         * The mock repository will return an Optional containing the user object.
         */
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.of(user));

        /* Act & Assert:
         * The assertThrows method checks if the createUser method throws a RuntimeException
         * when trying to create a user with an existing username.
         * Also verifies that the save method was not called.
         */
        assertThrows(RuntimeException.class, () -> userService.createUser(user));
        verify(userRepository, times(0)).save(any(User.class));
    }

    @Test
    void readUserByUserID_shouldReturnUserIfExists() {
        user.setUserID(26);

        /* Arrange:
         * Simulates the scenario where a user with ID 26 exists in the database.
         * The mock repository will return an Optional containing the user object.
         */
        when(userRepository.findByUserID(user.getUserID())).thenReturn(Optional.of(user));

        // Act: Calls the readUserByUserID method to retrieve the user
        User foundUser = userService.readUserByUserID(user.getUserID());

        /* Assert:
         * Checks if the returned user is not null and that the username matches the expected value.
         */
        assertNotNull(foundUser);
        assertEquals(user.getUsername(), foundUser.getUsername());
    }

    @Test
    void readUserByUserID_shouldReturnNullIfNotExists() {
        user.setUserID(1);

        /* Arrange:
         * Simulates the scenario where a user with ID 1 does not exist in the database.
         * The mock repository will return an empty Optional.
         */
        when(userRepository.findByUserID(user.getUserID())).thenReturn(Optional.empty());

        // Act: Calls the readUserByUserID method to attempt to retrieve the user
        User foundUser = userService.readUserByUserID(user.getUserID());

        /* Assert:
         * Checks if the returned user is null, indicating that no user with the given ID exists.
         */
        assertNull(foundUser);
    }
    
    @Test
    void updateUser_shouldUpdateExistingUser() {
        user.setUserID(26);
        user.setUsername("updatedTestUsername");

        // Act: Calls the updateUser method to update the user's details
        userService.updateUser(user);

        /* Assert:
         * Verifies that the save method was called exactly once with the updated user object.
         * This ensures that the user details were updated in the database.
         */
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void deleteUserByUserID_shouldDeleteUserIfExists() {
        user.setUserID(26);

        // Act: Calls the deleteUserByUserID method to delete the user
        userService.deleteUserByUserID(user.getUserID());

        /* Assert:
         * Verifies that the deleteByUserID method was called exactly once with the correct user ID.
         * This ensures that the user was deleted from the database.
         */
        verify(userRepository, times(1)).deleteByUserID(user.getUserID());
    }
}
