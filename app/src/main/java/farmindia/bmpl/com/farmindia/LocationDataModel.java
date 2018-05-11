package farmindia.bmpl.com.farmindia;

/**
 * Created by nikhilgupta on 24/03/17.
 */

public class LocationDataModel {

    double latitude;
    double longitude;

    public LocationDataModel(){


        //for firebASE


    }
    public LocationDataModel(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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
