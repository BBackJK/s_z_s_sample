package com.example.szs.common.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@UtilityClass
@Slf4j
public class LocalDateUtils {

    public static final String FORMAT_DATE_DOT = "yyyy.MM.dd";
    public static final String FORMAT_DATETIME_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    public LocalDate toLocalDate(String value) {
        return toLocalDate(value, DateTimeFormatter.ISO_DATE);
    }

    public LocalDate toLocalDate(String value, DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(value, formatter);
        } catch (DateTimeParseException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    public LocalDateTime toLocalDateTime(String value) {
        return toLocalDateTime(value, DateTimeFormatter.ofPattern(FORMAT_DATETIME_SSS));
    }

    public LocalDateTime toLocalDateTime(String value, DateTimeFormatter formatter) {
        try {
            return LocalDateTime.parse(value, formatter);
        } catch (DateTimeParseException ex) {
            log.error(ex.getMessage());
            return null;
        }
    }

    public String toString(LocalDate value) {
        return toString(value, DateTimeFormatter.ISO_DATE);
    }

    public String toString(LocalDate value, DateTimeFormatter format) {
        return value == null
                ? ""
                : value.format(format);
    }
}
