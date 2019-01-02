package creative.creation.in.cleansys.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import org.json.JSONException;
import org.json.JSONObject;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.interfaces.FragmentChangeListener;
import creative.creation.in.cleansys.modal.api_modal.customer_responce.CutomerModel;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.retrofit_provider.WebResponse;
import creative.creation.in.cleansys.util.Utility;
import creative.creation.in.cleansys.utils.Alerts;
import creative.creation.in.cleansys.utils.BaseFragment;
import creative.creation.in.cleansys.utils.ConnectionDetector;
import retrofit2.Response;

public class CreateCustomerFragment extends BaseFragment implements FragmentChangeListener, View.OnClickListener {

    private View rootView;
    EditText name_et, email_et, phone_et, location_et, street_et, city_et, postcode_et;
    Button save_bt;
    CheckBox email_cb, sms_cb, tele_cb, emailpost_cb, none_cb;
    ImageView back_iv;
    String name, email, phone, street, city, postcode, location;
    StringBuilder builder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_create_customer, container, false);
        mContext = getActivity();
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();
        cd = new ConnectionDetector(mContext);
        initXml();
        return rootView;
    }

    @Override
    public void onFragmentVisible(String fragmentTag) {

    }

    private void initXml() {
        name_et = rootView.findViewById(R.id.et_create_name);
        email_et = rootView.findViewById(R.id.et_create_email);
        phone_et = rootView.findViewById(R.id.et_create_phone);
        location_et = rootView.findViewById(R.id.et_create_location);
        street_et = rootView.findViewById(R.id.et_create_street);
        city_et = rootView.findViewById(R.id.et_create_city);
        postcode_et = rootView.findViewById(R.id.et_create_posycode);
        save_bt = rootView.findViewById(R.id.bt_create_save);
        email_cb = rootView.findViewById(R.id.cb_create_email);
        sms_cb = rootView.findViewById(R.id.cb_create_sms);
        tele_cb = rootView.findViewById(R.id.cb_create_telephone);
        emailpost_cb = rootView.findViewById(R.id.cb_create_mailpost);
        none_cb = rootView.findViewById(R.id.cb_create_none);
        back_iv = rootView.findViewById(R.id.iv_create_back);

        save_bt.setOnClickListener(this);
        back_iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_create_save:
                if (cd.isNetworkAvailable()) {
                    getData();
                } else {
                    cd.show(mContext);
                }
                break;
        }
    }

    private void getData() {
        name = name_et.getText().toString();
        email = email_et.getText().toString();
        phone = phone_et.getText().toString();
        location = location_et.getText().toString();
        street = street_et.getText().toString();
        city = city_et.getText().toString();
        postcode = postcode_et.getText().toString();
        builder = new StringBuilder();

        if (email_cb.isChecked()) {
            appendData(builder, "Email");
        }
        if (sms_cb.isChecked()) {
            appendData(builder, "SMS");
        }
        if (tele_cb.isChecked()) {
            appendData(builder, "Telephone");
        }
        if (emailpost_cb.isChecked()) {
            appendData(builder, "emailpost");
        }
        if (none_cb.isChecked()) {
            appendData(builder, "none");
        }

        if (name.equals("") || location.equals("") || street.equals("") ||
                city.equals("") || postcode.equals("")) {
            Utility.toastView(mContext, "Enter all field");
        } else if (!Utility.emailCheck(email)) {
            Utility.toastView(mContext, "Invalid E-mail address");
        } else if (phone.length() != 10) {
            Utility.toastView(mContext, "Enter 10 digit mobile");
        } else {
            createCustomerApi();
        }
    }

    private void setResponse(JSONObject response) {
        try {
            boolean error = response.getBoolean("error");
            String msg = response.getString("message");
            if (!error) {
                Utility.toastView(mContext, msg);
            } else {
                Utility.toastView(mContext, msg);
            }
            clear();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void clear() {
        name_et.setText("");
        email_et.setText("");
        phone_et.setText("");
        location_et.setText("");
        street_et.setText("");
        city_et.setText("");
        postcode_et.setText("");
        email_cb.setChecked(false);
        sms_cb.setChecked(false);
        tele_cb.setChecked(false);
        emailpost_cb.setChecked(false);
        none_cb.setChecked(false);
    }

    private void appendData(StringBuilder builder, String data) {
        if (builder.toString().equals("")) {
            builder.append(data);
        } else {
            builder.append("," + data);
        }
    }

    private void createCustomerApi() {
        if (cd.isNetworkAvailable()) {
            RetrofitService.getCustomer(new Dialog(mContext), retrofitApiClient.getCustomer(name, email, phone, location, street,
                    city, postcode, builder.toString()), new WebResponse() {
                @Override
                public void onResponseSuccess(Response<?> result) {
                    CutomerModel loginModal = (CutomerModel) result.body();
                    assert loginModal != null;
                    if (!loginModal.getError()) {
                        Alerts.show(mContext, loginModal.getMessage());
                        clear();
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
