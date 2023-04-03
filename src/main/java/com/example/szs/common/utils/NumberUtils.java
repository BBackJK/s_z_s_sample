package com.example.szs.common.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.text.NumberFormat;

@UtilityClass
@Slf4j
public class NumberUtils {
    public static final NumberFormat numberFormat = NumberFormat.getInstance();

    public String toComma(String dValue) {
        try {
            return toComma(Double.parseDouble(dValue));
        } catch ( NumberFormatException ex ) {
            log.error("input value :: {} , message :: {}", dValue, ex.getMessage());
            return "0";
        }
    }

    public String toComma(long value) {
        return numberFormat.format(value);
    }

    public String toComma(double value) {
        return numberFormat.format(value);
    }
}

