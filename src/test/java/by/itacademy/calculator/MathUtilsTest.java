package by.itacademy.calculator;

import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Execution(ExecutionMode.CONCURRENT)
public class MathUtilsTest {

    @ParameterizedTest
    @CsvSource(value = {"2,4,6", "3.1,6.2,9.3", "-3.8,-2.3,-6.1"})
    public void testAddCalculator(double firstNumber, double secondNumber, double expected) {
        double actual = MathUtils.add(firstNumber, secondNumber);
        assertEquals(expected, actual, "Wrong result of method 'Add' ");
    }

    @ParameterizedTest
    @CsvSource(value = {"2,2,5", "2.3,3.2,1.5", "-3,-3,0"})
    public void testAddIncorrectValues(double firstNumber, double secondNumber, double expected) {
        double actual = MathUtils.add(firstNumber, secondNumber);
        assertNotEquals(actual, expected, "Wrong result of method 'Add' ");
    }

    @ParameterizedTest
    @CsvSource(value = {"8,3,5", "9.3,6.2,3.1", "-3,-3,0"})
    public void testSubtractCalculator(double firstNumber, double secondNumber, double expected) {
        double actual = MathUtils.subtract(firstNumber, secondNumber);
        assertEquals(actual, expected, 2, "Wrong result of method 'Subtract' ");
    }

    @ParameterizedTest
    @CsvSource(value = {"2,1,3", "5.5,3.3,2.5", "-3,-3,-3"})
    public void testSubtractIncorrectValues(double firstNumber, double secondNumber, double expected) {
        double actual = MathUtils.subtract(firstNumber, secondNumber);
        assertNotEquals(actual, expected, "Wrong result of method 'Subtract' ");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,9", "2.3,2.1,4.83", "-3,-3,9"})
    public void testMultiplyCalculator(double firstNumber, double secondNumber, double expected) {
        double actual = MathUtils.multiply(firstNumber, secondNumber);
        assertEquals(actual, expected, "Wrong result of method 'Multiply' ");
    }

    @ParameterizedTest
    @CsvSource(value = {"3,3,3", "2.3,2.1,5.5", "-3,-3,-9"})
    public void testMultiplyIncorrectValues(double firstNumber, double secondNumber, double expected) {
        double actual = MathUtils.multiply(firstNumber, secondNumber);
        assertNotEquals(actual, expected, "Wrong result of method 'Multiply' ");
    }

    @ParameterizedTest
    @CsvSource(value = {"6,3,2", "19.2,6.1,3.14", "-3,-3,1"})
    public void testDivideCalculator(double firstNumber, double secondNumber, double expected) {
        double actual = MathUtils.divide(firstNumber, secondNumber);
        assertEquals(actual, expected, 2, "Wrong result of method 'Divide' ");
    }

    @ParameterizedTest
    @CsvSource(value = {"6,3,3", "19.2,6.1,3.0", "-3,-3,-3"})
    public void testDivideIncorrectValues(double firstNumber, double secondNumber, double expected) {
        double actual = MathUtils.divide(firstNumber, secondNumber);
        assertNotEquals(actual, expected, "Wrong result of method 'Divide' ");
    }
}