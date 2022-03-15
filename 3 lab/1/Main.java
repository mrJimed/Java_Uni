package com.company;
/*
Вариант: 18
Условие: Составить алгоритм для расчета функции y= ln(sin(x)+1)*0.15
         при x∈[2;2.8] с шагом 0.2.

*/
public class Main {

    public static void main(String[] args) {
	for (double x = 2; x < 2.81;x += 0.2)
        System.out.printf("x: %.2f\t\ty: %.2f\n", x, Math.log(Math.sin(x)+1)*0.15);
    }
}
