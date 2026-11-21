package com.example.Controllers;

import java.util.List;
import com.example.Models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Locale;

@RestController
@RequestMapping("/pilot")
public class PilotRestController {
    private final PilotDataStrategy arrayListStrategy =
            new PilotRestDataArrayList();

    private final PilotDataStrategy jsonStrategy =
            new PilotRestDataJSON();

    private volatile PilotDataStrategy pilotDataStrategy =
            arrayListStrategy;

    public PilotRestController() {
        // SWITCH THIS TO JSON OR SQL TO CHANGE DATA STRATEGY
        pilotDataStrategy = new PilotRestDataArrayList();
    }

    @RequestMapping(path = "/strategy/{strategy}", method = RequestMethod.PUT)
    public String selectStrategy(@PathVariable String strategy) {
        // NOTE: SQL NOT IMPLEMENTED TO AVOID CONTAINERIZATION IN THIS KATA
        switch (strategy.toLowerCase(Locale.ROOT)) {
            case "arrayList":
                pilotDataStrategy = arrayListStrategy;
                return "Pilot data strategy changed to ArrayList";
            case "json":
                pilotDataStrategy = jsonStrategy;
                return "Pilot data strategy changed to JSON";
            default:
                return "Invalid strategy. Use 'json' or 'arrayList'";
        }
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Pilot pilot) {
        return pilotDataStrategy.add(pilot);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Pilot> getAll() {
        return pilotDataStrategy.getAll();

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Pilot findById(@PathVariable int id) {
        return pilotDataStrategy.getById(id);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Pilot update(@RequestBody Pilot pilot) {
        return pilotDataStrategy.update(pilot);

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable int id) {
        return pilotDataStrategy.deleteById(id);

    }

}
