package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyGorilla {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();
        gorillas.add(new Gorilla("Grodd", 5, false));
        gorillas.add(new Gorilla("Ishmael", 8, true));
        File dataFile = new File("gorilla.data");

        saveToFile(gorillas, dataFile);
        var gorillasFromDisk = readFromFile(dataFile);
        System.out.print(gorillasFromDisk);
    }

    static void saveToFile(List<Gorilla> gorillas, File dataFile)throws IOException {
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Gorilla gorilla : gorillas)
                out.writeObject(gorilla);
        }
    }

    static List<Gorilla> readFromFile(File dataFile) throws IOException, ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();
        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while ( /*in.available() ==0*/true) {
                //System.out.println(in.available());
                var object = in.readObject();
                if (object instanceof Gorilla)
                    gorillas.add((Gorilla) object);
            }
        } catch (EOFException e) {
            // File end reached
//            e.printStackTrace();
        }
        return gorillas;
    }
}