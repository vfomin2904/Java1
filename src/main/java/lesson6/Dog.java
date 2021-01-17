package lesson6;

public class Dog extends Animal{
    private final int MAX_RUN = 500;
    private final int MAX_SWIM = 10;
    private static int counter = 0;

    public Dog(String name) {
        super(name);
        counter+=1;
    }

    public static int getCounter() {
        return counter;
    }

    public void swim(int l) {
        if(l <= MAX_SWIM){
            System.out.println(super.getName()+" проплыл "+l+" метров");
        }
        else{
            System.out.println(super.getName()+" не может проплыть больше "+MAX_SWIM+" метров");
        }
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
