package com.imp.deserializer;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

	@Override
	public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);
		int day = (Integer) ((IntNode) node.get("day")).numberValue();
		int month = (Integer) ((IntNode) node.get("month")).numberValue();
		int year = (Integer) ((IntNode) node.get("year")).numberValue();
		
		return LocalDate.of(year, month, day);
	}
	public LocalDateDeserializer() { 
        this(null); 
    }
	public LocalDateDeserializer(Class<?> vc) { 
        super(vc); 
    }

}
