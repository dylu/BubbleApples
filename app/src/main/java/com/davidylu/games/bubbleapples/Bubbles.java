package com.davidylu.games.bubbleapples;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Bubbles extends AppCompatActivity
{
    public final static String EXTRA_MESSAGE = "com.davidylu.games.bubbleapples.MESSAGE";

    /** Called when the user clicks the 'Send' button. **/
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /*
     * Notes:  Called every time this application is 'created.'
     *          Should not affect paused/resuming the application.
     *
     *          After this, the system calls onStart() and onResume() in quick succession.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubbles);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bubbles, menu);
        return true;
    }

    // Activity either being started for the first time or restarted.
    @Override
    protected void onStart()
    {
        super.onStart();

        // For example if our app needs gps:
//        LocationManager locationManager =
//                (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        boolean gpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//
//        if (!gpsEnabled) {
//            // Create a dialog here that requests the user to enable GPS, and use an intent
//            // with the android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS action
//            // to take the user to the Settings screen to enable GPS when they click "OK"
//        }
    }

    // Application being restarted from stopped state.
    @Override
    protected void onRestart()
    {
        super.onRestart();
    }

    /*
     * Although the onPause() method is called before onStop(), you should
     * use onStop() to perform larger, more CPU intensive shut-down operations,
     * such as writing information to a database.
     */
    @Override
    public void onStop()
    {
        super.onStop();

    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();

        // Stop method tracing that the activity started during onCreate()
        android.os.Debug.stopMethodTracing();
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
