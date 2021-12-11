package de.prisma.test.service.impl;

import de.prisma.test.model.Gender;
import de.prisma.test.repo.UserRepository;
import de.prisma.test.repo.entity.User;
import de.prisma.test.service.api.DataLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Component
public class UserLoader extends DataLoader {

    private static final Logger LOG = LoggerFactory.getLogger(UserLoader.class);

    private final UserRepository userRepository;

    public UserLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void load() {
        List<List<String>> rows = readDataFromCsv("user.csv");
        for (List<String> row : rows) {
            if (row.isEmpty()) {
                return;
            }
            String firstName = getRowValueAsString(row, 0);
            String lastName = getRowValueAsString(row, 1);
            LocalDate memberSince = getRowValueAsLocalDate(row, 2);
            LocalDate memberTill = getRowValueAsLocalDate(row, 3);
            String genderValue = getRowValueAsString(row, 4);
            Gender gender = null;
            try {
                gender = Gender.valueOf(genderValue.toUpperCase());
            } catch (IllegalArgumentException e) {
                LOG.warn("Invalid value of gender in use data {}", genderValue);
            }
            User user = new User(firstName, lastName, memberSince, memberTill, gender);
            userRepository.persist(user);
        }
    }


}
