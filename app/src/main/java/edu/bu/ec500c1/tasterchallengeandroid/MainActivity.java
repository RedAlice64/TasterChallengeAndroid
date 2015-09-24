package edu.bu.ec500c1.tasterchallengeandroid;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.media.MediaPlayer;


public class MainActivity extends Activity {

    static final int REQUEST_SETTINGS = 0;

    private ImageButton mSettingsButton;
    private ImageButton mLockButton;
    private MediaPlayer mMP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startSettingsActivity();
        startParentalControlActivity();

        mMP = MediaPlayer.create(this,R.raw.backgroundmusic);
        mMP.start();

    }
    public void startParentalControlActivity(){
        mLockButton = (ImageButton) findViewById(R.id.parental_control);
        mLockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ParentalControl.class);
                startActivity(intent);
            }
        });
    }
    public void startSettingsActivity(){
        mSettingsButton = (ImageButton) findViewById(R.id.settings_button);
        mSettingsButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //start settings Activity
                //get back status of volume bar
                Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
                startActivityForResult(intent,REQUEST_SETTINGS);
            }

        });
    }

    protected void onPause() {
        super.onPause();
        mMP.release();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
