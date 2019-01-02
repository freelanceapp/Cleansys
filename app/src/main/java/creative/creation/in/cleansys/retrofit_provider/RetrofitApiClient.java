package creative.creation.in.cleansys.retrofit_provider;


import creative.creation.in.cleansys.constant.Constant;
import creative.creation.in.cleansys.modal.api_modal.Customer_Detail.CustomerDetailModel1;
import creative.creation.in.cleansys.modal.api_modal.attechment_responce.AttechmentModel;
import creative.creation.in.cleansys.modal.api_modal.customer_responce.CutomerModel;
import creative.creation.in.cleansys.modal.api_modal.customerlist_responce.CutomerModel1;
import creative.creation.in.cleansys.modal.api_modal.login_response.LoginModal;
import creative.creation.in.cleansys.modal.api_modal.price_responce.PriceModel;
import creative.creation.in.cleansys.modal.api_modal.schedular_response.SchedularModel;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface RetrofitApiClient {

    @Multipart
    @POST(Constant.USER_REGISTRATION)
    Call<LoginModal> userRegistration(@Part("name") RequestBody name, @Part MultipartBody.Part file,
                                      @Part("email") RequestBody email, @Part("password") RequestBody password,
                                      @Part("mobile_number") RequestBody mobile_number);

    @FormUrlEncoded
    @POST(Constant.USER_LOGIN)
    Call<LoginModal> userLogin(@Field("username") String username,
                               @Field("password") String password);

    @FormUrlEncoded
    @POST(Constant.USER_PROFILE)
    Call<LoginModal> userProfile(@Field("user_id") String user_id);

    @FormUrlEncoded
    @POST(Constant.VERIFICATION)
    Call<LoginModal> userVerification(@Field("mobile_number") String mobile_number,
                                      @Field("otp_number") String otp_number);

    @FormUrlEncoded
    @POST(Constant.CUSTOMER)
    Call<CutomerModel> getCustomer(@Field("name") String name,
                                   @Field("email") String email,
                                   @Field("phone") String phone,
                                   @Field("location") String location,
                                   @Field("street") String street,
                                   @Field("city") String city,
                                   @Field("post_code") String post_code,
                                   @Field("mareting ") String mareting);

    @FormUrlEncoded
    @POST(Constant.FORM_FILL)
    Call<ResponseBody> getFormFill(@Field("js_loc") String js_loc,
                                   @Field("js_desc") String js_desc,
                                   @Field("f1_sorce_adv") String f1_sorce_adv,
                                   @Field("f1_othe_adv") String f1_othe_adv,
                                   @Field("f1_prop_type") String f1_prop_type,
                                   @Field("f1_no_storyes") String f1_no_storyes,
                                   @Field("f1_urgnt_handover_notes") String f1_urgnt_handover_notes,
                                   @Field("f1_prop_commercial") String f1_prop_commercial,
                                   @Field("f1_dorme_windo_pres") String f1_dorme_windo_pres,
                                   @Field("f1_gutter_dorm_windo") String f1_gutter_dorm_windo,
                                   @Field("f1_mand_2_man") String f1_mand_2_man,
                                   @Field("f1_long_3_tier_ladd_req") String f1_long_3_tier_ladd_req,
                                   @Field("f1_short_3_tier_ladd_req") String f1_short_3_tier_ladd_req,
                                   @Field("f1_dry_weath_req") String f1_dry_weath_req,
                                   @Field("qb_quated_by") String qb_quated_by,
                                   @Field("qb_visited_not_given_reasn") String qb_visited_not_given_reasn,
                                   @Field("qb_cancellation_reason") String qb_cancellation_reason,
                                   @Field("qb_bj_date") String qb_bj_date,
                                   @Field("qb_bj_time") String qb_bj_time,
                                   @Field("qb_bj_tech") String qb_bj_tech,
                                   @Field("qb_tech_writt_quot_cop_attached") String qb_tech_writt_quot_cop_attached,
                                   @Field("qb_quote_discussd_with_customer") String qb_quote_discussd_with_customer,
                                   @Field("qb_need_to_send_quote_to_customer") String qb_need_to_send_quote_to_customer,
                                   @Field("qb_quated_canceled_no_action") String qb_quated_canceled_no_action,
                                   @Field("qb_resched_req") String qb_resched_req,
                                   @Field("qb_instantl_converted") String qb_instantl_converted,
                                   @Field("prt_status") String prt_status,
                                   @Field("prt_brnd") String prt_brnd,
                                   @Field("prt_profile") String prt_profile,
                                   @Field("prt_colour") String prt_colour,
                                   @Field("prt_multiple_brnd") String prt_multiple_brnd,
                                   @Field("prt_job_deposit_req") String prt_job_deposit_req,
                                   @Field("jd_note_defect_pic_inform_customer") String jd_note_defect_pic_inform_customer,
                                   @Field("jd_ifNo_inspect_passed_risk_assetmnt") String jd_ifNo_inspect_passed_risk_assetmnt,
                                   @Field("jd_ifNo_inspect_pre_note") String jd_ifNo_inspect_pre_note,
                                   @Field("jd_cancled_reason") String jd_cancled_reason,
                                   @Field("jd_other_details") String jd_other_details,
                                   @Field("jd_note_dameges_pics") String jd_note_dameges_pics,
                                   @Field("jd_pre_site_inspect_compltd") String jd_pre_site_inspect_compltd,
                                   @Field("jd_site_inspect_passed_risk_assetmnt") String jd_site_inspect_passed_risk_assetmnt,
                                   @Field("jd_preInspect_equip_passed") String jd_preInspect_equip_passed,
                                   @Field("jd_job_cancelled") String jd_job_cancelled,
                                   @Field("jd_need_retrn_to_site") String jd_need_retrn_to_site,
                                   @Field("jd_post_site_inspect_compltd") String jd_post_site_inspect_compltd,
                                   @Field("pyd_date_depost_recived") String pyd_date_depost_recived,
                                   @Field("pyd_depost_amount_recived") String pyd_depost_amount_recived,
                                   @Field("pyd_invoice_number") String pyd_invoice_number,
                                   @Field("pyd_payment_status") String pyd_payment_status,
                                   @Field("pyd_date_completd_payment_recived") String pyd_date_completd_payment_recived,
                                   @Field("pyd_non_payment_reson") String pyd_non_payment_reson,
                                   @Field("pyd_payment_method") String pyd_payment_method,
                                   @Field("pyd_card_auth_code") String pyd_card_auth_code,
                                   @Field("pyd_invoice_status") String pyd_invoice_status,
                                   @Field("pyd_completd_payment_recived") String pyd_completd_payment_recived,
                                   @Field("cb_job_details") String cb_job_details,
                                   @Field("cb_callback_reason") String cb_callback_reason,
                                   @Field("cb_callback_reason_other") String cb_callback_reason_other,
                                   @Field("cb_callback_reason_complaint") String cb_callback_reason_complaint,
                                   @Field("cb_parent_job") String cb_parent_job,
                                   @Field("cb_follow_up_date") String cb_follow_up_date,
                                   @Field("fb_fdbck_for") String fb_fdbck_for,
                                   @Field("fb_fdbck_comments") String fb_fdbck_comments,
                                   @Field("fb_fdbck_category") String fb_fdbck_category,
                                   @Field("effrt") String effrt,
                                   @Field("hour") String hour,
                                   @Field("minute") String minute,
                                   @Field("crew_id[]") String crew_id);


    @FormUrlEncoded
    @POST(Constant.UPDATE_FORM)
    Call<CutomerModel> getUpdateFormFill(@Field("job_id") String job_id,
                                         @Field("js_loc") String js_loc,
                                         @Field("js_desc") String js_desc,
                                         @Field("f1_sorce_adv") String f1_sorce_adv,
                                         @Field("f1_othe_adv") String f1_othe_adv,
                                         @Field("f1_prop_type") String f1_prop_type,
                                         @Field("f1_no_storyes") String f1_no_storyes,
                                         @Field("f1_urgnt_handover_notes") String f1_urgnt_handover_notes,
                                         @Field("f1_prop_commercial") String f1_prop_commercial,
                                         @Field("f1_dorme_windo_pres") String f1_dorme_windo_pres,
                                         @Field("f1_gutter_dorm_windo") String f1_gutter_dorm_windo,
                                         @Field("f1_mand_2_man") String f1_mand_2_man,
                                         @Field("f1_long_3_tier_ladd_req") String f1_long_3_tier_ladd_req,
                                         @Field("f1_short_3_tier_ladd_req") String f1_short_3_tier_ladd_req,
                                         @Field("f1_dry_weath_req") String f1_dry_weath_req,
                                         @Field("qb_quated_by") String qb_quated_by,
                                         @Field("qb_visited_not_given_reasn") String qb_visited_not_given_reasn,
                                         @Field("qb_cancellation_reason") String qb_cancellation_reason,
                                         @Field("qb_bj_date") String qb_bj_date,
                                         @Field("qb_bj_time") String qb_bj_time,
                                         @Field("qb_bj_tech") String qb_bj_tech,
                                         @Field("qb_tech_writt_quot_cop_attached") String qb_tech_writt_quot_cop_attached,
                                         @Field("qb_quote_discussd_with_customer") String qb_quote_discussd_with_customer,
                                         @Field("qb_need_to_send_quote_to_customer") String qb_need_to_send_quote_to_customer,
                                         @Field("qb_quated_canceled_no_action") String qb_quated_canceled_no_action,
                                         @Field("qb_resched_req") String qb_resched_req,
                                         @Field("qb_instantl_converted") String qb_instantl_converted,
                                         @Field("prt_status") String prt_status,
                                         @Field("prt_brnd") String prt_brnd,
                                         @Field("prt_profile") String prt_profile,
                                         @Field("prt_colour") String prt_colour,
                                         @Field("prt_multiple_brnd") String prt_multiple_brnd,
                                         @Field("prt_job_deposit_req") String prt_job_deposit_req,
                                         @Field("jd_note_defect_pic_inform_customer") String jd_note_defect_pic_inform_customer,
                                         @Field("jd_ifNo_inspect_passed_risk_assetmnt") String jd_ifNo_inspect_passed_risk_assetmnt,
                                         @Field("jd_ifNo_inspect_pre_note") String jd_ifNo_inspect_pre_note,
                                         @Field("jd_cancled_reason") String jd_cancled_reason,
                                         @Field("jd_other_details") String jd_other_details,
                                         @Field("jd_note_dameges_pics") String jd_note_dameges_pics,
                                         @Field("jd_pre_site_inspect_compltd") String jd_pre_site_inspect_compltd,
                                         @Field("jd_site_inspect_passed_risk_assetmnt") String jd_site_inspect_passed_risk_assetmnt,
                                         @Field("jd_preInspect_equip_passed") String jd_preInspect_equip_passed,
                                         @Field("jd_job_cancelled") String jd_job_cancelled,
                                         @Field("jd_need_retrn_to_site") String jd_need_retrn_to_site,
                                         @Field("jd_post_site_inspect_compltd") String jd_post_site_inspect_compltd,
                                         @Field("pyd_date_depost_recived") String pyd_date_depost_recived,
                                         @Field("pyd_depost_amount_recived") String pyd_depost_amount_recived,
                                         @Field("pyd_invoice_number") String pyd_invoice_number,
                                         @Field("pyd_payment_status") String pyd_payment_status,
                                         @Field("pyd_date_completd_payment_recived") String pyd_date_completd_payment_recived,
                                         @Field("pyd_non_payment_reson") String pyd_non_payment_reson,
                                         @Field("pyd_payment_method") String pyd_payment_method,
                                         @Field("pyd_card_auth_code") String pyd_card_auth_code,
                                         @Field("pyd_invoice_status") String pyd_invoice_status,
                                         @Field("pyd_completd_payment_recived") String pyd_completd_payment_recived,
                                         @Field("cb_job_details") String cb_job_details,
                                         @Field("cb_callback_reason") String cb_callback_reason,
                                         @Field("cb_callback_reason_other") String cb_callback_reason_other,
                                         @Field("cb_callback_reason_complaint") String cb_callback_reason_complaint,
                                         @Field("cb_parent_job") String cb_parent_job,
                                         @Field("cb_follow_up_date") String cb_follow_up_date,
                                         @Field("fb_fdbck_for") String fb_fdbck_for,
                                         @Field("fb_fdbck_comments") String fb_fdbck_comments,
                                         @Field("fb_fdbck_category") String fb_fdbck_category,
                                         @Field("effrt") String effrt,
                                         @Field("hour") String hour,
                                         @Field("minute") String minute,
                                         @Field("crew_id[]") String crew_id);

    @GET(Constant.SCHEDULAR)
    Call<SchedularModel> getSchedular();

    @GET(Constant.PRICE_LIST)
    Call<PriceModel> getPrice();

    @GET(Constant.CUSTOMER_LIST)
    Call<CutomerModel1> customerList();

    @Multipart
    @POST(Constant.ATTECH_FILE)
    Call<CutomerModel> attechFile(@Part("job_id") RequestBody job_id,
                                  @Part MultipartBody.Part image);


    @FormUrlEncoded
    @POST(Constant.TOKEN_APP)
    Call<CutomerModel> getToken(@Field("user_id") String user_id,
                                @Field("token") String token);


    @FormUrlEncoded
    @POST(Constant.ATTECHMENT_LIST)
    Call<AttechmentModel> getAttechment(@Field("job_id") String job_id);


    @FormUrlEncoded
    @POST(Constant.GET_DETAIL)
    Call<CustomerDetailModel1> getCustomerDetail(@Field("job_id") String job_id);

}