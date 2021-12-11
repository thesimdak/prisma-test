package de.prisma.test.rest.impl;

import de.prisma.test.rest.api.dto.UserFilterQueryDto;
import de.prisma.test.model.UserFilterQuery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserFilterQueryMapper {
    UserFilterQueryDto modelToDto(UserFilterQuery model);
    UserFilterQuery dtoToModel(UserFilterQueryDto dto);
}