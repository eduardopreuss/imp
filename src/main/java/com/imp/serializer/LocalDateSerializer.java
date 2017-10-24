package com.imp.serializer;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class LocalDateSerializer extends StdSerializer<LocalDate> {
    
   public LocalDateSerializer() {
       this(null);
   }
  
   public LocalDateSerializer(Class<LocalDate> t) {
       super(t);
   }

   @Override
   public void serialize(
	LocalDate value, JsonGenerator jgen, SerializerProvider provider) 
     throws IOException, JsonProcessingException {
 
       //jgen.writeStartObject();
       /*jgen.writeNumberField("year", value.getYear());
       jgen.writeNumberField("month", value.getMonthValue());
       jgen.writeNumberField("day", value.getDayOfMonth());*/
       String date = value.getDayOfMonth() + "/" + value.getMonthValue() + "/" + value.getYear();
       jgen.writeString(date);
       //jgen.writeEndObject();
   }
} 


