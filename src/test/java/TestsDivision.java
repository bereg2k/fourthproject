import exceptions.DivisionByZeroException;
import operations.Division;
import operations.Operation;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test suite for various unit tests for Division operation.
 */
public class TestsDivision {

    @BeforeClass //method for informational message before all tests here are started
    public static void testsSetup() {
        System.out.println("The Division test suite has started...");
    }

    @Test //regular division test with and without a remainder
    public void testDivisionRemains() throws DivisionByZeroException {
        Operation operation1 = new Division(60, 15);
        Operation operation2 = new Division(62, 15);
        Operation operation3 = new Division(15, 60);
        Operation operation4 = new Division(15, 62);

        assertEquals("Division works incorrectly!", 4, operation1.calculateResult(), 0);
        assertEquals("Division works incorrectly!", 4.13, operation2.calculateResult(), 0.009);
        assertEquals("Division works incorrectly!", 0.25, operation3.calculateResult(), 0);
        assertEquals("Division works incorrectly!", 0.24, operation4.calculateResult(), 0.009);
    }

    @Test //various division tests with positive/negative 2-digit numbers
    public void testDivisionNegativeAndPositiveNumbers() throws DivisionByZeroException {
        Operation operation1 = new Division(-60, 15);
        Operation operation2 = new Division(60, -15);
        Operation operation3 = new Division(-60, -15);

        assertEquals("Division works incorrectly!", -4, operation1.calculateResult(), 0);
        assertEquals("Division works incorrectly!", -4, operation2.calculateResult(), 0);
        assertEquals("Division works incorrectly!", 4, operation3.calculateResult(), 0);
    }

    @Test //Division test for numbers with decimal points
    public void testDivisionDecimalPointNumbers() throws DivisionByZeroException {
        Operation operation1 = new Division(60.494900, 15.384385);
        Operation operation2 = new Division(60.4949, 1.23d);
        Operation operation3 = new Division(60.4949d, 1.2301d);
        Operation operation4 = new Division(60d, 15d);

        assertEquals("Division works incorrectly!", 3.93, operation1.calculateResult(), 0.009);
        assertEquals("Division works incorrectly!", 49.18, operation2.calculateResult(), 0.009);
        assertEquals("Division works incorrectly!", 49.17, operation3.calculateResult(), 0.009);
        assertEquals("Division works incorrectly!", 4.00, operation4.calculateResult(), 0);
    }

    @Test //Division test for float numbers that have different rounding algorithm
    public void testDivisionFloatNumbers() throws DivisionByZeroException {
        Operation operation1 = new Division(45.5f, 12.2f);
        Operation operation2 = new Division(45.5d, 12.2f);

        assertEquals("Division works incorrectly!", 3.73, operation1.calculateResult(), 0.009);
        assertEquals("Division works incorrectly!", 3.73, operation2.calculateResult(), 0.009);
    }

    @Test //Division test for numbers and zeros
    public void testDivisionWithOneZero() throws DivisionByZeroException {
        Operation operation1 = new Division(0, 12);

        assertEquals("Division works incorrectly!", 0, operation1.calculateResult(), 0);
    }

    @Test //Division test on exception handling when dividing by 0
    public void testDivisionByZeroException1() {
        Operation operation1 = new Division(12, 0);
        boolean isException = false;
        try {
            operation1.calculateResult();
        } catch (DivisionByZeroException e) {
            System.out.println("Division-by-zero exception thrown successfully!");
            isException = true;
        }
        assertTrue("There was no proper exception thrown!", isException);
    }

    @Test (expected = DivisionByZeroException.class) //another exception handling test with less code
    public void testDivisionByZeroException2() throws DivisionByZeroException {
        new Division(12, 0).calculateResult();
    }

    @Test //generic test validation operation's sign
    public void testDivisionSign() {
        Operation operation1 = new Division(13, 13);
        assertEquals("Division works incorrectly!", "/", operation1.getOperationSign());
    }

    @After //method for informational message after every test
    public void afterTests() {
        System.out.println("The Division test has finished.");
    }

    @AfterClass //method for informational message after all tests here are finished
    public static void testsClose() {
        System.out.println("The Division test suite has finished.");
    }
}
