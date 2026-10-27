import java.io.*;
import java.util.Date;

public class TestObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("./resources/output/object.dat"));

        String name = input.readUTF();
        double score = input.readDouble();
        Date date = (Date) input.readObject();

        System.out.println(name + " " + score + " " + date);
        input.close();
    }
}
