package com.company;

import java.util.Scanner;

/*
 Задание: 2, вариант 24
 Условие: Составить программу, позволяющую по последней цифре данного числа определить последнюю цифру куба этого числа
*/
public class Main {

    public static void main(String[] args) {
        var scan = new Scanner(System.in);
        System.out.print("Введите число: "); var val = scan.nextInt();
        int temp = val;
        val%=10;
        switch ((val*val*val) % 10)
        {
            case 0: System.out.printf("Последняя цифра куба числа %d = 0", temp); break;
            case 1: System.out.printf("Последняя цифра куба числа %d = 1", temp); break;
            case 2: System.out.printf("Последняя цифра куба числа %d = 2", temp); break;
            case 3: System.out.printf("Последняя цифра куба числа %d = 3", temp); break;
            case 4: System.out.printf("Последняя цифра куба числа %d = 4", temp); break;
            case 5: System.out.printf("Последняя цифра куба числа %d = 5", temp); break;
            case 6: System.out.printf("Последняя цифра куба числа %d = 6", temp); break;
            case 7: System.out.printf("Последняя цифра куба числа %d = 7", temp); break;
            case 8: System.out.printf("Последняя цифра куба числа %d = 8", temp); break;
            case 9: System.out.printf("Последняя цифра куба числа %d = 9", temp); break;
        }
    }
}
