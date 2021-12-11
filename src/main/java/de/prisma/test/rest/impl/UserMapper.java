package de.prisma.test.rest.impl;

import de.prisma.test.repo.entity.User;
import de.prisma.test.rest.api.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto modelToDto(User model);
    User dtoToModel(UserDto dto);
}