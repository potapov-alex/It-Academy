package by.itacademy.calculator;

import java.util.Scanner;

import static by.itacademy.calculator.MathUtils.*;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    private static double number1;
    private static double number2;
    private static char expression;

    public static void main(String[] args) {
        calculating();
    }

    public static void calculating() {
        double result = 0;

        number1 = setNumber("Enter first number: ");
        setExpression("Enter transaction: (e.g. '+' , '-' , '*' or '/' )");
        number2 = setNumber("Enter second number: ");

        switch (expression) {
            case '+':
                result = add(number1, number2);
                break;
            case '-':
                result = subtract(number1, number2);
                break;
            case '*':
                result = multiply(number1, number2);
                break;
            case '/':
                result = divide(number1, number2);
                break;
            default:
                calculating();
        }
        System.out.println("calculation result: " + result);
    }

    public static double setNumber(String message) {
        System.out.println(message);
        double number;
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("This is not a number. Try once again");
            scanner.next();
            number = setNumber(message);
        }
        return number;
    }

    public static char setExpression(String message) {
        Calculator.expression = expression;
        String string;
        while (true) {
            System.out.println("\n " + message);
            string = scanner.nextLine();
            if ((string.length() == 1 && string.equals("+")) || (string.length() == 1 && string.equals("-")) ||
                    (string.length() == 1 && string.equals("*")) || (string.length() == 1 && string.equals("/"))) {
                break;
            }
            System.out.println("Incorrect input. " + message);
        }
        expression = string.charAt(0);
        return expression;
    }

    public static char getExpression() {
        return expression;
    }
}