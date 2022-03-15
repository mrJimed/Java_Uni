package com.company;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/*
Задание 1:

Дан фрагмент программы:
final int N = 365;
double [] t = new double[N];
По массиву t, где указана температура каждого дня некоторого невисокосного года, определите название месяца:
a.	с максимальной среднемесячной температурой;  +
b.	с наибольшим количеством отрицательных температур; +
c.	с минимальной годовой температурой; +
d.	с максимальной температурой в третьей декаде.
*/
public class Main {
    public static String getFinalStrSw(double[] maxT, String text, double val){
        switch (findIndex(maxT, val))
        {
            case 0: return String.format("Месяц: Январь\n%s: %.2f", text, val);
            case 1: return String.format("Месяц: Февраль\n%s: %.2f", text, val);
            case 2: return String.format("Месяц: Март\n%s: %.2f", text, val);
            case 3: return String.format("Месяц: Апрель\n%s: %.2f", text, val);
            case 4: return String.format("Месяц: Май\n%s: %.2f", text, val);
            case 5: return String.format("Месяц: Июнь\n%s: %.2f", text, val);
            case 6: return String.format("Месяц: Июль\n%s: %.2f", text, val);
            case 7: return String.format("Месяц: Август\n%s: %.2f", text, val);
            case 8: return String.format("Месяц: Сентябрь\n%s: %.2f", text, val);
            case 9: return String.format("Месяц: Октябрь\n%s: %.2f", text, val);
            case 10: return String.format("Месяц: Ноябрь\n%s: %.2f", text, val);
            case 11: return String.format("Месяц: Декабрь\n%s: %.2f", text, val);
            default: return "";
        }
    }
    public static int findIndex(double[] arr, double val){
        for (int i = 0; i < arr.length; i++)
            if(arr[i] == val)return i;
        return -1;
    }

    public static String a(double[] t){
        var maxT = new double[12];
        for (int i = 0; i < t.length; i++){
            if(i < 31) maxT[0]+=t[i];
            else if(i >= 31 & i < 59) maxT[1]+=t[i];
            else if(i >= 59 && i < 90) maxT[2]+=t[i];
            else if(i >= 90 && i < 120) maxT[3]+=t[i];
            else if(i >= 120 && i < 151) maxT[4]+=t[i];
            else if(i >= 151 && i < 181) maxT[5]+=t[i];
            else if(i >= 181 && i < 212) maxT[6]+=t[i];
            else if(i >= 212 && i < 243) maxT[7]+=t[i];
            else if(i >= 243 && i < 273) maxT[8]+=t[i];
            else if(i >= 273 && i < 304) maxT[9]+=t[i];
            else if(i >= 304 && i < 334) maxT[10]+=t[i];
            else maxT[11] += t[i];
        }
        for (int i = 0; i < maxT.length;i++) {
            if(i == 0 || i == 2 || i == 4 || i == 6 || i == 7 || i == 9 || i == 11) maxT[i]/=31;
            else if(i == 1) maxT[i]/=28;
            else maxT[i]/=30;
        }
        return getFinalStrSw(maxT, "Максимальная среднемесячная температура:", Arrays.stream(maxT).max().getAsDouble());
    }

    public static String b(double[] t){
        var count = new double[12];
        for (int i = 0;i < t.length;i++){
            if(i < 31 && t[i] < 0) count[0]++;
            else if(i >= 31 & i < 59) count[1]++;
            else if(i >= 59 && i < 90) count[2]++;
            else if(i >= 90 && i < 120) count[3]++;
            else if(i >= 120 && i < 151) count[4]++;
            else if(i >= 151 && i < 181) count[5]++;
            else if(i >= 181 && i < 212) count[6]++;
            else if(i >= 212 && i < 243) count[7]++;
            else if(i >= 243 && i < 273) count[8]++;
            else if(i >= 273 && i < 304) count[9]++;
            else if(i >= 304 && i < 334) count[10]++;
            else count[11]++;
        }
        return getFinalStrSw(count, "Кол-во отрицательных температур", Arrays.stream(count).max().getAsDouble());
    }

    public static String c(double[] t){
        var index = findIndex(t, Arrays.stream(t).min().getAsDouble());
        if(index < 31) return String.format("Месяц: Январь\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else if(index >= 31 & index < 59) return String.format("Месяц: Февраль\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else if(index >= 59 && index < 90) return String.format("Месяц: Март\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else if(index >= 90 && index < 120) return String.format("Месяц: Апрель\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else if(index >= 120 && index < 151) return String.format("Месяц: Май\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else if(index >= 151 && index < 181) return String.format("Месяц: Июнь\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else if(index >= 181 && index < 212) return String.format("Месяц: Июль\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else if(index >= 212 && index < 243) return String.format("Месяц: Август\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else if(index >= 243 && index < 273) return String.format("Месяц: Сентябрь\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else if(index >= 273 && index < 304) return String.format("Месяц: Октябрь\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else if(index >= 304 && index < 334) return String.format("Месяц: Ноябрь\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
        else return String.format("Месяц: Декабрь\nМин. температура: %.2f", Arrays.stream(t).min().getAsDouble());
    }

    public static String d(double[] t){
        var maxT = t[20];
        var nameM = "Январь";

        for (int i = 0; i < t.length;i++){
            if(maxT < t[i] && i>=20 && i<=30){
                maxT = t[i];
                nameM="Январь";
            }else if(maxT < t[i] && i>=51 && i<=58){
                maxT = t[i];
                nameM="Февраль";
            }else if(maxT < t[i] && i>=79 && i<=89){
                maxT = t[i];
                nameM="Март";
            }else if(maxT < t[i] && i>=110 && i<=119){
                maxT = t[i];
                nameM="Апрель";
            }else if(maxT < t[i] && i>=140 && i<=150){
                maxT = t[i];
                nameM="Май";
            }else if(maxT < t[i] && i>=171 && i<=180){
                maxT = t[i];
                nameM="Июнь";
            }else if(maxT < t[i] && i>=201 && i<=210){
                maxT = t[i];
                nameM="Июль";
            }else if(maxT < t[i] && i>=234 && i<=242){
                maxT = t[i];
                nameM="Август";
            }else if(maxT < t[i] && i>=263 && i<=272){
                maxT = t[i];
                nameM="Сентябрь";
            }else if(maxT < t[i] && i>=293 && i<=303){
                maxT = t[i];
                nameM="Октябрь";
            }else if(maxT < t[i] && i>=324 && i<=333){
                maxT = t[i];
                nameM="Ноябрь";
            }else if(maxT < t[i] && i>=354 && i<=364){
                maxT = t[i];
                nameM="Декабрь";
            }
        }
        return String.format("Месяц: %s\nМаксимальная t в 3-ей декаде: %.2f", nameM, maxT);
    }

    public static void main(String[] args) {
        final int N = 365;
        var t = new double[N];

        for (int i = 0; i < N;i++) {
            if (i >= 0 && i < 59 || i >=334)
                t[i] = ThreadLocalRandom.current().nextDouble(-40.4, -10.4);
            else if(i >= 59 && i < 151)
                t[i] = ThreadLocalRandom.current().nextDouble(-10.5, -2.9);
            else if(i >= 151 && i < 243)
                t[i] = ThreadLocalRandom.current().nextDouble(20.1, 45.9);
            else if(i >= 243 && i < 334)
                t[i] = ThreadLocalRandom.current().nextDouble(7.0, 17.9);
        }
        System.out.println("\n" + a(t) + "\n\n");
        System.out.println(b(t)+ "\n\n");
        System.out.println(c(t)+ "\n\n");
        System.out.println(d(t));
    }
}