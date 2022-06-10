package by.itacademy.calculator;

import static by.itacademy.calculator.Calculator.calculating;

public class MathUtils {
    static char expression = Calculator.getExpression();
    public static double add(double number1, double number2) {
        return number1 + number2;
    }
    public static double subtract(double number1, double number2) {
        return number1 - number2;
    }

    public static double multiply(double number1, double number2) {
        return number1 * number2;
    }

    public static double divide(double number1, double number2) {

        if (expression == '/' && number2 == 0) {
            System.out.println("trying to divide by zero. use another combination");
            calculating();
        }
        return number1 / number2;
    }
}