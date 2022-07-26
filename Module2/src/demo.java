import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        try {
            student student1 = new student("anh",18);
            FileWriter myWriter = new FileWriter("result.csv");
            myWriter.write(student1.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
