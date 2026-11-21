package com.example.Controllers;

import java.util.ArrayList;
import com.example.Models.Spaceship;

public class SpaceshipRestDataArrayList {
    private static final ArrayList<Spaceship> spaceships = new ArrayList<>();

    public static String add(Spaceship spaceship) {
        if (spaceships.stream().filter(i -> i.getSpaceship_id() == spaceship.getSpaceship_id()).findFirst().orElse(null) == null) {
            spaceships.add(spaceship);
            return "Spaceship Added!";
        } else {
            return "Id Conflict";
        }
    }

    public static ArrayList<Spaceship> getAll() {
        return spaceships;
    }

    public static Spaceship findById(int id) {
        return spaceships.stream().filter(spaceship -> spaceship.getSpaceship_id() == id).findFirst().orElse(null);
    }

    public static Spaceship update(Spaceship spaceship) {
        Spaceship temp = spaceships.stream().filter(i -> i.getSpaceship_id() == spaceship.getSpaceship_id()).findFirst().orElse(null);
        if (temp != null) {
            spaceships.remove(temp);
            spaceships.add(spaceship);
            return spaceship;
        }
        return null;
    }

    public static String deleteById(int id) {
        return spaceships.removeIf(spaceship -> spaceship.getSpaceship_id() == id) ? "Removed" : "Not Found";
    }
}
