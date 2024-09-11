package org.example.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class DateUtils {

    private static final List<DateTimeFormatter> dateTimeFormatters = List.of(
            DateTimeFormatter.ofPattern("M-dd-yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy"),
            DateTimeFormatter.ofPattern("MM-dd-yyyy"),
            DateTimeFormatter.ofPattern("MM/dd/yyyy"),
            DateTimeFormatter.ofPattern("M/d/yyyy")
    );

    public static LocalDate parseDate(String dateStr) {
        for (DateTimeFormatter formatter : dateTimeFormatters) {
            try {
                return LocalDate.parse(dateStr, formatter);
            } catch (DateTimeParseException ignored) {

            }
        }
        throw new IllegalArgumentException("Unsupported date format: " + dateStr);
    }
}
