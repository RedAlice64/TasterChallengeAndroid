package edu.bu.ec500c1.tasterchallengeandroid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class TimerService extends Service {
    public static boolean isRunning=false;
    public static boolean restEnough=true;


    private Timer timerDuration =null;
    private Timer timerReset=null;
    private int timePlayed;
    private int durationTime=15,resetTime=15;
    @Nullable
     @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        durationTime=intent.getIntExtra("duration_time",200);
        resetTime=intent.getIntExtra("rest_time",200);
        timePlayed=0;

        timerDuration =new Timer();
        timerReset=new Timer();
        /*
        timerDuration.schedule(new TimerTask() {

            @Override
            public void run() {
                if (timePlayed++ > durationTime) {
                    sendShutDown();
                    Log.d("timerDuration", String.valueOf(timePlayed));
                    restEnough = false;
                    this.cancel();
                }

            }
        }, 0, 1000);*/
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //if(!intent.getBooleanExtra("shutdown",false)) timerDuration.cancel();
        timerDuration =new Timer();
        timerReset=new Timer();
        //if(!restEnough){//sendShutDown();}
        //else{
            timerDuration.schedule(new TimerTask() {

                @Override
                public void run() {
                    if (timePlayed++ > 80) {
                        Log.d("shutdown","shutdown");
                        Log.d("timerDuration", String.valueOf(timePlayed));
                        sendShutDown();
                        timePlayed=0;
                        restEnough = false;
                    }

                }
            }, 0, 1000);
        //}
        return super.onStartCommand(intent, flags, startId);
    }

    private void sendShutDown(){
        Intent intent=new Intent();
        intent.setAction(MainActivity.DURATION_END_ACTION);
        intent.putExtra("timeout",true);
        sendBroadcast(intent);
    }
}
