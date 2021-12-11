package de.prisma.test.rest.api;

import de.prisma.test.rest.api.dto.UserDto;
import de.prisma.test.rest.api.dto.UserFilterQueryDto;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public interface UserResource {

    @GET
    List<UserDto> getUsers(@BeanParam UserFilterQueryDto userFilterQueryDto) ;
}
