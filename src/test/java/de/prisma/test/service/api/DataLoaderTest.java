package de.prisma.test.service.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.NotSupportedException;
import java.time.LocalDate;
import java.util.Collections;

public class DataLoaderTest {
    DataLoader dataLoader = new DataLoader() {
        @Override
        public void load() {
            throw new NotSupportedException();
        }
    };

    @Test
    void getRowValueAsString_shouldReturnEmptyString_whenIndexOutOfBound() {
        String value = dataLoader.getRowValueAsString(Collections.emptyList(), 1);
        Assertions.assertTrue(value.isEmpty());
    }

    @Test
    void getRowValueAsString_shouldReturnStringValue_whenValueIsPresent() {
        String value = dataLoader.getRowValueAsString(Collections.singletonList("test"), 0);
        Assertions.assertEquals("test", value);
    }

    @Test
    void getRowValueAsLocalDate_shouldReturnNull_whenIndexOutOfBound() {
        LocalDate value = dataLoader.getRowValueAsLocalDate(Collections.emptyList(), 1);
        Assertions.assertNull(value);
    }

    @Test
    void getRowValueAsLocalDate_shouldReturnStringValue_whenValueIsPresent() {
        LocalDate value = dataLoader.getRowValueAsLocalDate(Collections.singletonList("11/25/2020"), 0);
        Assertions.assertEquals(11, value.getMonthValue());
        Assertions.assertEquals(25, value.getDayOfMonth());
        Assertions.assertEquals(2020, value.getYear());
    }
}
