package model;

import entity.Animal;

public interface AnimalModel{

    boolean saveAnimal(Animal animal);

    Animal searchAnimal(String term);

    boolean existAnimal(String id);

}
