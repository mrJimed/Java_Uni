/*
Вариант: 4

Организовать различные способы записи данных:
•	чтение с клавиатуры +
•	чтение из файла +
•	заполнение сгенерированными значениями +
Придумать и реализовать два собственных метода в классе. +
Сортировку реализовать несколькими вариантами:
•	реализовав для класса интерфейс Comparable (тогда в метод sort коллекции в качестве компаратора передаётся null или использовать Collections.sort без параметра); +
•	реализовав класс компаратора или использовать реализацию метода при инстанцировании (создании экземпляра); +
•	определив компаратор с использованием лямбда выражения (т.к. интерфейс Comparator является функциональным) +


 Описать класс с именем «Операция», содержащий поля:
•	расчетный счет плательщика; +
•	расчетный счет получателя; +
•	перечисляемая сумма в руб. +
Описать класс с именем «Журнал операций», содержащий поля:
•	название банка; +
•	список операций (список объектов класса «Операция»). +
Написать программу, выполняющую следующие действия:
•	ввод с клавиатуры данных класса типа «Операция»; +
•	вывод на экран информации о сумме, снятой с расчетного счета плательщика, введенного с клавиатуры, если таких счетов нет, вывести соответствующее сообщение; +
•	сортировку списка операций по счету получателя и вывод отсортированного списка. +
*/
package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void fill(int q, OperationLog operationLog, Scanner scan) throws FileNotFoundException {
        switch (q){
            case 1:
                System.out.print("Введите счёт плательщика: "); int payerAccount = scan.nextInt();
                System.out.print("Введите счёт получателя: "); int recipientAccount = scan.nextInt();
                System.out.print("Сумма: "); double sumMoney = scan.nextDouble();
                System.out.println("Название банка: "); String bankName = scan.nextLine();
                operationLog.add(new Operation(payerAccount, recipientAccount, sumMoney), bankName);
                break;

            case 2:
                Scanner obj = new Scanner(new File("TXT.txt"));

                while (obj.hasNextLine()){
                    var txt = obj.nextLine().split(" ");
                    operationLog.add(new Operation(Integer.parseInt(txt[0]), Integer.parseInt(txt[1]), Double.parseDouble(txt[2])), txt[3]);
                }
                break;

            case 3:
                var bankNames = new String[]{"Сбербанк", "ВТБ", "Открытие", "Тинькофф", "Альфа"};
                int radPayerAcc;
                int  randRecipientAccount;
                double randSum;

                for (int k = 0; k < 20; k++){
                    radPayerAcc = ThreadLocalRandom.current().nextInt(10000, 99999);
                    randRecipientAccount = ThreadLocalRandom.current().nextInt(10000, 99999);
                    randSum = ThreadLocalRandom.current().nextDouble(1, 99999.99);
                    operationLog.add(new Operation(radPayerAcc, randRecipientAccount, randSum), bankNames[ThreadLocalRandom.current().nextInt(0, 5)]);
                }
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        var scan = new Scanner(System.in);
        var operationLog = new OperationLog();
        System.out.println("\t\tMenu");
        System.out.println("1) Ввод с клавиатуры");
        System.out.println("2) Чтение из файла");
        System.out.println("3) Случайные значения");
        System.out.print("Ответ: ");
        var q = scan.nextInt();
        fill(q, operationLog, scan);

        System.out.println("Исходный Журнал Операций:\n");
        System.out.println(operationLog.toString());

        System.out.print("Введите счёт плательщика: "); var acc = scan.nextInt();
        System.out.println(operationLog.find(acc));

        System.out.println("\n\nОтсортированный Журнал операций:\n\n");
        operationLog.sort2();
        System.out.println(operationLog.toString());
    }
}
