package edu.bu.ec500c1.tasterchallengeandroid;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;

/**
 * Created by RedAlice64 on 2015/11/14.
 */
public class ParentalControlActual extends Activity{

    private SeekBar durationSeek;
    private SeekBar restTimeSeek;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences=getPreferences(MODE_PRIVATE);
        durationSeek=(SeekBar)findViewById(R.id.duration_seek_bar);
        restTimeSeek=(SeekBar)findViewById(R.id.rest_time_seek_bar);

        durationSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SharedPreferences.Editor editor=preferences.edit();
                editor.putInt("duration_time",progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        restTimeSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SharedPreferences.Editor editor=preferences.edit();
                editor.putInt("rest_time",progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
