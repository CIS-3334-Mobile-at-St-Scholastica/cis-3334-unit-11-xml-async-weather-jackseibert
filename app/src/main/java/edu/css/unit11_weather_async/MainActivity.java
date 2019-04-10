package edu.css.unit11_weather_async;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText etLoc;
    EditText etTemp;
    EditText etWind;
    EditText etVis;

    AsyncDownloadXML AsyncWeatherDownloader = new AsyncDownloadXML();

    /**
     * On create method
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // set up our edit text variables
        etLoc =  (EditText) findViewById(R.id.textLoc);
        etTemp =  (EditText) findViewById(R.id.textTemp);
        etWind =  (EditText) findViewById(R.id.textWind);
        etVis =  (EditText) findViewById(R.id.textVis);
    }

    /**
     * On create method
     * @param v
     * @throws XmlPullParserException
     * @throws URISyntaxException
     * @throws IOException
     */
    public void btnClick (View v) throws XmlPullParserException, URISyntaxException, IOException {
        // Download the weather asynchronously
        AsyncWeatherDownloader.execute(this);
    }

    /**
     * Set temp field to String newTemp
     * @param newTemp
     */
    public void setTemp(String newTemp) {
        etTemp.setText(newTemp);
    }

    /**
     * Set wind field to String newWind
     * @param newWind
     */
    public void setWind(String newWind) {
        etWind.setText(newWind);
    }

    /**
     * Set visibility field to String newVis
     * @param newVis
     */
    public void setVis(String newVis) {
        etVis.setText(newVis);
    }

    /**
     * Set location field
     */
    public String getLocation() {
        return etLoc.getText().toString();
    }

    /**
     * setStatus toast method
     * @param newStatus
     */
    public void setStatus(String newStatus) {
        Toast toast=Toast.makeText(getApplicationContext(), newStatus,Toast.LENGTH_LONG );
        toast.show();
    }

}
