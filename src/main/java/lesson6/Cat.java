package lesson6;

public class Cat extends Animal {
    private final int MAX_RUN = 200;
    private static int counter = 0;

    public Cat(String name) {
        super(name);
        counter+=1;
    }

    public static int getCounter() {
        return counter;
    }

    public void swim(int l) {
        System.out.println("Кошка не умеет плавать");
    }
    public void run(int l) {
        if(l <= MAX_RUN){
            System.out.println(super.getName()+" пробежал "+l+" метров");
        }
        else{
            System.out.println(super.getName()+" не может пробежать больше "+MAX_RUN+" метров");
        }
    }
}
