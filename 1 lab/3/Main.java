package com.company;

import java.util.Scanner;

/*
                Вариант: 4, задание 25
Условие: вычислить y = x^2-sin(x)+cos(x);
*/
public class Main {

    public static void main(String[] args) {
	var scan = new Scanner(System.in);
    System.out.print("Введите x: "); var x = scan.nextDouble();
    System.out.printf("y = %.2f", x * x - Math.sin(x) + Math.cos(x));
    }
}
