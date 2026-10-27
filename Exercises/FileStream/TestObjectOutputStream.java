import java.io.*;
import java.util.Date;

public class TestObjectOutputStream {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("./resources/output/object.dat"));

        output.writeUTF("David");
        output.writeDouble(85.5);
        output.writeObject(new Date());

        output.close();
    }
}
