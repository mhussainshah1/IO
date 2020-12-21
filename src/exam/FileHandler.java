package exam;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileHandler {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("foo.txt")) {
            // FileInputStream throws FileNotFoundException
            // and close() throws IOException
        }
        // line 1
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

        /*
        Which code fragment can be inserted in line 1 to make the code compile?
        a)  catch (FileNotFoundException | Exception e) { }
            finally { in.close(); }

        b)  finally { in.close() ; }

        c)  catch (Exception | IOException e) { }
        d)  catch (Exception e) { }
        e)  catch (FileNotFoundException e) { }

         Answer D:
        */

class Test implements Closeable {
    Test() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public static void main(String[] args) {
        try (var t = new Test()) {

        } catch (Exception e) {

        }
    }

    @Override
    public void close() throws IOException {
        System.out.println("File Close");
    }
}