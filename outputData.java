import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class outputData {
    //variables
    private ArrayList<outputObj> newOutput = new ArrayList<>();
    private ArrayList<outputObj> answer = new ArrayList<>();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public outputData(){

    }

    public double calcMiles(double lat, double lng, resObj resList){
        double radiusOfEarthInMiles = 3958.8;
        double distance;

        double lat1 = Math.toRadians(resList.getLatitude());
        double lat2 = Math.toRadians(lat);
        double long1 = Math.toRadians(resList.getLongitude());
        double long2 = Math.toRadians(lng);

        double a = Math.pow(Math.sin((lat2 - lat1)/2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin((long2 - long1)/2), 2);
        double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        distance = radiusOfEarthInMiles * c;
        //distance = Math.toRadians(distance);
        //System.out.println(distance);
        return distance;
    }

    public void algorithm(ArrayList<resObj> resList, queryObj queueList) {
        df.setRoundingMode(RoundingMode.HALF_UP);
        for (resObj newObj : resList) {
            double distanceGlob = calcMiles(queueList.getLatitude(), queueList.getLongitude(), newObj);
            outputObj x = new outputObj();

            x.setStoreID(newObj.getStoreID());
            x.setAddress(newObj.getAddress());
            x.setState(newObj.getState());
            x.setCity(newObj.getCity());
            x.setZipCode(newObj.getZipCode());
            x.setMilesAway(Double.parseDouble(df.format(distanceGlob)));

            newOutput.add(x);
        }
         randomizedSelect(newOutput,0, newOutput.size()-1, queueList.getNumOfStores());
         setNewOutput(newOutput);
    }

    public static outputObj randomizedSelect(ArrayList<outputObj> array, int l, int r, int i){
        if(l == r)
            return array.get(l);

        int mid = randomizedPartition(array, l, r);
        int k = mid - (l - 1);

        if(k == i)
            return array.get(mid);
        else if(i < k)
            return randomizedSelect(array, l, mid-1, i);
        else
            return randomizedSelect(array, mid+1, r, i-k);
    }

    public static int randomizedPartition(ArrayList<outputObj> array, int start, int end){
        Random rng = new Random();
        int pivotIndex = rng.nextInt(end - start + 1) + start;
        outputObj temp = array.get(start);
        array.set(start, array.get(pivotIndex));
        array.set(pivotIndex, temp);

        double pivotDistance = array.get(start).getMilesAway();
        int i = start;
        for(int j = start + 1; j <= end; j++){
            if(array.get(j).getMilesAway() <= pivotDistance){
                i++;

                //swap
                temp = array.get(j);
                array.set(j, array.get(i));
                array.set(i, temp);
            }
        }
        temp = array.get(start);
        array.set(start, array.get(i));
        array.set(i, temp);
        return i;
    }

    public void sortMiles(ArrayList<outputObj> m){
        for (int i = 0; i < m.size() - 1; i++) {
            for (int j = m.size() - 1; j > i; j--) {
                if (m.get(j - 1).getMilesAway() > m.get(j).getMilesAway()) {
                    //Swap
                    outputObj tmp = m.get(j - 1);
                    m.set(j -1, m.get(j));
                    m.set(j, tmp);
                }
            }
        }
    }

    @Override
    public String toString() {
        String printAnswer = "";
        for(outputObj finalOutput: newOutput){
            printAnswer = printAnswer.concat(finalOutput.toString());
        }
        return printAnswer;
    }

    public ArrayList<outputObj> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<outputObj> answer) {
        this.answer = answer;
    }

    public ArrayList<outputObj> getNewOutput() {
        return newOutput;
    }

    public void setNewOutput(ArrayList<outputObj> newOutput) {
        this.newOutput = newOutput;
    }
}
