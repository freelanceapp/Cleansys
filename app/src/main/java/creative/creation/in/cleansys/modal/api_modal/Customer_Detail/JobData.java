package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobData implements Parcelable
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
    @SerializedName("job_id")
    @Expose
    private String jobId;
    @SerializedName("cust_locat")
    @Expose
    private String custLocat;
    @SerializedName("js_desc")
    @Expose
    private String jsDesc;
    @SerializedName("js_contact")
    @Expose
    private String jsContact;
    @SerializedName("js_asset")
    @Expose
    private String jsAsset;
    @SerializedName("js_date")
    @Expose
    private String jsDate;
    @SerializedName("js_time")
    @Expose
    private String jsTime;
    public final static Parcelable.Creator<JobData> CREATOR = new Creator<JobData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public JobData createFromParcel(Parcel in) {
            return new JobData(in);
        }

        public JobData[] newArray(int size) {
            return (new JobData[size]);
        }

    }
            ;

    protected JobData(Parcel in) {
        this._0 = ((String) in.readValue((String.class.getClassLoader())));
        this._1 = ((String) in.readValue((String.class.getClassLoader())));
        this._2 = ((String) in.readValue((String.class.getClassLoader())));
        this._3 = ((String) in.readValue((String.class.getClassLoader())));
        this._4 = ((String) in.readValue((String.class.getClassLoader())));
        this._5 = ((String) in.readValue((String.class.getClassLoader())));
        this._6 = ((String) in.readValue((String.class.getClassLoader())));
        this.jobId = ((String) in.readValue((String.class.getClassLoader())));
        this.custLocat = ((String) in.readValue((String.class.getClassLoader())));
        this.jsDesc = ((String) in.readValue((String.class.getClassLoader())));
        this.jsContact = ((String) in.readValue((String.class.getClassLoader())));
        this.jsAsset = ((String) in.readValue((String.class.getClassLoader())));
        this.jsDate = ((String) in.readValue((String.class.getClassLoader())));
        this.jsTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobData() {
    }

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public JobData with0(String _0) {
        this._0 = _0;
        return this;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public JobData with1(String _1) {
        this._1 = _1;
        return this;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public JobData with2(String _2) {
        this._2 = _2;
        return this;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public JobData with3(String _3) {
        this._3 = _3;
        return this;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public JobData with4(String _4) {
        this._4 = _4;
        return this;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public JobData with5(String _5) {
        this._5 = _5;
        return this;
    }

    public String get6() {
        return _6;
    }

    public void set6(String _6) {
        this._6 = _6;
    }

    public JobData with6(String _6) {
        this._6 = _6;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public JobData withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getCustLocat() {
        return custLocat;
    }

    public void setCustLocat(String custLocat) {
        this.custLocat = custLocat;
    }

    public JobData withCustLocat(String custLocat) {
        this.custLocat = custLocat;
        return this;
    }

    public String getJsDesc() {
        return jsDesc;
    }

    public void setJsDesc(String jsDesc) {
        this.jsDesc = jsDesc;
    }

    public JobData withJsDesc(String jsDesc) {
        this.jsDesc = jsDesc;
        return this;
    }

    public String getJsContact() {
        return jsContact;
    }

    public void setJsContact(String jsContact) {
        this.jsContact = jsContact;
    }

    public JobData withJsContact(String jsContact) {
        this.jsContact = jsContact;
        return this;
    }

    public String getJsAsset() {
        return jsAsset;
    }

    public void setJsAsset(String jsAsset) {
        this.jsAsset = jsAsset;
    }

    public JobData withJsAsset(String jsAsset) {
        this.jsAsset = jsAsset;
        return this;
    }

    public String getJsDate() {
        return jsDate;
    }

    public void setJsDate(String jsDate) {
        this.jsDate = jsDate;
    }

    public JobData withJsDate(String jsDate) {
        this.jsDate = jsDate;
        return this;
    }

    public String getJsTime() {
        return jsTime;
    }

    public void setJsTime(String jsTime) {
        this.jsTime = jsTime;
    }

    public JobData withJsTime(String jsTime) {
        this.jsTime = jsTime;
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
        dest.writeValue(jobId);
        dest.writeValue(custLocat);
        dest.writeValue(jsDesc);
        dest.writeValue(jsContact);
        dest.writeValue(jsAsset);
        dest.writeValue(jsDate);
        dest.writeValue(jsTime);
    }

    public int describeContents() {
        return 0;
    }

}