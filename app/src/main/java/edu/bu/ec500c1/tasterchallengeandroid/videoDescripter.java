package edu.bu.ec500c1.tasterchallengeandroid;

import android.graphics.Bitmap;

/**
 * Created by jmeunier28 on 10/23/15.
 */
public class videoDescripter {
    private Bitmap thumbnail;

    private String videoID;

    public videoDescripter(Bitmap thumbnail, String videoID) {
        this.thumbnail = thumbnail;
        this.videoID = videoID;
    }
    public Bitmap getImageBitmap(){
        return thumbnail;
    }
    public String getVideoID(){
        return videoID;
    }
}
