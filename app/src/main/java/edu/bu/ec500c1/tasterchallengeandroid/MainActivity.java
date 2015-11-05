package edu.bu.ec500c1.tasterchallengeandroid;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.VideoView;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    static final int REQUEST_SETTINGS = 0;

    private ImageButton mSettingsButton;
    private ImageButton mLockButton;
   // private PlayerVK player;
   // private RelativeLayout videoContainer;
    public MediaPlayer mMP;
    private Button mExitButton; // button to exit app
    public ListView mVideoList;

    /*@Override
    protected void onResume() {
        super.onResume();
        player.onResumePlayerVK();
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startSettingsActivity();
        startParentalControlActivity();
        exitApp(); //will stop media when user exits the app

        mMP = MediaPlayer.create(this,R.raw.backgroundmusic);
        mMP.start();
        //player=new PlayerVK(this);

        mVideoList=(ListView)findViewById(R.id.video_list);
        VideoListAdapter adapter=new VideoListAdapter(this,getVideoData());
        videoThumbnailClicked();


        mVideoList.setAdapter(adapter);


    }

    private void videoThumbnailClicked() {

        mVideoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                VideoListAdapter adapter=(VideoListAdapter)mVideoList.getAdapter();
                //videoDescripter descripter=(videoDescripter)adapter.getItem((int)id);
                //getRequestMethod request = new getRequestMethod();
                //request.getVideoID((int)id);
                Intent intent=new Intent(MainActivity.this,VideoPlayerActivity.class);

                if ((int)id==0) {
                    intent.putExtra("id","Sample.mp4");
                }
                else if((int)id ==1){
                    intent.putExtra("id","car2.mp4");
                }
                else if((int)id ==2){
                    intent.putExtra("id","car_proc.mp4");
                }
                startActivity(intent);

            }
        });

    }

    private List<videoDescripter> getVideoData(){

        List<videoDescripter> video1 = new ArrayList<videoDescripter>();


        getResources().getDrawable(R.drawable.back_button_icon);
        getResources().getDrawable(R.drawable.check_icon);

        Bitmap bm= BitmapFactory.decodeResource(getResources(),R.drawable.sample);
        Bitmap bm2 = BitmapFactory.decodeResource(getResources(), R.drawable.car);
        Bitmap bm3 = BitmapFactory.decodeResource(getResources(), R.drawable.car_proc);

        video1.add(new videoDescripter(bm, "1"));
        video1.add(new videoDescripter(bm2, "2"));
        video1.add(new videoDescripter(bm3,"3"));

        return video1;
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
        mExitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMP.release();

                finish();
                System.exit(0);
            }
        });
    }

    protected void onPause() {
        super.onPause();
        //mMP.release();

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
