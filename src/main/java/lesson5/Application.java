package lesson5;

public class Application {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("Иванов Иван Иванович", "Инженер", "iv@mail.ru", 40000, 29);
        persons[1] = new Person("Никифоров Иван Иванович", "Аналитик", "nik1@mail.ru", 23000, 54);
        persons[2] = new Person("Никитин Иван Иванович", "Бухгалтер", "nik2@mail.ru", 12000, 44);
        persons[3] = new Person("Романов Иван Иванович", "Программист", "rom@mail.ru", 120000, 32);
        persons[4] = new Person("Прокофьев Иван Иванович", "Архитектор", "pro@mail.ru", 80000, 65);

        for(Person per: persons){
            if(per.getAge() > 40){
                per.showInfo();
            }
        }
    }
}
