package y2022.aoc.taleb.final_try;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver {
    //this class is initiated a broadcast from the Operating System
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, NotificationIntentService.class);
        context.startService(intent1);

    }
}