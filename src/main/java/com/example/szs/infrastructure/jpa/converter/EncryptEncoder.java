package com.example.szs.infrastructure.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class EncryptEncoder implements AttributeConverter<String, String> {



    @Override
    public String convertToDatabaseColumn(String attribute) {
        return null;
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return null;
    }
}
