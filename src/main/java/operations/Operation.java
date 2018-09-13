package operations;

/**
 * This is abstract class for any arithmetic operation.
 */
public abstract class Operation implements OperationInterface {
    private float n1; //first number for operation
    private float n2; //second number for operation

    Operation(float n1, float n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    float getN1() {
        return n1;
    }

    float getN2() {
        return n2;
    }

    /**
     * This is printing the result of any given arithmetic operation.
     * The operation sign and the result are obtained via interface from child classes.
     */
    public void printOperationResult() {
        System.out.printf("%.2f %s %.2f = %.2f", getN1(), getOperationSign(), getN2(), calculateResult());
    }
}
