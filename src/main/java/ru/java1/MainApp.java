package ru.java1;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class MainApp {
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = '0';
    public static final int SIZE = 5;
    public static final int SHTICK = 4;
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
            if(emptyMap()){
                drawMap();
                System.out.println("Ничья");
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

    public static boolean emptyMap() {
        boolean star = false;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(map[i][j] == DOT_EMPTY){
                    star = true;
                    break;
                }
            }
        }
        return !star;
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
        } while (x < 0 || x >= SIZE || y < 0 || y >= SIZE || map[y][x] != DOT_EMPTY);
        map[y][x] = DOT_X;
    }
    public static void aiStep(){
        int x, y;
        boolean step = false;

        for(int i = 0; i < SIZE;i++){
            for(int j = 0; j < SIZE;j++){
                if(map[i][j] == DOT_EMPTY && !step){
                    map[i][j] = DOT_X;
                    if(checkWin(DOT_X)){
                        map[i][j] = DOT_O;
                        step = true;
                        break;
                    }
                    else{
                        map[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        if(!step){
            do{
                Random rand = new Random();
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            } while (map[y][x] != DOT_EMPTY);
            map[y][x] = DOT_O;
        }
    }
    public static boolean checkWin(char symb){

        if(searchWin("rows", symb, 0) || searchWin("column", symb, 0)){
            return true;
        }
            for (int n = (SHTICK - SIZE); n <= (SIZE - SHTICK); n++) {
                if (searchWin("d1", symb, n)) {
                    return true;
                }
            }
            for (int n = (SHTICK-1); n <= SIZE; n++) {
                if (searchWin("d2", symb, n)) {
                    return true;
                }
            }
        return false;
    }

    public static boolean searchWin(String mode, char symb, int n){

        int count = 0;
        for(int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                switch (mode) {
                    case "rows":{
                        if(checkWin(i,j,symb)){
                            count+=1;
                        }
                        else{
                            count = 0;
                        }
                        if(j == SIZE-1 && count != SHTICK){
                            count = 0;
                        }
                        break;
                    }
                    case "column": {
                        if(checkWin(j,i,symb)){
                            count+=1;
                        }
                        else{
                            count = 0;
                        }
                        if(j == SIZE-1 && count != SHTICK){
                            count = 0;
                        }
                        break;
                    }
                    case "d1": {
                        if (i - j == n) {
                            if(checkWin(i, j,symb)){
                                count += 1;
                            }
                            else{
                                count = 0;
                            }
                        }
                        break;
                    }
                    case "d2": {
                        if (i + j == n) {
                            if(checkWin(i, j,symb)){
                                count += 1;
                            }
                            else{
                                count = 0;
                            }
                        }
                        break;
                    }
                }
                if(count==SHTICK){
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean checkWin(int i, int j, char symb){

        if (map[i][j] != symb) {
            return false;
        }
        else{
            return true;
        }
    }
}
