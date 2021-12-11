package de.prisma.test.service.api;

import de.prisma.test.repo.entity.User;
import de.prisma.test.model.UserFilterQuery;

import java.util.List;

/**
 * Interface for a service for searching users based on a query.
 */
public interface UserService {

    /**
     * Finds all stored user matching a filer.
     * @param userFilterQuery filter
     * @return list of users matching a filter
     */
    List<User> findUsers(UserFilterQuery userFilterQuery);

}
