package model;

import entity.Animal;

import java.util.List;

public interface AnimalModel{




    boolean saveAnimal(Animal animal);

    Animal searchAnimal(String term);

    boolean existAnimal(String id);

    List<Animal> getAnimals();

    Animal searchAnimalByAi(String string);

    Animal searchbyImageOutput(String firstBirdName);
}
