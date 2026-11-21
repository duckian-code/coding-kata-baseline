package com.example.Controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.Models.Pilot;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class PilotRestDataJSON {

    private static final File jsonFile = new File("src/main/resources/Database/pilot.json");
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static synchronized String add(Pilot pilot) throws IOException {
        List<Pilot> pilots = getAllInternal();
        int nextId = getNextId(pilots);
        pilot.setPilot_id(nextId);
        pilots.add(pilot);
        saveFile(pilots);
        return "Pilot added";
    }

    public static synchronized ArrayList<Pilot> getAll() throws IOException {
        return new ArrayList<>(getAllInternal());
    }

    public static synchronized Pilot getById(int pilot_id) throws IOException {
        for (Pilot pilot : getAllInternal()) {
            if (pilot.getPilot_id() == pilot_id) {
                return pilot;
            }
        }
        return null;
    }

    public static synchronized void update(Pilot pilot) throws IOException {
        ArrayList<Pilot> pilots = getAll();
        for (Pilot p : pilots) {
            if(p.getPilot_id() == pilot.getPilot_id()){
                p.setName(pilot.getName());
                p.setSkill_level(pilot.getSkill_level());
                saveFile(pilots);
            }
        }
    }

    public static synchronized void deleteById(int pilot_id) throws IOException {
        ArrayList<Pilot> pilots = getAll();
        for (Pilot p : pilots) {
            if(p.getPilot_id() == pilot_id){
                pilots.remove(p);
                saveFile(pilots);
            }
        }
    }

    private static List<Pilot> getAllInternal() throws IOException {
        if (!jsonFile.exists() || jsonFile.length() == 0) {
            // No data yet, just return an empty list
            return new ArrayList<>();
        }

        try {
            return objectMapper.readValue(
                    jsonFile,
                    new TypeReference<List<Pilot>>() {
                    }
            );
        } catch (IOException ex) {

            System.err.println("Failed to read pilot.json: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    private static int getNextId(List<Pilot> pilots) {
        if (pilots.isEmpty()) {
            return 1;
        }

        return pilots.stream()
                .map(Pilot::getPilot_id)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }

    private static void saveFile(List<Pilot> pilots) throws IOException {
        // Ensure directory exists
        File parent = jsonFile.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(jsonFile, pilots);
    }


}