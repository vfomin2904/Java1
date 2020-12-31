package ru.java1;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = '0';
    public static final int SIZE = 3;
    public static char[][] map = new char[SIZE][SIZE];

    public static void main(String[] args) {
        initMap();
        while(true) {
            drawMap();
            humanStep();
            if(checkWin(DOT_X)){
                drawMap();
                System.out.println("Победил человек");
                break;
            }
            aiStep();
            if(checkWin(DOT_O)){
                drawMap();
                System.out.println("Победил компьютер");
                break;
            }
        }
    }

    public static void initMap(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void drawMap(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void humanStep(){
        int x, y;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Введите X и Y");
            x = sc.nextInt();
            y = sc.nextInt();
        } while (x < 0 && x >= SIZE && y < 0 && y >= SIZE && map[y][x] != DOT_EMPTY);
        map[y][x] = DOT_X;
    }
    public static void aiStep(){
        int x, y;
        do{
            Random rand = new Random();
            x = rand.nextInt(3);
            y = rand.nextInt(3);
        } while (map[y][x] != DOT_EMPTY);
        map[y][x] = DOT_O;
    }
    public static boolean checkWin(char symb){
        for(int i = 0; i < SIZE; i++){
            if(searchWin(i, "rows", symb) || searchWin(i, "column", symb)){
                return true;
            }
        }
        if(searchWin(0, "d1", symb) || searchWin(0, "d2", symb)){
            return true;
        }

        return false;
    }

    public static boolean searchWin(int i, String mode, char symb){

        boolean  win = true;

        for (int j = 0; j < SIZE; j++) {
            int k1 = i,k2 = j;
            switch(mode){
                case "column":{
                    k1 = j;
                    k2 = i;
                    break;
                }
                case "d1":{
                    k1 = j;
                    k2 = j;
                    break;
                }
                case "d2":{
                    k1 = j;
                    k2 = SIZE - j - 1;
                    break;
                }
            }
            if (map[k1][k2] != symb) {
                win = false;
                break;
            }
        }
        return win;
    }
}
