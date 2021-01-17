package lesson6;

abstract class Animal {
    private static int counter = 0;
    private String name;

    Animal(String name){
        this.name = name;
        counter+=1;
    }

    public static int getCounter() {
        return counter;
    }

    abstract void swim(int l);
    abstract void run(int l);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
