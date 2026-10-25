import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class PrintingCreditsLogApp {
    // Highest cost record
    private static double highestCost;
    private static int keptId;
    private static String keptLabName;

    // Accumulated
    private static double totalCost;
    private static int totalPages;

    public static void main(String[] args) throws IOException {
        final String FILE_NAME = "printlog.dat";

        Scanner userInput = new Scanner(System.in);
        int readRecords = 0;

        // Header
        System.out.println("*************************************************************");
        System.out.println("Campus Printing Credits Log (Binary)");
        System.out.println("*************************************************************");

        System.out.print("How many print transactions will you enter? ");
        int numberOfRecords = Integer.valueOf(userInput.nextLine());

        try (DataOutputStream fileOutput = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            for (int i = 1; i <= numberOfRecords; i++) {
                System.out.println("\nTransaction #" + i);
                writeRecord(userInput, fileOutput);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("\nSaved transactions to " + FILE_NAME);
        System.out.println("-------------------------------------------------------------");

        if (!(new File(FILE_NAME)).exists()) {
            System.out.println(FILE_NAME + " not found.");
            System.exit(1);
        }

        try (DataInputStream fileInput = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("Reading + " + FILE_NAME + " ...");
            while (true) {
                printRecord(fileInput);
                readRecords++;
            }
        } catch (EOFException ex) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Total transactions: " + readRecords);
            System.out.println("Total pages: " + totalPages);
            System.out.println("Total cost: $" + totalCost);
            System.out.printf("Highest cost: %d | %s | $%.2f\n", keptId, keptLabName, highestCost);
            System.out.println("*************************************************************");
        }

    }

    private static void writeRecord(Scanner in, DataOutputStream out) throws IOException {
        // Prompt values
        System.out.print("Student ID: ");
        int studentId = Integer.valueOf(in.nextLine());
        System.out.print("Lab Name: ");
        String labName = in.nextLine();
        System.out.print("Pages Printed: ");
        int pagesPrinted = Integer.valueOf(in.nextLine());
        System.out.print("Cost: $");
        double cost = Double.valueOf(in.nextLine());

        out.writeInt(studentId);
        out.writeUTF(labName);
        out.writeInt(pagesPrinted);
        out.writeDouble(cost);
    }

    private static void printRecord(DataInputStream in) throws EOFException, IOException {
        int currentId = in.readInt();
        String currentLabName = in.readUTF();
        int pages = in.readInt();
        double currentCost = in.readDouble();

        // Replace record of highest cost.
        if (currentCost > highestCost) {
            keptId = currentId;
            keptLabName = currentLabName;
            highestCost = currentCost;
        }

        // Sum data
        totalPages += pages;
        totalCost += currentCost;

        System.out.printf("%7d | %-18s | Pages: %4d | Cost: $%.2f\n", currentId, currentLabName, pages, currentCost);
    }
}
