package review;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Nineteen {

    public static void main(String[] args) throws Exception {
        new Nineteen().copyFile(new File("src/review/old.txt"), new File("src/review/new.txt"));
    }

    public void copyFile(File file1, File file2) throws Exception {
        var reader = new InputStreamReader(new FileInputStream(file1));
        try (var writer = new FileWriter(file2)) {
            char[] buffer = new char[10];
            while (true) {
                int read = reader.read(buffer);
                System.out.println(read);
                if (read == -1) break;
                writer.write(buffer);
                // n1
            }
        }
    }
}
