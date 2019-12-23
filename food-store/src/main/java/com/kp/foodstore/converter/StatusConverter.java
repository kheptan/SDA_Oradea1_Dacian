package com.kp.foodstore.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

	@Override
	public String convertToDatabaseColumn(Status attribute) {
		if (attribute == null) {
			return null;
		}
		switch (attribute) {
		case CONFIRMED : 
			return "C";
		case PROCESSED :
			return "P";
		case DELIVERED : 
			return "D";
		default:
			throw new IllegalArgumentException("Status not supported");
		}
	}

	@Override
	public Status convertToEntityAttribute(String dbData) {
		if (dbData == null) {
			return null;
		}
		switch (dbData) {
		case "C" : 
			return Status.CONFIRMED;
		case "P" :
			return Status.PROCESSED;
		case "D" : 
			return Status.DELIVERED;
		default:
			throw new IllegalArgumentException("Status not supported");
		}
	}

}
