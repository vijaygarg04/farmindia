package farmindia.bmpl.com.farmindia;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by nikhilgupta on 23/04/17.
 */

public class CustomBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("custom.broadcast")){
            String message = intent.getStringExtra("message");
            //Toast.makeText(context,)

        }
    }
}
