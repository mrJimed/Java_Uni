/*
   Задание: 2, вариант: 5
   Условие: Дан одномерный массив А состоящий из 2n элементов. Переставить элементы массива следующим образом:
            a[2n], a[2n-1], . . .,a[n+1], a[1], a[2], . . ., a[n]

*/
package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static String print(int[] arr){
        String str = "";
        for (int i = 0; i < arr.length; i++)
            str+=String.format(arr[i] + " ");
        return str;
    }

    public static int[] randArr(final int N){
        var arr = new int[2*N];

        for (int i = 0;i < 2*N;i++)
            arr[i] = ThreadLocalRandom.current().nextInt(0, 100);
        return arr;
    }

    public static void main(String[] args) {
        final int N = 3;
        var arr = randArr(N);
        System.out.printf("Исходный массив: %s\n\n", print(arr));

        for (int i = 0; i < N; i++){
            int temp = arr[2*N-1];
            for (int k = 2*N-1; k > i; k--)
                arr[k]=arr[k-1];
            arr[i]=temp;
        }

        System.out.printf("Новый массив: %s\n\n", print(arr));
    }
}
