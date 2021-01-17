package lesson6;

public class Cat extends Animal {
    private final int MAX_RUN = 200;
    public static int counter = 0;

    public Cat(String name) {
        this.name = name;
        counter+=1;
    }

    public void swim(int l) {
        System.out.println("Кошка не умеет плавать");
    }
    public void run(int l) {
        if(l <= MAX_RUN){
            System.out.println(name+" пробежал "+l+" метров");
        }
        else{
            System.out.println(name+" пробежал "+MAX_RUN+" метров и устал");
        }
    }
}
