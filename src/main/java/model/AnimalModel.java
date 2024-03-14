package model;

import db.DBConnection;
import dev.morphia.Datastore;
import entity.Animal;

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
}
