package edu.bu.ec500c1.tasterchallengeandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaMetadataRetriever;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by RedAlice64 on 2015/10/14.
 */
public class PlayerVK extends SurfaceView implements Runnable{

    Thread thread=null;
    SurfaceHolder holder;
    Rect displayRect;
    Paint displayPaint;
    AnimationDrawable videoAnimation;
    MediaMetadataRetriever videoRetriever;
    Context mContext;
    int frame;

    volatile boolean isRunning=false;


    public PlayerVK(Context context) {
        super(context);
        holder=getHolder();
        displayRect=new Rect(0,0,5000,4000);
        videoRetriever=new MediaMetadataRetriever();
        mContext=context;
        FileInputStream stream=null;
        File file=new File("/storage/emulated/0/Video/1.wmv");
        try {
            stream=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            videoRetriever.setDataSource(stream.getFD());
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame=0;
    }
    public void onResumePlayerVK(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    public void onPausePlayerVK(){
        boolean retry = true;
        isRunning = false;
        while(retry){
            try {
                thread.join();
                retry = false;
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

/*
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect=new Rect();\
        canvas.drawRect(rect,new Paint());
    }*/

    @Override
    public void run() {
        //// TODO: 2015/10/14
        displayPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        displayPaint.setARGB(255,0,255,0);
        displayPaint.setStrokeWidth((float)2.0);
        Rect rect=new Rect(0,0,1000,800);
        Canvas canvas=null;

        while (isRunning){
            Bitmap buffer=videoRetriever.getFrameAtTime();
            if(holder.getSurface().isValid()){
                try {
                    canvas=holder.getSurface().lockCanvas(displayRect);
                } catch (Surface.OutOfResourcesException e) {
                    e.printStackTrace();
                }
                Bitmap bitmap=videoRetriever.getFrameAtTime(frame);
                frame+=10000;
                //canvas.drawRect(rect, displayPaint);
                canvas.drawBitmap(bitmap,0,100,displayPaint);
                holder.getSurface().unlockCanvasAndPost(canvas);
            }
        }
    }
}
