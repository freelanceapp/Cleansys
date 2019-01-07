package creative.creation.in.cleansys.fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import creative.creation.in.cleansys.AppPreference;
import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.CreawListAttechAdapter;
import creative.creation.in.cleansys.adapter.CrewSpinnerAdapter;
import creative.creation.in.cleansys.adapter.CustomerListAdapter;
import creative.creation.in.cleansys.interfaces.FragmentChangeListener;
import creative.creation.in.cleansys.modal.Model;
import creative.creation.in.cleansys.modal.api_modal.customer_responce.CutomerModel;
import creative.creation.in.cleansys.modal.api_modal.customerlist_responce.CustomerUser;
import creative.creation.in.cleansys.modal.api_modal.customerlist_responce.CutomerModel1;
import creative.creation.in.cleansys.modal.crew_modal.CrewMainModal;
import creative.creation.in.cleansys.modal.crew_modal.CrewUserList;
import creative.creation.in.cleansys.modal.customer_info.CustomerInfoMainModal;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseFragment;
import creative.creation.in.cleansys.utils.ConnectionDetector;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class JobSummaryFragment extends BaseFragment implements FragmentChangeListener, View.OnClickListener {

    private String strDate = "", strTime = "";

    private View rootView;
    String refreshedToken;
    String user_id = "0";

    final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR); // current year
    int mMonth = c.get(Calendar.MONTH); // current month
    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
    int hour1 = c.get(Calendar.HOUR_OF_DAY);
    int minute1 = c.get(Calendar.MINUTE);
    TimePickerDialog mTimePicker;
    DatePickerDialog datePickerDialog;
    ArrayList<String> list2 = new ArrayList<>();

    String[] condition = {" ", "Yes", "No"};
    String[] sourceAdvertising = {"", "DL Flyer", "Repeat", "Web", "CL Flyer", "G5 Layer"};
    String[] propertyType = {"", "Bungalow", "Detached", "Terraced", "Mid-terraced", "Flat"};
    String[] noOfStoryes = {"", "Single", "2", "3", "Multi"};
    String[] quotedBy = {"", "Karen Goulding", "Robert Muldoon", "Scott Colville", "Robert Muldoon", "Jack Pegrum"};
    String[] cancellationReason = {"", "Too Expensive", "Not a Gutter problem", "Already had worked done", "Robert MuldoonCustomer declined no reason given"};
    String[] bookedJobTech = {"", "Josh", "Noman", "Sam", "Lyndon", "Rafal"};
    String[] partsStatus = {"", "None required", "Parts required", "Deposit required", "Parts ordered", "Parts recieved", "Parts boxed"};
    String[] partsBrand = {"", "Osma", "Terrain", "Floplast", "Polypipe", "Cast iron", "Hunter"};
    String[] partsProfile = {"", "Square", "Ogee", "Deepflow", "Half Round", "Other"};
    String[] partsColor = {"", "Black", "White", "Brown ", "Grey"};
    String[] jdCancledReason = {"", "Frozen Gutter", "2nd Man required", "3 Tier Required ", "Technician no longer available", "Work already completed by diffrent company", "TGCP Preference"};
    String[] paymentStatus = {"", "Fully paid", "Part paid", "Panding", "Disputed", "Written off"};
    String[] paymentMethod = {"", "Cash", "Cheque", "Card", "BACS"};
    String[] invoiceStatus = {"", "To post", "To email", "Posted in mail", "Recieved invoice"};
    String[] callBackReason = {"", "Complaint", "Overflowing", "More work required", "Repair required", "Area missed off quote", "Others"};
    String[] feedbackFor = {"", "Mike Keeley", "Scott Colville", "Robert Muldoon", "Jack Pegrum"};
    String[] feedbackCategory = {"", "Praise", "Training required", "Further action"};
    String[] hourse = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};
    String[] minuts = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"};

    // for 0
    Spinner spCrewList, select_cust_0sp, select_contact_0sp, select_asset_0sp, spSourceAdv, spCommercialProperty, spPropertyType, spNoOfStoryes, spDormerWindowsPresent, spGutteringOnDormerWindows, spMandatoryMan, spLongTierLadderRequired, spShorTierLadderRequired, spDryWeatherRequired, spQuotedBy, spQuoteCopyAttached, spQuoteDiscussedCustomer, spSendQuoteCustomer, spQuoteCancelledFurther, spCancellationReason, spQuoteRescheduleRequired, spWasTheQuoteInstantlyConverted, spBookedJobTech,
            spPartsStatus, spPartMultipleBrands, spPartBrand, spPartProfile, spPartColour, spPartsJobDepositRequired, spJobSitePreInspectioCompleted, spJobHasSiteInspectionPassedRiskAssessmentToCompleteWork, spJobHaveAllEquipmentPassedPreUseInspection, spJobHasTheJobBeenCancelled, spJobCancelledReason, spJobDoWeNeedToReturnToTheSite, spJobHasSitePostInspectionBeenCompleted, spPaymentStatus, spPaymentCompletionPaymentReceived, spPaymentMethod, spInvoiceStatus, spCallBackReason, spFeedbackFor, spFeedbackCategory, spDetailHourse, spDetailMinuts;
    EditText et_0_jobdescr, jobdecrip_et, etOtherSourceAdv, etVisitedNotGivenReason, etNoteAnyDefectsTakeInformCustomer, etJobNoReason, etJobNoNoteActionRequired, etJobOtherDetails, etJobNoteanyissuesordamagesandensurepictureshavebeenuploaded, etPaymentDepositAmountReceived, etPaymentInvoiceNumber, etPaymentNonPaymentReason, etCardAuthCode, etCallBackJobdetails, etCallBackReasonOther, etCallBackReasonComplaint, etParentJob, etComments, pdUrgentHandoverNotes;
    TextView tvBookedJobDate, tvBookedJobTime, tvPaymentDateDepositReceived, tvPaymentDateCompletionPaymentReceived, tvFollowUpDate,
            tvDetailDateandTime;
    Button btnSave, btn_refresh;
    creative.creation.in.cleansys.util.ConnectionDetector connectionDetector;

    String crew_name, location, contact, asset, jobDetail, pr_source, pr_other_adv_source, pr_commercial_property, pr_type, pr_no_of_storages,
            pr_dormer_windows_present, pr_guttering_on_dormer_windows, pr_mandatory_man, pr_long_tier_ladder_required, pr_short_tier_ladder_required, pr_dry_weather_required, pr_urgent_handover_notes, pr_QuoteRescheduleRequired, qb_quated_by, qb_tech_writt_quot_cop_attached, qb_visited_not_given_reasn, qb_quote_discussd_with_customer,
            qb_need_to_send_quote_to_customer, qb_quated_canceled_no_action, qb_cancellation_reason, qb_resched_req, qb_instantl_converted,
            qb_bj_date, qb_bj_time, qb_bj_tech, prt_status, prt_multiple_brnd, prt_profile, prt_brnd, prt_colour, prt_job_deposit_req,
            jd_pre_site_inspect_compltd, jd_note_defect_pic_inform_customer, jd_site_inspect_passed_risk_assetmnt, jd_ifNo_inspect_passed_risk_assetmnt,
            jd_preInspect_equip_passed, jd_ifNo_inspect_pre_note, jd_job_cancelled, jd_cancled_reason, jd_other_details, jd_need_retrn_to_site,
            jd_post_site_inspect_compltd, jd_note_dameges_pics, pyd_date_depost_recived, pyd_depost_amount_recived, pyd_invoice_number, pyd_payment_status, pyd_completd_payment_recived,
            pyd_date_completd_payment_recived, pyd_non_payment_reson, pyd_payment_method, pyd_card_auth_code, pyd_invoice_status,
            cb_job_details, cb_callback_reason, cb_callback_reason_other, cb_callback_reason_complaint, cb_parent_job, cb_follow_up_date,
            fb_fdbck_for, fb_fdbck_comments, fb_fdbck_category, effrt, hour, minute;

    private CreawListAttechAdapter attechAdapter;
    private RecyclerView listView;
    private List<Model> ItemModelList = new ArrayList<>();
    private List<CrewUserList> crewUserLists = new ArrayList<>();
    private CrewSpinnerAdapter crewSpinnerAdapter;
    private String strCrewName = "";
    private String strCrewId = "";
    private Dialog dialogCustomer, dialogCustomerInfo;
    private CustomerListAdapter customerListAdapter;
    private List<CustomerUser> customerUserList = new ArrayList<>();
    private CutomerModel1 loginModal = new CutomerModel1();
    private String strFollowDate = "", strCustomerId = "", strCustomerName = "", strCustomerLocation = "",
            strCustomerCity = "", strCustomerStreet = "", strCustomerEmail = "", strCustomerPhone = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rootView = inflater.inflate(R.layout.fragment_jobsummary, container, false);
        mContext = getActivity();
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        cd = new ConnectionDetector(mContext);

        init();
        return rootView;
    }

    @Override
    public void onFragmentVisible(String fragmentTag) {
        //init();
    }

    private void init() {
        ((ImageView) rootView.findViewById(R.id.imgInfo)).setOnClickListener(this);
        ((TextView) rootView.findViewById(R.id.tvSelectCustomer)).setOnClickListener(this);
        refreshedToken = FirebaseInstanceId.getInstance().getToken();
        user_id = AppPreference.getStringPreference(mContext, "USER_ID");
        init0();
        apiToken();
        customerList();

        crewSpinnerAdapter = new CrewSpinnerAdapter(mContext, R.layout.spinner_layout, crewUserLists);
        spCrewList.setAdapter(crewSpinnerAdapter);

        listView = (RecyclerView) rootView.findViewById(R.id.listview);
        ((ImageView) rootView.findViewById(R.id.imgViewAdd)).setOnClickListener(this);
        attechAdapter = new CreawListAttechAdapter(mContext, ItemModelList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        listView.setLayoutManager(mLayoutManager);
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setAdapter(attechAdapter);

        spCrewList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                strCrewId = crewUserLists.get(i).getUserId();
                strCrewName = crewUserLists.get(i).getUserName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void customerInfoApi() {
        RetrofitService.getCustomerInfo(new Dialog(mContext), retrofitApiClient.getCustomerInfo(strCustomerId), new WebResponse() {
            @Override
            public void onResponseSuccess(Response<?> result) {
                CustomerInfoMainModal customerInfoMainModal = (CustomerInfoMainModal) result.body();
                if (customerInfoMainModal == null)
                    return;
                strCustomerEmail = customerInfoMainModal.getJobList().getEmail();
                strCustomerPhone = customerInfoMainModal.getJobList().getPhone();
                strCustomerName = customerInfoMainModal.getJobList().getName();
                strCustomerLocation = customerInfoMainModal.getJobList().getLocation();
                strCustomerCity = customerInfoMainModal.getJobList().getCity();
                strCustomerStreet = customerInfoMainModal.getJobList().getStreet();
            }

            @Override
            public void onResponseFailed(String error) {
                Alerts.show(mContext, error);
            }
        });
    }

    private void customerInfoDialog() {
        dialogCustomerInfo = new Dialog(mContext);
        dialogCustomerInfo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogCustomerInfo.setContentView(R.layout.dialog_customer_info);

        dialogCustomerInfo.setCanceledOnTouchOutside(true);
        dialogCustomerInfo.setCancelable(true);
        if (dialogCustomerInfo.getWindow() != null)
            dialogCustomerInfo.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        ((TextView) dialogCustomerInfo.findViewById(R.id.tvEmail)).setText(strCustomerEmail);
        ((TextView) dialogCustomerInfo.findViewById(R.id.tvPhone)).setText(strCustomerPhone);
        ((TextView) dialogCustomerInfo.findViewById(R.id.tvName)).setText(strCustomerName);
        ((TextView) dialogCustomerInfo.findViewById(R.id.tvLocation)).setText(strCustomerLocation);
        ((TextView) dialogCustomerInfo.findViewById(R.id.tvCity)).setText(strCustomerCity);
        ((TextView) dialogCustomerInfo.findViewById(R.id.tvStreet)).setText(strCustomerStreet);
        ((Button) dialogCustomerInfo.findViewById(R.id.btnClose)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCustomerInfo.dismiss();
            }
        });

        Window window = dialogCustomerInfo.getWindow();
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        dialogCustomerInfo.show();
    }

    private void reviewDialog() {
        dialogCustomer = new Dialog(mContext);
        dialogCustomer.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogCustomer.setContentView(R.layout.dialog_customer_list);

        dialogCustomer.setCanceledOnTouchOutside(true);
        dialogCustomer.setCancelable(true);
        if (dialogCustomer.getWindow() != null)
            dialogCustomer.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        customerUserList.clear();
        customerUserList.addAll(loginModal.getUser());

        customerListAdapter = new CustomerListAdapter(mContext, R.layout.row_customer_list, customerUserList);
        ListView listViewCustomer = (ListView) dialogCustomer.findViewById(R.id.listViewCustomer);
        listViewCustomer.setAdapter(customerListAdapter);
        customerListAdapter.notifyDataSetChanged();

        listViewCustomer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                location = customerUserList.get(position).getNamePostcode();
                strCustomerId = customerUserList.get(position).getId();
                ((ImageView) rootView.findViewById(R.id.imgInfo)).setVisibility(View.VISIBLE);
                ((TextView) rootView.findViewById(R.id.tvSelectCustomer)).setText(location);
                customerInfoApi();
                dialogCustomer.dismiss();
            }
        });

        ((EditText) dialogCustomer.findViewById(R.id.edtSearchCustomer))
                .addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence cs, int start, int before, int count) {
                        customerListAdapter.getFilter().filter(cs);
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });

        Window window = dialogCustomer.getWindow();
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        dialogCustomer.show();
    }

    private void validation() {
        jobDetail = et_0_jobdescr.getText().toString();
        pr_source = spSourceAdv.getSelectedItem().toString();
        pr_other_adv_source = etOtherSourceAdv.getText().toString();
        pr_commercial_property = spCommercialProperty.getSelectedItem().toString();
        pr_type = spPropertyType.getSelectedItem().toString();
        pr_no_of_storages = spNoOfStoryes.getSelectedItem().toString();
        pr_dormer_windows_present = spDormerWindowsPresent.getSelectedItem().toString();
        pr_guttering_on_dormer_windows = spGutteringOnDormerWindows.getSelectedItem().toString();
        pr_mandatory_man = spMandatoryMan.getSelectedItem().toString();
        pr_long_tier_ladder_required = spLongTierLadderRequired.getSelectedItem().toString();
        pr_short_tier_ladder_required = spShorTierLadderRequired.getSelectedItem().toString();
        pr_dry_weather_required = spDryWeatherRequired.getSelectedItem().toString();
        pr_urgent_handover_notes = pdUrgentHandoverNotes.getText().toString();
        qb_quated_by = spQuotedBy.getSelectedItem().toString();
        qb_tech_writt_quot_cop_attached = spQuoteCopyAttached.getSelectedItem().toString();
        qb_visited_not_given_reasn = etVisitedNotGivenReason.getText().toString();
        qb_quote_discussd_with_customer = spQuoteDiscussedCustomer.getSelectedItem().toString();
        qb_need_to_send_quote_to_customer = spSendQuoteCustomer.getSelectedItem().toString();
        qb_quated_canceled_no_action = spQuoteCancelledFurther.getSelectedItem().toString();
        qb_cancellation_reason = spCancellationReason.getSelectedItem().toString();
        qb_resched_req = spQuoteRescheduleRequired.getSelectedItem().toString();
        qb_instantl_converted = spWasTheQuoteInstantlyConverted.getSelectedItem().toString();
        qb_bj_date = tvBookedJobDate.getText().toString();
        qb_bj_time = tvBookedJobTime.getText().toString();
        qb_bj_tech = spBookedJobTech.getSelectedItem().toString();
        prt_status = spPartsStatus.getSelectedItem().toString();
        prt_multiple_brnd = spPartMultipleBrands.getSelectedItem().toString();
        prt_brnd = spPartBrand.getSelectedItem().toString();
        prt_profile = spPartProfile.getSelectedItem().toString();
        prt_colour = spPartColour.getSelectedItem().toString();
        prt_job_deposit_req = spPartsJobDepositRequired.getSelectedItem().toString();
        jd_pre_site_inspect_compltd = spJobSitePreInspectioCompleted.getSelectedItem().toString();
        jd_note_defect_pic_inform_customer = etNoteAnyDefectsTakeInformCustomer.getText().toString();
        jd_site_inspect_passed_risk_assetmnt = spJobHasSiteInspectionPassedRiskAssessmentToCompleteWork.getSelectedItem().toString();
        jd_ifNo_inspect_passed_risk_assetmnt = etJobNoReason.getText().toString();
        jd_preInspect_equip_passed = spJobHaveAllEquipmentPassedPreUseInspection.getSelectedItem().toString();
        jd_ifNo_inspect_pre_note = spJobCancelledReason.getSelectedItem().toString();
        jd_job_cancelled = spJobCancelledReason.getSelectedItem().toString();
        jd_cancled_reason = spCancellationReason.getSelectedItem().toString();
        jd_other_details = etJobOtherDetails.getText().toString();
        jd_need_retrn_to_site = spJobDoWeNeedToReturnToTheSite.getSelectedItem().toString();
        jd_post_site_inspect_compltd = spJobHasSitePostInspectionBeenCompleted.getSelectedItem().toString();
        jd_note_dameges_pics = etJobNoteanyissuesordamagesandensurepictureshavebeenuploaded.getText().toString();
        pyd_depost_amount_recived = etPaymentDepositAmountReceived.getText().toString();
        pyd_date_depost_recived = tvPaymentDateDepositReceived.getText().toString();
        pyd_invoice_number = etPaymentInvoiceNumber.getText().toString();
        pyd_payment_status = spPaymentStatus.getSelectedItem().toString();
        pyd_completd_payment_recived = spPaymentCompletionPaymentReceived.getSelectedItem().toString();
        pyd_date_completd_payment_recived = tvPaymentDateCompletionPaymentReceived.getText().toString();
        pyd_non_payment_reson = etPaymentNonPaymentReason.getText().toString();
        pyd_payment_method = spPaymentMethod.getSelectedItem().toString();
        pyd_card_auth_code = etCardAuthCode.getText().toString();
        pyd_invoice_status = spInvoiceStatus.getSelectedItem().toString();
        cb_callback_reason = spCallBackReason.getSelectedItem().toString();
        cb_callback_reason_complaint = etCallBackReasonComplaint.getText().toString();
        cb_callback_reason_other = etCallBackReasonOther.getText().toString();
        cb_parent_job = etParentJob.getText().toString();
        cb_follow_up_date = tvFollowUpDate.getText().toString();
        cb_job_details = etCallBackJobdetails.getText().toString();
        fb_fdbck_category = spFeedbackCategory.getSelectedItem().toString();
        fb_fdbck_for = spFeedbackFor.getSelectedItem().toString();
        fb_fdbck_comments = etComments.getText().toString();
        effrt = tvDetailDateandTime.getText().toString();
        hour = spDetailHourse.getSelectedItem().toString();
        minute = spDetailMinuts.getSelectedItem().toString();

        if (pr_commercial_property.equals("Yes")) {
            pr_commercial_property = "1";
        } else {
            pr_commercial_property = "0";
        }
        if (pr_dormer_windows_present.equals("Yes")) {
            pr_dormer_windows_present = "1";
        } else {
            pr_dormer_windows_present = "0";
        }
        if (pr_guttering_on_dormer_windows.equals("Yes")) {
            pr_guttering_on_dormer_windows = "1";
        } else {
            pr_guttering_on_dormer_windows = "0";
        }
        if (pr_mandatory_man.equals("Yes")) {
            pr_mandatory_man = "1";
        } else {
            pr_mandatory_man = "0";
        }
        if (pr_long_tier_ladder_required.equals("Yes")) {
            pr_long_tier_ladder_required = "1";
        } else {
            pr_long_tier_ladder_required = "0";
        }
        if (pr_short_tier_ladder_required.equals("Yes")) {
            pr_short_tier_ladder_required = "1";
        } else {
            pr_short_tier_ladder_required = "0";
        }
        if (pr_dry_weather_required.equals("Yes")) {
            pr_dry_weather_required = "1";
        } else {
            pr_dry_weather_required = "0";
        }
        if (qb_tech_writt_quot_cop_attached.equals("Yes")) {
            qb_tech_writt_quot_cop_attached = "1";
        } else {
            qb_tech_writt_quot_cop_attached = "0";
        }
        if (qb_need_to_send_quote_to_customer.equals("Yes")) {
            qb_need_to_send_quote_to_customer = "1";
        } else {
            qb_need_to_send_quote_to_customer = "0";
        }
        if (qb_quated_canceled_no_action.equals("Yes")) {
            qb_quated_canceled_no_action = "1";
        } else {
            qb_quated_canceled_no_action = "0";
        }
        if (qb_resched_req.equals("Yes")) {
            qb_resched_req = "1";
        } else {
            qb_resched_req = "0";
        }
        if (qb_instantl_converted.equals("Yes")) {
            qb_instantl_converted = "1";
        } else {
            qb_instantl_converted = "0";
        }
        //
        if (prt_multiple_brnd.equals("Yes")) {
            prt_multiple_brnd = "1";
        } else {
            prt_multiple_brnd = "0";
        }
        if (prt_job_deposit_req.equals("Yes")) {
            prt_job_deposit_req = "1";
        } else {
            prt_job_deposit_req = "0";
        }
        if (qb_quote_discussd_with_customer.equals("Yes")) {
            qb_quote_discussd_with_customer = "1";
        } else {
            qb_quote_discussd_with_customer = "0";
        }
        if (jd_pre_site_inspect_compltd.equals("Yes")) {
            jd_pre_site_inspect_compltd = "1";
        } else {
            jd_pre_site_inspect_compltd = "0";
        }
        if (jd_ifNo_inspect_passed_risk_assetmnt.equals("Yes")) {
            jd_ifNo_inspect_passed_risk_assetmnt = "1";
        } else {
            jd_ifNo_inspect_passed_risk_assetmnt = "0";
        }
        if (jd_preInspect_equip_passed.equals("Yes")) {
            jd_preInspect_equip_passed = "1";
        } else {
            jd_preInspect_equip_passed = "0";
        }
        if (jd_post_site_inspect_compltd.equals("Yes")) {
            jd_post_site_inspect_compltd = "1";
        } else {
            jd_post_site_inspect_compltd = "0";
        }
        if (jd_job_cancelled.equals("Yes")) {
            jd_job_cancelled = "1";
        } else {
            jd_job_cancelled = "0";
        }
        if (jd_need_retrn_to_site.equals("Yes")) {
            jd_need_retrn_to_site = "1";
        } else {
            jd_need_retrn_to_site = "0";
        }
        if (jd_site_inspect_passed_risk_assetmnt.equals("Yes")) {
            jd_site_inspect_passed_risk_assetmnt = "1";
        } else {
            jd_site_inspect_passed_risk_assetmnt = "0";
        }
        if (pyd_completd_payment_recived.equals("Yes")) {
            pyd_completd_payment_recived = "1";
        } else {
            pyd_completd_payment_recived = "0";
        }
        createForm();
    }

    private void getCrew(String strDateTime) {
        RetrofitService.getCrewUserList(new Dialog(mContext), retrofitApiClient.crewList(strDateTime), new WebResponse() {
            @Override
            public void onResponseSuccess(Response<?> result) {
                CrewMainModal crewMainModal = (CrewMainModal) result.body();
                crewUserLists.clear();
                if (crewMainModal == null)
                    return;
                if (crewMainModal.getUser().size() > 0) {
                    crewUserLists.addAll(crewMainModal.getUser());
                }
                crewSpinnerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onResponseFailed(String error) {
                Alerts.show(mContext, error);
            }
        });
    }

    private void init0() {
        btnSave = rootView.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        tvBookedJobDate = rootView.findViewById(R.id.tvBookedJobDate);
        tvBookedJobTime = rootView.findViewById(R.id.tvBookedJobTime);
        tvPaymentDateDepositReceived = rootView.findViewById(R.id.tvPaymentDateDepositReceived);
        tvPaymentDateCompletionPaymentReceived = rootView.findViewById(R.id.tvPaymentDateCompletionPaymentReceived);
        tvFollowUpDate = rootView.findViewById(R.id.tvFollowUpDate);
        tvDetailDateandTime = rootView.findViewById(R.id.tvDetailDateandTime);
        tvBookedJobDate.setOnClickListener(this);
        tvBookedJobTime.setOnClickListener(this);
        tvDetailDateandTime.setOnClickListener(this);
        tvPaymentDateCompletionPaymentReceived.setOnClickListener(this);
        tvPaymentDateDepositReceived.setOnClickListener(this);
        tvFollowUpDate.setOnClickListener(this);

        et_0_jobdescr = rootView.findViewById(R.id.et_0_jobdescr);
        pdUrgentHandoverNotes = rootView.findViewById(R.id.pdUrgentHandoverNotes);
        etOtherSourceAdv = rootView.findViewById(R.id.etOtherSourceAdv);
        etVisitedNotGivenReason = rootView.findViewById(R.id.etVisitedNotGivenReason);
        etNoteAnyDefectsTakeInformCustomer = rootView.findViewById(R.id.etNoteAnyDefectsTakeInformCustomer);
        etJobNoReason = rootView.findViewById(R.id.etJobNoReason);
        etJobNoNoteActionRequired = rootView.findViewById(R.id.etJobNoNoteActionRequired);
        etJobOtherDetails = rootView.findViewById(R.id.etJobOtherDetails);
        etJobNoteanyissuesordamagesandensurepictureshavebeenuploaded = rootView.findViewById(R.id.etJobNoteanyissuesordamagesandensurepictureshavebeenuploaded);
        etPaymentDepositAmountReceived = rootView.findViewById(R.id.etPaymentDepositAmountReceived);
        etPaymentInvoiceNumber = rootView.findViewById(R.id.etPaymentInvoiceNumber);
        etPaymentNonPaymentReason = rootView.findViewById(R.id.etPaymentNonPaymentReason);
        etCardAuthCode = rootView.findViewById(R.id.etCardAuthCode);
        etCallBackJobdetails = rootView.findViewById(R.id.etCallBackJobdetails);
        etCallBackReasonOther = rootView.findViewById(R.id.etCallBackReasonOther);
        etCallBackReasonComplaint = rootView.findViewById(R.id.etCallBackReasonComplaint);
        etParentJob = rootView.findViewById(R.id.etParentJob);
        etComments = rootView.findViewById(R.id.etComments);

        spCrewList = rootView.findViewById(R.id.spCrewList);
        select_cust_0sp = rootView.findViewById(R.id.sp_0_selectcustomer);
        spSourceAdv = rootView.findViewById(R.id.spSourceAdv);
        spCommercialProperty = rootView.findViewById(R.id.spCommercialProperty);
        spPropertyType = rootView.findViewById(R.id.spPropertyType);
        spNoOfStoryes = rootView.findViewById(R.id.spNoOfStoryes);
        spDormerWindowsPresent = rootView.findViewById(R.id.spDormerWindowsPresent);
        spGutteringOnDormerWindows = rootView.findViewById(R.id.spGutteringOnDormerWindows);
        spMandatoryMan = rootView.findViewById(R.id.spMandatoryMan);
        spLongTierLadderRequired = rootView.findViewById(R.id.spLongTierLadderRequired);
        spShorTierLadderRequired = rootView.findViewById(R.id.spShorTierLadderRequired);
        spDryWeatherRequired = rootView.findViewById(R.id.spDryWeatherRequired);
        spQuotedBy = rootView.findViewById(R.id.spQuotedBy);
        spQuoteCopyAttached = rootView.findViewById(R.id.spQuoteCopyAttached);
        spQuoteDiscussedCustomer = rootView.findViewById(R.id.spQuoteDiscussedCustomer);
        spSendQuoteCustomer = rootView.findViewById(R.id.spSendQuoteCustomer);
        spQuoteCancelledFurther = rootView.findViewById(R.id.spQuoteCancelledFurther);
        spCancellationReason = rootView.findViewById(R.id.spCancellationReason);
        spQuoteRescheduleRequired = rootView.findViewById(R.id.spQuoteRescheduleRequired);
        spWasTheQuoteInstantlyConverted = rootView.findViewById(R.id.spWasTheQuoteInstantlyConverted);
        spBookedJobTech = rootView.findViewById(R.id.spBookedJobTech);
        spPartsStatus = rootView.findViewById(R.id.spPartsStatus);
        spPartMultipleBrands = rootView.findViewById(R.id.spPartMultipleBrands);
        spPartBrand = rootView.findViewById(R.id.spPartBrand);
        spPartProfile = rootView.findViewById(R.id.spPartProfile);
        spPartColour = rootView.findViewById(R.id.spPartColour);
        spPartsJobDepositRequired = rootView.findViewById(R.id.spPartsJobDepositRequired);
        spJobSitePreInspectioCompleted = rootView.findViewById(R.id.spJobSitePreInspectioCompleted);
        spJobHasSiteInspectionPassedRiskAssessmentToCompleteWork = rootView.findViewById(R.id.spJobHasSiteInspectionPassedRiskAssessmentToCompleteWork);
        spJobHaveAllEquipmentPassedPreUseInspection = rootView.findViewById(R.id.spJobHaveAllEquipmentPassedPreUseInspection);
        spJobHasTheJobBeenCancelled = rootView.findViewById(R.id.spJobHasTheJobBeenCancelled);
        spJobCancelledReason = rootView.findViewById(R.id.spJobCancelledReason);
        spJobDoWeNeedToReturnToTheSite = rootView.findViewById(R.id.spJobDoWeNeedToReturnToTheSite);
        spJobHasSitePostInspectionBeenCompleted = rootView.findViewById(R.id.spJobHasSitePostInspectionBeenCompleted);
        spPaymentStatus = rootView.findViewById(R.id.spPaymentStatus);
        spPaymentCompletionPaymentReceived = rootView.findViewById(R.id.spPaymentCompletionPaymentReceived);
        spPaymentMethod = rootView.findViewById(R.id.spPaymentMethod);
        spInvoiceStatus = rootView.findViewById(R.id.spInvoiceStatus);
        spCallBackReason = rootView.findViewById(R.id.spCallBackReason);
        spFeedbackFor = rootView.findViewById(R.id.spFeedbackFor);
        spFeedbackCategory = rootView.findViewById(R.id.spFeedbackCategory);
        spDetailHourse = rootView.findViewById(R.id.spDetailsHourse);
        spDetailMinuts = rootView.findViewById(R.id.spDetailsMinuts);

        jobdecrip_et = rootView.findViewById(R.id.et_0_jobdescr);

        btn_refresh = rootView.findViewById(R.id.btn_refresh);
        btn_refresh.setOnClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, condition);
        spCommercialProperty.setAdapter(adapter);
        spDormerWindowsPresent.setAdapter(adapter);
        spGutteringOnDormerWindows.setAdapter(adapter);
        spMandatoryMan.setAdapter(adapter);
        spLongTierLadderRequired.setAdapter(adapter);
        spShorTierLadderRequired.setAdapter(adapter);
        spDryWeatherRequired.setAdapter(adapter);
        spQuoteCopyAttached.setAdapter(adapter);
        spQuoteDiscussedCustomer.setAdapter(adapter);
        spSendQuoteCustomer.setAdapter(adapter);
        spQuoteCancelledFurther.setAdapter(adapter);
        spQuoteRescheduleRequired.setAdapter(adapter);
        spWasTheQuoteInstantlyConverted.setAdapter(adapter);
        spPartMultipleBrands.setAdapter(adapter);
        spPartsJobDepositRequired.setAdapter(adapter);
        spJobSitePreInspectioCompleted.setAdapter(adapter);
        spJobHasSiteInspectionPassedRiskAssessmentToCompleteWork.setAdapter(adapter);
        spJobHaveAllEquipmentPassedPreUseInspection.setAdapter(adapter);
        spJobHasTheJobBeenCancelled.setAdapter(adapter);
        spJobDoWeNeedToReturnToTheSite.setAdapter(adapter);
        spJobHasSitePostInspectionBeenCompleted.setAdapter(adapter);
        spPaymentCompletionPaymentReceived.setAdapter(adapter);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, sourceAdvertising);
        spSourceAdv.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, propertyType);
        spPropertyType.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, noOfStoryes);
        spNoOfStoryes.setAdapter(adapter3);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, quotedBy);
        spQuotedBy.setAdapter(adapter4);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, cancellationReason);
        spCancellationReason.setAdapter(adapter5);

        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, bookedJobTech);
        spBookedJobTech.setAdapter(adapter6);

        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, partsStatus);
        spPartsStatus.setAdapter(adapter7);

        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, partsBrand);
        spPartBrand.setAdapter(adapter8);

        ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, partsProfile);
        spPartProfile.setAdapter(adapter9);

        ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, partsColor);
        spPartColour.setAdapter(adapter10);

        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, jdCancledReason);
        spJobCancelledReason.setAdapter(adapter11);

        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, paymentStatus);
        spPaymentStatus.setAdapter(adapter12);

        ArrayAdapter<String> adapter13 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, paymentMethod);
        spPaymentMethod.setAdapter(adapter13);

        ArrayAdapter<String> adapter14 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, invoiceStatus);
        spInvoiceStatus.setAdapter(adapter14);

        ArrayAdapter<String> adapter15 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, callBackReason);
        spCallBackReason.setAdapter(adapter15);

        ArrayAdapter<String> adapter16 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, feedbackFor);
        spFeedbackFor.setAdapter(adapter16);

        ArrayAdapter<String> adapter17 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, feedbackCategory);
        spFeedbackCategory.setAdapter(adapter17);

        ArrayAdapter<String> adapter18 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, hourse);
        spDetailHourse.setAdapter(adapter18);

        ArrayAdapter<String> adapter19 = new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, minuts);
        spDetailMinuts.setAdapter(adapter19);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSelectCustomer:
                if (loginModal != null) {
                    reviewDialog();
                }
                break;
            case R.id.imgInfo:
                customerInfoDialog();
                break;
            case R.id.imgViewAdd:
                addValue();
                break;
            case R.id.btnSave:
                validation();
                break;
            case R.id.btn_refresh:
                hour = spDetailHourse.getSelectedItem().toString();
                minute = spDetailMinuts.getSelectedItem().toString();
                if (strDate.isEmpty()) {
                    Alerts.show(mContext, "Please select date!!!");
                } else {
                    if (hour.isEmpty()) {
                        strTime = "";
                    } else {
                        strTime = hour + ":" + minute;
                    }
                    getCrew(strDate + " " + strTime);
                }
                break;
            case R.id.tvBookedJobDate:
                datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvBookedJobDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvBookedJobTime:
                mTimePicker = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        tvBookedJobTime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour1, minute1, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
                break;
            case R.id.tvDetailDateandTime:
                datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDetailDateandTime.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                        strDate = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvFollowUpDate:
                // date picker dialog
                datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        strFollowDate = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;

                        mTimePicker = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                                tvFollowUpDate.setText(strFollowDate + " " + selectedHour + ":" + selectedMinute);
                            }
                        }, hour1, minute1, true);//Yes 24 hour time
                        mTimePicker.setTitle("Select Time");
                        mTimePicker.show();
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvPaymentDateCompletionPaymentReceived:
                datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvPaymentDateCompletionPaymentReceived.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
            case R.id.tvPaymentDateDepositReceived:
                datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvPaymentDateDepositReceived.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;
        }
    }

    private void createForm() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            JSONArray array = new JSONArray();
            for (int i = 0; i < ItemModelList.size(); i++) {
                JSONObject internalObject = new JSONObject();
                internalObject.put("id", ItemModelList.get(i).getId());
                array.put(internalObject);
            }
            jsonObject.put("crew_data", array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String strCrewData = jsonObject + "";
        String strSplit[] = strCrewData.split("\\[");
        String strOne = strSplit[1];
        strOne = "[" + strOne;
        String strSplitTwo[] = strOne.split("\\]");
        String strData = strSplitTwo[0];
        strData = strData + "]";

        if (hour.isEmpty()) {
            hour = "0";
        }
        if (minute.isEmpty()) {
            minute = "0";
        }

        Log.e(jd_site_inspect_passed_risk_assetmnt + "..." + jd_preInspect_equip_passed, jd_job_cancelled + "..." + jd_need_retrn_to_site + "..." + jd_post_site_inspect_compltd);
        if (cd.isNetworkAvailable()) {
            RetrofitService.getFormData(new Dialog(mContext), retrofitApiClient.getFormFill(
                    location, jobDetail, pr_source, pr_other_adv_source, pr_type, pr_no_of_storages, pr_urgent_handover_notes, pr_commercial_property,
                    pr_dormer_windows_present, pr_guttering_on_dormer_windows, pr_mandatory_man, pr_long_tier_ladder_required, pr_short_tier_ladder_required,
                    pr_dry_weather_required, qb_quated_by, qb_visited_not_given_reasn, qb_cancellation_reason, qb_bj_date, qb_bj_time, qb_bj_tech,
                    qb_tech_writt_quot_cop_attached, qb_quote_discussd_with_customer, qb_need_to_send_quote_to_customer, qb_quated_canceled_no_action,
                    qb_resched_req, qb_instantl_converted, prt_status, prt_brnd, prt_profile, prt_colour, prt_multiple_brnd,
                    prt_job_deposit_req, jd_note_defect_pic_inform_customer, jd_ifNo_inspect_passed_risk_assetmnt,
                    jd_ifNo_inspect_pre_note, jd_cancled_reason, jd_other_details, jd_note_dameges_pics, jd_pre_site_inspect_compltd,
                    jd_site_inspect_passed_risk_assetmnt, jd_preInspect_equip_passed, jd_job_cancelled, jd_need_retrn_to_site, jd_post_site_inspect_compltd,
                    pyd_date_depost_recived, pyd_depost_amount_recived, pyd_invoice_number, pyd_payment_status,
                    pyd_date_completd_payment_recived, pyd_non_payment_reson, pyd_payment_method, pyd_card_auth_code, pyd_invoice_status,
                    pyd_completd_payment_recived, cb_job_details, cb_callback_reason, cb_callback_reason_other, cb_callback_reason_complaint,
                    cb_parent_job, cb_follow_up_date, fb_fdbck_for, fb_fdbck_comments, fb_fdbck_category, effrt, hour, minute, strData
            ), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    ResponseBody loginModal = (ResponseBody) result.body();
                    try {
                        JSONObject jsonObject = new JSONObject(loginModal.string());
                        Alerts.show(mContext, jsonObject.getString("message"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
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

    private void customerList() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.customerList(new Dialog(mContext), retrofitApiClient.customerList(
            ), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    loginModal = (CutomerModel1) result.body();
                    customerUserList.clear();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                        //Alerts.show(mContext, loginModal.getMessage());
                        customerUserList.addAll(loginModal.getUser());
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

    private void apiToken() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.getFormFill(new Dialog(mContext), retrofitApiClient.getToken(user_id, refreshedToken), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    CutomerModel loginModal = (CutomerModel) result.body();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                        //Alerts.show(mContext, loginModal.getMessage());
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

    public void addValue() {
        if (!strCrewName.isEmpty()) {
            Model md = new Model(strCrewName, strCrewId);
            ItemModelList.add(md);
            attechAdapter.notifyDataSetChanged();
        }
    }
}
