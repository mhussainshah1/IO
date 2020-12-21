package filesAndDirectories;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.separator"));// /
        System.out.println(java.io.File.separator);//   /

        var zooFile1 = new File("/home/tiger/data/stripes.txt");
        System.out.println(zooFile1.exists()); // true if the file exists

        File zooFile2 = new File("/home/tiger", "data/stripes.txt");

        File parent = new File("/home/tiger");
        File zooFile3 = new File(parent, "data/stripes.txt");
    }
}
