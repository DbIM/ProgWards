package ru.progwards.java1.lessons.classes;

public class Duck extends Animal {
    public Duck(double weight) {
        super(weight);
    }

    @Override
    public double getFoodCoeff() {
        return (0.04);
    }

    @Override
    public AnimalKind getKind() {
        AnimalKind animal = AnimalKind.DUCK;
        return animal;
    }

    @Override
    public FoodKind getFoodKind() {
        FoodKind food = FoodKind.CORN;
        return food;
    }
}
