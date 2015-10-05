package edu.slcc.jasonshepherd.myFragments;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use getWindow() to set the layout parameters to fullscreen
        // This will effectively hide the system's status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // getSupportActionBar() is used to get a reference to the activity's action bar
        // adding the .hide() to hide the activities action bar
        getSupportActionBar().hide();

        // important to set content view after the above methods, to avoid crash
        setContentView(R.layout.activity_splash);

        // New thread
        Runnable wait3seconds = new Runnable() {
            public void run() {
                nextActivity();
            }
        };

        Handler handler = new Handler();
        handler.postDelayed(wait3seconds, 3000);
    }

    public void nextActivity() {
        // Start next activity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
