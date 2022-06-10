package by.itacademy.calculator;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class MathUtilsTest {

    @Test
    public void shouldAddPosNumbers() {
        double a = 10.3;
        double b = 6.1;
        double result = MathUtils.add(a, b);
        double expectedResult = 16.4;
        Assertions.assertEquals(expectedResult,result, "Wrong result of method 'add' ");
    }

    @Test
    public void shouldSubtractPosNumbers() {
        double a = 10.3;
        double b = 6.1;
        double result = MathUtils.subtract(a, b);
        double expectedResult = 4.2;
        Assertions.assertEquals(expectedResult,result, "Wrong result of method 'subtract' ");
    }

    @Test
    public void shouldMultiplyPosNumbers() {
        double a = 10.3;
        double b = 6.1;
        double result = MathUtils.multiply(a, b);
        double expectedResult = 62.83;
        Assertions.assertEquals(expectedResult,result, "Wrong result of method 'multiply' ");
    }

    @Test
    public void shouldDivPosNumbers() {
        double a = 10.3;
        double b = 6.1;
        double result = MathUtils.divide(a, b);
        double expectedResult = 1.6885245901639347;
        Assertions.assertEquals(expectedResult,result, "Wrong result of method 'divide' ");
    }
}
