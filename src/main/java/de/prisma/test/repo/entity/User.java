package de.prisma.test.repo.entity;

import de.prisma.test.model.Gender;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Entity holding information about a User.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate memberSince;
    private LocalDate memberTill;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public User(String firstName, String lastName, LocalDate memberSince, LocalDate memberTill, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.memberSince = memberSince;
        this.memberTill = memberTill;
        this.gender = gender;
    }

    public User() {
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
