import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class resData {
    //Variables
    ArrayList<resObj> resList = new ArrayList<resObj>();

    public resData() {

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
                resObj resLocation = new resObj();

                //Line that is read is split up by it's regex into array.
                fileLine = scan.nextLine();
                String[] splitter = fileLine.split(",");

                //set the corresponding value from the csv to the correct variable
                resLocation.setStoreID(Integer.parseInt(splitter[0]));
                resLocation.setAddress(splitter[1]);
                resLocation.setCity(splitter[2]);
                resLocation.setState(splitter[3]);
                resLocation.setZipCode(Integer.parseInt(splitter[4]));
                resLocation.setLatitude(Double.parseDouble(splitter[5]));
                resLocation.setLongitude(Double.parseDouble(splitter[6]));
                //add new object to the arraylist
                resList.add(resLocation);
            }
            setResList(resList);
            scan.close(); //close the scanner
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }


    public String toString(){
        String printRes = "";
        int num = 1;
        for(resObj whataData : resList){
            printRes = printRes.concat("Store Number: " + num + " " + whataData.toString()) + "\n";
            num++;
        }
        return printRes;
    }

    public ArrayList<resObj> getResList() {
        return resList;
    }

    public void setResList(ArrayList<resObj> resList) {
        this.resList = resList;
    }
}
