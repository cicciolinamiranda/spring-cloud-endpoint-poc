package com.cloudsherpas.poc.util;


import com.google.appengine.repackaged.org.codehaus.jackson.JsonParser;
import com.google.appengine.repackaged.org.codehaus.jackson.map.DeserializationContext;
import com.google.appengine.repackaged.org.codehaus.jackson.map.JsonDeserializer;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public class JodaDateTimeDeserializer extends JsonDeserializer<DateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern("dd-MM-yyyy");

    @Override
    public DateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        return FORMATTER.parseDateTime(jsonParser.getText());
    }
}
