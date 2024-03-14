package model;

import db.DBConnection;
import dev.morphia.Datastore;
import dev.morphia.query.filters.Filters;
import entity.Animal;

import java.util.regex.Pattern;

public class AnimalModel {
    private static final Datastore datastore = DBConnection.getInstance().getDatastore();

    public static boolean saveAnimal(Animal animal) {
        try {
            datastore.save(animal);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public static Animal searchAnimal(String term) {
        String pattern = "(?i).*" + Pattern.quote(term) + ".*";
        return datastore.find(Animal.class)
                .filter(Filters.regex("common_name", pattern))
                .first();
    }
}
