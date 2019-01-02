package creative.creation.in.cleansys.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import creative.creation.in.cleansys.interfaces.FragmentChangeListener;
import creative.creation.in.cleansys.modal.api_modal.FellowUp_responce.FellowupUser;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.util.Utility;
import creative.creation.in.cleansys.util.WebApi;
import creative.creation.in.cleansys.utils.BaseFragment;

public class FollowUpFragment extends BaseFragment implements FragmentChangeListener, View.OnClickListener {

    private View rootView;
    private RecyclerView recyclerView;
    private ArrayList<FellowupUser> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_follow_list, container, false);
        mContext = getActivity();
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        cd = new creative.creation.in.cleansys.utils.ConnectionDetector(mContext);
        initXml();
        return rootView;
    }

    private void initXml() {
        recyclerView = rootView.findViewById(R.id.rv_fellowuplist_recyclerview);
        if (cd.isNetworkAvailable()) {
            getJobs();
        } else {
            cd.show(mContext);
        }
    }

    private void setAdapter(ArrayList<FellowupUser> list) {
        FellowUpListAdapter adapter = new FellowUpListAdapter(mContext, list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void getJobs() {
        //Utility.showLoader(mContext);
        AndroidNetworking.get(WebApi.API_FELLOW_LIST)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
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
                        list.add(new FellowupUser(customer_ref_umber, job_ref_num, customer_full_name, customer_email, job_details, customer_phone));
                    }
                    setAdapter(list);
                }
            } else {
                Utility.toastView(mContext, msg);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFragmentVisible(String fragmentTag) {

    }
}
