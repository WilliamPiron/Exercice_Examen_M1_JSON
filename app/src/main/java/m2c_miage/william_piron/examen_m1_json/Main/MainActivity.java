package m2c_miage.william_piron.examen_m1_json.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import m2c_miage.william_piron.examen_m1_json.R;
import m2c_miage.william_piron.examen_m1_json.Singleton.GeolocSingleton;

public class MainActivity extends AppCompatActivity {

    private GeolocSingleton geoloc = GeolocSingleton.getInstance();

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

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TEMPORAIRE
                longitude.setText(geoloc.getLongitude());
                latitude.setText(geoloc.getLatitude());
                street.setText(geoloc.getAddress());
                price.setText(geoloc.getPrice());
            }
        });
    }
}
