package de.prisma.test.service.api;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract class providing interface for loading data from cvs file.
 */
public abstract class DataLoader {

    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/d/yyyy");

    /**
     * Loads data into database.
     */
    public abstract void load();

    /**
     * Returns value on a given index as a string.
     *
     * @param row   list with values
     * @param index index of list from that a value should be read
     * @return value as string, if there is a value on the index, else empty string
     */
    protected String getRowValueAsString(List<String> row, int index) {
        try {
            return row.get(index);
        } catch (IndexOutOfBoundsException e) {
            LOG.warn("Data might be corrupt. No data available on index {}", index, e);
            return "";
        }
    }

    /**
     * Returns value on a given index as a local date.
     *
     * @param row   list with values
     * @param index index of list from that a value should be read
     * @return value as a LocalDate, if there is a value on the index, else null
     */
    protected LocalDate getRowValueAsLocalDate(List<String> row, int index) {
        String date = getRowValueAsString(row, index);
        if (!date.isEmpty()) {
            try {
                return LocalDate.parse(date, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                LOG.warn("Cannot read a date on index {}", index, e);
                return null;
            }
        }
        return null;
    }

    /**
     * Reads rows of a given data file and returns them in a list representation.
     *
     * @param dataFileName name of a data file
     * @return list of rows containing list of values in the row
     */
    protected List<List<String>> readDataFromCsv(String dataFileName) {
        List<List<String>> records = new ArrayList<>();
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("data/" + dataFileName);
        if (is == null) {
            String msg = String.format("Cannot load data. File %s doesn't exist", dataFileName);
            LOG.error(msg);
            throw new RuntimeException(msg);
        }
        try (Reader targetReader = new InputStreamReader(is)) {
            try (CSVReader csvReader = new CSVReader(targetReader)) {
                String[] values = null;
                // skip header and go directly to data
                csvReader.readNext();
                while ((values = csvReader.readNext()) != null) {
                    records.add(Arrays.asList(values));
                }
            }
        } catch (IOException | CsvValidationException e) {
            LOG.error("Error while reading file {}", dataFileName, e);
            throw new RuntimeException(e);
        }
        // Ignore all empty lines
        records = records.stream().filter(row ->
                row.stream().anyMatch(value -> !value.isEmpty())
        ).collect(Collectors.toList());
        return records;
    }


}
