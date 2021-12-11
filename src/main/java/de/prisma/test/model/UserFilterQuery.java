package de.prisma.test.model;

import java.time.LocalDate;

/**
 * Model containing filters for a query on users.
 */
public class UserFilterQuery {

    private boolean hasBorrowed;
    private boolean activeMemberOnly;
    private LocalDate hasBorrowedFrom;
    private LocalDate hasBorrowedTo;

    public UserFilterQuery(boolean hasBorrowed, boolean activeMemberOnly, LocalDate hasBorrowedFrom, LocalDate hasBorrowedTo) {
        this.hasBorrowed = hasBorrowed;
        this.activeMemberOnly = activeMemberOnly;
        this.hasBorrowedFrom = hasBorrowedFrom;
        this.hasBorrowedTo = hasBorrowedTo;
    }

    public UserFilterQuery() {
    }

    public boolean isHasBorrowed() {
        return hasBorrowed;
    }

    public void setHasBorrowed(boolean hasBorrowed) {
        this.hasBorrowed = hasBorrowed;
    }

    public boolean isActiveMemberOnly() {
        return activeMemberOnly;
    }

    public void setActiveMemberOnly(boolean activeMemberOnly) {
        this.activeMemberOnly = activeMemberOnly;
    }

    public LocalDate getHasBorrowedFrom() {
        return hasBorrowedFrom;
    }

    public void setHasBorrowedFrom(LocalDate hasBorrowedFrom) {
        this.hasBorrowedFrom = hasBorrowedFrom;
    }

    public LocalDate getHasBorrowedTo() {
        return hasBorrowedTo;
    }

    public void setHasBorrowedTo(LocalDate hasBorrowedTo) {
        this.hasBorrowedTo = hasBorrowedTo;
    }
}
