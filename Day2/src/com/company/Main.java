package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Account>users = new ArrayList<>();

        users.add(new Account("Jonas", "jonas@jonas.lt", 10, 100));
        users.add(new Account("Krapas", "krapas@jonas.lt", 13000, 100));
        users.add(new Account("Dzonis", "dzonis@jonas.lt", 21000, 100));
        users.add(new Account("bronius", "bronius@jonas.lt", 10020, 100));

        for (int i = 0; i<users.size(); i++) System.out.println(users.get(i));
        System.out.println("\n");

        new Menu();

        Transaction transaction = new Transaction(users.get(3), users.get(1), 999);

        transaction.makeTransaction();
        System.out.println(transaction.toString());
    }

}