package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Given the code fragment:
public class Main {
    public static void main(String... args) {
        /* insert code here */
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Input: ");
            String input = in.readLine();
            System.out.println("Echoz" + input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
You must read the data from the Standard Input console.
Which code inserted at line 5 meets your requirement?
A)  try(BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
B)  try {
    BufferedReader in = System.in;
C)  try(BufferedReader in = new BufferedReader(System.in)) {
D)  try(BufferedReader in = new BufferedReader(new Reader(new InputStream<System.in)))) {

Answer: A

*/

/*
And the command:
java Main Helloworld
What is the result ?

A)  A NullPointerException is thrown at run time.
B)  Input:
    Echo:
C)  Input:
    Echo: Helloworld
D)  Input: Helloworld
    Echo: Helloworld
E)  Input:
    Then block until any input comes from System.in.

Answer E:
*/