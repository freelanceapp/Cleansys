package creative.creation.in.cleansys.activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.PriceListAdapter;
import creative.creation.in.cleansys.modal.api_modal.price_responce.PriceModel;
import creative.creation.in.cleansys.model.PriceModel1;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.util.ConnectionDetector;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseActivity;
import retrofit2.Response;

public class PriceListActivity extends BaseActivity implements View.OnClickListener {

    Context ctx;
    ImageView back_iv;
    RecyclerView recyclerView;
    TextView tv_price3, tv_price2, tv_price1;
    ConnectionDetector connectionDetector;
    ArrayList<PriceModel1> list1 = new ArrayList<>();
    ArrayList<PriceModel1> list2 = new ArrayList<>();
    ArrayList<PriceModel1> list3 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_price_list);
        mContext = this;
        cd = new creative.creation.in.cleansys.utils.ConnectionDetector(mContext);
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        initXml();
       /* boolean internet = connectionDetector.isConnected();
        if (internet) {
            getJobs();
        } else {
            Utility.toastView(ctx, ctx.getString(R.string.no_internet));
        }*/

        priceList();


    }

    private void initXml() {
        ctx = this;
        back_iv = findViewById(R.id.iv_joblist_back);
        recyclerView = findViewById(R.id.rv_pricelist_recyclerview);
        tv_price3 = findViewById(R.id.tv_price3);
        tv_price2 = findViewById(R.id.tv_price2);
        tv_price1 = findViewById(R.id.tv_price1);
        back_iv.setOnClickListener(this);
        tv_price1.setOnClickListener(this);
        tv_price2.setOnClickListener(this);
        tv_price3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_joblist_back:
                finish();
                break;

            case R.id.tv_price1:
                tv_price1.setTextColor(Color.BLACK);
                tv_price2.setTextColor(Color.WHITE);
                tv_price3.setTextColor(Color.WHITE);

                PriceListAdapter adapter = new PriceListAdapter(ctx, list1);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter);
                break;

            case R.id.tv_price2:
                tv_price1.setTextColor(Color.WHITE);
                tv_price2.setTextColor(Color.BLACK);
                tv_price3.setTextColor(Color.WHITE);
                PriceListAdapter adapter2 = new PriceListAdapter(ctx, list2);
                RecyclerView.LayoutManager mLayoutManager2 = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager2);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(adapter2);
                break;

            case R.id.tv_price3:
                tv_price1.setTextColor(Color.WHITE);
                tv_price2.setTextColor(Color.WHITE);
                tv_price3.setTextColor(Color.BLACK);
                PriceListAdapter adapter3 = new PriceListAdapter(ctx, list3);
                RecyclerView.LayoutManager mLayoutManager3 = new LinearLayoutManager(getApplicationContext());
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

                        PriceListAdapter adapter = new PriceListAdapter(ctx, list1);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(adapter);

                        //clear();
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
}
