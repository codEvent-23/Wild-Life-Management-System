package com.codeventsl.wildLifeManagementSystem.model;

import com.codeventsl.wildLifeManagementSystem.dto.AnimalDTO;
import com.codeventsl.wildLifeManagementSystem.dto.Location;
import com.codeventsl.wildLifeManagementSystem.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Animal {
    public static ArrayList<Location> searchAnimalId(String name) throws SQLException, ClassNotFoundException {
        ResultSet result =  CrudUtil.execute("select id from animal where name = ?;",name);
        if (result.next()){
            return searchAnimalLocationId(result.getString("id")) ;
        }
        return null;
    }

    public static ArrayList<Location> searchAnimalLocationId(String animalId) throws SQLException, ClassNotFoundException {
        ArrayList<String> locationIds = new ArrayList<>();
        ResultSet rs = CrudUtil.execute("select location_id from animal_location where animal_id =?",animalId);
        while (rs.next()) {
            locationIds.add(rs.getString("location_id"));
        }
        return searchLocationLatLng(locationIds);
    }

    public static ArrayList<Location> searchLocationLatLng(ArrayList<String> locationIds) throws SQLException, ClassNotFoundException {
        ArrayList<Location> latAndLdg = new ArrayList<>();
        for (String locationId : locationIds){
            ResultSet resultSet = CrudUtil.execute("select latitude,longitude from location where id = ?", locationId);

            while (resultSet.next()) {
                latAndLdg.add(
                        new Location(resultSet.getString("latitude"),
                            resultSet.getString("longitude")
                        ));
            }
        }
        return latAndLdg;
    }
}
