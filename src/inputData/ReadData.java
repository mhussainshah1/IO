package inputData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadData {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in));) {
            String userInput = reader.readLine();
            System.out.println("You entered: " + userInput);
        }

        //DON'T DO: It will close out stream for entire application
        try (var out = System.out) {
        }
        System.out.println("Hello");

        //DON'T DO: It will close err stream for entire application and we cant see stack traces from all exceptions
  /*      try (var err = System.err) {}
        System.err.println("Hello");

        int i = 1/0;*/

        //calling closed stream
        var reader = new BufferedReader(new InputStreamReader(System.in));
        try (reader) {}
        String data = reader.readLine(); // IOException
    }
}
