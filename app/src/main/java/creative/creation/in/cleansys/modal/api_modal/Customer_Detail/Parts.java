
package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Parts implements Parcelable
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
    @SerializedName("prt_status")
    @Expose
    private String prtStatus;
    @SerializedName("prt_multiple_brands")
    @Expose
    private String prtMultipleBrands;
    @SerializedName("prt_brand")
    @Expose
    private String prtBrand;
    @SerializedName("prt_profile")
    @Expose
    private String prtProfile;
    @SerializedName("prt_colour")
    @Expose
    private String prtColour;
    @SerializedName("prt_deposit_req")
    @Expose
    private String prtDepositReq;
    @SerializedName("prt_date")
    @Expose
    private String prtDate;
    @SerializedName("prt_time")
    @Expose
    private String prtTime;
    public final static Creator<Parts> CREATOR = new Creator<Parts>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Parts createFromParcel(Parcel in) {
            return new Parts(in);
        }

        public Parts[] newArray(int size) {
            return (new Parts[size]);
        }

    }
    ;

    protected Parts(Parcel in) {
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
        this.prtStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.prtMultipleBrands = ((String) in.readValue((String.class.getClassLoader())));
        this.prtBrand = ((String) in.readValue((String.class.getClassLoader())));
        this.prtProfile = ((String) in.readValue((String.class.getClassLoader())));
        this.prtColour = ((String) in.readValue((String.class.getClassLoader())));
        this.prtDepositReq = ((String) in.readValue((String.class.getClassLoader())));
        this.prtDate = ((String) in.readValue((String.class.getClassLoader())));
        this.prtTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Parts() {
    }

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public Parts with0(String _0) {
        this._0 = _0;
        return this;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public Parts with1(String _1) {
        this._1 = _1;
        return this;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public Parts with2(String _2) {
        this._2 = _2;
        return this;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public Parts with3(String _3) {
        this._3 = _3;
        return this;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public Parts with4(String _4) {
        this._4 = _4;
        return this;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public Parts with5(String _5) {
        this._5 = _5;
        return this;
    }

    public String get6() {
        return _6;
    }

    public void set6(String _6) {
        this._6 = _6;
    }

    public Parts with6(String _6) {
        this._6 = _6;
        return this;
    }

    public String get7() {
        return _7;
    }

    public void set7(String _7) {
        this._7 = _7;
    }

    public Parts with7(String _7) {
        this._7 = _7;
        return this;
    }

    public String get8() {
        return _8;
    }

    public void set8(String _8) {
        this._8 = _8;
    }

    public Parts with8(String _8) {
        this._8 = _8;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Parts withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getPrtStatus() {
        return prtStatus;
    }

    public void setPrtStatus(String prtStatus) {
        this.prtStatus = prtStatus;
    }

    public Parts withPrtStatus(String prtStatus) {
        this.prtStatus = prtStatus;
        return this;
    }

    public String getPrtMultipleBrands() {
        return prtMultipleBrands;
    }

    public void setPrtMultipleBrands(String prtMultipleBrands) {
        this.prtMultipleBrands = prtMultipleBrands;
    }

    public Parts withPrtMultipleBrands(String prtMultipleBrands) {
        this.prtMultipleBrands = prtMultipleBrands;
        return this;
    }

    public String getPrtBrand() {
        return prtBrand;
    }

    public void setPrtBrand(String prtBrand) {
        this.prtBrand = prtBrand;
    }

    public Parts withPrtBrand(String prtBrand) {
        this.prtBrand = prtBrand;
        return this;
    }

    public String getPrtProfile() {
        return prtProfile;
    }

    public void setPrtProfile(String prtProfile) {
        this.prtProfile = prtProfile;
    }

    public Parts withPrtProfile(String prtProfile) {
        this.prtProfile = prtProfile;
        return this;
    }

    public String getPrtColour() {
        return prtColour;
    }

    public void setPrtColour(String prtColour) {
        this.prtColour = prtColour;
    }

    public Parts withPrtColour(String prtColour) {
        this.prtColour = prtColour;
        return this;
    }

    public String getPrtDepositReq() {
        return prtDepositReq;
    }

    public void setPrtDepositReq(String prtDepositReq) {
        this.prtDepositReq = prtDepositReq;
    }

    public Parts withPrtDepositReq(String prtDepositReq) {
        this.prtDepositReq = prtDepositReq;
        return this;
    }

    public String getPrtDate() {
        return prtDate;
    }

    public void setPrtDate(String prtDate) {
        this.prtDate = prtDate;
    }

    public Parts withPrtDate(String prtDate) {
        this.prtDate = prtDate;
        return this;
    }

    public String getPrtTime() {
        return prtTime;
    }

    public void setPrtTime(String prtTime) {
        this.prtTime = prtTime;
    }

    public Parts withPrtTime(String prtTime) {
        this.prtTime = prtTime;
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
        dest.writeValue(prtStatus);
        dest.writeValue(prtMultipleBrands);
        dest.writeValue(prtBrand);
        dest.writeValue(prtProfile);
        dest.writeValue(prtColour);
        dest.writeValue(prtDepositReq);
        dest.writeValue(prtDate);
        dest.writeValue(prtTime);
    }

    public int describeContents() {
        return  0;
    }

}
