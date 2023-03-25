package com.example.szs.common.utils;

import lombok.experimental.UtilityClass;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;

@UtilityClass
public class CommonUtils {

    public boolean isEmpty(Object value) {
        return ObjectUtils.isEmpty(value);
    }

    public boolean isNotEmpty(Object value) {
        return !isEmpty(value);
    }

    public boolean orEmpty(Object ...args) {
        return orEmpty(Arrays.asList(args));
    }

    public boolean orEmpty(List<Object> args) {
        return args == null || args.stream().anyMatch(CommonUtils::isEmpty);
    }

    public boolean andEmpty(Object... args) {
        return andEmpty(Arrays.asList(args));
    }

    public boolean andEmpty(List<Object> args) {
        return args == null || args.stream().allMatch(CommonUtils::isEmpty);
    }

    public String orElse(String value, String replaceValue) {
        return value == null ? replaceValue : value;
    }
}
