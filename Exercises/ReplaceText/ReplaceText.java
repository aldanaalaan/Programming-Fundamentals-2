import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReplaceText {
    public static void main(String[] args) throws Exception {

        if (args.length != 4) {
            System.out.println("Usage: java ReplaceText sourceFile targetFile oldStr newStr");
            System.exit(1);
        }

        File targetFile = new File(args[0]);
        File newFile = new File(args[1]);

        String oldString = args[2], newString = args[3];

        if (!targetFile.exists()) {
            System.out.println("Target " + targetFile + " not found.");
            System.exit(1);
        }

        if (newFile.exists()) {
            System.out.println("New file " + targetFile + " already exists.");
            System.exit(1);
        }

        Scanner fileIn = new Scanner(targetFile);
        PrintWriter fileOut = new PrintWriter(newFile);

        while (fileIn.hasNext()) {
            String s1 = fileIn.nextLine();
            System.out.println(s1);
            String s2 = s1.replaceAll(oldString, newString);
            System.out.println(s2);
            fileOut.println(s2);
        }

        fileIn.close();
        fileOut.close();
    }
}
