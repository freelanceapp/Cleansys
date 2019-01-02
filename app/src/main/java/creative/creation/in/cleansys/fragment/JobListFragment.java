package creative.creation.in.cleansys.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import creative.creation.in.cleansys.adapter.JobListAdapter;
import creative.creation.in.cleansys.interfaces.FragmentChangeListener;
import creative.creation.in.cleansys.model.Jobs;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.util.Utility;
import creative.creation.in.cleansys.util.WebApi;
import creative.creation.in.cleansys.utils.BaseFragment;
import creative.creation.in.cleansys.utils.ConnectionDetector;

public class JobListFragment extends BaseFragment implements FragmentChangeListener, View.OnClickListener {

    private View rootView;
    private RecyclerView recyclerView;
    private ArrayList<Jobs> list = new ArrayList<>();
    private JobListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_job_list, container, false);
        mContext = getActivity();
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        cd = new ConnectionDetector(mContext);
        initXml();
        return rootView;
    }

    private void initXml() {
        recyclerView = rootView.findViewById(R.id.rv_joblist_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        adapter = new JobListAdapter(mContext, list);
        recyclerView.setAdapter(adapter);
        if (cd.isNetworkAvailable()) {
            getJobs();
        } else {
            cd.show(mContext);
        }
    }

    private void getJobs() {
        //Utility.showLoader(mContext);
        AndroidNetworking.get(WebApi.API_JOB_LIST)
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
        try {
            boolean error = response.getBoolean("error");
            String msg = response.getString("message");
            if (!error) {
                JSONArray array = response.getJSONArray("job_list");
                if (array.length() > 0) {
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        String job_id = object.getString("job_id");
                        String data = object.getString("jld_data");
                        String customer = object.getString("customer");
                        String estm_price = object.getString("est_price");
                        String assets = object.getString("assets");
                        JSONArray member_array = object.getJSONArray("crew_member");
                        list.add(new Jobs(job_id, data, customer, estm_price, assets, member_array.toString()));
                    }
                    adapter.notifyDataSetChanged();
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
