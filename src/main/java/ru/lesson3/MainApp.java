package ru.lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        task1();
        task2();
    }
    private static void task1(){
        while(true){
            Random rand = new Random();
            int a = rand.nextInt(10);
            boolean win = false;
            System.out.println("Угадайте число");
            for(int i=0; i<3; i++){
                Scanner scan = new Scanner(System.in);
                int b = scan.nextInt();
                if(a > b){
                    System.out.println("Введенное число меньше загаданного");
                } else if(a < b){
                    System.out.println("Введенное число больше загаданного");
                } else{
                    win = true;
                    break;
                }
            }
            if(win){
                System.out.println("Вы выйграли!");
            } else {
                System.out.println("Вы проиграли!");
            }
            System.out.println("Повторить игру еще раз? 1 - да / 0 - нет");

            Scanner scan2 = new Scanner(System.in);
            int c = scan2.nextInt();
            if(c == 0){
                break;
            }
        }
    }
    private static void task2(){
        String[] words = {"apple", "orange", "lemon", "banana",
                "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        Random rand = new Random();
        int index = rand.nextInt(words.length);
        String word = words[index];
        System.out.println("Угадайте слово");
        while(true){
            Scanner scan = new Scanner(System.in);
            String input_word = scan.nextLine();
            if(word.equals(input_word)){
                System.out.println("Вы угадали!");
                break;
            }
            else{
                String str = "";
                for(int i = 0; i < 15; i++){
                    if(i < word.length() && i < input_word.length()){
                        if(word.charAt(i) == input_word.charAt(i)){
                            str += word.charAt(i);
                            continue;
                        }
                    }
                    str += "x";
                }
                System.out.println(str);
            }
        }
    }
}
