package de.prisma.test.service.impl;

import de.prisma.test.repo.BookRepository;
import de.prisma.test.repo.entity.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

public class BookLoaderTest {

    BookLoader bookLoader;
    @Mock
    BookRepository bookRepository;
    @Captor
    ArgumentCaptor<Book> bookArgumentCaptor;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        bookLoader = new BookLoader(bookRepository);
    }

    @Test
    void load_shouldPersistOneBookOnly_whenSecondLineIsEmpty() {
        // Execute
        bookLoader.load();

        // Asserts
        Mockito.verify(bookRepository, Mockito.times(1)).persist(bookArgumentCaptor.capture());
        Book book = bookArgumentCaptor.getValue();
        Assertions.assertEquals("Drucker, Peter", book.getAuthor());
        Assertions.assertEquals("economics", book.getGenre());
        Assertions.assertEquals("Random House", book.getPublisher());
        Assertions.assertEquals("Age of Discontuinity, The", book.getTitle());
        Assertions.assertNull(book.getId());
    }
}
