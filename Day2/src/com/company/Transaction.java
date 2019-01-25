package com.company;

public class Transaction {
    private Account sender;
    private Account reciever;
    private double sum;

    public Transaction(Account sender, Account reciever, double sum) {
        this.sender = sender;
        this.reciever = reciever;
        this.sum = sum;
    }

    public Account getSender() {
        return sender;
    }

    public Account getReciever() {
        return reciever;
    }

    public double getSum() {
        return sum;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public void setReciever(Account reciever) {
        this.reciever = reciever;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "sender=" + sender + "\n"+
                ", reciever=" + reciever +"\n"+
                ", Suma=" + sum +
                '}';
    }

    public void makeTransaction(){
        if (sender.getBalance()>sum) {
            sender.setBalance(sender.getBalance() - sum);
            reciever.setBalance(reciever.getBalance() + sum);
        }else{
            System.out.println("Nepakanka lesu");
        }
    }
}
