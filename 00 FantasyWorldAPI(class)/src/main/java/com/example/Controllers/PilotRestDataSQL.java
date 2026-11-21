package com.example.Controllers;

import java.sql.*;
import java.util.ArrayList;

import com.example.Models.Pilot;
import com.example.Models.Spaceship;
import org.springframework.stereotype.Service;

import static com.example.Controllers.PlanetRestDataArrayList.findById;

public class PilotRestDataSQL implements PilotDataStrategy {

    @Override
    public String add(Pilot pilot) {

        if (findById(pilot.getPilot_id()) != null)
            return "Id Conflict";

        String SQL = String.format(
                "INSERT INTO pilots (`pilot_id`, `name`, `skill_level`) VALUES ('%s', '%s', '%s');",
                pilot.getPilot_id(), pilot.getName(), pilot.getSkill_level(), pilot.getPilot_id());

        try {
            Connection conn = DriverManager.getConnection(
                    Settings.dbURL, Settings.username, Settings.password);
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Pilot Added! " + String.valueOf(pilot.getPilot_id());
    }

    @Override
    public Pilot getById(int id) {
        String SQL = String.format("SELECT * FROM pilots WHERE (`pilot_id` = '%s');", id);
        Pilot pilot = null;

        System.out.println("HERE1");

        try (Connection conn = DriverManager.getConnection(
                Settings.dbURL, Settings.username, Settings.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int pilot_id = resultSet.getInt("pilot_id");
                String name = resultSet.getString("name");
                int skill_level = resultSet.getInt("skill_level");

                pilot = new Pilot(pilot_id, name, skill_level);
                System.out.println("HERE" + pilot.getName());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pilot;
    }

    @Override
    public ArrayList<Pilot> getAll() {
        String SQL = String.format("SELECT * FROM pilots");
        ArrayList<Pilot> pilots = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(
                Settings.dbURL, Settings.username, Settings.password);
             PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int pilot_id = resultSet.getInt("pilot_id");
                String name = resultSet.getString("name");
                int skill_level = resultSet.getInt("skill_level");

                Pilot pilot = new Pilot(pilot_id, name, skill_level);
                pilots.add(pilot);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pilots;
    }

    @Override
    public Pilot update(Pilot pilot) {
        String SQL = String.format(
                "UPDATE pilots SET `name` = '%s', `skill_level` = '%s' WHERE (`pilot_id` = '%s');",
                pilot.getName(), pilot.getSkill_level(), pilot.getPilot_id());

        try {
            Connection conn = DriverManager.getConnection(
                    Settings.dbURL, Settings.username, Settings.password);
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);

            if (affectedRows == 1) {
                return pilot;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public String deleteById(int id) {
        String SQL = String.format("DELETE FROM pilots WHERE pilot_id = %s;", id);

        try {
            Connection conn = DriverManager.getConnection(
                    Settings.dbURL, Settings.username, Settings.password);
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);

            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);

            if (affectedRows == 1)
                return "Removed";

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Not Found";
    }
}
