
package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaskPropertyDetails implements Parcelable
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
    @SerializedName("9")
    @Expose
    private String _9;
    @SerializedName("10")
    @Expose
    private String _10;
    @SerializedName("11")
    @Expose
    private String _11;
    @SerializedName("12")
    @Expose
    private String _12;
    @SerializedName("13")
    @Expose
    private String _13;
    @SerializedName("14")
    @Expose
    private String _14;
    @SerializedName("job_id")
    @Expose
    private String jobId;
    @SerializedName("source_advert")
    @Expose
    private String sourceAdvert;
    @SerializedName("other_advert")
    @Expose
    private String otherAdvert;
    @SerializedName("pd_commercial")
    @Expose
    private String pdCommercial;
    @SerializedName("pd_type")
    @Expose
    private String pdType;
    @SerializedName("num_of_storyes")
    @Expose
    private String numOfStoryes;
    @SerializedName("dormer_windows")
    @Expose
    private String dormerWindows;
    @SerializedName("guttering_on_dormer_win")
    @Expose
    private String gutteringOnDormerWin;
    @SerializedName("mendatory_2_man")
    @Expose
    private String mendatory2Man;
    @SerializedName("long_3_tier_ladder")
    @Expose
    private String long3TierLadder;
    @SerializedName("short_3_tier_ladder")
    @Expose
    private String short3TierLadder;
    @SerializedName("dry_weather_req")
    @Expose
    private String dryWeatherReq;
    @SerializedName("urgent_handover_notes")
    @Expose
    private String urgentHandoverNotes;
    @SerializedName("pd_date")
    @Expose
    private String pdDate;
    @SerializedName("pd_time")
    @Expose
    private String pdTime;
    public final static Creator<TaskPropertyDetails> CREATOR = new Creator<TaskPropertyDetails>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TaskPropertyDetails createFromParcel(Parcel in) {
            return new TaskPropertyDetails(in);
        }

        public TaskPropertyDetails[] newArray(int size) {
            return (new TaskPropertyDetails[size]);
        }

    }
    ;

    protected TaskPropertyDetails(Parcel in) {
        this._0 = ((String) in.readValue((String.class.getClassLoader())));
        this._1 = ((String) in.readValue((String.class.getClassLoader())));
        this._2 = ((String) in.readValue((String.class.getClassLoader())));
        this._3 = ((String) in.readValue((String.class.getClassLoader())));
        this._4 = ((String) in.readValue((String.class.getClassLoader())));
        this._5 = ((String) in.readValue((String.class.getClassLoader())));
        this._6 = ((String) in.readValue((String.class.getClassLoader())));
        this._7 = ((String) in.readValue((String.class.getClassLoader())));
        this._8 = ((String) in.readValue((String.class.getClassLoader())));
        this._9 = ((String) in.readValue((String.class.getClassLoader())));
        this._10 = ((String) in.readValue((String.class.getClassLoader())));
        this._11 = ((String) in.readValue((String.class.getClassLoader())));
        this._12 = ((String) in.readValue((String.class.getClassLoader())));
        this._13 = ((String) in.readValue((String.class.getClassLoader())));
        this._14 = ((String) in.readValue((String.class.getClassLoader())));
        this.jobId = ((String) in.readValue((String.class.getClassLoader())));
        this.sourceAdvert = ((String) in.readValue((String.class.getClassLoader())));
        this.otherAdvert = ((String) in.readValue((String.class.getClassLoader())));
        this.pdCommercial = ((String) in.readValue((String.class.getClassLoader())));
        this.pdType = ((String) in.readValue((String.class.getClassLoader())));
        this.numOfStoryes = ((String) in.readValue((String.class.getClassLoader())));
        this.dormerWindows = ((String) in.readValue((String.class.getClassLoader())));
        this.gutteringOnDormerWin = ((String) in.readValue((String.class.getClassLoader())));
        this.mendatory2Man = ((String) in.readValue((String.class.getClassLoader())));
        this.long3TierLadder = ((String) in.readValue((String.class.getClassLoader())));
        this.short3TierLadder = ((String) in.readValue((String.class.getClassLoader())));
        this.dryWeatherReq = ((String) in.readValue((String.class.getClassLoader())));
        this.urgentHandoverNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.pdDate = ((String) in.readValue((String.class.getClassLoader())));
        this.pdTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TaskPropertyDetails() {
    }

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public TaskPropertyDetails with0(String _0) {
        this._0 = _0;
        return this;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public TaskPropertyDetails with1(String _1) {
        this._1 = _1;
        return this;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public TaskPropertyDetails with2(String _2) {
        this._2 = _2;
        return this;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public TaskPropertyDetails with3(String _3) {
        this._3 = _3;
        return this;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public TaskPropertyDetails with4(String _4) {
        this._4 = _4;
        return this;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public TaskPropertyDetails with5(String _5) {
        this._5 = _5;
        return this;
    }

    public String get6() {
        return _6;
    }

    public void set6(String _6) {
        this._6 = _6;
    }

    public TaskPropertyDetails with6(String _6) {
        this._6 = _6;
        return this;
    }

    public String get7() {
        return _7;
    }

    public void set7(String _7) {
        this._7 = _7;
    }

    public TaskPropertyDetails with7(String _7) {
        this._7 = _7;
        return this;
    }

    public String get8() {
        return _8;
    }

    public void set8(String _8) {
        this._8 = _8;
    }

    public TaskPropertyDetails with8(String _8) {
        this._8 = _8;
        return this;
    }

    public String get9() {
        return _9;
    }

    public void set9(String _9) {
        this._9 = _9;
    }

    public TaskPropertyDetails with9(String _9) {
        this._9 = _9;
        return this;
    }

    public String get10() {
        return _10;
    }

    public void set10(String _10) {
        this._10 = _10;
    }

    public TaskPropertyDetails with10(String _10) {
        this._10 = _10;
        return this;
    }

    public String get11() {
        return _11;
    }

    public void set11(String _11) {
        this._11 = _11;
    }

    public TaskPropertyDetails with11(String _11) {
        this._11 = _11;
        return this;
    }

    public String get12() {
        return _12;
    }

    public void set12(String _12) {
        this._12 = _12;
    }

    public TaskPropertyDetails with12(String _12) {
        this._12 = _12;
        return this;
    }

    public String get13() {
        return _13;
    }

    public void set13(String _13) {
        this._13 = _13;
    }

    public TaskPropertyDetails with13(String _13) {
        this._13 = _13;
        return this;
    }

    public String get14() {
        return _14;
    }

    public void set14(String _14) {
        this._14 = _14;
    }

    public TaskPropertyDetails with14(String _14) {
        this._14 = _14;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public TaskPropertyDetails withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getSourceAdvert() {
        return sourceAdvert;
    }

    public void setSourceAdvert(String sourceAdvert) {
        this.sourceAdvert = sourceAdvert;
    }

    public TaskPropertyDetails withSourceAdvert(String sourceAdvert) {
        this.sourceAdvert = sourceAdvert;
        return this;
    }

    public String getOtherAdvert() {
        return otherAdvert;
    }

    public void setOtherAdvert(String otherAdvert) {
        this.otherAdvert = otherAdvert;
    }

    public TaskPropertyDetails withOtherAdvert(String otherAdvert) {
        this.otherAdvert = otherAdvert;
        return this;
    }

    public String getPdCommercial() {
        return pdCommercial;
    }

    public void setPdCommercial(String pdCommercial) {
        this.pdCommercial = pdCommercial;
    }

    public TaskPropertyDetails withPdCommercial(String pdCommercial) {
        this.pdCommercial = pdCommercial;
        return this;
    }

    public String getPdType() {
        return pdType;
    }

    public void setPdType(String pdType) {
        this.pdType = pdType;
    }

    public TaskPropertyDetails withPdType(String pdType) {
        this.pdType = pdType;
        return this;
    }

    public String getNumOfStoryes() {
        return numOfStoryes;
    }

    public void setNumOfStoryes(String numOfStoryes) {
        this.numOfStoryes = numOfStoryes;
    }

    public TaskPropertyDetails withNumOfStoryes(String numOfStoryes) {
        this.numOfStoryes = numOfStoryes;
        return this;
    }

    public String getDormerWindows() {
        return dormerWindows;
    }

    public void setDormerWindows(String dormerWindows) {
        this.dormerWindows = dormerWindows;
    }

    public TaskPropertyDetails withDormerWindows(String dormerWindows) {
        this.dormerWindows = dormerWindows;
        return this;
    }

    public String getGutteringOnDormerWin() {
        return gutteringOnDormerWin;
    }

    public void setGutteringOnDormerWin(String gutteringOnDormerWin) {
        this.gutteringOnDormerWin = gutteringOnDormerWin;
    }

    public TaskPropertyDetails withGutteringOnDormerWin(String gutteringOnDormerWin) {
        this.gutteringOnDormerWin = gutteringOnDormerWin;
        return this;
    }

    public String getMendatory2Man() {
        return mendatory2Man;
    }

    public void setMendatory2Man(String mendatory2Man) {
        this.mendatory2Man = mendatory2Man;
    }

    public TaskPropertyDetails withMendatory2Man(String mendatory2Man) {
        this.mendatory2Man = mendatory2Man;
        return this;
    }

    public String getLong3TierLadder() {
        return long3TierLadder;
    }

    public void setLong3TierLadder(String long3TierLadder) {
        this.long3TierLadder = long3TierLadder;
    }

    public TaskPropertyDetails withLong3TierLadder(String long3TierLadder) {
        this.long3TierLadder = long3TierLadder;
        return this;
    }

    public String getShort3TierLadder() {
        return short3TierLadder;
    }

    public void setShort3TierLadder(String short3TierLadder) {
        this.short3TierLadder = short3TierLadder;
    }

    public TaskPropertyDetails withShort3TierLadder(String short3TierLadder) {
        this.short3TierLadder = short3TierLadder;
        return this;
    }

    public String getDryWeatherReq() {
        return dryWeatherReq;
    }

    public void setDryWeatherReq(String dryWeatherReq) {
        this.dryWeatherReq = dryWeatherReq;
    }

    public TaskPropertyDetails withDryWeatherReq(String dryWeatherReq) {
        this.dryWeatherReq = dryWeatherReq;
        return this;
    }

    public String getUrgentHandoverNotes() {
        return urgentHandoverNotes;
    }

    public void setUrgentHandoverNotes(String urgentHandoverNotes) {
        this.urgentHandoverNotes = urgentHandoverNotes;
    }

    public TaskPropertyDetails withUrgentHandoverNotes(String urgentHandoverNotes) {
        this.urgentHandoverNotes = urgentHandoverNotes;
        return this;
    }

    public String getPdDate() {
        return pdDate;
    }

    public void setPdDate(String pdDate) {
        this.pdDate = pdDate;
    }

    public TaskPropertyDetails withPdDate(String pdDate) {
        this.pdDate = pdDate;
        return this;
    }

    public String getPdTime() {
        return pdTime;
    }

    public void setPdTime(String pdTime) {
        this.pdTime = pdTime;
    }

    public TaskPropertyDetails withPdTime(String pdTime) {
        this.pdTime = pdTime;
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
        dest.writeValue(_9);
        dest.writeValue(_10);
        dest.writeValue(_11);
        dest.writeValue(_12);
        dest.writeValue(_13);
        dest.writeValue(_14);
        dest.writeValue(jobId);
        dest.writeValue(sourceAdvert);
        dest.writeValue(otherAdvert);
        dest.writeValue(pdCommercial);
        dest.writeValue(pdType);
        dest.writeValue(numOfStoryes);
        dest.writeValue(dormerWindows);
        dest.writeValue(gutteringOnDormerWin);
        dest.writeValue(mendatory2Man);
        dest.writeValue(long3TierLadder);
        dest.writeValue(short3TierLadder);
        dest.writeValue(dryWeatherReq);
        dest.writeValue(urgentHandoverNotes);
        dest.writeValue(pdDate);
        dest.writeValue(pdTime);
    }

    public int describeContents() {
        return  0;
    }

}
