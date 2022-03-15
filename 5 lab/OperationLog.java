package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class OperationLog{
    private ArrayList<Pair> operationLog;

    OperationLog(){ operationLog = new ArrayList<>(); }
    OperationLog(Operation operation, String bankName){
        this();
        add(operation, bankName);
    }

    public void add(Operation operation, String bankName){ operationLog.add(new Pair(operation, bankName)); }
    public String find(int payerAccount){
        for (int i = 0; i < operationLog.size(); i++)
            if(operationLog.get(i).operation.getPayer() == payerAccount)
                return "Счёт отправителя: " + payerAccount + "  сумма: " + operationLog.get(i).operation.getSum() + "\n";
        return "Такого счёта нет в базе";
    }
    public void sort1(){ Collections.sort(operationLog); }
    public void sort2() { Collections.sort(operationLog, new ComparatorOL()); }
    public void sort3() { Collections.sort(operationLog, (Pair o1, Pair o2)->o1.operation.getRecipient()- o2.operation.getRecipient()); }

    @Override
    public String toString(){
        var str = "";
        for (int i = 0; i < operationLog.size(); i++)
            str += String.format("%d) %d%10d%15.1f%15s\n",i + 1, operationLog.get(i).operation.getPayer(), operationLog.get(i).operation.getRecipient(), operationLog.get(i).operation.getSum(), operationLog.get(i).bankName);
        return str;
    }

    private class Pair implements Comparable<Pair>{
        public Operation operation;
        public String bankName;

        Pair(Operation operation, String bankName){
            this.operation = operation;
            this.bankName = bankName;
        }

        @Override
        public int compareTo(Pair o) { return operation.getRecipient() - o.operation.getRecipient(); }
    }

    private class ComparatorOL implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.operation.getRecipient() - o2.operation.getRecipient();
        }
    }
}
