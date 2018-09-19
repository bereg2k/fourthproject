package operations;

import exceptions.DivisionByZeroException;

/**
 * This is a class for operation of division of 2 numbers.
 */
public class Division extends Operation {

    public Division(double n1, double n2) {
        super(n1, n2);
    }

    public double calculateResult() throws DivisionByZeroException { //performing the division
        if (getN2() == 0) { //throwing new exception for dividing by 0
            throw new DivisionByZeroException();
        } else {
            return getN1() / getN2();
        }
    }

    public String getOperationSign() { //getting the actual operation sign for the final output
        return "/";
    }
}
