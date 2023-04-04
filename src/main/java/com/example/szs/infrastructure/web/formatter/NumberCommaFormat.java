package com.example.szs.infrastructure.web.formatter;

import com.example.szs.common.utils.NumberUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class NumberCommaFormat extends JsonSerializer<String> {

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value == null ? null : NumberUtils.toComma(value));
    }
}
