package operations;

public class Subtraction extends Operation {

    public Subtraction(float n1, float n2) {
        super(n1, n2);
    }

    private float subtractFloats() {
        return getN1() - getN2();
    }

    public void printFloatSubtraction() {
        System.out.printf("%.2f - %.2f = %.2f", getN1(), getN2(), subtractFloats());
    }
}
