package de.prisma.test.repo.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entity for Borrowed. Holding information about who and what have been borrowed.
 */
@Entity
public class Borrowed {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User borrower;
    private LocalDate borrowedFrom;
    private LocalDate borrowedTo;

    public Borrowed(Long id, Book book, User borrower, LocalDate borrowedFrom, LocalDate borrowedTo) {
        this.id = id;
        this.book = book;
        this.borrower = borrower;
        this.borrowedFrom = borrowedFrom;
        this.borrowedTo = borrowedTo;
    }

    public Borrowed() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public LocalDate getBorrowedFrom() {
        return borrowedFrom;
    }

    public void setBorrowedFrom(LocalDate borrowedFrom) {
        this.borrowedFrom = borrowedFrom;
    }

    public LocalDate getBorrowedTo() {
        return borrowedTo;
    }

    public void setBorrowedTo(LocalDate borrowedTo) {
        this.borrowedTo = borrowedTo;
    }
}
