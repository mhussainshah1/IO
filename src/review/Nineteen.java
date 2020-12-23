package review;

import java.io.*;

//Run this program in terminal window
public class Nineteen {

    public static void main(String[] args) throws Exception {
        new Nineteen().copyFile(new File("old.txt"), new File("new.txt"));
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
                System.console().readLine();
            }
        }
    }
}
