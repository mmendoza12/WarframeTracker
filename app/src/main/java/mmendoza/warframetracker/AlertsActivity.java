package mmendoza.warframetracker;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class AlertsActivity extends AppCompatActivity {

    // URL for Warframe Tracker
    private static final String URL = "https://deathsnacks.com/wf/";

    // Private member variable for the linear layout
    private LinearLayout linearLayout;

    // Private member variable(s) for the textView(s)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        // Connect the textView(s)
        textView = findViewById(R.id.textView);

        // Connect the linear layout
        linearLayout = findViewById(R.id.linearLayout);

        // Start the Jsoup processes
        new Alerts().execute();
    }

    private class Alerts extends AsyncTask
    {
        ArrayList<String> alerts = new ArrayList<>();

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

                // Find Ul items (alerts)
                Elements ul = body.select("div div div div ul");

                // Get each Li item (alert) from the Ul items (alerts)
                for (Element li : ul)
                {
                    // Get the span items of the Li items
                    Elements spans = li.select("span");
                    for (Element span : spans)
                        alerts.add(span.text());
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            // Update the textView(s) to display alert data
            for (String alert : alerts)
                //addAlert(alert);
                textView.setText(textView.getText() + alert + "\n");

            //linearLayout.removeView(textView);
        }
    }

    /**
     * Adds the alerts' text into a new textView for each alert.
     * Adds the textViews to the linear layout.
     *
     * @param alert The text of a single alert
     */
    public void addAlert(String alert)
    {
        TextView alertTextView = new TextView(this);
        alertTextView.setText(alert);
        alertTextView.setTextColor(getResources().getColor(R.color.white));
        alertTextView.setLayoutParams(textView.getLayoutParams());
        alertTextView.setGravity(Gravity.CENTER);
        alertTextView.setBackground(getResources().getDrawable(R.drawable.square_outline));
        linearLayout.addView(alertTextView);
    }
}
