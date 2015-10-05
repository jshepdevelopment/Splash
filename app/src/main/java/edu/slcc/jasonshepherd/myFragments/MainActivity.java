package edu.slcc.jasonshepherd.myFragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Create fragment manager. Allows interaction with fragment in an activity.
        FragmentManager fragmentManager = getFragmentManager();

        // Create fragment transaction. Allows us to call methods to manage fragments... show, etc.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Set to change fragments on orientation - first get configuration information
        Configuration configuration = getResources().getConfiguration();

        // Check configuration orientation, and hide panel if in portrait orientation
        if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            hideSidePanel();
        }

        // Used to invoke Fragment changes on Activity
        fragmentTransaction.commit();

    }

    // Hide the side panel if it is visible
    private void hideSidePanel() {
        View sidePane = findViewById(R.id.side_panel);
        if (sidePane.getVisibility() == View.VISIBLE) {
            sidePane.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(edu.slcc.jasonshepherd.myFragments.R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == edu.slcc.jasonshepherd.myFragments.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
