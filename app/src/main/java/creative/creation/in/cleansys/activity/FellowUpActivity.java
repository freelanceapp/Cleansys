package creative.creation.in.cleansys.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.FellowUpListAdapter;
import creative.creation.in.cleansys.modal.api_modal.FellowUp_responce.FellowupUser;
import creative.creation.in.cleansys.util.ConnectionDetector;
import creative.creation.in.cleansys.util.Utility;
import creative.creation.in.cleansys.util.WebApi;
import creative.creation.in.cleansys.utils.BaseActivity;

public class FellowUpActivity extends BaseActivity implements View.OnClickListener {

    Context ctx;
    ImageView back_iv;
    RecyclerView recyclerView;

    ConnectionDetector connectionDetector;
    ArrayList<FellowupUser> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_follow_list);
        initXml();
        boolean internet = connectionDetector.isConnected();
        if (internet) {
            getJobs();
        } else {
            Utility.toastView(ctx, ctx.getString(R.string.no_internet));
        }
    }

    private void setAdapter(ArrayList<FellowupUser> list) {
        FellowUpListAdapter adapter = new FellowUpListAdapter(ctx, list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void getJobs() {
        Utility.showLoader(ctx);
        AndroidNetworking.get(WebApi.API_FELLOW_LIST)
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
                        Utility.hideLoader();
                    }
                });
    }

    private void setResponse(JSONObject response) {

        list = new ArrayList<>();
        try {
            boolean error = response.getBoolean("error");
            String msg = response.getString("message");
            if (!error) {
                JSONArray array = response.getJSONArray("user");
                if (array.length() > 0) {
                    for (int i = 0; i < array.length(); i++) {

                        JSONObject object = array.getJSONObject(i);
                        String customer_ref_umber = object.getString("customer_ref_umber");
                        String job_ref_num = object.getString("job_ref_num");
                        String customer_full_name = object.getString("customer_full_name");
                        String customer_email = object.getString("customer_email");
                        String job_details = object.getString("job_details");
                        String customer_phone = object.getString("customer_phone");
                        //list.add(new Jobs(job_id, data, customer, estm_price, assets, member_array.toString()));

                        list.add(new FellowupUser(customer_ref_umber,job_ref_num,customer_full_name,customer_email,job_details,customer_phone));
                    }
                    setAdapter(list);
                }
            } else {
                Utility.toastView(ctx, msg);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initXml() {
        ctx = this;
        back_iv = findViewById(R.id.iv_joblist_back);
        recyclerView = findViewById(R.id.rv_fellowuplist_recyclerview);

        back_iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
