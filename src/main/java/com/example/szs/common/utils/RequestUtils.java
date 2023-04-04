package com.example.szs.common.utils;

import lombok.experimental.UtilityClass;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@UtilityClass
public class RequestUtils {

    public Optional<String> parseAuthHeaderValue(HttpServletRequest request) {
        Optional<String> valueOrNull = parseHeader(request, "authorization");
        String result = null;

        if (valueOrNull.isPresent()) {
            final String AUTH_PREFIX = "Bearer";
            final String headerValue = valueOrNull.get();
            if (headerValue.contains(AUTH_PREFIX)) {
                result = headerValue.substring(AUTH_PREFIX.length()).trim();
            }

        }
        return Optional.ofNullable(result);
    }

    public Optional<String> parseHeader(HttpServletRequest request, String headerName) {
        return Optional.ofNullable(request.getHeader(headerName));
    }
}
