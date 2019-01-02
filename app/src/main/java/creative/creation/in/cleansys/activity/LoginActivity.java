package creative.creation.in.cleansys.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import creative.creation.in.cleansys.AppPreference;
import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.util.ConnectionDetector;
import creative.creation.in.cleansys.util.Utility;
import creative.creation.in.cleansys.util.WebApi;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Context ctx;
    EditText username_et, pass_et;
    Button login_bt;
    TextView forgot_btn;

    ConnectionDetector connectionDetector;
    //SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initXml();
        //checkLogin();
    }

    private void initXml() {
        ctx = this;
        username_et = findViewById(R.id.et_login_username);
        pass_et = findViewById(R.id.et_login_pass);
        login_bt = findViewById(R.id.bt_login_login);
        forgot_btn = findViewById(R.id.forgot_btn);
        //sessionManager = new SessionManager(ctx);
        login_bt.setOnClickListener(this);

        forgot_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {

        boolean internet = connectionDetector.isConnected();
        if (internet) {
            getData();
        } else {
            Utility.toastView(ctx, ctx.getString(R.string.no_internet));
        }
    }

    private void getData() {

        String username = username_et.getText().toString();
        String pass = pass_et.getText().toString();

        if (!username.equals("") && !pass.equals("")) {
            submitData(username, pass);
        } else {
            Utility.toastView(ctx, "Enter Username and Password");
        }
    }

    private void submitData(String username, String pass) {
        Utility.showLoader(ctx);
        AndroidNetworking.post(WebApi.API_LOGIN)
                .addBodyParameter("username", username)
                .addBodyParameter("password", pass)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        Utility.hideLoader();
                        setResponse(response);
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Utility.hideLoader();
                    }
                });
    }

    private void setResponse(JSONObject response) {

        try {
            boolean error = response.getBoolean("error");
            String msg = response.getString("message");
            if (!error) {
                JSONObject object = response.getJSONObject("user");
                String user_id = object.getString("user_id");
                String username = object.getString("username");

                AppPreference.setBooleanPreference(getApplicationContext(), "Is_Login", true);
                AppPreference.setStringPreference(getApplicationContext(), "USER_ID", user_id);
                AppPreference.setStringPreference(getApplicationContext(), "USER_NAME", username);

                //sessionManager.createLoginSession(user_id, username);
                Intent intent = new Intent(ctx, MainActivity.class);
                startActivity(intent);
                Utility.toastView(ctx, "Successfully login");
                finish();
            } else {
                Utility.toastView(ctx, msg);
            }
            clear();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void clear() {
        username_et.setText("");
        pass_et.setText("");
    }
}
