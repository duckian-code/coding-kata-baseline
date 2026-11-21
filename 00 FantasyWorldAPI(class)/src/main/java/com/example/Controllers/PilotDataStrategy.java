package com.example.Controllers;

import com.example.Models.Pilot;

import java.util.List;

public interface PilotDataStrategy {
    String add(Pilot pilot);
    List<Pilot> getAll();
    Pilot getById(int id);
    Pilot update(Pilot pilot);
    String deleteById(int id);
}
