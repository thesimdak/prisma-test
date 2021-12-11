package de.prisma.test.repo;

import de.prisma.test.repo.entity.Book;

/**
 * Repository used for writing and retrieving books to/from database.
 */
public interface BookRepository {
    /**
     * Stores books in the db.
     *
     * @param book book entity
     */
    void persist(Book book);

    /**
     * Finds book by name
     * @param name name of book
     * @return book
     */
    Book findByName(String name);

}
