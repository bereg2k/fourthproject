package operations;

/**
 * This is a class for operation of multiplication of 2 numbers.
 */
public class Multiplication extends Operation {

    public Multiplication(float n1, float n2) {
        super(n1, n2);
    }

    public float calculateResult() { //performing the multiplication
        return getN1() * getN2();
    }

    public String getOperationSign(){ //getting the actual operation sign for the final output
        return "*";
    }
}
