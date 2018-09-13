package operations;

/**
 * This interface helps abstract class Operation to use methods of its child-classes
 */
public interface OperationInterface {
    void printOperationResult(); //printing the results of the operation
    float calculateResult(); //calculating the result of the operation
    String getOperationSign(); //getting the operation's sign (+, -, *, /)
}
