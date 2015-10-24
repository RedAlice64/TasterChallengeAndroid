package edu.bu.ec500c1.tasterchallengeandroid;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VideoPlayerActivity extends ActionBarActivity {

    public ListView mVideoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        mVideoList=(ListView)findViewById(R.id.video_list);
        VideoListAdapter adapter=new VideoListAdapter(this,getVideoData());

        mVideoList.setAdapter(adapter);
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
    }

    private List<videoDescripter> getVideoData(){

        List<videoDescripter> video1 = new ArrayList<videoDescripter>();

        getResources().getDrawable(R.drawable.back_button_icon);

        Bitmap bm= BitmapFactory.decodeResource(getResources(),R.drawable.back_button_icon);

        video1.add(new videoDescripter(bm,"1"));
        video1.add(new videoDescripter(bm,"2"));

        return video1;
    }


}
