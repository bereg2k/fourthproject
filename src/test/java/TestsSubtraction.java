import exceptions.DivisionByZeroException;
import operations.Subtraction;
import operations.Operation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test suite for various unit tests for Subtraction operation.
 */
public class TestsSubtraction {

    @BeforeClass //method for informational message before all tests here are started
    public static void testsSetup() {
        System.out.println("The Subtraction test suite has started...");
    }

    @Test //regular subtraction test with 2 positive 2-digit numbers
    public void testSubtractionTwoDigitNumbers() throws DivisionByZeroException {
        Operation operation = new Subtraction(47, 23);
        assertEquals("Subtraction works incorrectly!", 24, operation.calculateResult(), 0);
    }

    @Test //various subtraction tests with positive/negative 2-digit numbers
    public void testSubtractionNegativeAndPositiveNumbers() throws DivisionByZeroException {
        Operation operation1 = new Subtraction(-23, 47);
        Operation operation2 = new Subtraction(23, -12);
        Operation operation3 = new Subtraction(-23, -12);

        assertEquals("Subtraction works incorrectly!", -70, operation1.calculateResult(), 0);
        assertEquals("Subtraction works incorrectly!", 35, operation2.calculateResult(), 0);
        assertEquals("Subtraction works incorrectly!", -11, operation3.calculateResult(), 0);
    }

    @Test //Subtraction test for numbers with decimal points
    public void testSubtractionDecimalPointNumbers() throws DivisionByZeroException {
        Operation operation1 = new Subtraction(934.494900, 98.384385);
        Operation operation2 = new Subtraction(98.3844, 1.23d);
        Operation operation3 = new Subtraction(98.3844d, 1.2301d);
        Operation operation4 = new Subtraction(15d, 11d);

        assertEquals("Subtraction works incorrectly!", 836.11, operation1.calculateResult(), 0.009);
        assertEquals("Subtraction works incorrectly!", 97.15, operation2.calculateResult(), 0.009);
        assertEquals("Subtraction works incorrectly!", 97.15, operation3.calculateResult(), 0.009);
        assertEquals("Subtraction works incorrectly!", 4, operation4.calculateResult(), 0);
    }

    @Test //Subtraction test for float numbers that have different rounding algorithm
    public void testSubtractionFloatNumbers() throws DivisionByZeroException {
        Operation operation1 = new Subtraction(45.5f, 12.2f);
        Operation operation2 = new Subtraction(45.5d, 12.2f);

        assertEquals("Subtraction works incorrectly!", 33.3, operation1.calculateResult(), 0.009);
        assertEquals("Subtraction works incorrectly!", 33.3, operation2.calculateResult(), 0.009);
    }

    @Test //Subtraction test for numbers and zeros
    public void testSubtractionWithZero() throws DivisionByZeroException {
        Operation operation1 = new Subtraction(12, 0);
        Operation operation2 = new Subtraction(0, 12);
        Operation operation3 = new Subtraction(0, 0);

        assertEquals("Subtraction works incorrectly!", 12, operation1.calculateResult(), 0);
        assertEquals("Subtraction works incorrectly!", -12, operation2.calculateResult(), 0);
        assertEquals("Subtraction works incorrectly!", 0, operation3.calculateResult(), 0);
    }

    @Test //generic test validation operation's sign
    public void testSubtractionSign() {
        Operation operation1 = new Subtraction(13, 13);
        assertEquals("Subtraction works incorrectly!", "-", operation1.getOperationSign());
    }

    @After //method for informational message after every test
    public void afterTests() {
        System.out.println("The Subtraction test has finished.");
    }

    @AfterClass //method for informational message after all tests here are finished
    public static void testsClose() {
        System.out.println("The Subtraction test suite has finished.");
    }
}
