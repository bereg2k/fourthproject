import exceptions.DivisionByZeroException;
import operations.Operation;
import operations.Multiplication;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test suite for various unit tests for Multiplication operation.
 */
public class TestsMultiplication {

    @BeforeClass //method for informational message before all tests here are started
    public static void testsSetup() {
        System.out.println("The Multiplication test suite has started...");
    }

    @Test //regular multiplication test with 2 positive 2-digit numbers
    public void testMultiplicationTwoDigitNumbers() throws DivisionByZeroException {
        Operation operation = new Multiplication(47, 23);
        assertEquals("Multiplication works incorrectly!", 1081, operation.calculateResult(), 0);
    }

    @Test //various multiplication tests with positive/negative 2-digit numbers
    public void testMultiplicationNegativeAndPositiveNumbers() throws DivisionByZeroException {
        Operation operation1 = new Multiplication(-23, 47);
        Operation operation2 = new Multiplication(23, -12);
        Operation operation3 = new Multiplication(-23, -12);

        assertEquals("Multiplication works incorrectly!", -1081, operation1.calculateResult(), 0);
        assertEquals("Multiplication works incorrectly!", -276, operation2.calculateResult(), 0);
        assertEquals("Multiplication works incorrectly!", 276, operation3.calculateResult(), 0);
    }

    @Test //Multiplication test for numbers with decimal points
    public void testMultiplicationDecimalPointNumbers() throws DivisionByZeroException {
        Operation operation1 = new Multiplication(12.494900, 15.384385);
        Operation operation2 = new Multiplication(45.3844, 1.23d);
        Operation operation3 = new Multiplication(45.3844d, 1.2301d);
        Operation operation4 = new Multiplication(15d, 11d);

        assertEquals("Multiplication works incorrectly!", 192.23, operation1.calculateResult(), 0.009);
        assertEquals("Multiplication works incorrectly!", 55.82, operation2.calculateResult(), 0.009);
        assertEquals("Multiplication works incorrectly!", 55.83, operation3.calculateResult(), 0.009);
        assertEquals("Multiplication works incorrectly!", 165.00, operation4.calculateResult(), 0.009);
    }

    @Test //Multiplication test for float numbers that have different rounding algorithm
    public void testMultiplicationFloatNumbers() throws DivisionByZeroException {
        Operation operation1 = new Multiplication(45.52f, 12.23f);
        Operation operation2 = new Multiplication(45.52d, 12.23f);

        assertEquals("Multiplication works incorrectly!", 556.71, operation1.calculateResult(), 0.009);
        assertEquals("Multiplication works incorrectly!", 556.71, operation2.calculateResult(), 0.009);
    }

    @Test //Multiplication test for numbers and zeros
    public void testMultiplicationWithZero() throws DivisionByZeroException {
        Operation operation1 = new Multiplication(12, 0);
        Operation operation2 = new Multiplication(0, 12);
        Operation operation3 = new Multiplication(0, 0);

        assertEquals("Multiplication works incorrectly!", 0, operation1.calculateResult(), 0);
        assertEquals("Multiplication works incorrectly!", 0, operation2.calculateResult(), 0);
        assertEquals("Multiplication works incorrectly!", 0, operation3.calculateResult(), 0);
    }

    @Test //Multiplication test for super big numbers
    public void testMultiplicationBigNumbers() throws DivisionByZeroException {
        Operation operation1 = new Multiplication
                (1234567890123456789012345678901234567890123456789012345678901234567890D,
                        1234567890123456789012345678901234567890123456789012345678901234567890D);

        assertEquals
                ("Multiplication works incorrectly!",
                        1.5241578753238836750190519987502e+138, operation1.calculateResult(), 0);
    }

    @Test //generic test validation operation's sign
    public void testMultiplicationSign() {
        Operation operation1 = new Multiplication(13, 13);
        assertEquals("Multiplication works incorrectly!", "*", operation1.getOperationSign());
    }

    @After //method for informational message after every test
    public void afterTests() {
        System.out.println("The Multiplication test has finished.");
    }

    @AfterClass //method for informational message after all tests here are finished
    public static void testsClose() {
        System.out.println("The Multiplication test suite has finished.");
    }
}
