package com.company.Test;

import com.company.Utils.MathUtils;

import static org.junit.Assert.assertEquals;

public class Test {
    @org.junit.Test
    public void evaluatesExpression() {
        MathUtils utils = new MathUtils();
        utils.getMath().addTwoValue(12, 6);
        assertEquals(18, utils.getMath().getSum());
    }
}
