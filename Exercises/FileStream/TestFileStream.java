import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileStream {
    public static void main(String[] args) throws IOException {
        final String FILE_NAME = "./resources/temp.dat";
        File file = new File(FILE_NAME);
        try (
                // Create an output stream to the file
                FileOutputStream output = new FileOutputStream(file);) {
            // Output values to the file
            for (int i = 1; i <= 10; i++)
                output.write(i);
        }

        try (
                // Create an input stream for the file
                FileInputStream input = new FileInputStream(file)) {
            // Read values from the file
            int value;
            while ((value = input.read()) != -1)
                System.out.print(value + " ");
        }
    }
}