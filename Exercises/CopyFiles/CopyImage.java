import java.io.*;

public class CopyImage {
    public static void main(String[] args) throws IOException {
        // Arguments origin, destination
        if (args.length != 2 && false) {
            System.out.println("Usage: java Copy origin destination");
            System.exit(1);
        }
        // Define the files
        // For the purpose of this repository, the files will be
        // copied from origin to destination in the resources folder,
        // and we're simulating the args
        final String PREFIX_INPUT = "./resources/origin/";
        final String PREFIX_OUTPUT = "./resources/destination/";

        final String[] FAKE_args = {"avatar_size.png", "avatar_copy.png"};

        File sourceFile = new File(PREFIX_INPUT + FAKE_args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file not found.");
            System.exit(1);

        }

        File targetFile = new File(PREFIX_OUTPUT + FAKE_args[1]);
        if (targetFile.exists()) {
            System.out.println("Destination file already exists.");
            System.exit(1);
        }

        BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));

        int r;
        int numbersOfBytesCopiead = 0;

        while ((r = input.read()) != -1) {
            output.write((byte) r);
            numbersOfBytesCopiead++;
        }

        input.close();
        output.close();

        System.out.println(numbersOfBytesCopiead + " bytes copied.");
    }
}