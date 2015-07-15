package com.cloudsherpas.poc.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public final class JsonConversionUtility {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T convertJsonToObject(final String json, final TypeReference<T> typeReference) {
        T object;

        try {
            object = objectMapper.readValue(json, typeReference);
        } catch (IOException e) {
            object = null;
        }

        return object;
    }
}
