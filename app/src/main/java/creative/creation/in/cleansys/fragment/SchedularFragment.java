package creative.creation.in.cleansys.fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.DateListAdapter;
import creative.creation.in.cleansys.interfaces.FragmentChangeListener;
import creative.creation.in.cleansys.modal.api_modal.Sedular_Responce1.Event;
import creative.creation.in.cleansys.modal.api_modal.Sedular_Responce1.SedularModel1;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseFragment;
import creative.creation.in.cleansys.utils.ConnectionDetector;
import retrofit2.Response;

public class SchedularFragment extends BaseFragment implements FragmentChangeListener, View.OnClickListener {

    private View rootView;
    private CalendarView simpleCalendarView;
    private RecyclerView date_list;
    private String currentDate = "";
    private DateListAdapter adapter;
    private ArrayList<Event> arrayList = new ArrayList<>();
    private TextView tvEmptiry;
    String str;
    private SedularModel1 loginModal;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_scheduler, container, false);
        mContext = getActivity();
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        cd = new ConnectionDetector(mContext);
        initXml();
        schedularApi();

        return rootView;
    }

    private void initXml() {
        date_list = (RecyclerView) rootView.findViewById(R.id.date_list);
        tvEmptiry = (TextView) rootView.findViewById(R.id.tvEmptiry);
        simpleCalendarView = (CalendarView) rootView.findViewById(R.id.simpleCalendarView);
        simpleCalendarView.setFocusedMonthDateColor(Color.RED); // set the red color for the dates of  focused month
        simpleCalendarView.setUnfocusedMonthDateColor(Color.BLUE); // set the yellow color for the dates of an unfocused month
        simpleCalendarView.setSelectedWeekBackgroundColor(Color.RED); // red color for the selected week's background
        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN); // green color for the week separator line
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                int month1 = month + 1;
                currentDate = year + "-" + month1 + "-" + dayOfMonth;
                //Toast.makeText(mContext, dayOfMonth + "-" + month1 + "-" + year, Toast.LENGTH_LONG).show();
                parseDateToddMMyyyy(currentDate);
                selectData();
            }
        });

        adapter = new DateListAdapter(mContext, arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        date_list.setLayoutManager(mLayoutManager);
        date_list.setItemAnimator(new DefaultItemAnimator());
        date_list.setAdapter(adapter);
    }


    public String parseDateToddMMyyyy(String time) {
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "yyyy-MM-dd";
        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outputFormat = new SimpleDateFormat(outputPattern);

        Date date = null;
        str = null;

        try {
            date = inputFormat.parse(time);
            str = outputFormat.format(date);
            //schedularApi();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return str;
    }

    private void schedularApi() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.getSchedular(new Dialog(mContext), retrofitApiClient.getSchedular(), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    loginModal = (SedularModel1) result.body();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                       // Alerts.show(mContext, loginModal.getMessage());
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

    private void selectData(){
        arrayList.clear();
        for (int i = 0; i < loginModal.getEvents().size(); i++) {
            String currentString = loginModal.getEvents().get(i).getEnd();
            String[] separated = currentString.split("T");
            String date = separated[0].trim();
            Log.e("Data", "..." + date);
            if (date.equals(str)) {
                tvEmptiry.setVisibility(View.GONE);
                String s_date = loginModal.getEvents().get(i).getStart();
                String title = loginModal.getEvents().get(i).getTitle();
                String crew_job_id = loginModal.getEvents().get(i).getCrewJobId();
                String phone = String.valueOf(loginModal.getEvents().get(i).getPhone());
                String email = String.valueOf(loginModal.getEvents().get(i).getEmail());
                String location = String.valueOf(loginModal.getEvents().get(i).getLocation());
                String city = String.valueOf(loginModal.getEvents().get(i).getCity());
                String name = loginModal.getEvents().get(i).getName();
                String post_code = loginModal.getEvents().get(i).getPostCode();

                Event schedularModel = new Event();
                schedularModel.setName(name);
                schedularModel.setCrewJobId(crew_job_id);
                schedularModel.setStart(s_date);
                schedularModel.setTitle(title);
                schedularModel.setPostCode(post_code);
                schedularModel.setPhone(phone);
                schedularModel.setEmail(email);
                schedularModel.setLocation(location);
                schedularModel.setCity(city);
                schedularModel.setMemberName(loginModal.getEvents().get(i).getMemberName());
                arrayList.add(schedularModel);
            } else {
                tvEmptiry.setVisibility(View.VISIBLE);
                tvEmptiry.setText("No Data");
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onFragmentVisible(String fragmentTag) {

    }
}
