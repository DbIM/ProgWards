package ru.progwards.java1.lessons.classes;

public class Hamster extends Animal {
    public Hamster(double weight) {
        super(weight);
    }

    @Override
    public double getFoodCoeff() {
        return (0.03);
    }

    @Override
    public AnimalKind getKind() {
        AnimalKind animal = AnimalKind.HAMSTER;
        return animal;
    }

    @Override
    public FoodKind getFoodKind() {
        FoodKind food = FoodKind.CORN;
        return food;
    }
}
