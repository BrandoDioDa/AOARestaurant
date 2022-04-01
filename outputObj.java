public class outputObj {
    private int storeID;
    private String address, city, state;
    private int zipCode;
    private double milesAway;
    public outputObj(){}

    @Override
    public String toString() {
        return "Store #" + getStoreID() + ". " + getAddress() + ", " + getCity() + ", " + getState() + ", " + getZipCode() + ". - " + getMilesAway() + " miles.\n";
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

    public double getMilesAway() {
        return milesAway;
    }

    public void setMilesAway(double milesAway) {
        this.milesAway = milesAway;
    }
}
