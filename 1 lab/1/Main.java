package com.company;

import java.util.Scanner;

/*
          Вариант 4, номер 5
  Условие: вычислить y=tg(x)+5x^3-4x^2;
*/
public class Main {
    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        double x;

        System.out.print("Введите x: ");
        x = scan.nextDouble();

        System.out.printf("y = %.2f", Math.tan(x) + 5 * Math.pow(x, 3) - 4 * Math.pow(x, 2));
    }
}
