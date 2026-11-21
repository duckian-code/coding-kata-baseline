package com.example.Controllers;

import com.example.Models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/spaceship")
public class SpaceshipRestController {    

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String createSpaceship(@RequestBody Spaceship spaceship) {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return SpaceshipRestDataArrayList.add(spaceship);

            case SQL:
                return SpaceshipRestDataArrayList.add(spaceship);

            case JPA:
                return null;

            default:
                return null;

        }
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<Spaceship> getAll() {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return SpaceshipRestDataArrayList.getAll();
            case SQL:
                return null;

            case JPA:
                return null;

            default:
                return null;

        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Spaceship findById(@PathVariable int id) {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return SpaceshipRestDataArrayList.findById(id);

            case SQL:
                return null;

            case JPA:
                return null;

            default:
                return null;

        }
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public Spaceship updateSpaceship(@RequestBody Spaceship spaceship) {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return SpaceshipRestDataArrayList.update(spaceship);

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
                return SpaceshipRestDataArrayList.deleteById(id);

            case SQL:
                return SpaceshipRestDataArrayList.deleteById(id);

            case JPA:
                return null;

            default:
                return null;

        }
    }    

    @RequestMapping(path = "/getplanets/{spaceship_id}", method = RequestMethod.GET)
    public ArrayList<Planet> getAllPlanets(@PathVariable int spaceship_id) {
        switch (Settings.dbStatus) {
            case ARRAYLIST:
                return null;

            case SQL:
                return null;

            case JPA:
                return null;

            default:
                return null;

        }

    }
}