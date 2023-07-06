package com.javarush.hibernate2.rantsev.converter;

import jakarta.persistence.AttributeConverter;

import java.time.Year;

public class YearConverter implements AttributeConverter<Year, Short> {
    @Override
    public Short convertToDatabaseColumn(Year attribute) {
        if(attribute != null) {
            return (short) attribute.getValue();
        }
        return null;
    }

    @Override
    public Year convertToEntityAttribute(Short dbData) {
        if(dbData != null) {
            return Year.of(dbData);
        }
        return null;
    }
}
