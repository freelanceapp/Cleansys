
package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Callback implements Parcelable
{

    @SerializedName("0")
    @Expose
    private String _0;
    @SerializedName("1")
    @Expose
    private String _1;
    @SerializedName("2")
    @Expose
    private String _2;
    @SerializedName("3")
    @Expose
    private String _3;
    @SerializedName("4")
    @Expose
    private String _4;
    @SerializedName("5")
    @Expose
    private String _5;
    @SerializedName("6")
    @Expose
    private String _6;
    @SerializedName("7")
    @Expose
    private String _7;
    @SerializedName("8")
    @Expose
    private String _8;
    @SerializedName("job_id")
    @Expose
    private String jobId;
    @SerializedName("cb_jb_detail")
    @Expose
    private String cbJbDetail;
    @SerializedName("cb_reason")
    @Expose
    private String cbReason;
    @SerializedName("cb_reason_other")
    @Expose
    private String cbReasonOther;
    @SerializedName("cb_complaint")
    @Expose
    private String cbComplaint;
    @SerializedName("cb_parent_jb")
    @Expose
    private String cbParentJb;
    @SerializedName("cb_follow_up_date")
    @Expose
    private String cbFollowUpDate;
    @SerializedName("cb_date")
    @Expose
    private String cbDate;
    @SerializedName("cb_time")
    @Expose
    private String cbTime;
    public final static Creator<Callback> CREATOR = new Creator<Callback>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Callback createFromParcel(Parcel in) {
            return new Callback(in);
        }

        public Callback[] newArray(int size) {
            return (new Callback[size]);
        }

    }
    ;

    protected Callback(Parcel in) {
        this._0 = ((String) in.readValue((String.class.getClassLoader())));
        this._1 = ((String) in.readValue((String.class.getClassLoader())));
        this._2 = ((String) in.readValue((String.class.getClassLoader())));
        this._3 = ((String) in.readValue((String.class.getClassLoader())));
        this._4 = ((String) in.readValue((String.class.getClassLoader())));
        this._5 = ((String) in.readValue((String.class.getClassLoader())));
        this._6 = ((String) in.readValue((String.class.getClassLoader())));
        this._7 = ((String) in.readValue((String.class.getClassLoader())));
        this._8 = ((String) in.readValue((String.class.getClassLoader())));
        this.jobId = ((String) in.readValue((String.class.getClassLoader())));
        this.cbJbDetail = ((String) in.readValue((String.class.getClassLoader())));
        this.cbReason = ((String) in.readValue((String.class.getClassLoader())));
        this.cbReasonOther = ((String) in.readValue((String.class.getClassLoader())));
        this.cbComplaint = ((String) in.readValue((String.class.getClassLoader())));
        this.cbParentJb = ((String) in.readValue((String.class.getClassLoader())));
        this.cbFollowUpDate = ((String) in.readValue((String.class.getClassLoader())));
        this.cbDate = ((String) in.readValue((String.class.getClassLoader())));
        this.cbTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Callback() {
    }

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public Callback with0(String _0) {
        this._0 = _0;
        return this;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public Callback with1(String _1) {
        this._1 = _1;
        return this;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public Callback with2(String _2) {
        this._2 = _2;
        return this;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public Callback with3(String _3) {
        this._3 = _3;
        return this;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public Callback with4(String _4) {
        this._4 = _4;
        return this;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public Callback with5(String _5) {
        this._5 = _5;
        return this;
    }

    public String get6() {
        return _6;
    }

    public void set6(String _6) {
        this._6 = _6;
    }

    public Callback with6(String _6) {
        this._6 = _6;
        return this;
    }

    public String get7() {
        return _7;
    }

    public void set7(String _7) {
        this._7 = _7;
    }

    public Callback with7(String _7) {
        this._7 = _7;
        return this;
    }

    public String get8() {
        return _8;
    }

    public void set8(String _8) {
        this._8 = _8;
    }

    public Callback with8(String _8) {
        this._8 = _8;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Callback withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getCbJbDetail() {
        return cbJbDetail;
    }

    public void setCbJbDetail(String cbJbDetail) {
        this.cbJbDetail = cbJbDetail;
    }

    public Callback withCbJbDetail(String cbJbDetail) {
        this.cbJbDetail = cbJbDetail;
        return this;
    }

    public String getCbReason() {
        return cbReason;
    }

    public void setCbReason(String cbReason) {
        this.cbReason = cbReason;
    }

    public Callback withCbReason(String cbReason) {
        this.cbReason = cbReason;
        return this;
    }

    public String getCbReasonOther() {
        return cbReasonOther;
    }

    public void setCbReasonOther(String cbReasonOther) {
        this.cbReasonOther = cbReasonOther;
    }

    public Callback withCbReasonOther(String cbReasonOther) {
        this.cbReasonOther = cbReasonOther;
        return this;
    }

    public String getCbComplaint() {
        return cbComplaint;
    }

    public void setCbComplaint(String cbComplaint) {
        this.cbComplaint = cbComplaint;
    }

    public Callback withCbComplaint(String cbComplaint) {
        this.cbComplaint = cbComplaint;
        return this;
    }

    public String getCbParentJb() {
        return cbParentJb;
    }

    public void setCbParentJb(String cbParentJb) {
        this.cbParentJb = cbParentJb;
    }

    public Callback withCbParentJb(String cbParentJb) {
        this.cbParentJb = cbParentJb;
        return this;
    }

    public String getCbFollowUpDate() {
        return cbFollowUpDate;
    }

    public void setCbFollowUpDate(String cbFollowUpDate) {
        this.cbFollowUpDate = cbFollowUpDate;
    }

    public Callback withCbFollowUpDate(String cbFollowUpDate) {
        this.cbFollowUpDate = cbFollowUpDate;
        return this;
    }

    public String getCbDate() {
        return cbDate;
    }

    public void setCbDate(String cbDate) {
        this.cbDate = cbDate;
    }

    public Callback withCbDate(String cbDate) {
        this.cbDate = cbDate;
        return this;
    }

    public String getCbTime() {
        return cbTime;
    }

    public void setCbTime(String cbTime) {
        this.cbTime = cbTime;
    }

    public Callback withCbTime(String cbTime) {
        this.cbTime = cbTime;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_0);
        dest.writeValue(_1);
        dest.writeValue(_2);
        dest.writeValue(_3);
        dest.writeValue(_4);
        dest.writeValue(_5);
        dest.writeValue(_6);
        dest.writeValue(_7);
        dest.writeValue(_8);
        dest.writeValue(jobId);
        dest.writeValue(cbJbDetail);
        dest.writeValue(cbReason);
        dest.writeValue(cbReasonOther);
        dest.writeValue(cbComplaint);
        dest.writeValue(cbParentJb);
        dest.writeValue(cbFollowUpDate);
        dest.writeValue(cbDate);
        dest.writeValue(cbTime);
    }

    public int describeContents() {
        return  0;
    }

}
