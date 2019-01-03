
package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class JobDataDetail implements Parcelable {

    @SerializedName("job_data")
    @Expose
    private JobData jobData;
    @SerializedName("task_property_details")
    @Expose
    private TaskPropertyDetails taskPropertyDetails;
    @SerializedName("qoute_derief_follow_up")
    @Expose
    private QouteDeriefFollowUp qouteDeriefFollowUp;
    @SerializedName("parts")
    @Expose
    private Parts parts;
    @SerializedName("job_breif")
    @Expose
    private JobBreif jobBreif;
    @SerializedName("payment_details")
    @Expose
    private PaymentDetails paymentDetails;
    @SerializedName("callback")
    @Expose
    private Callback callback;
    @SerializedName("tech_feedback")
    @Expose
    private TechFeedback techFeedback;
    @SerializedName("jb_details")
    @Expose
    private JbDetails jbDetails;
    @SerializedName("crew")
    @Expose
    //private CustomerCrewData crew;
    private List<CustomerCrewData> crew = new ArrayList<CustomerCrewData>();
    public final static Creator<JobDataDetail> CREATOR = new Creator<JobDataDetail>() {


        @SuppressWarnings({
                "unchecked"
        })
        public JobDataDetail createFromParcel(Parcel in) {
            return new JobDataDetail(in);
        }

        public JobDataDetail[] newArray(int size) {
            return (new JobDataDetail[size]);
        }

    };

    protected JobDataDetail(Parcel in) {
        this.jobData = ((JobData) in.readValue((JobData.class.getClassLoader())));
        this.taskPropertyDetails = ((TaskPropertyDetails) in.readValue((TaskPropertyDetails.class.getClassLoader())));
        this.qouteDeriefFollowUp = ((QouteDeriefFollowUp) in.readValue((QouteDeriefFollowUp.class.getClassLoader())));
        this.parts = ((Parts) in.readValue((Parts.class.getClassLoader())));
        this.jobBreif = ((JobBreif) in.readValue((JobBreif.class.getClassLoader())));
        this.paymentDetails = ((PaymentDetails) in.readValue((PaymentDetails.class.getClassLoader())));
        this.callback = ((Callback) in.readValue((Callback.class.getClassLoader())));
        this.techFeedback = ((TechFeedback) in.readValue((TechFeedback.class.getClassLoader())));
        this.jbDetails = ((JbDetails) in.readValue((JbDetails.class.getClassLoader())));
        in.readList(this.crew, (CustomerCrewData.class.getClassLoader()));
    }

    public JobDataDetail() {
    }

    public JobData getJobData() {
        return jobData;
    }

    public void setJobData(JobData jobData) {
        this.jobData = jobData;
    }

    public JobDataDetail withJobData(JobData jobData) {
        this.jobData = jobData;
        return this;
    }

    public TaskPropertyDetails getTaskPropertyDetails() {
        return taskPropertyDetails;
    }

    public void setTaskPropertyDetails(TaskPropertyDetails taskPropertyDetails) {
        this.taskPropertyDetails = taskPropertyDetails;
    }

    public JobDataDetail withTaskPropertyDetails(TaskPropertyDetails taskPropertyDetails) {
        this.taskPropertyDetails = taskPropertyDetails;
        return this;
    }

    public QouteDeriefFollowUp getQouteDeriefFollowUp() {
        return qouteDeriefFollowUp;
    }

    public void setQouteDeriefFollowUp(QouteDeriefFollowUp qouteDeriefFollowUp) {
        this.qouteDeriefFollowUp = qouteDeriefFollowUp;
    }

    public JobDataDetail withQouteDeriefFollowUp(QouteDeriefFollowUp qouteDeriefFollowUp) {
        this.qouteDeriefFollowUp = qouteDeriefFollowUp;
        return this;
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public JobDataDetail withParts(Parts parts) {
        this.parts = parts;
        return this;
    }

    public JobBreif getJobBreif() {
        return jobBreif;
    }

    public void setJobBreif(JobBreif jobBreif) {
        this.jobBreif = jobBreif;
    }

    public JobDataDetail withJobBreif(JobBreif jobBreif) {
        this.jobBreif = jobBreif;
        return this;
    }

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public JobDataDetail withPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
        return this;
    }

    public Callback getCallback() {
        return callback;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public JobDataDetail withCallback(Callback callback) {
        this.callback = callback;
        return this;
    }

    public TechFeedback getTechFeedback() {
        return techFeedback;
    }

    public void setTechFeedback(TechFeedback techFeedback) {
        this.techFeedback = techFeedback;
    }

    public JobDataDetail withTechFeedback(TechFeedback techFeedback) {
        this.techFeedback = techFeedback;
        return this;
    }


    public JbDetails getJbDetails() {
        return jbDetails;
    }

    public void setJbDetails(JbDetails jbDetails) {
        this.jbDetails = jbDetails;
    }

    public JobDataDetail withJbDetails(JbDetails jbDetails) {
        this.jbDetails = jbDetails;
        return this;
    }


    public List<CustomerCrewData> getCrew() {
        return crew;
    }

    public void setCrew(List<CustomerCrewData> crew) {
        this.crew = crew;
    }

    public JobDataDetail withCrew(List<CustomerCrewData> crew) {
        this.crew = crew;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(jobData);
        dest.writeValue(taskPropertyDetails);
        dest.writeValue(qouteDeriefFollowUp);
        dest.writeValue(parts);
        dest.writeValue(jobBreif);
        dest.writeValue(paymentDetails);
        dest.writeValue(callback);
        dest.writeValue(techFeedback);
        dest.writeValue(jbDetails);
        dest.writeValue(crew);
    }

    public int describeContents() {
        return 0;
    }

}
