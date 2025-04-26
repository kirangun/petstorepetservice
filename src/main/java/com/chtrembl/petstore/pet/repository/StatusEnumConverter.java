package com.chtrembl.petstore.pet.repository;

import com.chtrembl.petstore.pet.model.Pet;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusEnumConverter implements AttributeConverter<Pet.StatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(Pet.StatusEnum statusEnum) {
        if (statusEnum == null) {
            return null;
        }
        // Convert the enum to lowercase for database storage
        return statusEnum.name().toLowerCase();
    }

    @Override
    public Pet.StatusEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Pet.StatusEnum.valueOf(dbData.toUpperCase());
    }
}
