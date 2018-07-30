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
import java.util.ArrayList;

public class InvasionsActivity extends AppCompatActivity {

    // URL for Warframe Tracker
    private static final String URL = "https://deathsnacks.com/wf/";

    // Private member variable for the textView(s)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invasions);

        // Connect the textView(s)
        textView = findViewById(R.id.textView);

        // Start the Jsoup processes
        new Invasions().execute();
    }

    private class Invasions extends AsyncTask
    {
        ArrayList<String> invasions = new ArrayList<>();

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

                // Get the div items (invasions)
                Elements divs = body.select("div[class=invasion-container]");

                // Traverse each div (invasion) within the divs (invasions)
                for (Element div : divs)
                {
                    // Get the td items (invasion info) for each div (invasion)
                    Elements tr = div.select("table tbody tr");
                    for (Element td : tr)
                        invasions.add(td.text());
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

            // Update the textView(s) with the invasions' data
            for (String invasion : invasions)
                textView.setText(textView.getText() + invasion + "\n");

            //linearLayout.removeView(textView);
        }
    }
}
