package creative.creation.in.cleansys.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.FellowUpListAdapter;
import creative.creation.in.cleansys.interfaces.FragmentChangeListener;
import creative.creation.in.cleansys.modal.api_modal.FellowUp_responce.FellowUpModel;
import creative.creation.in.cleansys.modal.api_modal.FellowUp_responce.FellowupUser;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseFragment;
import creative.creation.in.cleansys.utils.ConnectionDetector;
import retrofit2.Response;

public class FollowUpFragment extends BaseFragment implements FragmentChangeListener, View.OnClickListener {

    private View rootView;
    private RecyclerView recyclerView;
    private List<FellowupUser> followupUserList = new ArrayList<>();
    private FellowUpListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_follow_list, container, false);
        mContext = getActivity();
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        cd = new ConnectionDetector(mContext);
        initXml();
        return rootView;
    }

    private void initXml() {
        ((CardView) rootView.findViewById(R.id.cardRefresh)).setOnClickListener(this);
        recyclerView = rootView.findViewById(R.id.rv_fellowuplist_recyclerview);
        if (cd.isNetworkAvailable()) {
            getJobs();
        } else {
            cd.show(mContext);
        }
        setAdapter();
    }

    private void setAdapter() {
        adapter = new FellowUpListAdapter(mContext, followupUserList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void getJobs() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.getFollowUp(new Dialog(mContext), retrofitApiClient.followUpList(), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    FellowUpModel fellowUpModel = (FellowUpModel) result.body();
                    followupUserList.clear();
                    if (fellowUpModel == null)
                        return;
                    if (fellowUpModel.getUser().size() > 0) {
                        followupUserList.addAll(fellowUpModel.getUser());
                    } else {
                        Alerts.show(mContext, "Data not available");
                    }
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onResponseFailed(String error) {
                    Alerts.show(mContext, error);
                }
            });
        } else {
            cd.show(mContext);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardRefresh:
                if (cd.isNetworkAvailable()) {
                    followupUserList.clear();
                    adapter.notifyDataSetChanged();
                    getJobs();
                } else {
                    cd.show(mContext);
                }
                break;
        }
    }

    @Override
    public void onFragmentVisible(String fragmentTag) {

    }
}
