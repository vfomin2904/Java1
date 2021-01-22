package ru.lesson7;

public class Application {
    public static void main(String[] args) {
        Plate plate = new Plate(20);
        Cat[] cat = new Cat[5];
        cat[0] = new Cat("Барсик", 5);
        cat[1] = new Cat("Вася", 10);
        cat[2] = new Cat("Кузя", 10);
        cat[3] = new Cat("Том", 6);
        cat[4] = new Cat("Пушок", 3);
        plate.info();
        for(Cat c:cat){
            if(c.eat(plate)){
                System.out.println(c.getName()+" сыт");
            }
            else{
                System.out.println(c.getName()+" голоден");
            }
        }
        plate.info();
        plate.increaseFood(15);
        plate.info();
    }
}
