
package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerDetailModel1 implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("jobdata")
    @Expose
    private JobDataDetail jobdata;
    public final static Creator<CustomerDetailModel1> CREATOR = new Creator<CustomerDetailModel1>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CustomerDetailModel1 createFromParcel(Parcel in) {
            return new CustomerDetailModel1(in);
        }

        public CustomerDetailModel1 [] newArray(int size) {
            return (new CustomerDetailModel1[size]);
        }

    }
    ;

    protected CustomerDetailModel1(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.jobdata = ((JobDataDetail) in.readValue((JobDataDetail.class.getClassLoader())));
    }

    public CustomerDetailModel1() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public CustomerDetailModel1 withError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomerDetailModel1 withMessage(String message) {
        this.message = message;
        return this;
    }

    public JobDataDetail getJobdata() {
        return jobdata;
    }

    public void setJobdata(JobDataDetail jobdata) {
        this.jobdata = jobdata;
    }

    public CustomerDetailModel1 withJobdata(JobDataDetail jobdata) {
        this.jobdata = jobdata;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(message);
        dest.writeValue(jobdata);
    }

    public int describeContents() {
        return  0;
    }

}
