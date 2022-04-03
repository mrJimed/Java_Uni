package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

class OperationLog{
    private String bankName;
    private ArrayList<Operation> operationLog;

    OperationLog(String bankName){ operationLog = new ArrayList<>(); this.bankName = bankName;}
    OperationLog(Operation operation, String bankName){
        this(bankName);
        add(operation);
    }

    public void add(Operation operation){ operationLog.add(operation); }
    public String find(int payerAccount){
        for (int i = 0; i < operationLog.size(); i++)
            if(operationLog.get(i).getPayer() == payerAccount)
                return "Счёт отправителя: " + payerAccount + "  сумма: " + operationLog.get(i).getSum() + "\n";
        return "Такого счёта нет в базе";
    }

    public void sort1(){ Collections.sort(operationLog); }
    public void sort2() { Collections.sort(operationLog, new ComparatorOL()); }
    public void sort3() { Collections.sort(operationLog, (Operation o1, Operation o2)->o1.getRecipient()- o2.getRecipient()); }

    public ArrayList<Operation> filter(int criteria){
        return operationLog.stream().filter(i -> i.getSum() > criteria).collect(Collectors.toCollection(ArrayList<Operation>::new));
    }
    public ArrayList<String> map(){
        return operationLog.stream().map(Operation::toString).collect(Collectors.toCollection(ArrayList<String>::new));
    }
    public ArrayList<Operation> peek(int p){
        return operationLog.stream().peek(i -> i.setPayerAccount(p)).collect(Collectors.toCollection(ArrayList<Operation>::new));
    }
    public ArrayList<Operation> firstN(int N){
        return operationLog.stream().limit(N).collect(Collectors.toCollection(ArrayList<Operation>::new));
    }
    public ArrayList<Operation> lastN(int N){
        var skip = N <= operationLog.size() ? operationLog.size() - N : 0;
        return operationLog.stream().skip(skip).collect(Collectors.toCollection(ArrayList<Operation>::new));
    }
    public Object[] toArray(){
        return operationLog.stream().toArray();
    }
    public Optional<Operation> maxRecipient(){
        return  operationLog.stream().max(Operation::compareTo);
    }
    public boolean onlyOne(int criteria){
        return operationLog.stream().filter(i -> i.getRecipient() == criteria).count() == 1;
    }
    public boolean all(int criteria){
        return operationLog.stream().filter(i -> i.getSum() >= criteria).count() == operationLog.size();
    }

    @Override
    public String toString(){
        var str = "";
        for (int i = 0; i < operationLog.size(); i++)
            str += String.format("%d) %d%10d%15.1f%15s\n",i + 1, operationLog.get(i).getPayer(), operationLog.get(i).getRecipient(), operationLog.get(i).getSum(), bankName);
        return str;
    }

    private class ComparatorOL implements Comparator<Operation> {
        @Override
        public int compare(Operation o1, Operation o2) {
            return o1.getRecipient() - o2.getRecipient();
        }
    }
}
