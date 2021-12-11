package de.prisma.test.service.impl;

import de.prisma.test.model.UserFilterQuery;
import de.prisma.test.repo.UserRepository;
import de.prisma.test.repo.entity.User;
import de.prisma.test.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

public class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    UserServiceImpl userService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void findUsers_shouldReturnUsers_whenRepositoryReturnsUsers() {
        UserFilterQuery userFilterQuery = new UserFilterQuery();
        // Prepare
        User user = new User();
        List<User> mockUsers = Collections.singletonList(user);
        Mockito.when(userRepository.findUsers(userFilterQuery)).thenReturn(mockUsers);

        // Execute
        List<User> users = userService.findUsers(userFilterQuery);

        //Asserts
        Assertions.assertEquals(1, users.size());
        Assertions.assertEquals(user, users.get(0));
    }

    @Test
    void findUsers_shouldReturnEmptyList_whenRepositoryReturnsEmptyList() {
        UserFilterQuery userFilterQuery = new UserFilterQuery();
        // Prepare
        List<User> mockUserList = Collections.emptyList();
        Mockito.when(userRepository.findUsers(userFilterQuery)).thenReturn(mockUserList);

        // Execute
        List<User> users = userService.findUsers(userFilterQuery);

        //Asserts
        Assertions.assertTrue(users.isEmpty());
    }

}
