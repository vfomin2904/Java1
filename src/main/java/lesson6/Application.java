package lesson6;

public class Application {
    public static void main(String[] args) {

        Dog dog1 = new Dog("Бобик");
        Dog dog2 = new Dog("Шарик");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Том");
        Cat cat3 = new Cat("Пушок");


        dog1.run(300);
        dog1.swim(5);
        dog2.swim(20);
        dog2.run(2100);

        cat1.swim(20);
        cat2.run(20);
        cat3.run(250);

        System.out.println("Всего животных: "+Animal.getCounter());
        System.out.println("Всего собак: "+Dog.getCounter());
        System.out.println("Всего кошек: "+Cat.getCounter());

    }
}
