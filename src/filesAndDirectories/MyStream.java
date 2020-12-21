package filesAndDirectories;

import java.io.*;

public class MyStream {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        //#1: create object
        //High Level (HL) Stream from Low Level Stream (LL)
        try (var br = new BufferedReader(//HL
                new FileReader("zoo-data.txt"))) {//LL
            System.out.println(br.readLine());
        }

        //High Level Stream from High Level Stream
        try (var ois = new ObjectInputStream(new BufferedInputStream(//Both streams are HL
                new FileInputStream("zoo-data.txt")))) {//LL
            System.out.print(ois.readObject());
        }
       /* try {
            new BufferedInputStream(new FileReader("z.txt")); // DOES NOT COMPILE
            new BufferedWriter(new FileOutputStream("z.txt")); // DOES NOT COMPILE
            new ObjectInputStream(new FileOutputStream("z.txt")); // DOES NOT COMPILE
            new BufferedInputStream(new InputStream()); // DOES NOT COMPILE
        }*/
    }

    public void printData(InputStream is) throws IOException {
        int b;
        while ((b = is.read()) != -1) {
            System.out.print(b);
        }
    }

    public void readFile(String fileName) throws IOException {
        try (var fis = new FileInputStream(fileName)) {//close stream
            printData(fis);//create stream
        }
    }
}
