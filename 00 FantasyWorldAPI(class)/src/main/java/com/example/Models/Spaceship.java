package com.example.Models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Spaceship implements Serializable {
    int spaceship_id;
    String name;
    String description;
    int pilot_id;

    public Spaceship() {

    }

    public Spaceship(int spaceship_id, String name, String description, int pilot_id) {
        this.spaceship_id = spaceship_id;
        this.name = name;
        this.description = description;
        this.pilot_id = pilot_id;
    }

    public int getSpaceship_id() {
        return spaceship_id;
    }

    public void setSpaceship_id(int spaceship_id) {
        this.spaceship_id = spaceship_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPilot_id() {
        return pilot_id;
    }

    public void setPilot_id(int pilot_id) {
        this.pilot_id = pilot_id;
    }

}
