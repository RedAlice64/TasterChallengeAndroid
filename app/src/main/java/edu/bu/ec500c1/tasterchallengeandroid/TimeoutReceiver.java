package edu.bu.ec500c1.tasterchallengeandroid;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by RedAlice64 on 2015/11/24.
 */
public class TimeoutReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getBooleanExtra("timeout",false))System.exit(0);
    }
}
