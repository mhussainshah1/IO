package review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Zebra implements Serializable {
    private transient String name = "George";
    private static String birthPlace = "Africa";
    private transient Integer age;
    List<Zebra> friends = new ArrayList<>();
//    private Object stripes = new Object();

    {
        age = 10;
    }

    public Zebra() {
        this.name = "Sophia";
    }

    static Zebra writeAndRead(Zebra z) {
        try (var out = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("src/review/dataFile")))) {
            out.writeObject(z);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (var in = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream("src/review/dataFile")))) {
            while (true) {
                var object = in.readObject();
                if(object instanceof Zebra)
                    z = (Zebra) object;
            }
        } catch (IOException | ClassNotFoundException e) {
            // File end reached
//            e.printStackTrace();
        }
        return z;
    }

    @Override
    public String toString() {
        return "[" + "name=" + name + ", age=" + age + ", friends=" + friends + ']';
    }

    public static void main(String[] args) {
        var zebra = new Zebra();
        zebra = writeAndRead(zebra);
        System.out.println(zebra);
    }
}