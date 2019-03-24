package com.iknowyou.infra.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * An abstract class to help with serialization objects
 *
 * @author José Carlos Mazella Junior
 * @version 1.0 08/10/2018
 */
public abstract class AbstractSerializer<T> extends JsonSerializer<T> {

    protected abstract void serialize(final T value, final JsonWriter jsonWriter) throws IOException;

    @Override
    public void serialize(final T value, final JsonGenerator jsonGenerator, final SerializerProvider serializers) throws IOException {
        final JsonWriter jsonWriter = new JsonWriter(jsonGenerator);
        serialize(value, new JsonWriter(jsonGenerator));
    }

}
