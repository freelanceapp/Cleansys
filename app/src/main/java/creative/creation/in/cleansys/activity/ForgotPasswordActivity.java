package creative.creation.in.cleansys.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.util.ConnectionDetector;
import creative.creation.in.cleansys.util.Utility;
import creative.creation.in.cleansys.util.WebApi;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    Context ctx;
    EditText email_id_et;
    Button forgot_bt;
    ImageView back_btn;

    ConnectionDetector connectionDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initXml();
        checkLogin();
    }

    private void initXml() {
        ctx = this;
        email_id_et = findViewById(R.id.et_forgot_email);
        forgot_bt = findViewById(R.id.bt_forgot_btn);
        back_btn = findViewById(R.id.back_btn);
        forgot_bt.setOnClickListener(this);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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

        String username = email_id_et.getText().toString();

        if (!username.equals("")) {
            submitData(username);
        } else {
            Utility.toastView(ctx, "Enter Username and Password");
        }
    }

    private void checkLogin() {
       /* boolean login = sessionManager.isLoggedIn();
        if (login) {
            startActivity(new Intent(ctx, MainActivity.class));
            finish();
        }*/
    }


    private void submitData(String username) {
        Utility.showLoader(ctx);
        AndroidNetworking.post(WebApi.API_FORGOT)
                .addBodyParameter("email", username)
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
                Utility.toastView(ctx, msg);
            } else {
                Utility.toastView(ctx, msg);
            }
            clear();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void clear() {
        email_id_et.setText("");
    }
}
