package israel.firebasepushnotifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by hackeru on 17/07/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("hackeru", "onMessageReceived");
    }


    @Override
    public void handleIntent(Intent intent) {
       // super.handleIntent(intent);
        Log.d("hackeru", "handelIntent");


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Hello custom push");
        builder.setSmallIcon(R.drawable.ic_notification);
        builder.setContentText("The Content Text");
        builder.setAutoCancel(true);


        Intent contentIntent = new Intent(this, MainActivity.class);
        contentIntent.putExtra("name", "Israel");

        PendingIntent pi = PendingIntent.getActivities(this, 1, contentIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = builder.build();
    }
}
