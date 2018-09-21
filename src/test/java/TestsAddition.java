import exceptions.DivisionByZeroException;
import operations.Addition;
import operations.Operation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test suite for various unit tests for Addition operation.
 */
public class TestsAddition {

    @BeforeClass //method for informational message before all tests here are started
    public static void testsSetup() {
        System.out.println("The addition test suite has started...");
    }

    @Test //regular addition test with 2 positive 2-digit numbers
    public void testAdditionTwoDigitNumbers() throws DivisionByZeroException {
        Operation operation = new Addition(23, 46);
        assertEquals("Addition works incorrectly!", 69, operation.calculateResult(), 0);
    }

    @Test //various addition tests with positive/negative 2-digit numbers
    public void testAdditionNegativeAndPositiveNumbers() throws DivisionByZeroException {
        Operation operation1 = new Addition(-23, 47);
        Operation operation2 = new Addition(23, -12);
        Operation operation3 = new Addition(-23, -12);
        Operation operation4 = new Addition(23, -47);

        assertEquals("Addition works incorrectly!", 24, operation1.calculateResult(), 0);
        assertEquals("Addition works incorrectly!", 11, operation2.calculateResult(), 0);
        assertEquals("Addition works incorrectly!", -35, operation3.calculateResult(), 0);
        assertEquals("Addition works incorrectly!", -24, operation4.calculateResult(), 0);
    }

    @Test //addition test for numbers with decimal points
    public void testAdditionDecimalPointNumbers() throws DivisionByZeroException {
        Operation operation1 = new Addition(98.384385, 934.4949);
        Operation operation2 = new Addition(98.3844, 1.23d);
        Operation operation3 = new Addition(98.3844d, 1.2301d);
        Operation operation4 = new Addition(12d, 13d);

        assertEquals("Addition works incorrectly!", 1032.88, operation1.calculateResult(), 0.009);
        assertEquals("Addition works incorrectly!", 99.61, operation2.calculateResult(), 0.009);
        assertEquals("Addition works incorrectly!", 99.61, operation3.calculateResult(), 0.009);
        assertEquals("Addition works incorrectly!", 25, operation4.calculateResult(), 0);
    }

    @Test //addition test for float numbers that have different rounding algorithm
    public void testAdditionFloatNumbers() throws DivisionByZeroException {
        Operation operation1 = new Addition(45.55f, 12.22f);
        Operation operation2 = new Addition(45.55d, 12.22f);

        assertEquals("Addition works incorrectly!", 57.77, operation1.calculateResult(), 0.009);
        assertEquals("Addition works incorrectly!", 57.77, operation2.calculateResult(), 0.009);
    }

    @Test //addition test for numbers and zeros
    public void testAdditionWithZero() throws DivisionByZeroException {
        Operation operation1 = new Addition(12, 0);
        Operation operation2 = new Addition(0, 12);
        Operation operation3 = new Addition(0, 0);

        assertEquals("Addition works incorrectly!", 12, operation1.calculateResult(), 0);
        assertEquals("Addition works incorrectly!", 12, operation2.calculateResult(), 0);
        assertEquals("Addition works incorrectly!", 0, operation3.calculateResult(), 0);
    }

    @Test //generic test validation operation's sign
    public void testAdditionSign() {
        Operation operation1 = new Addition(12, 13);
        assertEquals("Addition works incorrectly!", "+", operation1.getOperationSign());
    }

    @After //method for informational message after every test
    public void afterTest() {
        System.out.println("The Addition test has finished.");
    }

    @AfterClass //method for informational message after all tests here are finished
    public static void testsClose() {
        System.out.println("The Addition test suite has finished.");
    }
}
