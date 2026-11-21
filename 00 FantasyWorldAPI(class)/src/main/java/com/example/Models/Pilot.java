package com.example.Models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class Pilot implements Serializable {
    int pilot_id;
    String name;
    int skill_level;        

    public Pilot() {

    }

    public Pilot(int pilot_id, String name, int skill_level) {
        this.pilot_id = pilot_id;
        this.name = name;
        this.skill_level = skill_level;
    }

    public int getPilot_id() {
        return pilot_id;
    }

    public void setPilot_id(int pilot_id) {
        this.pilot_id = pilot_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkill_level() {
        return skill_level;
    }

    public void setSkill_level(int skill_level) {
        this.skill_level = skill_level;
    }

    
}
