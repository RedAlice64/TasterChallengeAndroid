package edu.bu.ec500c1.tasterchallengeandroid;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.SeekBar;
import android.media.AudioManager;
import android.widget.ImageButton;
import android.content.Intent;
import android.widget.Toast;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import java.util.List;
import android.content.ComponentName;

public class SettingsActivity extends ActionBarActivity implements SeekBar.OnSeekBarChangeListener {

    public SeekBar mSeekBarVolume;
    public MediaPlayer mMP;
    public AudioManager mAM;
    public ImageButton mVolumeSetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        mSeekBarVolume = (SeekBar) findViewById(R.id.sbVolume);
       // mMP = MediaPlayer.create(this,R.raw.backgroundmusic);
       // mMP.start();
        mAM = (AudioManager)getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = mAM.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = mAM.getStreamVolume(AudioManager.STREAM_MUSIC);
        mSeekBarVolume.setMax(maxVolume);
        mSeekBarVolume.setProgress(currentVolume);

        mSeekBarVolume.setOnSeekBarChangeListener(this);

        setVolume();

    }
    protected void onPause() {
        super.onPause();
       // mMP.release();
    }

    public void setVolume(){

        mVolumeSetButton = (ImageButton) findViewById(R.id.checkbox);
        mVolumeSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // here we want to go back to the main activity page
                // can we make this so we dont stop playing the music??
                //Intent intent = new Intent();
                //setResult(RESULT_OK);
                onBackPressed();
            }
        });
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

        mAM.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        //blah blah blah

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        //blah blah blah

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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

