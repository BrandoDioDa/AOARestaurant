import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main (String [] args) {
        resData data = new resData();
        queryData query = new queryData();

        query.parseFile("test/Queries.csv");

        System.out.println();
        data.parseFile(args[0]);
        //whatABurger.parseFile("test/WhataburgerData.csv");
        //System.out.println(data);
    }
}
