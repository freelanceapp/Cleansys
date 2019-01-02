package creative.creation.in.cleansys.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.PriceListAdapter;
import creative.creation.in.cleansys.interfaces.FragmentChangeListener;
import creative.creation.in.cleansys.modal.api_modal.price_responce.PriceModel;
import creative.creation.in.cleansys.model.PriceModel1;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseFragment;
import retrofit2.Response;

public class PriceListFragment extends BaseFragment implements FragmentChangeListener, View.OnClickListener {

    private View rootView;
    private RecyclerView recyclerView;
    private TextView tv_price3, tv_price2, tv_price1;
    private ArrayList<PriceModel1> list1 = new ArrayList<>();
    private ArrayList<PriceModel1> list2 = new ArrayList<>();
    private ArrayList<PriceModel1> list3 = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_price_list, container, false);
        mContext = getActivity();
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        cd = new creative.creation.in.cleansys.utils.ConnectionDetector(mContext);
        initXml();
        priceList();
        return rootView;
    }

    private void initXml() {
        recyclerView = rootView.findViewById(R.id.rv_pricelist_recyclerview);
        tv_price3 = rootView.findViewById(R.id.tv_price3);
        tv_price2 = rootView.findViewById(R.id.tv_price2);
        tv_price1 = rootView.findViewById(R.id.tv_price1);
        tv_price1.setOnClickListener(this);
        tv_price2.setOnClickListener(this);
        tv_price3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_price1:
                tv_price1.setTextColor(Color.BLACK);
                tv_price2.setTextColor(Color.WHITE);
                tv_price3.setTextColor(Color.WHITE);
                PriceListAdapter adapter = new PriceListAdapter(mContext, list1);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);
                break;
            case R.id.tv_price2:
                tv_price1.setTextColor(Color.WHITE);
                tv_price2.setTextColor(Color.BLACK);
                tv_price3.setTextColor(Color.WHITE);
                PriceListAdapter adapter2 = new PriceListAdapter(mContext, list2);
                RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(mContext);
                recyclerView.setLayoutManager(mLayoutManager2);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter2);
                break;
            case R.id.tv_price3:
                tv_price1.setTextColor(Color.WHITE);
                tv_price2.setTextColor(Color.WHITE);
                tv_price3.setTextColor(Color.BLACK);
                PriceListAdapter adapter3 = new PriceListAdapter(mContext, list3);
                RecyclerView.LayoutManager mLayoutManager3 = new LinearLayoutManager(mContext);
                recyclerView.setLayoutManager(mLayoutManager3);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter3);
                break;
        }
    }

    private void priceList() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.getPrice(new Dialog(mContext), retrofitApiClient.getPrice(), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    PriceModel loginModal = (PriceModel) result.body();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                        Alerts.show(mContext, loginModal.getMessage());

                        if (loginModal.get1ManBasicClearance().size() != 0) {
                            for (int i = 0; i < loginModal.get1ManBasicClearance().size(); i++) {
                                String time = loginModal.get1ManBasicClearance().get(i).getTime();
                                String amount = loginModal.get1ManBasicClearance().get(i).getAmount();
                                list1.add(new PriceModel1(time, amount));
                            }
                        }
                        if (loginModal.get1ManClearInspectClean().size() != 0) {
                            for (int i = 0; i < loginModal.get1ManClearInspectClean().size(); i++) {
                                String time = loginModal.get1ManClearInspectClean().get(i).getTime();
                                String amount = loginModal.get1ManClearInspectClean().get(i).getAmount();
                                list2.add(new PriceModel1(time, amount));
                            }
                        }
                        if (loginModal.get2Man().size() != 0) {
                            for (int i = 0; i < loginModal.get2Man().size(); i++) {
                                String time = loginModal.get2Man().get(i).getTime();
                                String amount = loginModal.get2Man().get(i).getAmount();
                                list3.add(new PriceModel1(time, amount));
                            }
                        }

                        PriceListAdapter adapter = new PriceListAdapter(mContext, list1);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(adapter);
                    } else {
                        Alerts.show(mContext, loginModal.getMessage());
                    }
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
    public void onFragmentVisible(String fragmentTag) {

    }
}
