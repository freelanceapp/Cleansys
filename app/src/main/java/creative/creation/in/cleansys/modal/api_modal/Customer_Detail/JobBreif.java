
package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobBreif implements Parcelable
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
    @SerializedName("jb_site_pre_inspect_compl")
    @Expose
    private String jbSitePreInspectCompl;
    @SerializedName("jb_notes")
    @Expose
    private String jbNotes;
    @SerializedName("jb_site_preInspect_passed")
    @Expose
    private String jbSitePreInspectPassed;
    @SerializedName("jb_if_not_passed_reson")
    @Expose
    private String jbIfNotPassedReson;
    @SerializedName("jb_equip_passed_in_preUseInspect")
    @Expose
    private String jbEquipPassedInPreUseInspect;
    @SerializedName("jb_if_no_noteActionReq")
    @Expose
    private String jbIfNoNoteActionReq;
    @SerializedName("jb_cacelled")
    @Expose
    private String jbCacelled;
    @SerializedName("jb_cancel_reson")
    @Expose
    private String jbCancelReson;
    @SerializedName("jb_other_details")
    @Expose
    private String jbOtherDetails;
    @SerializedName("jb_do_return_to_site")
    @Expose
    private String jbDoReturnToSite;
    @SerializedName("jb_post_inspectCompl")
    @Expose
    private String jbPostInspectCompl;
    @SerializedName("jb_note")
    @Expose
    private String jbNote;
    @SerializedName("jb_date")
    @Expose
    private String jbDate;
    @SerializedName("jb_time")
    @Expose
    private String jbTime;
    public final static Creator<JobBreif> CREATOR = new Creator<JobBreif>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobBreif createFromParcel(Parcel in) {
            return new JobBreif(in);
        }

        public JobBreif[] newArray(int size) {
            return (new JobBreif[size]);
        }

    }
    ;

    protected JobBreif(Parcel in) {
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
        this.jbSitePreInspectCompl = ((String) in.readValue((String.class.getClassLoader())));
        this.jbNotes = ((String) in.readValue((String.class.getClassLoader())));
        this.jbSitePreInspectPassed = ((String) in.readValue((String.class.getClassLoader())));
        this.jbIfNotPassedReson = ((String) in.readValue((String.class.getClassLoader())));
        this.jbEquipPassedInPreUseInspect = ((String) in.readValue((String.class.getClassLoader())));
        this.jbIfNoNoteActionReq = ((String) in.readValue((String.class.getClassLoader())));
        this.jbCacelled = ((String) in.readValue((String.class.getClassLoader())));
        this.jbCancelReson = ((String) in.readValue((String.class.getClassLoader())));
        this.jbOtherDetails = ((String) in.readValue((String.class.getClassLoader())));
        this.jbDoReturnToSite = ((String) in.readValue((String.class.getClassLoader())));
        this.jbPostInspectCompl = ((String) in.readValue((String.class.getClassLoader())));
        this.jbNote = ((String) in.readValue((String.class.getClassLoader())));
        this.jbDate = ((String) in.readValue((String.class.getClassLoader())));
        this.jbTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobBreif() {
    }

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public JobBreif with0(String _0) {
        this._0 = _0;
        return this;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public JobBreif with1(String _1) {
        this._1 = _1;
        return this;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public JobBreif with2(String _2) {
        this._2 = _2;
        return this;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public JobBreif with3(String _3) {
        this._3 = _3;
        return this;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public JobBreif with4(String _4) {
        this._4 = _4;
        return this;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public JobBreif with5(String _5) {
        this._5 = _5;
        return this;
    }

    public String get6() {
        return _6;
    }

    public void set6(String _6) {
        this._6 = _6;
    }

    public JobBreif with6(String _6) {
        this._6 = _6;
        return this;
    }

    public String get7() {
        return _7;
    }

    public void set7(String _7) {
        this._7 = _7;
    }

    public JobBreif with7(String _7) {
        this._7 = _7;
        return this;
    }

    public String get8() {
        return _8;
    }

    public void set8(String _8) {
        this._8 = _8;
    }

    public JobBreif with8(String _8) {
        this._8 = _8;
        return this;
    }

    public String get9() {
        return _9;
    }

    public void set9(String _9) {
        this._9 = _9;
    }

    public JobBreif with9(String _9) {
        this._9 = _9;
        return this;
    }

    public String get10() {
        return _10;
    }

    public void set10(String _10) {
        this._10 = _10;
    }

    public JobBreif with10(String _10) {
        this._10 = _10;
        return this;
    }

    public String get11() {
        return _11;
    }

    public void set11(String _11) {
        this._11 = _11;
    }

    public JobBreif with11(String _11) {
        this._11 = _11;
        return this;
    }

    public String get12() {
        return _12;
    }

    public void set12(String _12) {
        this._12 = _12;
    }

    public JobBreif with12(String _12) {
        this._12 = _12;
        return this;
    }

    public String get13() {
        return _13;
    }

    public void set13(String _13) {
        this._13 = _13;
    }

    public JobBreif with13(String _13) {
        this._13 = _13;
        return this;
    }

    public String get14() {
        return _14;
    }

    public void set14(String _14) {
        this._14 = _14;
    }

    public JobBreif with14(String _14) {
        this._14 = _14;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public JobBreif withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getJbSitePreInspectCompl() {
        return jbSitePreInspectCompl;
    }

    public void setJbSitePreInspectCompl(String jbSitePreInspectCompl) {
        this.jbSitePreInspectCompl = jbSitePreInspectCompl;
    }

    public JobBreif withJbSitePreInspectCompl(String jbSitePreInspectCompl) {
        this.jbSitePreInspectCompl = jbSitePreInspectCompl;
        return this;
    }

    public String getJbNotes() {
        return jbNotes;
    }

    public void setJbNotes(String jbNotes) {
        this.jbNotes = jbNotes;
    }

    public JobBreif withJbNotes(String jbNotes) {
        this.jbNotes = jbNotes;
        return this;
    }

    public String getJbSitePreInspectPassed() {
        return jbSitePreInspectPassed;
    }

    public void setJbSitePreInspectPassed(String jbSitePreInspectPassed) {
        this.jbSitePreInspectPassed = jbSitePreInspectPassed;
    }

    public JobBreif withJbSitePreInspectPassed(String jbSitePreInspectPassed) {
        this.jbSitePreInspectPassed = jbSitePreInspectPassed;
        return this;
    }

    public String getJbIfNotPassedReson() {
        return jbIfNotPassedReson;
    }

    public void setJbIfNotPassedReson(String jbIfNotPassedReson) {
        this.jbIfNotPassedReson = jbIfNotPassedReson;
    }

    public JobBreif withJbIfNotPassedReson(String jbIfNotPassedReson) {
        this.jbIfNotPassedReson = jbIfNotPassedReson;
        return this;
    }

    public String getJbEquipPassedInPreUseInspect() {
        return jbEquipPassedInPreUseInspect;
    }

    public void setJbEquipPassedInPreUseInspect(String jbEquipPassedInPreUseInspect) {
        this.jbEquipPassedInPreUseInspect = jbEquipPassedInPreUseInspect;
    }

    public JobBreif withJbEquipPassedInPreUseInspect(String jbEquipPassedInPreUseInspect) {
        this.jbEquipPassedInPreUseInspect = jbEquipPassedInPreUseInspect;
        return this;
    }

    public String getJbIfNoNoteActionReq() {
        return jbIfNoNoteActionReq;
    }

    public void setJbIfNoNoteActionReq(String jbIfNoNoteActionReq) {
        this.jbIfNoNoteActionReq = jbIfNoNoteActionReq;
    }

    public JobBreif withJbIfNoNoteActionReq(String jbIfNoNoteActionReq) {
        this.jbIfNoNoteActionReq = jbIfNoNoteActionReq;
        return this;
    }

    public String getJbCacelled() {
        return jbCacelled;
    }

    public void setJbCacelled(String jbCacelled) {
        this.jbCacelled = jbCacelled;
    }

    public JobBreif withJbCacelled(String jbCacelled) {
        this.jbCacelled = jbCacelled;
        return this;
    }

    public String getJbCancelReson() {
        return jbCancelReson;
    }

    public void setJbCancelReson(String jbCancelReson) {
        this.jbCancelReson = jbCancelReson;
    }

    public JobBreif withJbCancelReson(String jbCancelReson) {
        this.jbCancelReson = jbCancelReson;
        return this;
    }

    public String getJbOtherDetails() {
        return jbOtherDetails;
    }

    public void setJbOtherDetails(String jbOtherDetails) {
        this.jbOtherDetails = jbOtherDetails;
    }

    public JobBreif withJbOtherDetails(String jbOtherDetails) {
        this.jbOtherDetails = jbOtherDetails;
        return this;
    }

    public String getJbDoReturnToSite() {
        return jbDoReturnToSite;
    }

    public void setJbDoReturnToSite(String jbDoReturnToSite) {
        this.jbDoReturnToSite = jbDoReturnToSite;
    }

    public JobBreif withJbDoReturnToSite(String jbDoReturnToSite) {
        this.jbDoReturnToSite = jbDoReturnToSite;
        return this;
    }

    public String getJbPostInspectCompl() {
        return jbPostInspectCompl;
    }

    public void setJbPostInspectCompl(String jbPostInspectCompl) {
        this.jbPostInspectCompl = jbPostInspectCompl;
    }

    public JobBreif withJbPostInspectCompl(String jbPostInspectCompl) {
        this.jbPostInspectCompl = jbPostInspectCompl;
        return this;
    }

    public String getJbNote() {
        return jbNote;
    }

    public void setJbNote(String jbNote) {
        this.jbNote = jbNote;
    }

    public JobBreif withJbNote(String jbNote) {
        this.jbNote = jbNote;
        return this;
    }

    public String getJbDate() {
        return jbDate;
    }

    public void setJbDate(String jbDate) {
        this.jbDate = jbDate;
    }

    public JobBreif withJbDate(String jbDate) {
        this.jbDate = jbDate;
        return this;
    }

    public String getJbTime() {
        return jbTime;
    }

    public void setJbTime(String jbTime) {
        this.jbTime = jbTime;
    }

    public JobBreif withJbTime(String jbTime) {
        this.jbTime = jbTime;
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
        dest.writeValue(jbSitePreInspectCompl);
        dest.writeValue(jbNotes);
        dest.writeValue(jbSitePreInspectPassed);
        dest.writeValue(jbIfNotPassedReson);
        dest.writeValue(jbEquipPassedInPreUseInspect);
        dest.writeValue(jbIfNoNoteActionReq);
        dest.writeValue(jbCacelled);
        dest.writeValue(jbCancelReson);
        dest.writeValue(jbOtherDetails);
        dest.writeValue(jbDoReturnToSite);
        dest.writeValue(jbPostInspectCompl);
        dest.writeValue(jbNote);
        dest.writeValue(jbDate);
        dest.writeValue(jbTime);
    }

    public int describeContents() {
        return  0;
    }

}
