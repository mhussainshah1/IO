package review;

import java.io.IOException;
import java.io.InputStream;

public class Seven {
    public static void main(String[] args) {

    }
    public static String pullBytes(InputStream in, int count)
            throws IOException {
        var sb = new StringBuilder();
        if(in.markSupported()){
            in.mark(count);
            for (int i = 0; i < count; i++)
                sb.append((char) in.read());
            in.reset();
            in.skip(1);
        }
        sb.append((char) in.read());
        return sb.toString();
    }
}
