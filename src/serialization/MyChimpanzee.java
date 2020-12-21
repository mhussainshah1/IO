package serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyChimpanzee {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var chimpanzees = new ArrayList<Chimpanzee>();
        chimpanzees.add(new Chimpanzee("Ham", 2, 'A'));
        chimpanzees.add(new Chimpanzee("Enos", 4, 'B'));
        File dataFile = new File("src/serialization/chimpanzee.data");

        saveToFile(chimpanzees, dataFile);
        var chimpanzeesFromDisk = readFromFile(dataFile);
        System.out.println(chimpanzeesFromDisk);
    }

    private static void saveToFile(List<Chimpanzee> chimpanzees, File dataFile) throws IOException {
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
            for (Chimpanzee chimpanzee : chimpanzees)
                out.writeObject(chimpanzee);
        }
    }

    private static List<Chimpanzee> readFromFile(File dataFile) throws IOException, ClassNotFoundException {
        var gorillas = new ArrayList<Chimpanzee>();
        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                System.out.println(in.available());
                var object = in.readObject();
                if (object instanceof Chimpanzee)
                    gorillas.add((Chimpanzee) object);
            }
        } catch (EOFException e) {
            // File end reached
//            e.printStackTrace();
        }
        return gorillas;
    }
}