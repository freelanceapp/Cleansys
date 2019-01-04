package creative.creation.in.cleansys.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;

import creative.creation.in.cleansys.AppPreference;
import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.util.Constant;

public class SplashActivity extends AppCompatActivity {

    private FirebaseAnalytics mFirebaseAnalytics;
    Context ctx;
    public static String APP_NAME = "Cleansys";
    private String user_id;
    boolean isLogin = false;
    private String strId = "";
    private String strFrom = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ctx = this;

        if (getIntent() != null) {
            strId = getIntent().getStringExtra("job_id");
            strFrom = getIntent().getStringExtra("from");
        }

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        String tkn = FirebaseInstanceId.getInstance().getToken();

        isLogin = AppPreference.getBooleanPreference(getApplicationContext(), "Is_Login");
        SharedPreferences prefs = getSharedPreferences(APP_NAME, MODE_PRIVATE);
        user_id = AppPreference.getStringPreference(getApplicationContext(), "USER_ID");//"No name defined" is the default value.
        //Toast.makeText(SplashActivity.this, "Current token ["+tkn+"]", Toast.LENGTH_LONG).show();
        Log.e("Token", ".." + tkn);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isLogin) {
                    startActivity(new Intent(ctx, LoginActivity.class));
                } else {

                    if (strFrom==null) {
                        startActivity(new Intent(ctx, MainActivity.class));
                    } else {
                        Intent intent = new Intent(ctx, UpdateActivity.class);
                        intent.putExtra("job_id", strId);
                        intent.putExtra("from", "notification");
                    }

                    /*Intent intent = new Intent(ctx, JobSchedulerActivity1.class);
                    intent.putExtra("type", "login");
                    startActivity(intent);*/
                }
                finish();
            }
        }, Constant.SPLASH_TIME_OUT);
    }
}
