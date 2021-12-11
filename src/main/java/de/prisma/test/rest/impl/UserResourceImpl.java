package de.prisma.test.rest.impl;

import de.prisma.test.repo.entity.User;
import de.prisma.test.rest.api.UserResource;
import de.prisma.test.rest.api.dto.UserDto;
import de.prisma.test.rest.api.dto.UserFilterQueryDto;
import de.prisma.test.model.UserFilterQuery;
import de.prisma.test.service.api.UserService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserResourceImpl implements UserResource {

    private final UserService userService;
    private final UserFilterQueryMapper userFilterQueryMapper;
    private final UserMapper userMapper;

    public UserResourceImpl(UserService userService,
                            UserFilterQueryMapper userFilterQueryMapper,
                            UserMapper userMapper) {
        this.userService = userService;
        this.userFilterQueryMapper = userFilterQueryMapper;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getUsers(UserFilterQueryDto userFilterQueryDto) {
        UserFilterQuery userFilterQuery = userFilterQueryMapper.dtoToModel(userFilterQueryDto);
        List<User> users = userService.findUsers(userFilterQuery);
        return users.stream().map(userMapper::modelToDto).collect(Collectors.toList());
    }
}
