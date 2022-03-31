import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class resData {
    //Variables
    private int storeID;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private double latitude;
    private double longitude;
    ArrayList<resData> resList = new ArrayList<resData>();

    public resData() {

    }

    public int getStoreID() {
        return storeID;
    }

    public void parseFile(String fileName){
        File file = new File(fileName);

        try{
            Scanner scan = new Scanner(file);
            String fileLine;

            while(scan.hasNextLine()){
                resData resLocation = new resData();

                fileLine = scan.nextLine();
                String[] splitter = fileLine.split(",");



                resLocation.setStoreID(Integer.parseInt(splitter[0]));
                resLocation.setAddress(splitter[1]);
                resLocation.setCity(splitter[2]);
                resLocation.setState(splitter[3]);
                resLocation.setZipCode(Integer.parseInt(splitter[4]));
                resLocation.setLatitude(Double.parseDouble(splitter[5]));
                resLocation.setLongitude(Double.parseDouble(splitter[6]));

                resList.add(resLocation);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public String toString(){
        String printRes = "";
        printRes = printRes.concat("StoreID: " + this.getStoreID() + " | " + "Address: " + this.getAddress() + " | "
         + "City: " + this.getCity() + " | " + "State: " + this.getState() + " | " + "Zip Code: " + this.getZipCode()
         + " | " + "Latitude: " + this.getLatitude() + " | " + "Longitude: " + this.getLongitude() + "\n");
        return printRes;
    }

    public ArrayList<resData> getResList() {
        return resList;
    }

    public void setResList(ArrayList<resData> resList) {
        this.resList = resList;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
