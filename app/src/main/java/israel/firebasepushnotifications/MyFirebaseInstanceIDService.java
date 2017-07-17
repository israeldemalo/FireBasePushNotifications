package israel.firebasepushnotifications;

import android.content.SharedPreferences;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by hackeru on 17/07/2017.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();

        String token = FirebaseInstanceId.getInstance().getToken();

        SharedPreferences prefs = getSharedPreferences("userid", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("token", token);

        editor.commit();
    }
}
