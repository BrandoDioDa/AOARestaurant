import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class queryData {
    private ArrayList<queryObj> queueList = new ArrayList<queryObj>();
    public queryData(){

    }

    public void parseFile(String fileName){
        //Initialize File
        File file = new File(fileName);
        //Try catch for going through file lines
        try{
            Scanner scan = new Scanner(file);
            String fileLine;
            //Testing for skipping first line that is all Strings
            scan.nextLine();
            while(scan.hasNextLine()){
                queryObj queueLocation = new queryObj();

                //Line that is read is split up by it's regex into array.
                fileLine = scan.nextLine();
                String[] splitter = fileLine.split(",");

                //set the corresponding value from the csv to the correct variable
                queueLocation.setLatitude(Double.parseDouble(splitter[0]));
                queueLocation.setLongitude(Double.parseDouble(splitter[1]));
                queueLocation.setNumOfStores(Integer.parseInt(splitter[2]));
                //add new object to the arraylist
                queueList.add(queueLocation);
            }
            scan.close(); //close the scanner
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        String printList = "";
        int numLine= 1;
        for(queryObj newQueryData: queueList){
            printList = printList.concat("Line #: " + numLine + " | " + newQueryData.toString() + "\n");
            numLine++;
        }
        return printList;
    }
}
