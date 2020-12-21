package exam;
//Given the code fragment:

import java.io.*;

class Classes implements Serializable {
    String id;
}

class Person {
    String name;
    transient String address;
}

class Student extends Person implements Serializable {
    String studentNo;
    Classes classes = new Classes();

    Student() {
        studentNo = "1";
        name = "Amir";
        address = "New York";
        classes.id = "2";
    }

    public String toString() {
        return "[" + "name=" + name + ", address=" + address + ", studentNo=" + studentNo + ", classes=" + classes.id + ']';
    }
}

class IOMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (var ois = new ObjectOutputStream(
                new FileOutputStream("src/exam/student.log"));) {
            ois.writeObject(new Student());
        }

        try (var in = new ObjectInputStream(
                new FileInputStream("src/exam/student.log"));) {
            var object = in.readObject();
            System.out.println(object);
        }
    }
}
/*
Which fields are serialized in a Student object?

A) studentNo and name
B) studentNo and classes
C) studentNo, classes, and name
D) studentNo, classes, name, and address

Answer: B
*/
