package com.solvd.gym;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GymJacksonParser implements Parsable {

    @Override
    public Gym parse(String path) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        mapper.registerModule(new JavaTimeModule());

        try {
            String jsonString = new String(Files.readAllBytes(Paths.get(path)));
            return mapper.readValue(jsonString, Gym.class);
        } catch (IOException e) {
            throw new RuntimeException("Jackson file input error" + e.getLocalizedMessage());
        }
    }

}
