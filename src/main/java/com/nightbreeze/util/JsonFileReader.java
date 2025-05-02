package com.nightbreeze.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nightbreeze.model.Species;
import com.nightbreeze.model.SpeciesListWrapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class JsonFileReader {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static List<Species> readJsonDataFile(String fileName) {
        String resourcePath = "/com/nightbreeze/data/" + fileName + ".json";

        try (InputStream inputStream = JsonFileReader.class.getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                System.err.println("Cannot find resource file: " + resourcePath);
                return Collections.emptyList(); // Return empty list on failure
            }

            SpeciesListWrapper wrapper = mapper.readValue(inputStream, SpeciesListWrapper.class);
            if (wrapper != null && wrapper.getSpecies() != null) {
                System.out.println("Successfully loaded " + wrapper.getSpecies().size() + " species.");
                return wrapper.getSpecies();
            } else {
                System.err.println("Species data is null or empty in the JSON file: " + resourcePath);
                return Collections.emptyList();
            }

        } catch (IOException e) {
            System.err.println("Error reading or parsing species JSON file: " + resourcePath);
            e.printStackTrace();
            return Collections.emptyList(); // Return empty list on error
        }
    }
}
