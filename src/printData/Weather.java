package printData;

import java.io.*;

public class Weather {
    public static void main(String[] args) throws IOException {
        File source = new File("src/printData/zoo.log");
        try (var out = new PrintWriter(new BufferedWriter(new FileWriter(source)))) {
            out.print("Today's weather is: ");
            out.println("Sunny");
            out.print("Today's temperature at the zoo is: ");
            out.print(1 / 3.0);
            out.println('C');
            out.format("It has rained %5.2f inches this year %d", 10.2, 2021);
            out.println();
            out.printf("It may rain %s more inches this year", 1.2);
        }
    }
}
