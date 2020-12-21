package serialization;

import java.io.Serializable;

public class Chimpanzee implements Serializable {

    //static
    private static final long serialVersionUID = 2L;
    private static char type = 'C';

    //instance
    private transient String name;
    private transient int age = 10;

    {
        this.age = 14;
    }

    public Chimpanzee() {
        this.name = "Unknown";
        this.age = 12;
        this.type = 'Q';
    }

    public Chimpanzee(String name, int age, char type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    public static char getType() {
        return type;
    }

    public static void setType(char type) {
        Chimpanzee.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" +
                "name=" + name +
                ", age=" + age +
                ", type=" + type +
                ']';
    }
}
