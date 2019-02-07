package com.company;

import java.util.Scanner;
import java.util.stream.IntStream;

public class PvmValidatorius {
    private int a1 = 0;
    private int a2 = 0;
    private int r1;
    private int r2;
    private int c9;

    final void tikrintiPVMkoda(IntStream numbers) {
        if (pvmChecker(numbers)) {
            System.out.println("PVM moketojo kodas yra teisingas");
        } else {
            System.out.println("PVM moketojo kodas yra neteisingas");
        }
    }

    final IntStream enterCode() {
        return code();
    }

    private boolean pvmChecker(IntStream numbers) {
        //A1 A2
        int[] numbersArray = numbers.toArray();
        if (numbersArray[7] == 1) {
            int o = 3;
            for (int i = 0; i < numbersArray.length - 1; i++) {
                a1 += ((i + 1) * numbersArray[i]);
                if ((i - 1) != numbersArray.length - 3) {
                    a2 += ((o++) * numbersArray[i]);
                } else {
                    a2 += numbersArray[i];
                }
            }
            //R1
            r1 = a1 % 11;
            //C9
            if (r1 != 10) {
                c9 = r1;
            } else {
                r2 = a2 % 11;
                if (r2 == 10) {
                    c9 = 0;
                } else {
                    c9 = r2;
                }
            }
        }
        return c9 == numbersArray[8];
    }

    private IntStream code() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite 9 skaiciu pvm koda:");
        String number = sc.nextLine();
        while (number.length() != 9 || !number.chars().allMatch(Character::isDigit)) {
            System.out.println("Neteisingai ivestas kodas! Bandykite dar karta.");
            number = sc.next();
        }
        sc.close();
        return number.chars().map(Character::getNumericValue);
    }
}
