package exam;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDateTime;

//Given:
public class SerializedMessage implements Serializable {
    String message;
    LocalDateTime createdTime;
    transient LocalDateTime updatedDateTime;;

    SerializedMessage(String message) {
        this.message = message;
        this.createdTime = LocalDateTime.now();
    }

    private void readObject(ObjectInputStream in) {
        try {
            in.defaultReadObject();
            this.updatedDateTime = LocalDateTime.now();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*
When is the readObject method called?
A) after this object is deserialized
B) after this object is serialized
C) before this object is serialized
D) before this object is deserialized
E) The method is never called.

Answer: E
*/
