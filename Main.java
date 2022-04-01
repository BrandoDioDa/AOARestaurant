import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main (String [] args) {
        resData data = new resData();
        queryData query = new queryData();
        outputData output = new outputData();

        query.parseFile("test/Queries.csv");
        data.parseFile(args[0]);


        for(int i = 0; i < query.getCount(); i++){
            output.algorithm(data.getResList(), query.getQueueList().get(i));
            System.out.println("The " + query.getQueueList().get(i).getNumOfStores() + " closest Stores to (" + query.getQueueList().get(i).getLatitude() + ", " + query.getQueueList().get(i).getLongitude() + "):");
            for(int j = 0; j < query.getQueueList().get(i).getNumOfStores(); j++){
                output.getAnswer().add(output.getNewOutput().get(j));
                //System.out.println(output.getNewOutput().get(j));
            }
            output.sortMiles(output.getAnswer());
            System.out.println(output.getAnswer().toString());
            System.out.println("\n");
            //Clears previous data
            output.getAnswer().clear();
            output.getNewOutput().clear();
        }
    }
}
