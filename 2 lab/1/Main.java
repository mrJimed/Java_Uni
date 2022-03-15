package com.company;

import java.util.Scanner;

// Вариант 18
public class Main {

    public static void main(String[] args) {
	var scan = new Scanner(System.in);
    System.out.print("Введите а: "); var a = scan.nextDouble();
    System.out.print("Введите b: "); var b = scan.nextDouble();
    System.out.print("Введите c: "); var c = scan.nextDouble();
    System.out.print("Введите x: "); var x = scan.nextDouble();

    if(x < 0 && b != 0)
        System.out.printf("Ответ: %.2f", -1 * (2 * x - c)/(c * x - a));
    else if(x > 0 && b == 0)
        System.out.printf("Ответ: %.2f", (x - a)/(x - c));
    else
        System.out.printf("Ответ: %.2f", -x/c + (-c)/(2 * x));
    }
}
