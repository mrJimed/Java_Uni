package com.company;

public class Operation implements Comparable<Operation>{
    private int payerAccount;
    private int recipientAccount;
    private double sumMoney;

    Operation(){
        payerAccount = recipientAccount = 0;
        sumMoney = 0;
    }
    Operation(int payerAccount, int recipientAccount, double sumMoney){
        add(payerAccount, recipientAccount, sumMoney);
    }

    public void add(int payerAccount, int recipientAccount, double sumMoney){
        if(payerAccount > 0 && recipientAccount > 0 && sumMoney > 0){
            this.sumMoney = sumMoney;
            this.payerAccount = payerAccount;
            this.recipientAccount = recipientAccount;
        }
    }
    public void setPayerAccount(int payerAccount){
        this.payerAccount = payerAccount;
    }

    public int getPayer(){ return payerAccount; }
    public int getRecipient(){ return recipientAccount; }
    public double getSum(){ return sumMoney; }

    @Override
    public String toString() {
        return String.format("Счёт получателя: %d\nСчёт плательщика: %d\nСумма: %.2f\n", recipientAccount, payerAccount, sumMoney );
    }

    @Override
    public int compareTo(Operation o) {
        return recipientAccount - o.recipientAccount;
    }
}
