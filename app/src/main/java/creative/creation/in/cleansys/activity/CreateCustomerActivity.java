package creative.creation.in.cleansys.activity;

import android.os.Bundle;
import android.view.View;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.utils.BaseActivity;

public class CreateCustomerActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_customer);
        mContext = this;
        cd = new creative.creation.in.cleansys.utils.ConnectionDetector(mContext);
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
    }

    @Override
    public void onClick(View view) {
    }
}
