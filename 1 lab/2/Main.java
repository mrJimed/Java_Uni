package com.company;

import java.util.Scanner;

/*
                                  Вариант: 4, задание 15
Условие: вычислить длину гипотенузы прямоугольного треугольника, зная длины двух катетов;
*/
public class Main {

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        System.out.print("Введите длину 1-го катета: "); var a = scan.nextDouble();
        System.out.print("Введите длину 2-го катета: "); var b = scan.nextDouble();
        System.out.printf("Ответ: %.2f", Math.sqrt(a * a + b * b));
    }
}
