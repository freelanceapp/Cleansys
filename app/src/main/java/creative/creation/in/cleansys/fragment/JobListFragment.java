package creative.creation.in.cleansys.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.JobListAdapter;
import creative.creation.in.cleansys.interfaces.FragmentChangeListener;
import creative.creation.in.cleansys.modal.api_modal.search_responce.JobList;
import creative.creation.in.cleansys.modal.api_modal.search_responce.SearchModel;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.util.Utility;
import creative.creation.in.cleansys.util.WebApi;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseFragment;
import creative.creation.in.cleansys.utils.ConnectionDetector;
import retrofit2.Response;

public class JobListFragment extends BaseFragment implements FragmentChangeListener, View.OnClickListener {

    private View rootView;
    private RecyclerView recyclerView;
    private ArrayList<JobList> list = new ArrayList<>();
    private JobListAdapter adapter;
    private EditText searchName, searchFromDate, searchToDate;
    private Button searchButtom;
    DatePickerDialog datePickerDialog;
    final Calendar c = Calendar.getInstance();
    private int mYear = c.get(Calendar.YEAR); // current year
    private int mMonth = c.get(Calendar.MONTH); // current month
    private int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

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
        ((Button) rootView.findViewById(R.id.refreshButton)).setOnClickListener(this);
        searchName = rootView.findViewById(R.id.search_name);
        searchFromDate = rootView.findViewById(R.id.searchFromDate);
        searchToDate = rootView.findViewById(R.id.searchToDate);
        searchButtom = rootView.findViewById(R.id.searchButton);
        searchButtom.setOnClickListener(this);
        recyclerView = rootView.findViewById(R.id.rv_joblist_recyclerview);

        if (cd.isNetworkAvailable()) {
            // getJobs();
        } else {
            cd.show(mContext);
        }
        JoblistList();
        searchFromDate.setOnClickListener(this);
        searchToDate.setOnClickListener(this);
        adapter = new JobListAdapter(mContext, list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
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
                list.clear();
                JSONArray array = response.getJSONArray("job_list");
                if (array.length() > 0) {
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        String job_id = object.getString("job_id");
                        String data = object.getString("jld_data");
                        String customer = object.getString("customer");
                        String estm_price = object.getString("est_price");
                        String assets = object.getString("assets");
                        String customer_reference_number = object.getString("customer_reference_number");
                        String payment_status = object.getString("payment_status");
                        String attachments = object.getString("attachments");
                        JSONArray member_array = object.getJSONArray("crew_member");
                        list.add(new JobList(job_id, data, member_array, customer, customer_reference_number, payment_status, estm_price, attachments, assets));
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
        switch (view.getId()) {
            case R.id.searchFromDate:
                datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        searchFromDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;

            case R.id.searchToDate:
                datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        searchToDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;

            case R.id.searchButton:
                searchList();
                break;
            case R.id.refreshButton:
                JoblistList();
                break;
        }
    }

    @Override
    public void onFragmentVisible(String fragmentTag) {

    }

    private void searchList() {
        String sName = searchName.getText().toString();
        String fromDate = searchFromDate.getText().toString();
        String toDate = searchToDate.getText().toString();
       /* if (sName.equals("")) {
            Alerts.show(mContext, "Please Enter Search Name");
        } else if (fromDate.equals("")) {
            Alerts.show(mContext, "Select From Date");
        } else if (toDate.equals("")) {
            Alerts.show(mContext, "Select To Date");
        } else {*/

        if (cd.isNetworkAvailable()) {
            RetrofitService.searchList(new Dialog(mContext), retrofitApiClient.searchApi(fromDate, sName, toDate), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    SearchModel loginModal = (SearchModel) result.body();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                        list.clear();
                        Alerts.show(mContext, loginModal.getMessage());
                        if (loginModal.getJobList() == null) {
                            Alerts.show(mContext, "List not Avilable");
                        } else {

                            for (int i = 0; i < loginModal.getJobList().size(); i++) {
                                String getAssets = loginModal.getJobList().get(i).getAssets();
                                String getAttachments = loginModal.getJobList().get(i).getAttachments();
                                String getCustomer = loginModal.getJobList().get(i).getCustomer();
                                String getCustomerReferenceNumber = loginModal.getJobList().get(i).getCustomerReferenceNumber();
                                String getEstPrice = loginModal.getJobList().get(i).getEstPrice();
                                String getJldData = loginModal.getJobList().get(i).getJldData();
                                String getJobId = loginModal.getJobList().get(i).getJobId();
                                String getPaymentStatus = loginModal.getJobList().get(i).getPaymentStatus();

                                JobList jobList = new JobList();
                                jobList.setAssets(getAssets);
                                jobList.setAttachments(getAttachments);
                                jobList.setCustomer(getCustomer);
                                jobList.setCustomerReferenceNumber(getCustomerReferenceNumber);
                                jobList.setEstPrice(getEstPrice);
                                jobList.setJldData(getJldData);
                                jobList.setJobId(getJobId);
                                jobList.setPaymentStatus(getPaymentStatus);

                                list.add(jobList);
                            }
                        }
                        adapter.notifyDataSetChanged();

                           /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, list2);
                            select_cust_0sp.setAdapter(adapter);*/
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
        // }
    }

    private void JoblistList() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.jobListApi(new Dialog(mContext), retrofitApiClient.jobListApi(), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    SearchModel loginModal = (SearchModel) result.body();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                        Alerts.show(mContext, loginModal.getMessage());

                        for (int i = 0; i < loginModal.getJobList().size(); i++) {
                            String getAssets = loginModal.getJobList().get(i).getAssets();
                            String getAttachments = loginModal.getJobList().get(i).getAttachments();
                            String getCustomer = loginModal.getJobList().get(i).getCustomer();
                            String getCustomerReferenceNumber = loginModal.getJobList().get(i).getCustomerReferenceNumber();
                            String getEstPrice = loginModal.getJobList().get(i).getEstPrice();
                            String getJldData = loginModal.getJobList().get(i).getJldData();
                            String getJobId = loginModal.getJobList().get(i).getJobId();
                            String getPaymentStatus = loginModal.getJobList().get(i).getPaymentStatus();

                            JobList jobList = new JobList();
                            jobList.setAssets(getAssets);
                            jobList.setAttachments(getAttachments);
                            jobList.setCustomer(getCustomer);
                            jobList.setCustomerReferenceNumber(getCustomerReferenceNumber);
                            jobList.setEstPrice(getEstPrice);
                            jobList.setJldData(getJldData);
                            jobList.setJobId(getJobId);
                            jobList.setPaymentStatus(getPaymentStatus);

                            list.add(jobList);
                        }
                        adapter.notifyDataSetChanged();

                           /* ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, list2);
                            select_cust_0sp.setAdapter(adapter);*/
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
