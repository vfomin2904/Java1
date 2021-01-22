package ru.lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean full;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean eat(Plate p) {
        full = p.decreaseFood(appetite);
        return full;
    }

    public String getName() {
        return name;
    }
}
