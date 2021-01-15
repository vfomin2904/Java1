package lesson5;

public class Person {
    private String fio;
    private String position;
    private String email;
    private int salary;
    private byte age;


    public Person(String fio, String position, String email, int salary, byte age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.salary = salary;
        this.age = age;
    }


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void showInfo(){
        System.out.println("ФИО: "+fio);
        System.out.println("Email: "+email);
        System.out.println("Должность: "+position);
        System.out.println("Зарплата: "+salary);
        System.out.println("Возраст: "+age);
        System.out.println();
    }
}
