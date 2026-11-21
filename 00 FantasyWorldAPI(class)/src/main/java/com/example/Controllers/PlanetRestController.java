package com.example.Controllers;

import com.example.Models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/planet")
public class PlanetRestController {
    //public static final boolean useDB = true;    

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String create(@RequestBody Planet planet) {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return PlanetRestDataArrayList.add(planet);

            case SQL:
                return null;

            case JPA:
                return null;

            default:
                return null;

        }
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Planet> getAll() {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return PlanetRestDataArrayList.getAll();

            case SQL:
                return null;

            case JPA:
                return null;

            default:
                return null;

        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Planet findById(@PathVariable int id) {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return PlanetRestDataArrayList.findById(id);

            case SQL:
                return null;

            case JPA:
               return null;

            default:
                return null;

        }
    }
    

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Planet update(@RequestBody Planet planet) {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return PlanetRestDataArrayList.update(planet);

            case SQL:
                return null;

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
                return PlanetRestDataArrayList.deleteById(id);

            case SQL:
                return null;

            case JPA:
                return null;

            default:
                return null;

        }
    }
}