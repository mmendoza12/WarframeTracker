package mmendoza.warframetracker;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AlertsActivity extends AppCompatActivity {

    // URL for Warframe Tracker
    private static final String URL = "https://deathsnacks.com/wf/";

    // Private member variable(s) for the textView(s)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        // Connect the textView(s)
        textView = findViewById(R.id.textView);

        // Start the Jsoup processes
        new Alerts().execute();
    }

    private class Alerts extends AsyncTask
    {
        String alert = "";

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
                //System.out.println(ul.text()); THIS WORKS PROPERLY

                // Get each Li item (alert) from the Ul items (alerts)
                for (Element li : ul)
                {
                    //System.out.println(li.text());

                    // Get the span items of the Li items
                    Elements spans = li.select("span");
                    for (Element span : spans) {
                        System.out.print(span.text() + "\n");
                        alert += span.text() + "\n";
                    }
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
            textView.setText(alert);
        }
    }
}
