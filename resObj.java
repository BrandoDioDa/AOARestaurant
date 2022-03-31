public class resObj {
    //Variables
    private int storeID;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private double latitude;
    private double longitude;

    public resObj(){

    }

    public String toString(){
        return   ("StoreID: " + this.getStoreID() + " | " + "Address: " + this.getAddress() + " | "
                + "City: " + this.getCity() + " | " + "State: " + this.getState() + " | " + "Zip Code: " + this.getZipCode()
                + " | " + "Latitude: " + this.getLatitude() + " | " + "Longitude: " + this.getLongitude() + "\n");
    }

    public int getStoreID() {
        return storeID;
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
