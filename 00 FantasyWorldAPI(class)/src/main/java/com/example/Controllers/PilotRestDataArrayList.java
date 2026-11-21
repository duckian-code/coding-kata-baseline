package com.example.Controllers;

import java.util.ArrayList;
import com.example.Models.*;

public class PilotRestDataArrayList {
    private static final ArrayList<Pilot> pilots = new ArrayList<>();

    public static String add(Pilot pilot) {
        if (pilots.stream().filter(i -> i.getPilot_id() == pilot.getPilot_id()).findFirst().orElse(null) == null) {
            pilots.add(pilot);
            return "Pilot Added";
        } else {
            return "Id Conflict";
        }
    }

    public static ArrayList<Pilot> getAll() {
        return pilots;
    }

    public static Pilot getById(int id) {
        return pilots.stream().filter(pilot -> pilot.getPilot_id() == id).findFirst().orElse(null);
    }

    public static Pilot update(Pilot pilot) {
        Pilot temp_pilot = pilots.stream().filter(i -> i.getPilot_id() == pilot.getPilot_id()).findFirst().orElse(null);
        if (temp_pilot != null) {
            pilots.remove(temp_pilot);
            pilots.add(pilot);
            return pilot;
        }

        return null;
    }

    public static String deleteById(int id) {
        return pilots.removeIf(pilot -> pilot.getPilot_id() == id) ? "Removed" : "Not Found";
    }
}
