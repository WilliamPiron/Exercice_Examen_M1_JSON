package m2c_miage.william_piron.examen_m1_json.Singleton;

/**
 * Created by William on 19/01/2018.
 */

public class GeolocSingleton {
    private static GeolocSingleton instance = null;

    private String latitude;
    private String longitude;

    private String address;
    private String price;

    private GeolocSingleton(){
        this.latitude = "0.0";
        this.longitude = "0.0";
        this.address = "";
        this.price = "0";
    }

    public static GeolocSingleton getInstance(){
        if (instance == null) return new GeolocSingleton();
        else return instance;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
