package Test;

import static org.junit.Assert.assertEquals;

import Matematika.Math;
import org.junit.Test;

public class MathTest {
    @Test
    public void evaluatesExpression() {
        Math sum = new Math();
        sum.addTwoValue(12, 6);
        assertEquals(18, sum.getSum());
    }
}