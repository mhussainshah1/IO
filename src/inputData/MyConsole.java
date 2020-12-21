package inputData;

import java.io.Console;
import java.util.Locale;

public class MyConsole {
    public static void main(String[] args) {
//        Console c = new Console(); // DOES NOT COMPILE

        Console console = System.console();
        //Input
        if (console != null) {
            String userInput = console.readLine();
            console.writer().println("You entered: " + userInput);
        } else {
            System.err.println("Console not available");
        }

        //Output
        if (console == null) {
            throw new RuntimeException("Console not available");
        } else {
            console.writer().println("Welcome to Our Zoo!");
            console.format("It has %d animals and employs %d people", 391, 25);
            console.writer().println();
            console.printf("The zoo spans %5.1f acres%n", 128.91);
        }

        //Using Locale
        console.writer().format(new Locale("fr", "CA"), "Hello World");
    }
}
