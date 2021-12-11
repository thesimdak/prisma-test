package de.prisma.test.repo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import de.prisma.test.repo.entity.Book;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Implementation of {@link BookRepository}.
 */
@Component
public class BookRepositoryImpl implements BookRepository {

    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    public BookRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.jpaQueryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    @Transactional
    public void persist(Book book) {
        entityManager.persist(book);
    }

    @Override
    public Book findByName(String name) {
        return null;
       // return jpaQueryFactory.from(QBook.book);
    }
}