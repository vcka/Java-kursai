package com.company;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        String s = "1234567891";
        if (s.matches("\\d{9}")) System.out.println(s);

        PvmValidatorius pvmValidatorius = new PvmValidatorius();
        IntStream code = pvmValidatorius.enterCode();
        pvmValidatorius.tikrintiPVMkoda(code);
    }
}
//        System.out.println(pvmValidatorius.tikrintiPVMkoda(pvmValidatorius.enterCode()) ? "PVM moketojo kodas yra teisingas" : "PVM moketojo kodas yra neteisingas");