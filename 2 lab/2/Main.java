package com.company;

import java.util.Scanner;
/*
                                                     Вариант: 18
    Условие: Написать программу, которая бы по введенному номеру времени года (1 — зима, 2 — весна, 3 — лето, 4 — осень)
    выдавала соответствующие этому времени года месяцы, количество дней в каждом из месяцев.
*/
public class Main {

    public static void main(String[] args) {
	var scan = new Scanner(System.in);
    System.out.print("Введите номер месяца: "); var season = scan.nextByte();
    switch (season){
        case 1:
            System.out.println("Время года: зима");
            System.out.print("Месяцы: Декабрь(31), Январь(31), Февраль(28-29)");
            break;
        case 2:
            System.out.println("Время года: весна");
            System.out.print("Месяцы: Март(31), Апрель(30), Май(31)");
            break;
        case 3:
            System.out.println("Время года: лето");
            System.out.print("Месяцы: Июнь(30), Июль(31), Август(31)");
            break;
        case 4:
            System.out.println("Время года: осень");
            System.out.print("Месяцы: Сентябрь(30), Октябрь(31), Ноябрь(30)");
            break;
        default:
            System.out.println("Ошибка при вводе");
            break;
    }
    }
}
