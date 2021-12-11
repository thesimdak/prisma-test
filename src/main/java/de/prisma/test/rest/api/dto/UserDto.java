package de.prisma.test.rest.api.dto;

import de.prisma.test.model.Gender;

import java.time.LocalDate;

public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate memberSince;
    private LocalDate memberTill;
    private Gender gender;

    public UserDto(Long id, String firstName, String lastName, LocalDate memberSince, LocalDate memberTill, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberSince = memberSince;
        this.memberTill = memberTill;
        this.gender = gender;
    }

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(LocalDate memberSince) {
        this.memberSince = memberSince;
    }

    public LocalDate getMemberTill() {
        return memberTill;
    }

    public void setMemberTill(LocalDate memberTill) {
        this.memberTill = memberTill;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
