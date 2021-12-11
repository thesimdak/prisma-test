package de.prisma.test.repo;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import de.prisma.test.model.UserFilterQuery;
import de.prisma.test.repo.entity.QUser;
import de.prisma.test.repo.entity.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link UserRepository}.
 */
@Component
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<User> findUsers(UserFilterQuery userFilterQuery) {
        JPAQuery<User> userJPAQuery = (JPAQuery<User>) jpaQueryFactory.from(QUser.user);

        List<Predicate> wherePredicates = new ArrayList<>();
        if (userFilterQuery.isActiveMemberOnly()) {
            wherePredicates.add(QUser.user.memberTill.after(LocalDate.now()).or(QUser.user.memberTill.isNull()));
        }
        if (userFilterQuery.getHasBorrowedFrom() != null && userFilterQuery.getHasBorrowedTo() != null) {
            // TODO
        }
        userJPAQuery = userJPAQuery.where(wherePredicates.toArray(new Predicate[]{}));
        return userJPAQuery.fetch();
    }

    @Override
    @Transactional
    public void persist(User user) {
        entityManager.persist(user);
    }
}