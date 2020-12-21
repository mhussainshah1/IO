package printData;

import serialization.Chimpanzee;

import java.io.*;

public class Printing {
    public static void main(String[] args) throws IOException {

        try (PrintWriter out = new PrintWriter("zoo.log")) {
            out.write(String.valueOf(5)); // Writer method
            // 5
            out.print( 5 + System.getProperty("line.separator")); // PrintWriter method
            // 5

            var a = new Chimpanzee();
            out.write(a == null ? "null" : a.toString()); // Writer method
            // [name=Unknown, age=12, type=Q]
            out.print(a); // PrintWriter method
            // [name=Unknown, age=12, type=Q]
        }

        //println()
        System.out.println(System.getProperty("line.separator"));
        System.out.println(System.lineSeparator());

        try (Reader r = new InputStreamReader(System.in);
             Writer w = new OutputStreamWriter(System.out)) {

        }

        try (var in = new FileInputStream("zoo.txt")) {
            System.out.println("Found file!");
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
    }
}