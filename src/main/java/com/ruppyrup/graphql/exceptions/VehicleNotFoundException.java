package com.ruppyrup.graphql.exceptions;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class VehicleNotFoundException extends RuntimeException implements GraphQLError, Supplier<VehicleNotFoundException> {

    private Map<String, Object> extensions = new HashMap<>();

    public VehicleNotFoundException(String message, int invalidId) {
        super(message);
        extensions.put("Invalid vehicle id", invalidId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }

    @Override
    public VehicleNotFoundException get() {
        return this;
    }
}
