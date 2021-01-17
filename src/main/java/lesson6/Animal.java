package lesson6;

abstract class Animal {
    public static int counter = 0;
    public String name;

    Animal(){
        counter+=1;
    }

    abstract void swim(int l);
    abstract void run(int l);
}
