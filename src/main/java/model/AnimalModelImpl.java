package model;

import db.DBConnection;
import dev.morphia.Datastore;
import dev.morphia.query.filters.Filters;
import entity.Animal;
import entity.Location;

import java.util.List;
import java.util.regex.Pattern;

public class AnimalModelImpl implements AnimalModel{
    private static final Datastore datastore = DBConnection.getInstance().getDatastore();

    @Override
    public boolean saveAnimal(Animal animal) {
        try {
            for (Location location : animal.getLocations()) {
                datastore.save(location);
            }
            datastore.save(animal);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Animal searchAnimal(String term) {
        String pattern = "(?i).*" + Pattern.quote(term) + ".*";
        return datastore.find(Animal.class)
                .filter(Filters.regex("common_name", pattern))
                .first();
    }
    @Override
    public boolean existAnimal(String id) {
        Animal animal = datastore.find(Animal.class)
                .filter(Filters.eq("_id", id))
                .first();
        return animal != null;
    }

    @Override
    public List<Animal> getAnimals() {
        return datastore.find(Animal.class)
                .iterator().toList()
                .stream().limit(4).toList();
    }

    @Override
    public Animal searchAnimalByAi(String string) {
        String pattern = "(?i).*" + Pattern.quote(string) + ".*";
        return datastore.find(Animal.class)
                .filter(Filters.regex("common_name", pattern))
                .first();
    }

    @Override
    public Animal searchbyImageOutput(String firstBirdName) {
        String pattern = "(?i).*" + Pattern.quote(firstBirdName) + ".*";
        return datastore.find(Animal.class)
                .filter(Filters.regex("common_name", pattern))
                .first();
    }


}
