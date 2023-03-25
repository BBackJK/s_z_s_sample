package com.example.szs.common.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@UtilityClass
@Slf4j
public class BigDecimalUtils {

    public BigDecimal toBigDecimal(String value) {
        try {
            return new BigDecimal(value);
        } catch ( NumberFormatException ex ) {
            log.error("input :: {}, message :: {}", value, ex.getMessage());
            return new BigDecimal("0");
        }
    }
}
