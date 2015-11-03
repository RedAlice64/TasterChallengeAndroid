package edu.bu.ec500c1.tasterchallengeandroid;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.VideoView;


public class MainActivity extends Activity {

    static final int REQUEST_SETTINGS = 0;

    private ImageButton mSettingsButton;
    private ImageButton mLockButton;
    private PlayerVK player;
    private RelativeLayout videoContainer;
    public MediaPlayer mMP;
    private Button mExitButton; // button to exit app

    @Override
    protected void onResume() {
        super.onResume();
        player.onResumePlayerVK();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startSettingsActivity();
        startParentalControlActivity();
        exitApp(); //will stop media when user exits the app

        mMP = MediaPlayer.create(this,R.raw.backgroundmusic);
        mMP.start();
        player=new PlayerVK(this);
        //setContentView(player,new ActionBar.LayoutParams(50,50));

        videoContainer=(RelativeLayout)findViewById(R.id.video_container);
        videoContainer.addView(player,1000,800);

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
                startActivityForResult(intent, REQUEST_SETTINGS);
            }

        });
    }
    public void exitApp(){
        mExitButton = (Button) findViewById(R.id.exit_button);
        mExitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                mMP.release();

                finish();
                System.exit(0);
            }
        });
    }

    protected void onPause() {
        super.onPause();
        //mMP.release();
        mMP.release();
        player.onPausePlayerVK();
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
