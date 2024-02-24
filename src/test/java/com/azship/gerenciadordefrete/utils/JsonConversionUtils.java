package com.azship.gerenciadordefrete.utils;

import com.azship.gerenciadordefrete.dto.FreteDTO;
import com.azship.gerenciadordefrete.dto.InsertFreteDTO;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonConversionUtils {

    public static String asJsonString(FreteDTO expectedCreatedFreteDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(expectedCreatedFreteDTO);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String asJsonString(InsertFreteDTO expectedCreatedInsertFreteDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModules(new JavaTimeModule());

            return objectMapper.writeValueAsString(expectedCreatedInsertFreteDTO);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
