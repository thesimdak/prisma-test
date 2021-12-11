package de.prisma.test.rest.api.dto;

import javax.ws.rs.QueryParam;
import java.time.LocalDate;

public class UserFilterQueryDto {

    @QueryParam("hasBorrowed")
    private boolean hasBorrowed;
    @QueryParam("activeMemberOnly")
    private boolean activeMemberOnly;
    @QueryParam("hasBorrowedFrom")
    private LocalDate hasBorrowedFrom;
    @QueryParam("hasBorrowedTo")
    private LocalDate hasBorrowedTo;

    public UserFilterQueryDto(boolean hasBorrowed, boolean activeMemberOnly, LocalDate hasBorrowedFrom, LocalDate hasBorrowedTo) {
        this.hasBorrowed = hasBorrowed;
        this.activeMemberOnly = activeMemberOnly;
        this.hasBorrowedFrom = hasBorrowedFrom;
        this.hasBorrowedTo = hasBorrowedTo;
    }

    public UserFilterQueryDto() {
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
