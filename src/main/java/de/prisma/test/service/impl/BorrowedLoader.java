package de.prisma.test.service.impl;

import de.prisma.test.repo.BookRepository;
import de.prisma.test.repo.UserRepository;
import de.prisma.test.service.api.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Component
public class BorrowedLoader extends DataLoader {

    private static final Logger LOG = LoggerFactory.getLogger(BorrowedLoader.class);

    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public BorrowedLoader(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    public void load() {
        List<List<String>> rows = readDataFromCsv("borrowed.csv");
        for (List<String> row : rows) {
            if (row.isEmpty()) {
                return;
            }
            String borrower = getRowValueAsString(row, 0);
            String bookName = getRowValueAsString(row, 1);
            LocalDate from = getRowValueAsLocalDate(row, 2);
            LocalDate to = getRowValueAsLocalDate(row, 3);
//            bookRepository.persist();
//            userRepository.persist(user);
        }
    }


}
