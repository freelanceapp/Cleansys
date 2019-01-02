
package creative.creation.in.cleansys.modal.api_modal.search_responce;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;

public class JobList implements Parcelable
{

    @SerializedName("job_id")
    @Expose
    private String jobId;
    @SerializedName("jld_data")
    @Expose
    private String jldData;
    @SerializedName("crew_member")
    @Expose
    private List<String> crewMember = new ArrayList<String>();
    @SerializedName("customer")
    @Expose
    private String customer;
    @SerializedName("customer_reference_number")
    @Expose
    private String customerReferenceNumber;
    @SerializedName("payment_status")
    @Expose
    private String paymentStatus;
    @SerializedName("est_price")
    @Expose
    private String estPrice;
    @SerializedName("attachments")
    @Expose
    private String attachments;
    @SerializedName("assets")
    @Expose
    private String assets;
    public final static Creator<JobList> CREATOR = new Creator<JobList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobList createFromParcel(Parcel in) {
            return new JobList(in);
        }

        public JobList[] newArray(int size) {
            return (new JobList[size]);
        }

    }
    ;

    protected JobList(Parcel in) {
        this.jobId = ((String) in.readValue((String.class.getClassLoader())));
        this.jldData = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.crewMember, (String.class.getClassLoader()));
        this.customer = ((String) in.readValue((String.class.getClassLoader())));
        this.customerReferenceNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.paymentStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.estPrice = ((String) in.readValue((String.class.getClassLoader())));
        this.attachments = ((String) in.readValue((String.class.getClassLoader())));
        this.assets = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobList(String job_id, String data, JSONArray member_array, String customer, String customer_reference_number, String payment_status, String estm_price, String attachments, String assets) {
    }

    public JobList() {
    }

    public JobList(String jobId, String jldData, List<String> crewMember, String customer, String customerReferenceNumber, String paymentStatus, String estPrice, String attachments, String assets) {
        this.jobId = jobId;
        this.jldData = jldData;
        this.crewMember = crewMember;
        this.customer = customer;
        this.customerReferenceNumber = customerReferenceNumber;
        this.paymentStatus = paymentStatus;
        this.estPrice = estPrice;
        this.attachments = attachments;
        this.assets = assets;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJldData() {
        return jldData;
    }

    public void setJldData(String jldData) {
        this.jldData = jldData;
    }

    public List<String> getCrewMember() {
        return crewMember;
    }

    public void setCrewMember(List<String> crewMember) {
        this.crewMember = crewMember;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerReferenceNumber() {
        return customerReferenceNumber;
    }

    public void setCustomerReferenceNumber(String customerReferenceNumber) {
        this.customerReferenceNumber = customerReferenceNumber;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getEstPrice() {
        return estPrice;
    }

    public void setEstPrice(String estPrice) {
        this.estPrice = estPrice;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(jobId);
        dest.writeValue(jldData);
        dest.writeList(crewMember);
        dest.writeValue(customer);
        dest.writeValue(customerReferenceNumber);
        dest.writeValue(paymentStatus);
        dest.writeValue(estPrice);
        dest.writeValue(attachments);
        dest.writeValue(assets);
    }

    public int describeContents() {
        return  0;
    }

}
