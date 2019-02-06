package com.company;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Transaction> transactions = Transaction.transactions(10);
        print(transactions);

        List<Transaction> newTransactions = transactions.stream()
                .filter(transaction -> transaction.getId() % 2 == 0)
                .filter(transaction -> transaction.getAmount() > 1008)
                .map(transaction -> new Transaction(transaction.getId(), transaction.getDateTime(),transaction.getAmount() * 2))
                .collect(Collectors.toList());

        Map<Integer, Integer> transactionMap = transactions.stream()
                .collect(Collectors.toMap(
                        transaction -> transaction.getId(),
                        transaction -> transaction.getAmount()));

        Map<Integer, Integer> transactionMap2 = transactions.stream()
                .collect(Collectors.toMap(Transaction::getId, Transaction::getAmount));





        print(newTransactions);
        print(transactionMap.entrySet());
        print(transactionMap2.entrySet());
    }

    private static void print(Collection list){
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------");
    }

//    private static Transaction getTransactionByID(int id, Supplier<Transaction> defaultValue){
//        Transaction transaction = getTransactionByID();
//    }
}
