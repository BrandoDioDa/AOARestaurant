public class queryObj {
    //Variables
    private double longitude;
    private double latitude;
    private int numOfStores;
    public queryObj(){

    }

    @Override
    public String toString() {
        return "Query Lat: " + getLatitude() + " | " + "Query Long: " + getLongitude() + " | " + "# of Stores to search: " + getNumOfStores() + "\n";
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getNumOfStores() {
        return numOfStores;
    }

    public void setNumOfStores(int numOfStores) {
        this.numOfStores = numOfStores;
    }
}
