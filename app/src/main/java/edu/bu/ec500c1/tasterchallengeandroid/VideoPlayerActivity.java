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
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoPlayerActivity extends ActionBarActivity {
    private VideoView videoView;
    private MediaController controller;
    private RadioGroup selectionRadioGroup;
    private OnCheckedChangeListener selectListener;
    private Map<Integer,Integer> idMap;

    private String VideoName;
    @Override
    protected void onResume(){
        super.onResume();
        videoView.start();
        videoView.postDelayed(new Runnable() {
            @Override
            public void run() {
                videoView.pause();
                onPauseForSelection();
            }
        },5000);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoView= (VideoView)findViewById(R.id.video_player);
        videoView.setVideoPath("http://vid4kids.s3.amazonaws.com/" + getIntent().getExtras().getString("id"));
        String string = "http://vid4kids.s3.amazonaws.com/" + getIntent().getExtras().getString("id");
        controller=new MediaController(this);
        videoView.setMediaController(controller);
        selectionRadioGroup=(RadioGroup)findViewById(R.id.selection_group);
        selectionRadioGroup.setAlpha(0.0f);

        idMap=new HashMap<Integer, Integer>();
        idMap.put(R.id.selection_0,0);
        idMap.put(R.id.selection_1,1);
        idMap.put(R.id.selection_2,2);
        idMap.put(R.id.selection_3,3);

        /*RadioButton button=new RadioButton(this);
        button.setText("sefhiawehgoiawg");
        selectionRadioGroup.addView(button);*/
        //onPauseForSelection();
    }

    public void onPauseForSelection(){
        selectionRadioGroup.setAlpha(1.0f);
        final MultipleChoice multipleChoice=new MultipleChoice();
        selectListener=new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(multipleChoice.isCorrect(idMap.get(checkedId)))Toast.makeText(VideoPlayerActivity.this,"Correct!",Toast.LENGTH_SHORT).show();
                else Toast.makeText(VideoPlayerActivity.this,"Not correct!",Toast.LENGTH_SHORT).show();
                group.setAlpha(0.0f);
                videoView.start();
            }
        };
        selectionRadioGroup.setOnCheckedChangeListener(selectListener);
        RadioButton[] buttons=new RadioButton[4];
        buttons[0]=(RadioButton)findViewById(R.id.selection_0);
        buttons[1]=(RadioButton)findViewById(R.id.selection_1);
        buttons[2]=(RadioButton)findViewById(R.id.selection_2);
        buttons[3]=(RadioButton)findViewById(R.id.selection_3);
        for(int i=0;i<4;i++){
            buttons[i].setText(multipleChoice.next());
        }
    }
   // public ListView mVideoList;
  /* private PlayerVK player;
    private RelativeLayout videoContainer;

    @Override
    protected void onResume(){
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