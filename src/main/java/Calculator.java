import exceptions.DivisionByZeroException;
import operations.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Calculator {
    public static void main(String[] args) throws IOException {

        //initializing log file functionality to log errors during exception handling
        Logger logger = Logger.getLogger("Logger for errors and stack traces");
        FileHandler logfile = new FileHandler("errors_log.log", true);
        logfile.setFormatter(new SimpleFormatter());
        logger.addHandler(logfile);

        //startAgain - variable to let the "while"-cycle below know, whether user wants to exit the program or use it again.
        //scanner - basic console input.
        boolean startAgain = true;
        Scanner scanner = new Scanner(System.in);

        while (startAgain) {
            //Main menu of the program. User can choose to open Calculator or Exit.
            System.out.println("\nHi there! This is the MAIN MENU. What would you like to work with?");
            boolean goodData = false; //additional variable for further exception handling
            int mainChoice = 0;

            while (!goodData) { //section for handling input mismatch exceptions in the main menu
                System.out.print("Enter '1' for Calculator, '2' for Exit: ");
                try {
                    mainChoice = scanner.nextInt();
                    goodData = true;
                } catch (InputMismatchException e) {
                    System.out.println("You can only input integer values! ");
                    logStackTraceToFile(e, logger, "invalid MAIN MENU choice");
                    scanner.next(); //clearing the buffer
                }
            }

            //This branch is for accessing Calculator from the main menu.
            if (mainChoice == 1) {
                goodData = false;
                double n1 = 0;
                double n2 = 0;
                int operationChoice = 0;

                System.out.println("This is a basic console calculator.");

                while (!goodData) { //section for handling input mismatch exceptions in the calculator
                    try {
                        System.out.print("Enter the first number: ");
                        n1 = scanner.nextDouble();
                        System.out.print("Enter the second number: ");
                        n2 = scanner.nextDouble();
                        System.out.println("Choose mathematical operation.");
                        System.out.print("Enter '1' for addition, '2' for subtraction, '3' for multiplication, '4' for division: ");
                        operationChoice = scanner.nextInt();
                        goodData = true;
                    } catch (InputMismatchException e) {
                        System.out.println("You can only input valid numbers here!");
                        logStackTraceToFile(e, logger, "invalid calculator's numbers/operation");
                        scanner.next(); //clearing the buffer
                    }
                }

                Operation operation = null; //creating a new basic null operation via interface reference link
                switch (operationChoice) {
                    case 1:
                        //If user enters "1" as operation, then the program performs ADDITION
                        operation = new Addition(n1, n2);
                        break;

                    case 2:
                        //If user enters "2" as operation, then the program performs SUBTRACTION
                        operation = new Subtraction(n1, n2);
                        break;

                    case 3:
                        //If user enters "3" as operation, then the program performs MULTIPLICATION
                        operation = new Multiplication(n1, n2);
                        break;

                    case 4:
                        //If user enters "4" as operation, then the program performs DIVISION
                        operation = new Division(n1, n2);
                        break;

                    default:
                        //If users enters any other number, then the program shows an error message
                        System.out.println("Entered operation is invalid!");
                        break;
                }

                if (operation != null) { //if operation became some class's object then print the result of it
                    try {//dividing by 0 exception handling
                        operation.printOperationResult();
                    } catch (DivisionByZeroException e) {
                        System.out.println("Division by 0 will result in infinity...");
                        logStackTraceToFile(e, logger, "0 as a divider");
                    }
                }

                //calling method to start again and return a flag value for "while"-cycle
                startAgain = startAgainFunction();
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
        logfile.close();
    }

    /**
     * This method called at the end of iteration of main functionality.
     * It lets the user to use go back to main menu or quit the program right away.
     *
     * @return boolean value for main method, so that the program could go back to main menu or quit.
     */
    private static boolean startAgainFunction() {
        /*If user enters "y", then program goes back to main menu.
        If user enters "n", then program ends its execution.
        Otherwise, the program terminates with an error.*/
        Scanner scanner = new Scanner(System.in);
        boolean startAgainLocal; //startAgainLocal - to avoid confusion with main "startAgain" variable

        System.out.print("\nWould you like to start again [y/n]?: ");
        String exit = scanner.next(); //exit - additional string variable to exit the program after executing a function.

        if (exit.equals("y")) {
            startAgainLocal = true;
        } else if (exit.equals("n")) {
            System.out.println("\nThank you for using our Calculator! Bye!");
            startAgainLocal = false;
        } else {
            System.err.println("Invalid input! Program aborted!");
            startAgainLocal = false;
        }
        return startAgainLocal;
    }

    /**
     * This method gets exception's stack trace, converts it to string value and logs it to the external file
     *
     * @param exception        exception to handle
     * @param logger           log file for logging stack traces
     * @param userInvalidInput additional string value to add some info depending on the exception handled
     */
    private static void logStackTraceToFile(Exception exception, Logger logger, String userInvalidInput) {
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        exception.printStackTrace(printWriter);
        logger.setLevel(Level.FINE);
        logger.fine("ERROR: User has entered " + userInvalidInput + ". Stack trace:\n" + writer.toString());
    }
}
