package ru.progwards.java1.lessons.interfaces;

public class Animal {
    double weight;

    public Animal(double weight) {
        this.weight = weight;
    }

    public boolean equals(Object anObject) {
        if (this == anObject) return true;
        if (anObject == null || getClass() != anObject.getClass()) return false;
        Animal animal = (Animal) anObject;
        return Double.compare(animal.weight, weight) == 0;
    }

    public double getFood1kgPrice() {
        switch (getFoodKind()) {
            case HAY: return 20d;
            case CORN: return 50d;
        }
        return 0d;
    }

    public double getFoodPrice(){
        return calculateFoodWeight() * getFood1kgPrice();
    }

    public int compareFoodPrice(Animal aminal){
        return Double.compare(getFoodPrice(), aminal.getFoodPrice());
    }

    public CompareWeight.CompareResult compareWeight(Double weight){
        if(this.weight < weight){
            return CompareWeight.CompareResult.LESS;
        }
        if(this.weight == weight){
            return CompareWeight.CompareResult.EQUAL;
        }
        return CompareWeight.CompareResult.GREATER;
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

    enum AnimalKind {ANIMAL, COW, HAMSTER, DUCK} ;

    enum FoodKind {UNKNOWN, HAY, CORN};

    AnimalKind animal = AnimalKind.ANIMAL;
    FoodKind food = FoodKind.UNKNOWN;
}
