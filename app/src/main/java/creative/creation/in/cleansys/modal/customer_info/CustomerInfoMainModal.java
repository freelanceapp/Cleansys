package creative.creation.in.cleansys.modal.customer_info;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerInfoMainModal implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("job_list")
    @Expose
    private CustomerInfo jobList;
    public final static Parcelable.Creator<CustomerInfoMainModal> CREATOR = new Creator<CustomerInfoMainModal>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CustomerInfoMainModal createFromParcel(Parcel in) {
            return new CustomerInfoMainModal(in);
        }

        public CustomerInfoMainModal[] newArray(int size) {
            return (new CustomerInfoMainModal[size]);
        }

    }
            ;

    protected CustomerInfoMainModal(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.jobList = ((CustomerInfo) in.readValue((CustomerInfo.class.getClassLoader())));
    }

    public CustomerInfoMainModal() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CustomerInfo getJobList() {
        return jobList;
    }

    public void setJobList(CustomerInfo jobList) {
        this.jobList = jobList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(message);
        dest.writeValue(jobList);
    }

    public int describeContents() {
        return 0;
    }

}