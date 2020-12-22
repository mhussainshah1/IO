package review;

import java.io.*;

public class Four {
    public static void main(String[] args) throws IOException {
        var is = new BufferedInputStream(new FileInputStream("z.txt"));
        InputStream wrapper = new ObjectInputStream(new BufferedInputStream(is));
        try (wrapper) {
        }
    }
}