package review;

import java.io.File;

public class Eleven {
    public static void main(String[] args) {
        deleteTree(new File("c/storage"));
    }

    public static void deleteTree(File file) {
        if (!file.isFile()) // f1
            for (File entry : file.listFiles()) // f2
                deleteTree(entry);
        else
            file.delete();
    }
}
