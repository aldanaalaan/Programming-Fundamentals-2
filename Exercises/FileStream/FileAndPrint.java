import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileAndPrint {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("resources/pass.txt");

        try (
            FileInputStream iStream = new FileInputStream(file);
            Scanner input = new Scanner(iStream);
        ) {
            while (input.hasNext()) {
                System.out.print(input.nextByte());
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
