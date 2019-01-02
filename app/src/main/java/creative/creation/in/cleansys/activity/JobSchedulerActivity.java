package creative.creation.in.cleansys.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.riontech.calendar.CustomCalendar;
import com.riontech.calendar.dao.EventData;
import com.riontech.calendar.dao.dataAboutDate;

import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.modal.api_modal.schedular_response.SchedularModel;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseActivity;
import creative.creation.in.cleansys.utils.ConnectionDetector;
import retrofit2.Response;

public class JobSchedulerActivity extends BaseActivity implements View.OnClickListener {

    Context ctx;
    ImageView back_iv;
    private CustomCalendar customCalendar;
    ArrayList<EventData> eventData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_scheduler);
        mContext = this;
        cd = new ConnectionDetector(mContext);
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        initXml();
    }

    private void initXml() {

    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
