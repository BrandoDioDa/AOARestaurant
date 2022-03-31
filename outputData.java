import java.util.ArrayList;

public class outputData {
    //variables
    private ArrayList<outputObj> newOutput = new ArrayList<>();

    public outputData(){

    }

    public double calcMiles(double lat, double longi, resObj resList){
        double radiusOfEarthInMiles = 3958.8;
        double distance = 0;

        double lat1 = Math.toRadians(resList.getLatitude());
        double lat2 = Math.toRadians(lat);
        double long1 = Math.toRadians(resList.getLongitude());
        double long2 = Math.toRadians(longi);

        double a = Math.pow(Math.sin((lat2 - lat1)/2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin((long2 - long1)/2), 2);
        double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        distance = radiusOfEarthInMiles * c;
        distance = Math.toRadians(distance);
        //System.out.println(distance);
        return distance;
    }

    public void algorithm(ArrayList<resObj> resList, queryObj queueList) {
        for (resObj resObj : resList) {
            double distanceGlob = calcMiles(queueList.getLatitude(), queueList.getLongitude(), resObj);
            outputObj x = new outputObj();

            x.setStoreID(resObj.getStoreID());
            x.setAddress(resObj.getAddress());
            x.setState(resObj.getState());
            x.setCity(resObj.getCity());
            x.setZipCode(resObj.getZipCode());
            x.setMilesAway(distanceGlob);

            newOutput.add(x);
        }



    }

    @Override
    public String toString() {
        return "outputData{" +
                "newOutput=" + newOutput +
                '}';
    }

    public ArrayList<outputObj> getNewOutput() {
        return newOutput;
    }

    public void setNewOutput(ArrayList<outputObj> newOutput) {
        this.newOutput = newOutput;
    }
}
