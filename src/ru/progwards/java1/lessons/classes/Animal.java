package ru.progwards.java1.lessons.classes;

public class Animal {
    double weight;

    public Animal(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodCoeff() {
        return (0.02);
    }

    public AnimalKind getKind() {
        return animal;
    }

    public FoodKind getFoodKind() {
        return food;
    }

    public double calculateFoodWeight() {
        return (getWeight() * getFoodCoeff());
    }

    public String toStringFull() {
        return ("I am " + getKind() + ", eat " + getFoodKind() + " " + calculateFoodWeight());
    }

    @Override
    public String toString() {
        return ("I am " + getKind() + ", eat " + getFoodKind());
    }

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK}

    ;

    enum FoodKind {UNKNOWN, HAY, CORN}

    ;

    AnimalKind animal = AnimalKind.ANIMAL;
    FoodKind food = FoodKind.UNKNOWN;
}
