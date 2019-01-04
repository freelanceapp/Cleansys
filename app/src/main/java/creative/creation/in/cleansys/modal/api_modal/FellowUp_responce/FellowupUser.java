
package creative.creation.in.cleansys.modal.api_modal.FellowUp_responce;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
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
    private String customerFullName;
    @SerializedName("customer_email")
    @Expose
    private String customerEmail;
    @SerializedName("job_details")
    @Expose
    private String jobDetails;
    @SerializedName("customer_phone")
    @Expose
    private String customerPhone;
    public final static Parcelable.Creator<FellowupUser> CREATOR = new Creator<FellowupUser>() {


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
        this.customerFullName = ((String) in.readValue((String.class.getClassLoader())));
        this.customerEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.jobDetails = ((String) in.readValue((String.class.getClassLoader())));
        this.customerPhone = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FellowupUser() {
    }

    public String getCustomerRefUmber() {
        return customerRefUmber;
    }

    public void setCustomerRefUmber(String customerRefUmber) {
        this.customerRefUmber = customerRefUmber;
    }

    public String getJobRefNum() {
        return jobRefNum;
    }

    public void setJobRefNum(String jobRefNum) {
        this.jobRefNum = jobRefNum;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(String jobDetails) {
        this.jobDetails = jobDetails;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
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
        return 0;
    }

}
