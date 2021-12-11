package de.prisma.test.repo;

import de.prisma.test.repo.entity.User;
import de.prisma.test.model.UserFilterQuery;

import java.util.List;

/**
 * Repository used for writing and retrieving users to/from database.
 */
public interface UserRepository {

    /**
     * Finds all users matching the query criteria.
     * @param userFilterQuery filter for a query
     * @return list of user entities matching a filter
     */
    List<User> findUsers(UserFilterQuery userFilterQuery);

    /**
     * Stores user in the db.
     * @param user user entity
     */
    void persist(User user);

}
