package serialization;

import java.io.Serial;
import java.io.Serializable;

public class Gorilla implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private Boolean friendly;
    private transient String favoriteFood;

    public Gorilla() {
        System.out.println("Gorilla constructor");
    }

    public Gorilla(String name, int age, Boolean friendly) {
        this.name = name;
        this.age = age;
        this.friendly = friendly;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public Boolean getFriendly() {
        return friendly;
    }

    public void setFriendly(Boolean friendly) {
        this.friendly = friendly;
    }

    @Override
    public String toString() {
        return "[" + "name=" + name +  ", age=" + age + ", friendly=" + friendly + "]";
    }
}