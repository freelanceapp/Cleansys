
package creative.creation.in.cleansys.modal.api_modal.FellowUp_responce;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FellowupUser implements Parcelable
{

    @SerializedName("customer_ref_umber")
    @Expose
    private String customerRefUmber;
    @SerializedName("job_ref_num")
    @Expose
    private String jobRefNum;
    @SerializedName("customer_full_name")
    @Expose
    private Object customerFullName;
    @SerializedName("customer_email")
    @Expose
    private Object customerEmail;
    @SerializedName("job_details")
    @Expose
    private String jobDetails;
    @SerializedName("customer_phone")
    @Expose
    private Object customerPhone;
    public final static Creator<FellowupUser> CREATOR = new Creator<FellowupUser>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FellowupUser createFromParcel(Parcel in) {
            return new FellowupUser(in);
        }

        public FellowupUser[] newArray(int size) {
            return (new FellowupUser[size]);
        }

    }
    ;

    protected FellowupUser(Parcel in) {
        this.customerRefUmber = ((String) in.readValue((String.class.getClassLoader())));
        this.jobRefNum = ((String) in.readValue((String.class.getClassLoader())));
        this.customerFullName = ((Object) in.readValue((Object.class.getClassLoader())));
        this.customerEmail = ((Object) in.readValue((Object.class.getClassLoader())));
        this.jobDetails = ((String) in.readValue((String.class.getClassLoader())));
        this.customerPhone = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public FellowupUser(String customerRefUmber, String jobRefNum, Object customerFullName, Object customerEmail, String jobDetails, Object customerPhone) {
        this.customerRefUmber = customerRefUmber;
        this.jobRefNum = jobRefNum;
        this.customerFullName = customerFullName;
        this.customerEmail = customerEmail;
        this.jobDetails = jobDetails;
        this.customerPhone = customerPhone;
    }

    public FellowupUser() {
    }

    public String getCustomerRefUmber() {
        return customerRefUmber;
    }

    public void setCustomerRefUmber(String customerRefUmber) {
        this.customerRefUmber = customerRefUmber;
    }

    public FellowupUser withCustomerRefUmber(String customerRefUmber) {
        this.customerRefUmber = customerRefUmber;
        return this;
    }

    public String getJobRefNum() {
        return jobRefNum;
    }

    public void setJobRefNum(String jobRefNum) {
        this.jobRefNum = jobRefNum;
    }

    public FellowupUser withJobRefNum(String jobRefNum) {
        this.jobRefNum = jobRefNum;
        return this;
    }

    public Object getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(Object customerFullName) {
        this.customerFullName = customerFullName;
    }

    public FellowupUser withCustomerFullName(Object customerFullName) {
        this.customerFullName = customerFullName;
        return this;
    }

    public Object getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(Object customerEmail) {
        this.customerEmail = customerEmail;
    }

    public FellowupUser withCustomerEmail(Object customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public String getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(String jobDetails) {
        this.jobDetails = jobDetails;
    }

    public FellowupUser withJobDetails(String jobDetails) {
        this.jobDetails = jobDetails;
        return this;
    }

    public Object getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Object customerPhone) {
        this.customerPhone = customerPhone;
    }

    public FellowupUser withCustomerPhone(Object customerPhone) {
        this.customerPhone = customerPhone;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(customerRefUmber);
        dest.writeValue(jobRefNum);
        dest.writeValue(customerFullName);
        dest.writeValue(customerEmail);
        dest.writeValue(jobDetails);
        dest.writeValue(customerPhone);
    }

    public int describeContents() {
        return  0;
    }

}
