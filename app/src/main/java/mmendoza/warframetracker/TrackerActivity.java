package mmendoza.warframetracker;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class TrackerActivity extends AppCompatActivity {

    // Private member variables for the text views
    private TextView alertsTextView;
    private TextView invasionsTextView;
    private TextView darvoTextView;
    private TextView traderTextView;
    private TextView sortiesTextView;
    private TextView fissuresTextView;
    private TextView cetusTextView;
    private TextView earthTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracker);

        // Connect the text views
        alertsTextView = findViewById(R.id.alertsTextView);
        invasionsTextView = findViewById(R.id.invasionsTextView);
        darvoTextView = findViewById(R.id.darvoDailyDealsTextView);
        traderTextView = findViewById(R.id.voidTraderTextView);
        sortiesTextView = findViewById(R.id.sortiesTextView);
        fissuresTextView = findViewById(R.id.voidFissuresTextView);
        cetusTextView = findViewById(R.id.cetusTextView);
        earthTextView = findViewById(R.id.earthTextView);
    }

    /**
     * Used when the user clicks on the alerts option.
     *
     * @param v View
     */
    public void launchAlerts(View v)
    {
        Intent alertsIntent = new Intent(this, AlertsActivity.class);
        startActivity(alertsIntent);
    }

    /**
     * Used when the user clicks on the invasions option.
     *
     * @param v View
     */
    public void launchInvasions(View v)
    {
        Intent invasionsIntent = new Intent(this, InvasionsActivity.class);
        startActivity(invasionsIntent);
    }
}
