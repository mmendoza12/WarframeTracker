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

public class SortiesActivity extends AppCompatActivity {

    // URL for Warframe Tracker
    private static final String URL = "https://deathsnacks.com/wf/";

    // Private member variable for the textView(s)
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorties);

        // Connect the textView(s)
        textView = findViewById(R.id.textView);

        // Start the Jsoup processes
        new Sorties().execute();
    }

    private class Sorties extends AsyncTask
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

                // Get the ul item (sorties)
                Elements ul = body.select("ul[class=list-group sorties-container]");

                System.out.println("2222" + ul.text());

                // Get each li item (sortie) from the ul item (sorties)
                for (Element li : ul)
                {
                    System.out.println("@@@" + li.text());

                    // Get the span items (details) from each li item (sortie)
                    Elements spans = li.select("span");
                    for (Element span : spans)
                        System.out.println("spans:" + span.text());
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

            // Update the textView(s) with the sorties' data
            //for (String sortie : sorties)
                //textView.setText(textView.getText() + sortie+ "\n");

            //linearLayout.removeView(textView);
        }
    }
}
