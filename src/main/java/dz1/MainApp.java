package dz1;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args){

        // Задание 1
        int[] mas = {1,1,0,0,1,0,1,1,0,0};
        for(int i = 0; i<mas.length;i++){
            if(mas[i] == 0){
                mas[i] = 1;
            } else{
                mas[i] = 0;
            }
        }
        System.out.println(Arrays.toString(mas));

        // Задание 2
        int[] mas2 = new int[8];
        for(int i = 0; i < mas2.length; i++){
            mas2[i] = i*3;
        }
        System.out.println(Arrays.toString(mas2));

        // Заданеие 3
        int[] mas3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for(int i = 0; i< mas3.length; i++){
            if(mas3[i]<6){
                mas3[i]*=2;
            }
        }
        System.out.println(Arrays.toString(mas3));

        // Задание 4
        int[][] mas4 = new int[5][5];
        for(int i = 0; i < mas4.length; i++){
            for(int j = 0;j < mas4.length; j++){
                if(i==j)
                    mas4[i][j] = 1;
                else mas4[i][j] = 0;
            }
        }
        for(int i = 0; i < mas4.length; i++){
            for(int j = 0;j < mas4.length; j++){
                System.out.print(mas4[i][j]);
            }
            System.out.println();
        }

        // Задание 5
        int[] mas5 = {4,5,73,3,23,8,2,14,9};
        int min = mas5[0];
        int max = mas5[0];

        for(int i = 1; i < mas5.length; i++){
            if(mas5[i] < min){
                min = mas5[i];
            }
            if(mas5[i] > max){
                max = mas5[i];
            }
        }
        System.out.println("Max =" + max);
        System.out.println("Min =" + min);

        // Задание 6
        int[] mas6 = {1, 1, 1, 2, 1};
        boolean check = checkBalance(mas6);
        System.out.println(check);

        // Задание 7
        int[] mas7 = {1,2,3,4,5,6,7,8};
        int shift = -6;
        func(mas7, shift); 
    }

    private static boolean checkBalance(int[] mas){
        boolean check = false;
        for(int i = 1; i < mas.length-1; i++){
            int left = 0;
            int right = 0;
            for(int j = 0; j < mas.length; j++){
                if(j<i){
                    left += mas[j];
                }
                else {
                    right += mas[j];
                }
            }
            if(left == right){
                check = true;
                break;
            }
        }
        return check;
    }


    private static void func(int[] mas, int shift){

        for(int j = 0; j < Math.abs(shift); j++) {
            int last = mas[0];
            int current;
            for (int i = 0; i < mas.length; i++) {
                if (shift > 0) {
                    if (i == 0){
                        mas[i] = mas[mas.length - 1];
                    }
                    else{
                        current = mas[i];
                        mas[i] = last;
                        last = current;
                    }
                }
                else{
                    int index = mas.length-1-i;
                    if (i == 0){
                        last = mas[index];
                        mas[index] = mas[i];
                    }
                    else{
                        current = mas[index];
                        mas[index] = last;
                        last = current;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(mas));
    }
}
