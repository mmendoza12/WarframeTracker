package mmendoza.warframetracker;

import android.content.Intent;
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

    // URL for Warframe Tracker
    private static final String URL = "https://deathsnacks.com/wf/";

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

        // Start the Jsoup processes
        new Data().execute();
    }

    /**
     * Task that allows the TrackerActivity to display quick data relevant to specific options.
     */
    private class Data extends AsyncTask
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            Document doc;

            try {
                // Connect to URL
                doc = Jsoup.connect(URL).get();

                // Get the body of the site
                Element body = doc.body();

                // Get Darvo's Daily Deal
                // TODO:
                //Elements li = body.select("li[class=list-group-item darvodaily]");
                //Elements li = body.select("ul[class=list-group deal-container]");

                //System.out.println("1111" + li.text());

                //
                /*
                for (Element span : li)
                {
                    System.out.println("!!!!" + span.text());
                }
                */

                // Get the Void Trader's data
                // TODO:

                // Get Cetus' Day/Night cycle
                // TODO: Figure out the "Javascript is required to load this page"
                Elements h = body.select("div[class=col-md-6]");
                /*
                for (Element j : h)
                {
                    System.out.println("cetus:" + j.text());
                }
                */

                // Get the div items (invasions)
                //Elements divs = body.select("div[class=invasion-container]");

                // Traverse each div (invasion) within the divs (invasions)
                /*
                for (Element div : divs)
                {
                    // Get the td items (invasion info) for each div (invasion)
                    Elements tr = div.select("table tbody tr");
                    for (Element td : tr)
                        td.text();
                }
                */
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            // Update the textView(s) with the invasions' data
            //for (String invasion : invasions)
                //textView.setText(textView.getText() + invasion + "\n");

            //linearLayout.removeView(textView);
        }
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

    /**
     * Used when the user clicks on the sorties option.
     *
     * @param v View
     */
    public void launchSorties(View v)
    {
        Intent sortiesIntent = new Intent(this, SortiesActivity.class);
        startActivity(sortiesIntent);
    }
}
