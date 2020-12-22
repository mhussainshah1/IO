package review;

import java.io.Console;

public class Twenty {
    public static void main(String[] args) {
        Console console = System.console();
        String color = console.readLine("Favorite color? ");
        console. format("Your favorite color is %s", color);
    }
}
