/*
Задание: 3, вариант 10;
Условие: Последний отрицательный элемент каждого столбца двухмерного массива размерности n x m заменить нулем
*/
package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static int[][] randArr(final int N, final int M){
        var arr = new int[N][M];
        for (int i = 0; i < N; i++)
            for (int k = 0; k < M; k++)
                arr[i][k] = ThreadLocalRandom.current().nextInt(-500, 500);
        return arr;
    }

    public static String print(int[][] arr){
        String str = "";
        for (int i = 0; i < arr.length; i++){
            for (int k = 0; k < arr[i].length; k++)
                str += String.format("%10s", arr[i][k]);
            str += "\n";
        }
        return str;
    }

    public static void main(String[] args) {
        final int N = 3;
        final int M = 12;
        var arr = randArr(N, M);

        System.out.println("Исходный массив:\n" + print(arr) + "\n\n\n");

        for (int i = 0; i < M; i++)
            for (int k = N - 1; k >= 0;k--)
                if(arr[k][i] < 0){
                    arr[k][i]=0;
                    break;
                }
        System.out.println("Изменённый массив:\n" + print(arr) + "\n\n\n");
    }
}
