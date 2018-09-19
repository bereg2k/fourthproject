package operations;

import exceptions.DivisionByZeroException;

/**
 * This interface helps abstract class Operation to use methods of its child-classes
 */
public interface OperationInterface {
    void printOperationResult() throws DivisionByZeroException; //printing the results of the operation
    double calculateResult() throws DivisionByZeroException; //calculating the result of the operation
    String getOperationSign(); //getting the operation's sign (+, -, *, /)
}
