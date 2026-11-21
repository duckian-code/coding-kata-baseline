package com.example.Models;

import java.io.Serializable;

import java.util.*;

public class Planet implements Serializable {
    int planet_id;

    String name;

    String climate;

    String sector;

    private List<Spaceship> spaceships = new ArrayList<>();

    public Planet() {
    }

    public Planet(int id, String name, String climate, String sector) {
        this.planet_id = id;
        this.name = name;
        this.climate = climate;
        this.sector = sector;
    }

    public int getPlanet_id() {
        return planet_id;
    }

    public void setPlanet_id(int id) {
        this.planet_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public List<Spaceship> getSpaceships() {
        return spaceships;
    }

    public void setSpaceships(List<Spaceship> spaceships) {
        this.spaceships = spaceships;
    }

}
