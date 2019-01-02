package creative.creation.in.cleansys.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.CreawListAttechAdapter;
import creative.creation.in.cleansys.adapter.CrewSpinnerAdapter;
import creative.creation.in.cleansys.modal.Model;
import creative.creation.in.cleansys.modal.api_modal.Customer_Detail.CustomerDetailModel1;
import creative.creation.in.cleansys.modal.api_modal.customer_responce.CutomerModel;
import creative.creation.in.cleansys.modal.api_modal.customerlist_responce.CutomerModel1;
import creative.creation.in.cleansys.modal.crew_modal.CrewMainModal;
import creative.creation.in.cleansys.modal.crew_modal.CrewUserList;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.util.ConnectionDetector;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseActivity;
import retrofit2.Response;

public class UpdateActivity extends BaseActivity implements View.OnClickListener {
    //String text = mySpinner.getSelectedItem().toString();

    ArrayList<String> list2 = new ArrayList<>();
    final Calendar c = Calendar.getInstance();
    int mYear = c.get(Calendar.YEAR); // current year
    int mMonth = c.get(Calendar.MONTH); // current month
    int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
    int hour1 = c.get(Calendar.HOUR_OF_DAY);
    int minute1 = c.get(Calendar.MINUTE);
    TimePickerDialog mTimePicker;
    DatePickerDialog datePickerDialog;
    Context ctx;
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
    String[] hourse = {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24"};
    String[] minuts = {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38",
            "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"};

    // for 0
    Spinner spCrewList, select_cust_0sp, spSourceAdv, spCommercialProperty, spPropertyType,
            spNoOfStoryes, spDormerWindowsPresent, spGutteringOnDormerWindows, spMandatoryMan, spLongTierLadderRequired,
            spShorTierLadderRequired, spDryWeatherRequired, spQuotedBy, spQuoteCopyAttached, spQuoteDiscussedCustomer,
            spSendQuoteCustomer, spQuoteCancelledFurther, spCancellationReason, spQuoteRescheduleRequired,
            spWasTheQuoteInstantlyConverted, spBookedJobTech, spPartsStatus, spPartMultipleBrands, spPartBrand, spPartProfile,
            spPartColour, spPartsJobDepositRequired,
            spJobSitePreInspectioCompleted, spJobHasSiteInspectionPassedRiskAssessmentToCompleteWork, spJobHaveAllEquipmentPassedPreUseInspection, spJobHasTheJobBeenCancelled, spJobCancelledReason, spJobDoWeNeedToReturnToTheSite, spJobHasSitePostInspectionBeenCompleted, spPaymentStatus, spPaymentCompletionPaymentReceived, spPaymentMethod, spInvoiceStatus, spCallBackReason, spFeedbackFor, spFeedbackCategory, spDetailHourse, spDetailMinuts;
    EditText et_0_jobdescr, jobdecrip_et, etOtherSourceAdv, etVisitedNotGivenReason, etNoteAnyDefectsTakeInformCustomer, etJobNoReason, etJobNoNoteActionRequired, etJobOtherDetails, etJobNoteanyissuesordamagesandensurepictureshavebeenuploaded, etPaymentDepositAmountReceived, etPaymentInvoiceNumber, etPaymentNonPaymentReason, etCardAuthCode, etCallBackJobdetails, etCallBackReasonOther, etCallBackReasonComplaint, etParentJob, etComments, pdUrgentHandoverNotes;
    TextView tvBookedJobDate, tvBookedJobTime, tvPaymentDateDepositReceived, tvPaymentDateCompletionPaymentReceived, tvFollowUpDate,
            tvDetailDateandTime;
    Button btnSave;
    ConnectionDetector connectionDetector;

    String CrewList, jobId, location, contact, asset, jobDetail, pr_source, pr_other_adv_source, pr_commercial_property, pr_type, pr_no_of_storages,
            pr_dormer_windows_present, pr_guttering_on_dormer_windows, pr_mandatory_man, pr_long_tier_ladder_required, pr_short_tier_ladder_required, pr_dry_weather_required, pr_urgent_handover_notes, pr_QuoteRescheduleRequired, qb_quated_by, qb_tech_writt_quot_cop_attached, qb_visited_not_given_reasn, qb_quote_discussd_with_customer,
            qb_need_to_send_quote_to_customer, qb_quated_canceled_no_action, qb_cancellation_reason, qb_resched_req, qb_instantl_converted,
            qb_bj_date, qb_bj_time, qb_bj_tech, prt_status, prt_multiple_brnd, prt_profile, prt_brnd, prt_colour, prt_job_deposit_req,
            jd_pre_site_inspect_compltd, jd_note_defect_pic_inform_customer, jd_site_inspect_passed_risk_assetmnt, jd_ifNo_inspect_passed_risk_assetmnt,
            jd_preInspect_equip_passed, jd_ifNo_inspect_pre_note, jd_job_cancelled, jd_cancled_reason, jd_other_details, jd_need_retrn_to_site,
            jd_post_site_inspect_compltd, jd_note_dameges_pics, pyd_date_depost_recived, pyd_depost_amount_recived, pyd_invoice_number, pyd_payment_status, pyd_completd_payment_recived,
            pyd_date_completd_payment_recived, pyd_non_payment_reson, pyd_payment_method, pyd_card_auth_code, pyd_invoice_status,
            cb_job_details, cb_callback_reason, cb_callback_reason_other, cb_callback_reason_complaint, cb_parent_job, cb_follow_up_date,
            fb_fdbck_for, fb_fdbck_comments, fb_fdbck_category, effrt, hour, minute;

    private String strDate = "", strTime = "";
    private CreawListAttechAdapter attechAdapter;
    private RecyclerView listView;
    private List<Model> ItemModelList = new ArrayList<>();
    private List<CrewUserList> crewUserLists = new ArrayList<>();
    private CrewSpinnerAdapter crewSpinnerAdapter;
    private String strCrewName = "";
    private String strCrewId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        mContext = this;
        cd = new creative.creation.in.cleansys.utils.ConnectionDetector(mContext);
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        jobId = getIntent().getStringExtra("job_id");
        ctx = this;
        customerList();
        //initXml();
        init0();
        ImageView iv_update_back = (ImageView) findViewById(R.id.iv_update_back);
        iv_update_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        crewSpinnerAdapter = new CrewSpinnerAdapter(mContext, R.layout.spinner_layout, crewUserLists);
        spCrewList.setAdapter(crewSpinnerAdapter);

        listView = (RecyclerView) findViewById(R.id.listview);
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

    private void validation() {
        CrewList = spCrewList.getSelectedItem().toString();
        location = select_cust_0sp.getSelectedItem().toString();
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

        Log.e("Payment" + pyd_completd_payment_recived + ".." + pyd_invoice_status + ".." + pyd_card_auth_code, pyd_date_completd_payment_recived + pyd_payment_method + pyd_invoice_number);

        if (location.equals("") || jobDetail.equals("") || pr_source.equals("") || pr_other_adv_source.equals("") || pr_type.equals("") || pr_commercial_property.equals("")
                || pr_no_of_storages.equals("") || pr_dormer_windows_present.equals("")) {
            Alerts.show(ctx, "Input");
        } else {

        }
        createForm();
    }

    private void init0() {
        (findViewById(R.id.btn_refresh)).setOnClickListener(this);
        ((ImageView) findViewById(R.id.imgViewAdd)).setOnClickListener(this);

        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        tvBookedJobDate = findViewById(R.id.tvBookedJobDate);
        tvBookedJobTime = findViewById(R.id.tvBookedJobTime);
        tvPaymentDateDepositReceived = findViewById(R.id.tvPaymentDateDepositReceived);
        tvPaymentDateCompletionPaymentReceived = findViewById(R.id.tvPaymentDateCompletionPaymentReceived);
        tvFollowUpDate = findViewById(R.id.tvFollowUpDate);
        tvDetailDateandTime = findViewById(R.id.tvDetailDateandTime);
        tvBookedJobDate.setOnClickListener(this);
        tvBookedJobTime.setOnClickListener(this);
        tvDetailDateandTime.setOnClickListener(this);
        tvPaymentDateCompletionPaymentReceived.setOnClickListener(this);
        tvPaymentDateDepositReceived.setOnClickListener(this);
        tvFollowUpDate.setOnClickListener(this);

        et_0_jobdescr = findViewById(R.id.et_0_jobdescr);
        pdUrgentHandoverNotes = findViewById(R.id.pdUrgentHandoverNotes);
        etOtherSourceAdv = findViewById(R.id.etOtherSourceAdv);
        etVisitedNotGivenReason = findViewById(R.id.etVisitedNotGivenReason);
        etNoteAnyDefectsTakeInformCustomer = findViewById(R.id.etNoteAnyDefectsTakeInformCustomer);
        etJobNoReason = findViewById(R.id.etJobNoReason);
        etJobNoNoteActionRequired = findViewById(R.id.etJobNoNoteActionRequired);
        etJobOtherDetails = findViewById(R.id.etJobOtherDetails);
        etJobNoteanyissuesordamagesandensurepictureshavebeenuploaded = findViewById(R.id.etJobNoteanyissuesordamagesandensurepictureshavebeenuploaded);
        etPaymentDepositAmountReceived = findViewById(R.id.etPaymentDepositAmountReceived);
        etPaymentInvoiceNumber = findViewById(R.id.etPaymentInvoiceNumber);
        etPaymentNonPaymentReason = findViewById(R.id.etPaymentNonPaymentReason);
        etCardAuthCode = findViewById(R.id.etCardAuthCode);
        etCallBackJobdetails = findViewById(R.id.etCallBackJobdetails);
        etCallBackReasonOther = findViewById(R.id.etCallBackReasonOther);
        etCallBackReasonComplaint = findViewById(R.id.etCallBackReasonComplaint);
        etParentJob = findViewById(R.id.etParentJob);
        etComments = findViewById(R.id.etComments);

        spCrewList = findViewById(R.id.spCrewList);
        select_cust_0sp = findViewById(R.id.sp_0_selectcustomer);
        spSourceAdv = findViewById(R.id.spSourceAdv);
        spCommercialProperty = findViewById(R.id.spCommercialProperty);
        spPropertyType = findViewById(R.id.spPropertyType);
        spNoOfStoryes = findViewById(R.id.spNoOfStoryes);
        spDormerWindowsPresent = findViewById(R.id.spDormerWindowsPresent);
        spGutteringOnDormerWindows = findViewById(R.id.spGutteringOnDormerWindows);
        spMandatoryMan = findViewById(R.id.spMandatoryMan);
        spLongTierLadderRequired = findViewById(R.id.spLongTierLadderRequired);
        spShorTierLadderRequired = findViewById(R.id.spShorTierLadderRequired);
        spDryWeatherRequired = findViewById(R.id.spDryWeatherRequired);
        spQuotedBy = findViewById(R.id.spQuotedBy);
        spQuoteCopyAttached = findViewById(R.id.spQuoteCopyAttached);
        spQuoteDiscussedCustomer = findViewById(R.id.spQuoteDiscussedCustomer);
        spSendQuoteCustomer = findViewById(R.id.spSendQuoteCustomer);
        spQuoteCancelledFurther = findViewById(R.id.spQuoteCancelledFurther);
        spCancellationReason = findViewById(R.id.spCancellationReason);
        spQuoteRescheduleRequired = findViewById(R.id.spQuoteRescheduleRequired);
        spWasTheQuoteInstantlyConverted = findViewById(R.id.spWasTheQuoteInstantlyConverted);
        spBookedJobTech = findViewById(R.id.spBookedJobTech);
        spPartsStatus = findViewById(R.id.spPartsStatus);
        spPartMultipleBrands = findViewById(R.id.spPartMultipleBrands);
        spPartBrand = findViewById(R.id.spPartBrand);
        spPartProfile = findViewById(R.id.spPartProfile);
        spPartColour = findViewById(R.id.spPartColour);
        spPartsJobDepositRequired = findViewById(R.id.spPartsJobDepositRequired);
        spJobSitePreInspectioCompleted = findViewById(R.id.spJobSitePreInspectioCompleted);
        spJobHasSiteInspectionPassedRiskAssessmentToCompleteWork = findViewById(R.id.spJobHasSiteInspectionPassedRiskAssessmentToCompleteWork);
        spJobHaveAllEquipmentPassedPreUseInspection = findViewById(R.id.spJobHaveAllEquipmentPassedPreUseInspection);
        spJobHasTheJobBeenCancelled = findViewById(R.id.spJobHasTheJobBeenCancelled);
        spJobCancelledReason = findViewById(R.id.spJobCancelledReason);
        spJobDoWeNeedToReturnToTheSite = findViewById(R.id.spJobDoWeNeedToReturnToTheSite);
        spJobHasSitePostInspectionBeenCompleted = findViewById(R.id.spJobHasSitePostInspectionBeenCompleted);
        spPaymentStatus = findViewById(R.id.spPaymentStatus);
        spPaymentCompletionPaymentReceived = findViewById(R.id.spPaymentCompletionPaymentReceived);
        spPaymentMethod = findViewById(R.id.spPaymentMethod);
        spInvoiceStatus = findViewById(R.id.spInvoiceStatus);
        spCallBackReason = findViewById(R.id.spCallBackReason);
        spFeedbackFor = findViewById(R.id.spFeedbackFor);
        spFeedbackCategory = findViewById(R.id.spFeedbackCategory);
        spDetailHourse = findViewById(R.id.spDetailsHourse);
        spDetailMinuts = findViewById(R.id.spDetailsMinuts);

        jobdecrip_et = findViewById(R.id.et_0_jobdescr);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, condition);
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

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, sourceAdvertising);
        spSourceAdv.setAdapter(adapter1);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, propertyType);
        spPropertyType.setAdapter(adapter2);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, noOfStoryes);
        spNoOfStoryes.setAdapter(adapter3);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, quotedBy);
        spQuotedBy.setAdapter(adapter4);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, cancellationReason);
        spCancellationReason.setAdapter(adapter5);

        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, bookedJobTech);
        spBookedJobTech.setAdapter(adapter6);

        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, partsStatus);
        spPartsStatus.setAdapter(adapter7);

        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, partsBrand);
        spPartBrand.setAdapter(adapter8);

        ArrayAdapter<String> adapter9 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, partsProfile);
        spPartProfile.setAdapter(adapter9);

        ArrayAdapter<String> adapter10 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, partsColor);
        spPartColour.setAdapter(adapter10);

        ArrayAdapter<String> adapter11 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, jdCancledReason);
        spJobCancelledReason.setAdapter(adapter11);

        ArrayAdapter<String> adapter12 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, paymentStatus);
        spPaymentStatus.setAdapter(adapter12);

        ArrayAdapter<String> adapter13 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, paymentMethod);
        spPaymentMethod.setAdapter(adapter13);

        ArrayAdapter<String> adapter14 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, invoiceStatus);
        spInvoiceStatus.setAdapter(adapter14);

        ArrayAdapter<String> adapter15 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, callBackReason);
        spCallBackReason.setAdapter(adapter15);

        ArrayAdapter<String> adapter16 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, feedbackFor);
        spFeedbackFor.setAdapter(adapter16);

        ArrayAdapter<String> adapter17 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, feedbackCategory);
        spFeedbackCategory.setAdapter(adapter17);

        ArrayAdapter<String> adapter18 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, hourse);
        spDetailHourse.setAdapter(adapter18);

        ArrayAdapter<String> adapter19 = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, minuts);
        spDetailMinuts.setAdapter(adapter19);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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
                // date picker dialog
                datePickerDialog = new DatePickerDialog(UpdateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvBookedJobDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;

            case R.id.tvBookedJobTime:
                mTimePicker = new TimePickerDialog(UpdateActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        tvBookedJobTime.setText(selectedHour + "-" + selectedMinute);
                    }
                }, hour1, minute1, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
                break;

            case R.id.tvDetailDateandTime:
                // date picker dialog
                datePickerDialog = new DatePickerDialog(UpdateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDetailDateandTime.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                        strDate = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;

            case R.id.tvFollowUpDate:
                // date picker dialog
                datePickerDialog = new DatePickerDialog(UpdateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvFollowUpDate.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;

            case R.id.tvPaymentDateCompletionPaymentReceived:
                // date picker dialog
                datePickerDialog = new DatePickerDialog(UpdateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvPaymentDateCompletionPaymentReceived.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;

            case R.id.tvPaymentDateDepositReceived:
                // date picker dialog
                datePickerDialog = new DatePickerDialog(UpdateActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvPaymentDateDepositReceived.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
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
        Alerts.show(mContext, strData);

        if (hour.isEmpty()) {
            hour = "0";
        }
        if (minute.isEmpty()) {
            minute = "0";
        }

        if (cd.isNetworkAvailable()) {
            RetrofitService.getUpdateFormFill(new Dialog(mContext), retrofitApiClient.getUpdateFormFill(jobId,
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
                    cb_parent_job, cb_follow_up_date, fb_fdbck_for, fb_fdbck_comments, fb_fdbck_category, effrt, hour, minute, CrewList
            ), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    CutomerModel loginModal = (CutomerModel) result.body();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                        Alerts.show(mContext, loginModal.getMessage());
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

    private void customerList() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.customerList(new Dialog(mContext), retrofitApiClient.customerList(
            ), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    CutomerModel1 loginModal = (CutomerModel1) result.body();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                        Alerts.show(mContext, loginModal.getMessage());

                        for (int i = 0; i < loginModal.getUser().size(); i++) {
                            String name = loginModal.getUser().get(i).getName();
                            list2.add(name);
                        }
                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ctx, android.R.layout.simple_list_item_1, list2);
                        select_cust_0sp.setAdapter(adapter);
                        select_cust_0sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                ((TextView) findViewById(R.id.tvName)).setText(parent.getItemAtPosition(position).toString());
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
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

    private void setSpinner(CustomerDetailModel1 loginModal) {
        // 1
        etOtherSourceAdv.setText(loginModal.getJobdata().getTaskPropertyDetails().getOtherAdvert());
        pdUrgentHandoverNotes.setText(loginModal.getJobdata().getTaskPropertyDetails().getUrgentHandoverNotes());
        if (loginModal.getJobdata().getTaskPropertyDetails().getPdCommercial().equalsIgnoreCase("0")) {
            spCommercialProperty.setSelection(2);
        } else if (loginModal.getJobdata().getTaskPropertyDetails().getPdCommercial().equalsIgnoreCase("1")) {
            spCommercialProperty.setSelection(1);
        }
        if (loginModal.getJobdata().getTaskPropertyDetails().getDormerWindows().equalsIgnoreCase("0")) {
            spDormerWindowsPresent.setSelection(2);
        } else if (loginModal.getJobdata().getTaskPropertyDetails().getDormerWindows().equalsIgnoreCase("1")) {
            spDormerWindowsPresent.setSelection(1);
        }
        if (loginModal.getJobdata().getTaskPropertyDetails().getGutteringOnDormerWin().equalsIgnoreCase("0")) {
            spGutteringOnDormerWindows.setSelection(2);
        } else if (loginModal.getJobdata().getTaskPropertyDetails().getGutteringOnDormerWin().equalsIgnoreCase("1")) {
            spGutteringOnDormerWindows.setSelection(1);
        }
        if (loginModal.getJobdata().getTaskPropertyDetails().getMendatory2Man().equalsIgnoreCase("0")) {
            spMandatoryMan.setSelection(2);
        } else if (loginModal.getJobdata().getTaskPropertyDetails().getMendatory2Man().equalsIgnoreCase("1")) {
            spMandatoryMan.setSelection(1);
        }
        if (loginModal.getJobdata().getTaskPropertyDetails().getLong3TierLadder().equalsIgnoreCase("0")) {
            spLongTierLadderRequired.setSelection(2);
        } else if (loginModal.getJobdata().getTaskPropertyDetails().getLong3TierLadder().equalsIgnoreCase("1")) {
            spLongTierLadderRequired.setSelection(1);
        }
        if (loginModal.getJobdata().getTaskPropertyDetails().getShort3TierLadder().equalsIgnoreCase("0")) {
            spShorTierLadderRequired.setSelection(2);
        } else if (loginModal.getJobdata().getTaskPropertyDetails().getShort3TierLadder().equalsIgnoreCase("1")) {
            spShorTierLadderRequired.setSelection(1);
        }
        if (loginModal.getJobdata().getTaskPropertyDetails().getDryWeatherReq().equalsIgnoreCase("0")) {
            spDryWeatherRequired.setSelection(2);
        } else if (loginModal.getJobdata().getTaskPropertyDetails().getDryWeatherReq().equalsIgnoreCase("1")) {
            spDryWeatherRequired.setSelection(1);
        }
        // 2
        etVisitedNotGivenReason.setText(loginModal.getJobdata().getQouteDeriefFollowUp().getQdVisitedNotGivenReason());
        tvBookedJobDate.setText(loginModal.getJobdata().getQouteDeriefFollowUp().getQdBookDate());
        tvBookedJobTime.setText(loginModal.getJobdata().getQouteDeriefFollowUp().getQdBookTime());
        if (loginModal.getJobdata().getQouteDeriefFollowUp().getQdTechWrittenQuoteCopyAttached().equalsIgnoreCase("0")) {
            spQuoteCopyAttached.setSelection(2);
        } else if (loginModal.getJobdata().getQouteDeriefFollowUp().getQdTechWrittenQuoteCopyAttached().equalsIgnoreCase("1")) {
            spQuoteCopyAttached.setSelection(1);
        }
        if (loginModal.getJobdata().getQouteDeriefFollowUp().getQdDiscusWithCustomer().equalsIgnoreCase("0")) {
            spQuoteDiscussedCustomer.setSelection(2);
        } else if (loginModal.getJobdata().getQouteDeriefFollowUp().getQdDiscusWithCustomer().equalsIgnoreCase("1")) {
            spQuoteDiscussedCustomer.setSelection(1);
        }
        if (loginModal.getJobdata().getQouteDeriefFollowUp().getQdSendToCust().equalsIgnoreCase("0")) {
            spSendQuoteCustomer.setSelection(2);
        } else if (loginModal.getJobdata().getQouteDeriefFollowUp().getQdSendToCust().equalsIgnoreCase("1")) {
            spSendQuoteCustomer.setSelection(1);
        }
        if (loginModal.getJobdata().getQouteDeriefFollowUp().getQdCancelledNoAction().equalsIgnoreCase("0")) {
            spQuoteCancelledFurther.setSelection(2);
        } else if (loginModal.getJobdata().getQouteDeriefFollowUp().getQdCancelledNoAction().equalsIgnoreCase("1")) {
            spQuoteCancelledFurther.setSelection(1);
        }
        if (loginModal.getJobdata().getQouteDeriefFollowUp().getQdRescheduleReq().equalsIgnoreCase("0")) {
            spQuoteRescheduleRequired.setSelection(2);
        } else if (loginModal.getJobdata().getQouteDeriefFollowUp().getQdRescheduleReq().equalsIgnoreCase("1")) {
            spQuoteRescheduleRequired.setSelection(1);
        }
        if (loginModal.getJobdata().getQouteDeriefFollowUp().getQuoteInstnConver().equalsIgnoreCase("0")) {
            spWasTheQuoteInstantlyConverted.setSelection(2);
        } else if (loginModal.getJobdata().getQouteDeriefFollowUp().getQuoteInstnConver().equalsIgnoreCase("1")) {
            spWasTheQuoteInstantlyConverted.setSelection(1);
        }
        // 3
        if (loginModal.getJobdata().getParts().getPrtMultipleBrands().equalsIgnoreCase("0")) {
            spPartMultipleBrands.setSelection(2);
        } else if (loginModal.getJobdata().getParts().getPrtMultipleBrands().equalsIgnoreCase("1")) {
            spPartMultipleBrands.setSelection(1);
        }
        if (loginModal.getJobdata().getParts().getPrtDepositReq().equalsIgnoreCase("0")) {
            spPartsJobDepositRequired.setSelection(2);
        } else if (loginModal.getJobdata().getParts().getPrtDepositReq().equalsIgnoreCase("1")) {
            spPartsJobDepositRequired.setSelection(1);
        }
        // 4
        etNoteAnyDefectsTakeInformCustomer.setText(loginModal.getJobdata().getJobBreif().getJbNotes());
        etJobNoReason.setText(loginModal.getJobdata().getJobBreif().getJbIfNotPassedReson());
        etJobNoNoteActionRequired.setText(loginModal.getJobdata().getJobBreif().getJbIfNoNoteActionReq());
        etJobOtherDetails.setText(loginModal.getJobdata().getJobBreif().getJbOtherDetails());
        etJobNoteanyissuesordamagesandensurepictureshavebeenuploaded.setText(loginModal.getJobdata().getJobBreif().getJbNote());
        if (loginModal.getJobdata().getJobBreif().getJbSitePreInspectCompl().equalsIgnoreCase("0")) {
            spJobSitePreInspectioCompleted.setSelection(2);
        } else if (loginModal.getJobdata().getJobBreif().getJbSitePreInspectCompl().equalsIgnoreCase("1")) {
            spJobSitePreInspectioCompleted.setSelection(1);
        }
        if (loginModal.getJobdata().getJobBreif().getJbSitePreInspectPassed().equalsIgnoreCase("0")) {
            spJobHasSiteInspectionPassedRiskAssessmentToCompleteWork.setSelection(2);
        } else if (loginModal.getJobdata().getJobBreif().getJbSitePreInspectPassed().equalsIgnoreCase("1")) {
            spJobHasSiteInspectionPassedRiskAssessmentToCompleteWork.setSelection(1);
        }
        if (loginModal.getJobdata().getJobBreif().getJbEquipPassedInPreUseInspect().equalsIgnoreCase("0")) {
            spJobHaveAllEquipmentPassedPreUseInspection.setSelection(2);
        } else if (loginModal.getJobdata().getJobBreif().getJbEquipPassedInPreUseInspect().equalsIgnoreCase("1")) {
            spJobHaveAllEquipmentPassedPreUseInspection.setSelection(1);
        }
        if (loginModal.getJobdata().getJobBreif().getJbCacelled().equalsIgnoreCase("0")) {
            spJobHasTheJobBeenCancelled.setSelection(2);
        } else if (loginModal.getJobdata().getJobBreif().getJbCacelled().equalsIgnoreCase("1")) {
            spJobHasTheJobBeenCancelled.setSelection(1);
        }
        if (loginModal.getJobdata().getJobBreif().getJbDoReturnToSite().equalsIgnoreCase("0")) {
            spJobDoWeNeedToReturnToTheSite.setSelection(2);
        } else if (loginModal.getJobdata().getJobBreif().getJbDoReturnToSite().equalsIgnoreCase("1")) {
            spJobDoWeNeedToReturnToTheSite.setSelection(1);
        }
        if (loginModal.getJobdata().getJobBreif().getJbPostInspectCompl().equalsIgnoreCase("0")) {
            spJobHasSitePostInspectionBeenCompleted.setSelection(2);
        } else if (loginModal.getJobdata().getJobBreif().getJbPostInspectCompl().equalsIgnoreCase("1")) {
            spJobHasSitePostInspectionBeenCompleted.setSelection(1);
        }
        // 5
        etCardAuthCode.setText(loginModal.getJobdata().getPaymentDetails().getPaydCardAuthCode());
        etPaymentNonPaymentReason.setText(loginModal.getJobdata().getPaymentDetails().getPaydNonPaymentReason());
        etPaymentDepositAmountReceived.setText(loginModal.getJobdata().getPaymentDetails().getPaydDepositAmount());
        etPaymentInvoiceNumber.setText(loginModal.getJobdata().getPaymentDetails().getPaydInvoiceNumber());
        tvPaymentDateDepositReceived.setText(loginModal.getJobdata().getPaymentDetails().getPaydDateDepostiRecieve());
        tvPaymentDateCompletionPaymentReceived.setText(loginModal.getJobdata().getPaymentDetails().getPaydComplPaymentRecieveDate());
        if (loginModal.getJobdata().getPaymentDetails().getPaydComplPaymentRecieve().equalsIgnoreCase("0")) {
            spPaymentCompletionPaymentReceived.setSelection(2);
        } else if (loginModal.getJobdata().getPaymentDetails().getPaydComplPaymentRecieve().equalsIgnoreCase("1")) {
            spPaymentCompletionPaymentReceived.setSelection(1);
        }
        // 6
        etCallBackJobdetails.setText(loginModal.getJobdata().getCallback().getCbJbDetail());
        etCallBackReasonOther.setText(loginModal.getJobdata().getCallback().getCbReasonOther());
        etCallBackReasonComplaint.setText(loginModal.getJobdata().getCallback().getCbComplaint());
        etParentJob.setText(loginModal.getJobdata().getCallback().getCbParentJb());
        tvFollowUpDate.setText(loginModal.getJobdata().getCallback().getCbFollowUpDate());
        // 7
        etComments.setText(loginModal.getJobdata().getTechFeedback().getTfComments());
        // 8
        tvDetailDateandTime.setText(loginModal.getJobdata().getJbDetails().getScheduleDateTime());
        String strHH = loginModal.getJobdata().getJbDetails().getEstimatedEffrtHh();
        int intHH = 0;
        if (strHH.isEmpty()) {
            strHH = "0";
        }
        intHH = Integer.parseInt(strHH);
        spDetailHourse.setSelection(intHH + 1);

        String strMM = loginModal.getJobdata().getJbDetails().getEstimatedEffrtMm();
        int intMM = 0;
        if (strMM.isEmpty()) {
            strMM = "0";
        }
        intMM = Integer.parseInt(strMM);
        spDetailMinuts.setSelection(intMM + 1);
    }

    public void addValue() {
        /*if (ItemModelList.size() >= 1) {
            Model md = new Model(strCrewName);
            for (int j = 0; j < ItemModelList.size(); j++) {
                if (strCrewName.equals(ItemModelList.get(j).getName())) {
                    Alerts.show(mContext, "Already added!!!");
                } else {
                    if (!strCrewName.isEmpty()) {
                        ItemModelList.add(md);
                        attechAdapter.notifyDataSetChanged();
                        break;
                    }
                }
            }
        } else if (ItemModelList.size() < 1) {
            if (!strCrewName.isEmpty()) {
                Model md = new Model(strCrewName);
                ItemModelList.add(md);
                attechAdapter.notifyDataSetChanged();
            }
        }*/
        if (!strCrewName.isEmpty()) {
            Model md = new Model(strCrewName, strCrewId);
            ItemModelList.add(md);
            attechAdapter.notifyDataSetChanged();
        }
    }

}
