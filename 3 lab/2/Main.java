package com.company;

import java.util.Scanner;

/*
                                Вариант 4
 	Найти сумму ряда с точностью ε, общий член которого равен
    a_n=n^2 * e^(-√n)
    Точность считается достигнутой, если следующий член последовательности меньше заданного ε.
*/
public class Main {

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        int n = 1;
        double sum = 0;
        System.out.print("Введите точность для задачи: "); var eps = scan.nextDouble();

        while (n*n*Math.exp(-Math.sqrt(n)) > eps) {
            sum+=n*n*Math.exp(-Math.sqrt(n));
            n++;
        }
        System.out.printf("Сумма для задачи с while = %.5f\n",sum);

        sum = 0; n = 1;
        do {
            sum+=n*n*Math.exp(-Math.sqrt(n));
            n++;
        }while ((n-1)*(n-1)*Math.exp(-Math.sqrt(n-1)) > eps);
        sum-=(n-1)*(n-1)*Math.exp(-Math.sqrt(n-1));
        System.out.printf("Сумма для задачи с do while = %.5f\n",sum);
    }
}
