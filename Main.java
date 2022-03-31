import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main (String [] args) throws IOException {

        resData whatABurger = new resData();
        whatABurger.parseFile("test/WhataburgerData.csv");
    }
}
