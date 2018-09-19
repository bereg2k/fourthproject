package operations;

import exceptions.DivisionByZeroException;

/**
 * This is abstract class for any arithmetic operation.
 */
public abstract class Operation implements OperationInterface {
    private double n1; //first number for operation
    private double n2; //second number for operation

    Operation(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    double getN1() {
        return n1;
    }

    double getN2() {
        return n2;
    }

    /**
     * This is printing the result of any given arithmetic operation.
     * The operation sign and the result are obtained via interface from child classes.
     */
    public void printOperationResult() throws DivisionByZeroException {
        System.out.printf("%.2f %s %.2f = %.2f", getN1(), getOperationSign(), getN2(), calculateResult());
    }
}
