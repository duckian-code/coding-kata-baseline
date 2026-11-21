package com.example.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.Models.*;
import org.springframework.stereotype.Service;

public class PilotRestDataArrayList implements PilotDataStrategy {
    private final ArrayList<Pilot> pilots = new ArrayList<>();

    @Override
    public String add(Pilot pilot) {
        if (pilots.stream().filter(i -> i.getPilot_id() == pilot.getPilot_id()).findFirst().orElse(null) == null) {
            pilots.add(pilot);
            return "Pilot Added";
        } else {
            return "Id Conflict";
        }
    }

    @Override
    public ArrayList<Pilot> getAll() {
        return pilots;
    }

    @Override
    public Pilot getById(int id) {
        return pilots.stream().filter(pilot -> pilot.getPilot_id() == id).findFirst().orElse(null);
    }

    @Override
    public Pilot update(Pilot pilot) {
        Pilot temp_pilot = pilots.stream().filter(i -> i.getPilot_id() == pilot.getPilot_id()).findFirst().orElse(null);
        if (temp_pilot != null) {
            pilots.remove(temp_pilot);
            pilots.add(pilot);
            return pilot;
        }

        return null;
    }

    @Override
    public String deleteById(int id) {
        return pilots.removeIf(pilot -> pilot.getPilot_id() == id) ? "Removed" : "Not Found";
    }
}
