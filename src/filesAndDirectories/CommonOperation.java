package filesAndDirectories;

import java.io.*;

public class CommonOperation {

    public static void main(String[] args) throws IOException {

        var ops = new CommonOperation();
        ops.readData(new BufferedInputStream(new FileInputStream("src/filesAndDirectories/Lion.txt")));
        ops.skipData(new BufferedInputStream(new FileInputStream("src/filesAndDirectories/Tiger.txt")));
        ops.closeStream();
    }

    //read and write stream
    //#1: Byte stream
    void copyStream(InputStream in, OutputStream out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
    }

    //#2: Character stream
    void copyStream(Reader in, Writer out) throws IOException {
        int b;
        while ((b = in.read()) != -1) {
            out.write(b);
        }
    }

    //closing stream
    public void closeStream() throws IOException {
        //close with try-with-resource
        try (var fis = new FileInputStream("src\\filesAndDirectories\\zoo.txt")) {
            System.out.print(fis.read());
        }

        //call three close methods
        try (var fis = new FileOutputStream("src\\filesAndDirectories\\zoo.txt"); // Unnecessary
             var bis = new BufferedOutputStream(fis);
             var ois = new ObjectOutputStream(bis)) {
            ois.writeObject("Hello");
        }

        //call one close method
        try (var ois = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("src\\filesAndDirectories\\zoo.txt")))) {
            ois.writeObject("Hello");
        }
    }

    //mark() and reset()
    public void readData(InputStream is) throws IOException {
        System.out.print((char) is.read()); // L
        if (is.markSupported()) {
            is.mark(100); // Marks up to 100 bytes
            System.out.print((char) is.read()); // I
            System.out.print((char) is.read()); // O
            is.reset(); // Resets stream to position before I
        }
        System.out.print((char) is.read()); // I
        System.out.print((char) is.read()); // O
        System.out.println((char) is.read()); // N
    }

    //skip()
    public void skipData(InputStream is) throws IOException {
        System.out.print((char) is.read()); // T
        is.skip(2); // Skips I and G
        is.read(); // Reads E but doesn't output it
        System.out.print((char) is.read()); // R
        System.out.println((char) is.read()); // S
    }

    //flush()
    public void flushData(String fileName) throws IOException {
        try (var fos = new FileOutputStream(fileName)) {
            for (int i = 0; i < 1000; i++) {
                fos.write('a');
                if (i % 100 == 0) {
                    fos.flush();
                }
            }
        }
    }
}
