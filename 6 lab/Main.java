/*
Создать коллекцию (ArrayList) из нескольких десятков экземпляров, используя иерархию классов из практической работы №5.
Выполнить с коллекцией следующие действия с помощью Stream API:
•	отфильтровать коллекцию по произвольному критерию, используя оператор filter (например, получить все объекты определённого типа); +
•	трансформировать коллекцию, используя оператор map (например, из первоначальной коллекции объектов получить коллекцию строковых представлений,
    возвращаемых методом toString); +
•	выполнить обработку объектов, используя оператор peek (например, установить новое значение одного из атрибутов для каждого объекта); +
•	получить первые N объектов коллекции; +
•	получить последние N объектов коллекции; +
•	преобразовать коллекцию в массив; +
•	найти в коллекции объект с минимальным или максимальным значением одного из атрибутов; +
•	проверить что один из объектов коллекции удовлетворяет какому-либо условию; +
•	проверить что каждый из объектов коллекции удовлетворяет какому-либо условию. +

*/
package com.company;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static OperationLog randOperations(int length){
        var opLog = new OperationLog("Сбербанк");

        for (int i = 0; i < length; i++)
            opLog.add(new Operation(ThreadLocalRandom.current().nextInt(10000, 99999), ThreadLocalRandom.current().nextInt(10000, 99999), ThreadLocalRandom.current().nextInt(0, 99999)));
        return opLog;
    }

    public static void printStr(ArrayList<String > str){
        for (var i:str)
            System.out.println(i.toString());
        System.out.println("---------------------------------------------------------");
    }

    public static void printOp(ArrayList<Operation> op){
        for (var i:op)
            System.out.println(i.toString());
        System.out.println("---------------------------------------------------------");
    }

    public static void main(String[] args) {
        var opLog = randOperations(14);
        opLog.add(new Operation(14, 12, 98));

        System.out.println("Полный список журнала операций:");
        System.out.println(opLog.toString());

        int sum = 10000;
        System.out.printf("Отфильтрованная коллекция по сумма больше %d\n\n", sum);
        printOp(opLog.filter(sum));

        System.out.println("Коллекция строковых представлений:\n");
        printStr(opLog.map());

        int q = -1;
        System.out.printf("Заменим счёт плательщика на %d\n", q);
        printOp(opLog.peek(q));

        int n = 4;
        System.out.printf("Первый %d элеменов\n", n);
        printOp(opLog.firstN(n));

        System.out.printf("Последние %d элеменов\n", n);
        printOp(opLog.lastN(n));

        System.out.println("Объект с макс счётом получателя");
        System.out.println(opLog.maxRecipient().toString());
        System.out.println("---------------------------------------------------------");

        int recipient = 12;
        System.out.printf("Счёт получателя равен %d: %b\n", recipient, opLog.onlyOne(recipient));

        int s = 100;
        System.out.printf("Сумма везде больше, чем %d: %b\n", s, opLog.all(s));
    }
}
