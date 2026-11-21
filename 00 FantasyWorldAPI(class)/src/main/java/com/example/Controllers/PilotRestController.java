package com.example.Controllers;

import java.util.List;
import com.example.Models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pilot")
public class PilotRestController {

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Pilot pilot) {

        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return PilotRestDataArrayList.add(pilot);

            case SQL:
                return PilotRestDataSQL.add(pilot);

            case JPA:
                return null;

            default:
                return null;
        }

    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Pilot> getAll() {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return PilotRestDataArrayList.getAll();

            case SQL:
                return PilotRestDataSQL.getAll();

            case JPA:
                return null;

            default:
                return null;
        }

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Pilot findById(@PathVariable int id) {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return PilotRestDataArrayList.getById(id);

            case SQL:
                return PilotRestDataSQL.findById(id);

            case JPA:
                return null;

            default:
                return null;
        }

    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Pilot update(@RequestBody Pilot pilot) {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return PilotRestDataArrayList.update(pilot);

            case SQL:
                return PilotRestDataSQL.update(pilot);

            case JPA:
                return null;

            default:
                return null;
        }

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable int id) {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return PilotRestDataArrayList.deleteById(id);

            case SQL:
                return PilotRestDataSQL.deleteById(id);

            case JPA:
                return null;

            default:
                return null;
        }

    }

}
