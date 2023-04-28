import java.io.FileWriter;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        try {
            FileWriter fw
            = new FileWriter("file.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
