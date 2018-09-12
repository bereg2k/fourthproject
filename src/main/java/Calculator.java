import operations.*;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        //startAgain - variable to let the "while"-cycle below know, whether user wants to exit the program or use it again.
        //scanner - basic console input.
        boolean startAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (startAgain) {
            //Main menu of the program. User can choose to open Calculator or Exit.
            System.out.println("\nHi there! This is the MAIN MENU. What would you like to work with?");
            System.out.print("Enter '1' for Calculator, '2' for Exit: ");
            int mainChoice = scanner.nextInt();

            //This branch is for accessing Calculator from the main menu.
            if (mainChoice == 1) {
                System.out.println("This is a basic console calculator.");
                System.out.print("Enter the first number: ");
                float n1 = scanner.nextFloat();
                System.out.print("Enter the second number: ");
                float n2 = scanner.nextFloat();
                System.out.println("Choose mathematical operation.");
                System.out.print("Enter '1' for addition, '2' for subtraction, '3' for multiplication, '4' for division: ");
                int operationChoice = scanner.nextInt();
                switch (operationChoice) {
                    case 1:
                        //If user enters "1" as operation, then the program performs ADDITION
                        OperationInterface singleSum = new Addition(n1, n2);
                        singleSum.printOperationResult();
                        break;

                    case 2:
                        //If user enters "2" as operation, then the program performs SUBTRACTION
                        OperationInterface singleSubtract = new Subtraction(n1, n2);
                        singleSubtract.printOperationResult();
                        break;

                    case 3:
                        //If user enters "3" as operation, then the program performs MULTIPLICATION
                        OperationInterface singleMultiplication = new Multiplication(n1, n2);
                        singleMultiplication.printOperationResult();
                        break;

                    case 4:
                        //If user enters "4" as operation, then the program performs DIVISION
                        OperationInterface singleDivision = new Division(n1, n2);
                        singleDivision.printOperationResult();
                        break;

                    default:
                        //If users enters any other number, then the program shows an error message
                        System.out.println("Entered operation is invalid!");
                        break;
                }

                //calling method to start again and return a flag value for "while"-cycle
                startAgain = startAgainFunction(scanner, 'c');
            }

            //This branch is for quitting the program from the main menu.
            else if (mainChoice == 2) {
                System.out.println("\nThank you! Bye!");
                startAgain = false;
            }

            //This branch is for handling invalid input from the main menu.
            else {
                System.out.println("\nInvalid number entered! Please try again!");
                startAgain = true;
            }
        }
        scanner.close();
    }

    /**
     * This method called at the end of iteration of main functionality.
     * It lets the user to use go back to main menu or quit the program right away.
     *
     * @param scanner     console input parameter for user's decision
     * @param flagForExit flag variable for appropriate "good-bye" message (depends on the user's previous choice)
     * @return boolean value for main method, so that the program could go back to main menu or quit.
     */
    private static boolean startAgainFunction(Scanner scanner, char flagForExit) {
        /*If user enters "y", then program goes back to main menu.
        If user enters "n", then program ends its execution.
        Otherwise, the program terminates with an error.*/

        boolean startAgainLocal; //startAgainLocal - to avoid confusion with main "startAgain" variable

        System.out.print("\nWould you like to start again [y/n]?: ");
        String exit = scanner.next(); //exit - additional string variable to exit the program after executing a function.

        if (exit.equals("y")) {
            startAgainLocal = true;
        } else if (exit.equals("n")) {
            switch (flagForExit) {  // flagForExit - variable for correct exit message on quitting the chosen module
                case 'c':
                    System.out.println("\nThank you for using our Calculator! Bye!");
                    break;
            }
            startAgainLocal = false;
        } else {
            System.err.println("Invalid input! Program aborted!");
            startAgainLocal = false;
        }
        return startAgainLocal;
    }
}
