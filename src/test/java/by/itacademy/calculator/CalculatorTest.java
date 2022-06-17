package by.itacademy.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class CalculatorTest {

    static double number = 4.0;

    @Test
    public void scanNumberTesting() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Give a number between 1 and 10");
        int input = keyboard.nextInt();

        double scanNumber = Calculator.setNumber("My number");
        assertEquals(number, 1, "Scanned not a number");
    }
}
