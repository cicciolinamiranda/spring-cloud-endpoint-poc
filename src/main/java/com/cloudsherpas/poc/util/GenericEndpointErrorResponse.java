package com.cloudsherpas.poc.util;

import com.google.api.server.spi.response.NotFoundException;

public final class GenericEndpointErrorResponse {

    private GenericEndpointErrorResponse() {

    }

    public static void entityNotFound() throws NotFoundException {
        final String message = "No data found.";
        entityNotFound(message);
    }

    public static void entityNotFound(final String message) throws NotFoundException {
        throw new NotFoundException(message);
    }
}
