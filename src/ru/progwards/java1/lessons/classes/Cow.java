package ru.progwards.java1.lessons.classes;

public class Cow extends Animal{

    public Cow(double weight) {
        super(weight);
    }

    @Override
    public double getFoodCoeff(){
        return (0.05);
    }

    @Override
    public AnimalKind getKind(){
        AnimalKind animal = AnimalKind.COW;
        return animal;
    }

    @Override
    public FoodKind getFoodKind(){
        FoodKind food = FoodKind.HAY;
        return food;
    }
}
