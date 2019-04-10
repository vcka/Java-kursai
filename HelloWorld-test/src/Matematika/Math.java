package Matematika;

import org.apache.log4j.Logger;

public class Math {
    private static final Logger LOGGER = Logger.getLogger(Main.class);
    private int sum;

    public int addTwoValue(int a, int b){
        sum = a + b;
        LOGGER.info(sum);
        return sum;
    }

    public void showSumOfTwoValues(){
        System.out.println("SUM of two values: " + sum);
    }

    @Override
    public String toString() {
        return "Matematika.Math{" +
                "sum=" + sum +
                '}';
    }

    public int getSum() {
        return sum;
    }
}
