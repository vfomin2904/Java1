package lesson6;

public class Dog extends Animal{
    private final int MAX_RUN = 500;
    private final int MAX_SWIM = 10;
    public static int counter = 0;

    public Dog(String name) {
        this.name = name;
        counter+=1;
    }

    public void swim(int l) {
        if(l <= MAX_SWIM){
            System.out.println(name+" проплыл "+l+" метров");
        }
        else{
            System.out.println(name+" проплыл "+MAX_SWIM+" метров и устал");
        }
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
