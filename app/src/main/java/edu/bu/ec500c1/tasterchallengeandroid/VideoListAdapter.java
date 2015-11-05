package edu.bu.ec500c1.tasterchallengeandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by jmeunier28 on 10/23/15.
 */
public class VideoListAdapter extends BaseAdapter {

    private Activity Context;
    private List<videoDescripter> list;
    public VideoListAdapter(Activity context,List<videoDescripter> l){
        Context=context;
        list=l;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=Context.getLayoutInflater();
        View itemView=inflater.inflate(R.layout.video_item_layout, null);
        videoDescripter descripter=list.get(position);
        ImageView imageView=(ImageView)itemView.findViewById(R.id.video1_image);
        imageView.setImageBitmap(descripter.getImageBitmap());
        //imageView1.setImageBitmap(descripter.getImageBitmap());
        return itemView;
    }
}
