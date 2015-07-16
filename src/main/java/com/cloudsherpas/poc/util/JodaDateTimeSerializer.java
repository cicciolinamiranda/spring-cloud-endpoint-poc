package com.cloudsherpas.poc.util;

import com.google.appengine.repackaged.org.codehaus.jackson.JsonGenerator;
import com.google.appengine.repackaged.org.codehaus.jackson.map.JsonSerializer;
import com.google.appengine.repackaged.org.codehaus.jackson.map.SerializerProvider;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public class JodaDateTimeSerializer extends JsonSerializer<DateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("dd-MM-yyyy");

    @Override
    public void serialize(DateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(FORMATTER.print(dateTime));
    }
}
