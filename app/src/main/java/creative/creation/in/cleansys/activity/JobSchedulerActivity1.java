package creative.creation.in.cleansys.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.tibolte.agendacalendarview.AgendaCalendarView;
import com.github.tibolte.agendacalendarview.CalendarManager;
import com.github.tibolte.agendacalendarview.CalendarPickerController;
import com.github.tibolte.agendacalendarview.models.BaseCalendarEvent;
import com.github.tibolte.agendacalendarview.models.CalendarEvent;
import com.github.tibolte.agendacalendarview.models.DayItem;
import com.github.tibolte.agendacalendarview.models.WeekItem;

import com.riontech.calendar.CustomCalendar;
import com.riontech.calendar.dao.EventData;
import com.riontech.calendar.dao.dataAboutDate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import creative.creation.in.cleansys.DrawableCalendarEvent;
import creative.creation.in.cleansys.DrawableEventRenderer;
import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.DateListAdapter;
import creative.creation.in.cleansys.adapter.PriceListAdapter;
import creative.creation.in.cleansys.modal.DateEvent;
import creative.creation.in.cleansys.modal.api_modal.Sedular_Responce1.Event;
import creative.creation.in.cleansys.modal.api_modal.Sedular_Responce1.SedularModel1;
import creative.creation.in.cleansys.modal.api_modal.schedular_response.SchedularModel;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseActivity;
import creative.creation.in.cleansys.utils.ConnectionDetector;
import retrofit2.Response;

public class JobSchedulerActivity1 extends BaseActivity implements View.OnClickListener {

    Context ctx;
    CalendarView simpleCalendarView;
    RecyclerView date_list;
    String currentDate = "";
    DateListAdapter adapter;
    ArrayList<Event> arrayList = new ArrayList<>();
    TextView tvEmptiry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_scheduler1);
        mContext = this;

        if (getIntent() == null)
            return;
        String strType = getIntent().getStringExtra("type");
        if (strType.equalsIgnoreCase("login")) {
            ((ImageView) findViewById(R.id.iv_scheduler_back)).setVisibility(View.GONE);
            ((ImageView) findViewById(R.id.imgMenu)).setVisibility(View.VISIBLE);
        } else {
            ((ImageView) findViewById(R.id.iv_scheduler_back)).setVisibility(View.VISIBLE);
            ((ImageView) findViewById(R.id.imgMenu)).setVisibility(View.GONE);
        }

        ((ImageView) findViewById(R.id.iv_scheduler_back)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((ImageView) findViewById(R.id.imgMenu)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, MainActivity.class));
                finish();
            }
        });

        cd = new ConnectionDetector(mContext);
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        date_list = (RecyclerView) findViewById(R.id.date_list);
        tvEmptiry = (TextView) findViewById(R.id.tvEmptiry);
        simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView); // get the reference of CalendarView
        simpleCalendarView.setFocusedMonthDateColor(Color.RED); // set the red color for the dates of  focused month
        simpleCalendarView.setUnfocusedMonthDateColor(Color.BLUE); // set the yellow color for the dates of an unfocused month
        simpleCalendarView.setSelectedWeekBackgroundColor(Color.RED); // red color for the selected week's background
        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN); // green color for the week separator line
        // perform setOnDateChangeListener event on CalendarView
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                // display the selected date by using a toast

                int month1 = month + 1;
                currentDate = year + "-" + month1 + "-" + dayOfMonth;
                Toast.makeText(getApplicationContext(), dayOfMonth + "-" + month1 + "-" + year, Toast.LENGTH_LONG).show();

                schedularApi();
            }
        });

        adapter = new DateListAdapter(ctx, arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        date_list.setLayoutManager(mLayoutManager);
        date_list.setItemAnimator(new DefaultItemAnimator());
        date_list.setAdapter(adapter);
    }

    private void schedularApi() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.getSchedular(new Dialog(mContext), retrofitApiClient.getSchedular(), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    SedularModel1 loginModal = (SedularModel1) result.body();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                        Alerts.show(mContext, loginModal.getMessage());

                        arrayList.clear();

                        for (int i = 0; i < loginModal.getEvents().size(); i++) {
                            String currentString = loginModal.getEvents().get(i).getEnd();
                            String[] separated = currentString.split("T");
                            String date = separated[0].trim();

                            if (date.equals(currentDate)) {
                                tvEmptiry.setVisibility(View.GONE);
                                String s_date = loginModal.getEvents().get(i).getStart();
                                String title = loginModal.getEvents().get(i).getTitle();
                                String name = "";
                                if (loginModal.getEvents().get(i).getMemberName().size() > 0) {
                                    name = loginModal.getEvents().get(i).getMemberName().get(0).getTitle();
                                }
                                Event schedularModel = new Event();
                                schedularModel.setName(name);
                                schedularModel.setCrewJobId(date);
                                schedularModel.setTitle(title);
                                //schedularModel.getEvents().get(i).getMemberName().get(i).setTitle(name);

                                arrayList.add(schedularModel);
                            } else {
                                tvEmptiry.setVisibility(View.VISIBLE);
                                tvEmptiry.setText("No Data");
                            }

                            adapter.notifyDataSetChanged();
                        }
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
    public void onClick(View view) {
        finish();
    }
}
