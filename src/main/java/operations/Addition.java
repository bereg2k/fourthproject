package operations;

public class Addition extends Operation {

    public Addition(float n1, float n2) {
        super(n1, n2);
    }

    private float sumTwoFloats() {
        return getN1() + getN2();
    }

    public void printFloatAddition() {
        System.out.printf("%.2f + %.2f = %.2f", getN1(), getN2(), sumTwoFloats());
    }
}