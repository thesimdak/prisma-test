package de.prisma.test.service.impl;

import de.prisma.test.repo.UserRepository;
import de.prisma.test.repo.entity.User;
import de.prisma.test.model.UserFilterQuery;
import de.prisma.test.service.api.UserService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findUsers(UserFilterQuery userFilterQuery) {
        return userRepository.findUsers(userFilterQuery);
    }
}
