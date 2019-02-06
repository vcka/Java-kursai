package com.company;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        int a1 = 0;
        int a2 = 0;
        int r1 = 0;
        int r2 = 0;
        int c9 = 0;
        String code = String.valueOf(213179412);
        IntStream numbers = code.chars().map(Character::getNumericValue);
        //A1 A2
        int[] numbersArray = numbers.toArray();
        if (numbersArray[7] == 1) {
            int o = 3;
            for (int i = 0; i < numbersArray.length-1; i++) {

                a1 += ((i + 1) * numbersArray[i]);
                if ((i - 1) != numbersArray.length) {
                    a2 += ((o++) * numbersArray[i]);
                }
                a2 += numbersArray[i];
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
        } else {
            System.out.println("Neteisingas PVM");
        }
        if (c9 == 2) System.out.println("Kodas yra tesingas");

        System.out.println("A1 "+a1);
        System.out.println("R1 "+r1);
        System.out.println("A2 "+a2);
        System.out.println("C9 "+c9);
        System.out.println("R2 "+r2);
        System.out.println(a1%11);
        int a = numbersArray[0]*1+numbersArray[1]*2+numbersArray[3]*3+numbersArray[4]*4+numbersArray[5]*5+numbersArray[6]*6+numbersArray[7]*7+numbersArray[8]*8;
        System.out.println(a%11);

    }
}
