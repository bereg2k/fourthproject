package operations;

public class Addition extends Operation implements OperationInterface {

    public Addition(float n1, float n2) {
        super(n1, n2);
    }

    private float sumTwoFloats() {
        return getN1() + getN2();
    }

    public void printOperationResult() {
        System.out.printf("%.2f + %.2f = %.2f", getN1(), getN2(), sumTwoFloats());

    }
}