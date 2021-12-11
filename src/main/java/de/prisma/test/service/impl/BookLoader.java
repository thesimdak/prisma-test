package de.prisma.test.service.impl;

import de.prisma.test.repo.BookRepository;
import de.prisma.test.repo.entity.Book;
import de.prisma.test.service.api.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class BookLoader extends DataLoader {

    private static final Logger LOG = LoggerFactory.getLogger(BookLoader.class);

    private final BookRepository bookRepository;

    public BookLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void load() {
        List<List<String>> rows = readDataFromCsv("books.csv");
        for (List<String> row : rows) {
            if (row.isEmpty()) {
                return;
            }
            String title = getRowValueAsString(row, 0);
            String author = getRowValueAsString(row, 1);
            String genre = getRowValueAsString(row, 2);
            String publisher = getRowValueAsString(row, 3);
            Book book = new Book(title, author, genre, publisher);
            bookRepository.persist(book);
        }
    }


}
