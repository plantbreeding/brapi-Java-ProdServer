package org.brapi.test.BrAPITestServer.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Map;

@Converter(autoApply = false)
public class JsonbConverter implements AttributeConverter<Map<String, Object>, String> {

    private final static ObjectMapper mapper = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(JsonbConverter.class);

    @Override
    public String convertToDatabaseColumn(Map<String, Object> jsonb) {
        try {
            return mapper.writeValueAsString(jsonb);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        try {
            if (dbData == null) {
                return null;
            }
            return mapper.readValue(dbData, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}