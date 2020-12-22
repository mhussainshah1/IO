package review;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Sixteen {
    public static void main(String[] args) throws IOException {
        new Sixteen().echo();
    }

    private void echo() throws IOException {
        var o = new FileWriter("src/review/new-zoo.txt");
        try (var f = new FileReader("src/review/zoo-data.txt");
             var b = new BufferedReader(f); o) {
            o.write(b.readLine());
        }
        o.write("");
    }
}
