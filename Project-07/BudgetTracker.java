import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BudgetTracker {
    private static int writenExpenses = 0;
    private static int skippedCounter = 0, validCounter = 0;
    private static double totalSpent = 0;

    /*
     * There is not a subfolder in the PrintWriter file path, so it
     * should not throw FileNotFoundException.
     * The Scanner Exception is handled.
     */
    public static void main(String[] args) throws FileNotFoundException {

        // Keyboard input used during the whole execution
        Scanner keyInput = new Scanner(System.in);

        // File-related objects and variables
        final String FILE_NAME = "expenses.txt";
        File expensesFile = new File(FILE_NAME);
        PrintWriter output = new PrintWriter(expensesFile);

        // Header
        System.out.println("***********************************************");
        System.out.println("Student Budget Tracker (Week 1)");
        System.out.println("***********************************************");

        int numberOfLines = validateNumberOfLines(keyInput);

        for (int currentLine = 1; currentLine <= numberOfLines; currentLine++) {
            writeExpenseLine(currentLine, output, keyInput);
        }
        output.close(); // End of file writing

        System.out.println("\nSaved " + writenExpenses + " expenses to " + FILE_NAME);
        System.out.println("-----------------------------------------------");

        // Read file
        try (Scanner fileInput = new Scanner(expensesFile)) {
            while (fileInput.hasNext()) {
                processEntry(fileInput.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File \"" + FILE_NAME + "\" not found");
            System.exit(1);
        }

        System.out.println("Skipped invalid entries: " + skippedCounter);

        if (validCounter == 0) {
            System.out.println(FILE_NAME + " has no valid entries.");
            System.exit(0);
        }

        System.out.println("Total spent: $" + totalSpent);
        System.out.println("Valid expenses: " + validCounter);
        System.out.println("Average expense: $" + (totalSpent / validCounter));
        System.out.println("***********************************************");

    }

    public static void writeExpenseLine(int lineNumber, PrintWriter output, Scanner in) {

        double amount = validateAmount(in, lineNumber);

        // Write line as double (?)
        output.println(((double) lineNumber) + " " + amount);
        writenExpenses++;
    }

    public static void processEntry(String entry) {
        double amount;
        try (Scanner expenseLine = new Scanner(entry)) {
            // Expense number
            expenseLine.nextDouble();

            if (!expenseLine.hasNextDouble())
                skippedCounter++;
            else {
                amount = expenseLine.nextDouble();
                totalSpent += amount;
                validCounter++;
            }
        } catch (InputMismatchException ex) {
            skippedCounter++;
        }
    }

    public static int validateNumberOfLines(Scanner in) {
        // While the number of lines is invalid, keeps asking for it.
        boolean numberIsValid = false;
        int number = -1;

        do {
            System.out.print("How many expenses will you enter? ");
            try {
                number = in.nextInt();
                if (number <= 0) {
                    System.out.println("The number of lines must be more than zero.");
                    continue;
                }
                numberIsValid = true;
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a valid number.");
                in.nextLine();
            }
        } while (!numberIsValid);
        return number;
    }

    public static double validateAmount(Scanner in, int numberOfExpense) {
        // Validate amount >= 0 per expense.
        boolean amountIsValid = false;
        double amount = -1;

        do {
            System.out.print("Enter expense #" + numberOfExpense + ": ");
            try {
                amount = in.nextDouble();
                if (amount < 0) {
                    System.out.println("The amount shouldn't be negative.");
                    continue;
                }
                amountIsValid = true;
            } catch (InputMismatchException ex) {
                System.out.println("Please, enter a valid amount.");
                in.nextLine();
            }
        } while (!amountIsValid);
        return amount;
    }
}
