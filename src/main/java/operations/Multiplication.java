package operations;

public class Multiplication extends Operation {
    public Multiplication(float n1, float n2) {
        super(n1, n2);
    }

    private float multiplyTwoFloats() {
        return getN1() * getN2();
    }

    public void printFloatMultiplication() {
        System.out.printf("%.2f * %.2f = %.2f", getN1(), getN2(), multiplyTwoFloats());
    }
}
