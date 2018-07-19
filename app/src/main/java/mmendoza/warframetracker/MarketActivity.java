/**
 * Warframe Market component. Allows the user to see the current prices of trade items.
 * Uses JSoup to retrieve information from nexus-stats.com.
 * NexusStats contains the average price of each item sold per week.
 *
 * @author Moises Mendoza
 */

package mmendoza.warframetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MarketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
    }
}
