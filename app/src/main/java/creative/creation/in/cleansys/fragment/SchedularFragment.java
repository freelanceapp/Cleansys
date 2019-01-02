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
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.DateListAdapter;
import creative.creation.in.cleansys.interfaces.FragmentChangeListener;
import creative.creation.in.cleansys.modal.DateEvent;
import creative.creation.in.cleansys.modal.api_modal.schedular_response.SchedularModel;
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
    private ArrayList<DateEvent> arrayList = new ArrayList<>();
    private TextView tvEmptiry;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_scheduler, container, false);
        mContext = getActivity();
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        cd = new ConnectionDetector(mContext);
        initXml();
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
                Toast.makeText(mContext, dayOfMonth + "-" + month1 + "-" + year, Toast.LENGTH_LONG).show();
                schedularApi();
            }
        });

        adapter = new DateListAdapter(mContext, arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        date_list.setLayoutManager(mLayoutManager);
        date_list.setItemAnimator(new DefaultItemAnimator());
        date_list.setAdapter(adapter);
        schedularApi();
    }

    private void schedularApi() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.getSchedular(new Dialog(mContext), retrofitApiClient.getSchedular(), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    SchedularModel loginModal = (SchedularModel) result.body();
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
                                DateEvent schedularModel = new DateEvent();
                                schedularModel.setName(name);
                                schedularModel.setS_datel(date);
                                schedularModel.setTitle(title);
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

    }

    @Override
    public void onFragmentVisible(String fragmentTag) {

    }
}
