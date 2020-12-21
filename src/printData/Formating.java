package printData;

public class Formating {
    public static void main(String[] args) {
        //format()
        String name = "Lindsey";
        int orderId = 5;

        // Both print: Hello Lindsey, order 5 is ready
        System.out.format("Hello "+name+", order "+orderId+" is ready\n");
        System.out.format("Hello %s, order %d is ready %n", name, orderId);

        name = "James";
        double score = 90.25;
        int total = 100;
        System.out.format("%s:%n Score: %f out of %d%n", name, score, total);

//        System.out.format("Food: %d tons", 2.0); // IllegalFormatConversionException

        var pi = 3.14159265359;
        System.out.format("[%f] %n",pi);       // [3.141593]
        System.out.format("[%12.8f] %n",pi);   // [ 3.14159265]
        System.out.format("[%012f] %n",pi);    // [00003.141593]
        System.out.format("[%12.2f] %n",pi);   // [ 3.14]
        System.out.format("[%.3f] %n",pi);     // [3.142]
    }
}
