package serialization;

import java.io.*;

public class Cat implements Serializable{
    private Tail tail = new Tail();
}

class Tail implements Serializable{
    private transient Fur fur = new Fur();
}

class Fur{
}

class Main{
    public static void main(String[] args) throws IOException {
        try(var ois = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("src/serialization/cat.log")));){
            ois.writeObject(new Cat());
        }
    }
}