package m2c_miage.william_piron.examen_m1_json.Main;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import m2c_miage.william_piron.examen_m1_json.R;
import m2c_miage.william_piron.examen_m1_json.Singleton.GeolocSingleton;

public class MainActivity extends AppCompatActivity {

    private GeolocSingleton geoloc = GeolocSingleton.getInstance();

    protected Location location;
    protected double longitude_location;
    protected double latitude_location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.button_start);
        Button stop = findViewById(R.id.button_stop);
        Button getinfos = findViewById(R.id.button_getinfo);

        final TextView longitude = findViewById(R.id.text_longitude);
        final TextView latitude = findViewById(R.id.text_latitude);
        final TextView street = findViewById(R.id.text_street);
        final TextView price = findViewById(R.id.text_price);


        LocationManager lm;
        if (getApplicationContext().checkCallingOrSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission obtenue !", Toast.LENGTH_SHORT).show();
            lm = (LocationManager) getSystemService(this.LOCATION_SERVICE);
            location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            LocationListener locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    longitude_location = location.getLongitude();
                    latitude_location = location.getLatitude();

                    geoloc.setLongitude(String.valueOf(longitude_location));
                    geoloc.setLatitude(String.valueOf(latitude_location));

                    longitude.setText(geoloc.getLongitude());
                    latitude.setText(geoloc.getLatitude());
                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {
                    //TODO
                }

                @Override
                public void onProviderEnabled(String provider) {
                    //TODO
                }

                @Override
                public void onProviderDisabled(String provider) {
                    //TODO
                }
            };
            Toast.makeText(this, "Listener validé !", Toast.LENGTH_SHORT).show();
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2000, 10, locationListener);
        }
        else
            Toast.makeText(this, "Permission refusée", Toast.LENGTH_SHORT).show();

        Geocoder geocoder = new Geocoder(this);

        getinfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TEMPORAIRE
                longitude.setText(geoloc.getLongitude());
                latitude.setText(geoloc.getLatitude());
                street.setText(geoloc.getAddress());
                price.setText(geoloc.getPrice());
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
