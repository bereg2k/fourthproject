package operations;

/**
 * This is a class for operation of subtraction of 2 numbers.
 */
public class Subtraction extends Operation {

    public Subtraction(double n1, double n2) {
        super(n1, n2);
    }

    public double calculateResult() { //performing the subtraction
        return getN1() - getN2();
    }

    public String getOperationSign(){ //getting the actual operation sign for the final output
        return "-";
    }
}
