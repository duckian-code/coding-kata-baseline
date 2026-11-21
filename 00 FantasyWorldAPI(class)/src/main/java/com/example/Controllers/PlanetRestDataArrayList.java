package com.example.Controllers;

import java.util.ArrayList;
import com.example.Models.Planet;

public class PlanetRestDataArrayList {
    private static final ArrayList<Planet> planets = new ArrayList<>();

    public static String add(Planet planet) {
        if (planets.stream().filter(i -> i.getPlanet_id() == planet.getPlanet_id()).findFirst().orElse(null) == null) {
            planets.add(planet);
            return "Planet Added";
        } else {
            return "Id Conflict";
        }
    }

    public static ArrayList<Planet> getAll() {
        return planets;
    }

    public static Planet findById(int id) {
        return planets.stream().filter(planet -> planet.getPlanet_id() == id).findFirst().orElse(null);
    }

    public static String deleteById(int id) {
        return planets.removeIf(planet -> planet.getPlanet_id() == id) ? "Removed" : "Not Found";
    }

    public static Planet update(Planet planet) {
        Planet temp = planets.stream().filter(i -> i.getPlanet_id() == planet.getPlanet_id()).findFirst().orElse(null);
        if (temp != null) {
            planets.remove(temp);
            planets.add(planet);
            return planet;
        }
        return null;
    }
}
