import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main (String [] args) {
        resData data = new resData();
        queryData query = new queryData();

        query.parseFile("test/Queries.csv");
        data.parseFile(args[0]);

        for(int i = 0; i < query.getCount(); i++){

        }
       // System.out.println(data);
    }
}
