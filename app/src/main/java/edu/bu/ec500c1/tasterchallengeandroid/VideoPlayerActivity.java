package edu.bu.ec500c1.tasterchallengeandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class VideoPlayerActivity extends ActionBarActivity {
    private VideoView videoView;
    private String VideoName;
    @Override
    protected void onResume(){
        super.onResume();
        videoView.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoView= (VideoView)findViewById(R.id.video_player);
        videoView.setVideoPath("http://vid4kids.s3.amazonaws.com/" + getIntent().getExtras().getString("id"));
        String string = "http://vid4kids.s3.amazonaws.com/" + getIntent().getExtras().getString("id");
    }
   // public ListView mVideoList;
  /* private PlayerVK player;
    private RelativeLayout videoContainer;

    @Override
    protected void onResume() {
        super.onResume();
        player.onResumePlayerVK();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        player=new PlayerVK(this);
        videoContainer=(RelativeLayout)findViewById(R.id.video_container);
        videoContainer.addView(player, 1000, 800);
    }

    protected void onPause() {
        super.onPause();
        player.onPausePlayerVK();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video_player, menu);
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
    }*/



}
