package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JbDetails implements Parcelable
{

    @SerializedName("job_id")
    @Expose
    private String jobId;
    @SerializedName("schedule_date_time")
    @Expose
    private String scheduleDateTime;
    @SerializedName("estimated_effrt_hh")
    @Expose
    private String estimatedEffrtHh;
    @SerializedName("estimated_effrt_mm")
    @Expose
    private String estimatedEffrtMm;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("time")
    @Expose
    private String time;
    public final static Parcelable.Creator<JbDetails> CREATOR = new Creator<JbDetails>() {


        @SuppressWarnings({
                "unchecked"
        })
        public JbDetails createFromParcel(Parcel in) {
            return new JbDetails(in);
        }

        public JbDetails[] newArray(int size) {
            return (new JbDetails[size]);
        }

    }
            ;

    protected JbDetails(Parcel in) {
        this.jobId = ((String) in.readValue((String.class.getClassLoader())));
        this.scheduleDateTime = ((String) in.readValue((String.class.getClassLoader())));
        this.estimatedEffrtHh = ((String) in.readValue((String.class.getClassLoader())));
        this.estimatedEffrtMm = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.time = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JbDetails() {
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public JbDetails withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getScheduleDateTime() {
        return scheduleDateTime;
    }

    public void setScheduleDateTime(String scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
    }

    public JbDetails withScheduleDateTime(String scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
        return this;
    }

    public String getEstimatedEffrtHh() {
        return estimatedEffrtHh;
    }

    public void setEstimatedEffrtHh(String estimatedEffrtHh) {
        this.estimatedEffrtHh = estimatedEffrtHh;
    }

    public JbDetails withEstimatedEffrtHh(String estimatedEffrtHh) {
        this.estimatedEffrtHh = estimatedEffrtHh;
        return this;
    }

    public String getEstimatedEffrtMm() {
        return estimatedEffrtMm;
    }

    public void setEstimatedEffrtMm(String estimatedEffrtMm) {
        this.estimatedEffrtMm = estimatedEffrtMm;
    }

    public JbDetails withEstimatedEffrtMm(String estimatedEffrtMm) {
        this.estimatedEffrtMm = estimatedEffrtMm;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public JbDetails withDate(String date) {
        this.date = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public JbDetails withTime(String time) {
        this.time = time;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(jobId);
        dest.writeValue(scheduleDateTime);
        dest.writeValue(estimatedEffrtHh);
        dest.writeValue(estimatedEffrtMm);
        dest.writeValue(date);
        dest.writeValue(time);
    }

    public int describeContents() {
        return 0;
    }

}