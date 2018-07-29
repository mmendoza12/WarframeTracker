/**
 * First activity of the app.
 * Allows the user to choose between launching the warframe tracker or market components.
 *
 * @author Moises Mendoza
 */

package mmendoza.warframetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Private member variables for the image views
    private ImageView trackerImageView;
    private ImageView marketImageView;

    // Private member variables for the text views
    private TextView trackerTextView;
    private TextView marketTextView;

    // Private variables used to track the selected option
    private boolean tracker = false,
                    market = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect the image views
        trackerImageView = findViewById(R.id.trackerImageView);
        marketImageView = findViewById(R.id.marketImageView);

        // Connect the text views
        trackerTextView = findViewById(R.id.trackerTextView);
        marketTextView = findViewById(R.id.marketTextView);
    }

    /**
     * Used when the user clicks on the tracker image
     *
     * @param v View
     */
    public void launchTracker(View v)
    {
        if (tracker)
        {
            Intent trackerIntent = new Intent(this, TrackerActivity.class);
            startActivity(trackerIntent);
        }
        else {
            // Visible effects to indicate tracker has been selected
            trackerImageView.setImageDrawable(getDrawable(R.drawable.warframe_blue_selected));
            trackerTextView.setTextColor(getColor(R.color.white));

            // Visible effects to indicate market has been deselected
            if (market) {
                marketImageView.setImageDrawable(getDrawable(R.drawable.warframe_green));
                marketTextView.setTextColor(getColor(R.color.gray));
                market = false;
            }

            tracker = true;
        }
    }

    /**
     * Used when the user clicks on the market image
     *
     * @param v View
     */
    public void launchMarket(View v)
    {
        if (market)
        {
            Intent marketIntent = new Intent(this, MarketActivity.class);
            startActivity(marketIntent);
        }
        else {
            // Visible effects to indicate market has been selected
            marketImageView.setImageDrawable(getDrawable(R.drawable.warframe_green_selected));
            marketTextView.setTextColor(getColor(R.color.white));

            // Visible effects to indicate tracker has been deselected
            if (tracker) {
                trackerImageView.setImageDrawable(getDrawable(R.drawable.warframe_blue));
                trackerTextView.setTextColor(getColor(R.color.gray));
                tracker = false;
            }
            market = true;
        }
    }
}
