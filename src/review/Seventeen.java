package review;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Seventeen {
    public static void main(String[] args) throws IOException {
        var sb = new StringBuilder();
        InputStream reader = new BufferedInputStream(new FileInputStream("src/review/Peacocks.txt"));
        if(reader.markSupported()){
            sb.append((char) reader.read());
            reader.mark(10);
            for (int i = 0; i < 2; i++) {
                sb.append((char) reader.read());
                reader.skip(2);
            }
            reader.reset();
            reader.skip(0);
            sb.append((char) reader.read());
            System.out.println(sb.toString());
        }
    }
}
