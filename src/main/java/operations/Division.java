package operations;

public class Division extends Operation implements OperationInterface {

    public Division(float n1, float n2) {
        super(n1, n2);
    }

    private float divideTwoFloats() {
        return getN1() / getN2();
    }

    public void printOperationResult() {
        System.out.printf("%.2f / %.2f = %.2f", getN1(), getN2(), divideTwoFloats());
    }
}
