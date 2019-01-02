
package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TechFeedback implements Parcelable
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
    @SerializedName("job_id")
    @Expose
    private String jobId;
    @SerializedName("tf_fedbck_for")
    @Expose
    private String tfFedbckFor;
    @SerializedName("tf_comments")
    @Expose
    private String tfComments;
    @SerializedName("tf_category")
    @Expose
    private String tfCategory;
    @SerializedName("tf_date")
    @Expose
    private String tfDate;
    @SerializedName("tf_time")
    @Expose
    private String tfTime;
    public final static Creator<TechFeedback> CREATOR = new Creator<TechFeedback>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TechFeedback createFromParcel(Parcel in) {
            return new TechFeedback(in);
        }

        public TechFeedback[] newArray(int size) {
            return (new TechFeedback[size]);
        }

    }
    ;

    protected TechFeedback(Parcel in) {
        this._0 = ((String) in.readValue((String.class.getClassLoader())));
        this._1 = ((String) in.readValue((String.class.getClassLoader())));
        this._2 = ((String) in.readValue((String.class.getClassLoader())));
        this._3 = ((String) in.readValue((String.class.getClassLoader())));
        this._4 = ((String) in.readValue((String.class.getClassLoader())));
        this._5 = ((String) in.readValue((String.class.getClassLoader())));
        this.jobId = ((String) in.readValue((String.class.getClassLoader())));
        this.tfFedbckFor = ((String) in.readValue((String.class.getClassLoader())));
        this.tfComments = ((String) in.readValue((String.class.getClassLoader())));
        this.tfCategory = ((String) in.readValue((String.class.getClassLoader())));
        this.tfDate = ((String) in.readValue((String.class.getClassLoader())));
        this.tfTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TechFeedback() {
    }

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public TechFeedback with0(String _0) {
        this._0 = _0;
        return this;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public TechFeedback with1(String _1) {
        this._1 = _1;
        return this;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public TechFeedback with2(String _2) {
        this._2 = _2;
        return this;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public TechFeedback with3(String _3) {
        this._3 = _3;
        return this;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public TechFeedback with4(String _4) {
        this._4 = _4;
        return this;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public TechFeedback with5(String _5) {
        this._5 = _5;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public TechFeedback withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getTfFedbckFor() {
        return tfFedbckFor;
    }

    public void setTfFedbckFor(String tfFedbckFor) {
        this.tfFedbckFor = tfFedbckFor;
    }

    public TechFeedback withTfFedbckFor(String tfFedbckFor) {
        this.tfFedbckFor = tfFedbckFor;
        return this;
    }

    public String getTfComments() {
        return tfComments;
    }

    public void setTfComments(String tfComments) {
        this.tfComments = tfComments;
    }

    public TechFeedback withTfComments(String tfComments) {
        this.tfComments = tfComments;
        return this;
    }

    public String getTfCategory() {
        return tfCategory;
    }

    public void setTfCategory(String tfCategory) {
        this.tfCategory = tfCategory;
    }

    public TechFeedback withTfCategory(String tfCategory) {
        this.tfCategory = tfCategory;
        return this;
    }

    public String getTfDate() {
        return tfDate;
    }

    public void setTfDate(String tfDate) {
        this.tfDate = tfDate;
    }

    public TechFeedback withTfDate(String tfDate) {
        this.tfDate = tfDate;
        return this;
    }

    public String getTfTime() {
        return tfTime;
    }

    public void setTfTime(String tfTime) {
        this.tfTime = tfTime;
    }

    public TechFeedback withTfTime(String tfTime) {
        this.tfTime = tfTime;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(_0);
        dest.writeValue(_1);
        dest.writeValue(_2);
        dest.writeValue(_3);
        dest.writeValue(_4);
        dest.writeValue(_5);
        dest.writeValue(jobId);
        dest.writeValue(tfFedbckFor);
        dest.writeValue(tfComments);
        dest.writeValue(tfCategory);
        dest.writeValue(tfDate);
        dest.writeValue(tfTime);
    }

    public int describeContents() {
        return  0;
    }

}
