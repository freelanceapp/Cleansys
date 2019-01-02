
package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QouteDeriefFollowUp implements Parcelable
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
    @SerializedName("qd_by")
    @Expose
    private String qdBy;
    @SerializedName("qd_tech_written_quote_copy_attached")
    @Expose
    private String qdTechWrittenQuoteCopyAttached;
    @SerializedName("qd_visited_not_given_reason")
    @Expose
    private String qdVisitedNotGivenReason;
    @SerializedName("qd_discus_with_customer")
    @Expose
    private String qdDiscusWithCustomer;
    @SerializedName("qd_send_to_cust")
    @Expose
    private String qdSendToCust;
    @SerializedName("qd_cancelled_no_action")
    @Expose
    private String qdCancelledNoAction;
    @SerializedName("qd_cancelled_reason")
    @Expose
    private String qdCancelledReason;
    @SerializedName("qd_reschedule_req")
    @Expose
    private String qdRescheduleReq;
    @SerializedName("quote_instn_conver")
    @Expose
    private String quoteInstnConver;
    @SerializedName("qd_book_date")
    @Expose
    private String qdBookDate;
    @SerializedName("qd_book_time")
    @Expose
    private String qdBookTime;
    @SerializedName("qd_book_tech")
    @Expose
    private String qdBookTech;
    @SerializedName("qd_date")
    @Expose
    private String qdDate;
    @SerializedName("qd_time")
    @Expose
    private String qdTime;
    public final static Creator<QouteDeriefFollowUp> CREATOR = new Creator<QouteDeriefFollowUp>() {


        @SuppressWarnings({
            "unchecked"
        })
        public QouteDeriefFollowUp createFromParcel(Parcel in) {
            return new QouteDeriefFollowUp(in);
        }

        public QouteDeriefFollowUp[] newArray(int size) {
            return (new QouteDeriefFollowUp[size]);
        }

    }
    ;

    protected QouteDeriefFollowUp(Parcel in) {
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
        this.qdBy = ((String) in.readValue((String.class.getClassLoader())));
        this.qdTechWrittenQuoteCopyAttached = ((String) in.readValue((String.class.getClassLoader())));
        this.qdVisitedNotGivenReason = ((String) in.readValue((String.class.getClassLoader())));
        this.qdDiscusWithCustomer = ((String) in.readValue((String.class.getClassLoader())));
        this.qdSendToCust = ((String) in.readValue((String.class.getClassLoader())));
        this.qdCancelledNoAction = ((String) in.readValue((String.class.getClassLoader())));
        this.qdCancelledReason = ((String) in.readValue((String.class.getClassLoader())));
        this.qdRescheduleReq = ((String) in.readValue((String.class.getClassLoader())));
        this.quoteInstnConver = ((String) in.readValue((String.class.getClassLoader())));
        this.qdBookDate = ((String) in.readValue((String.class.getClassLoader())));
        this.qdBookTime = ((String) in.readValue((String.class.getClassLoader())));
        this.qdBookTech = ((String) in.readValue((String.class.getClassLoader())));
        this.qdDate = ((String) in.readValue((String.class.getClassLoader())));
        this.qdTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public QouteDeriefFollowUp() {
    }

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public QouteDeriefFollowUp with0(String _0) {
        this._0 = _0;
        return this;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public QouteDeriefFollowUp with1(String _1) {
        this._1 = _1;
        return this;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public QouteDeriefFollowUp with2(String _2) {
        this._2 = _2;
        return this;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public QouteDeriefFollowUp with3(String _3) {
        this._3 = _3;
        return this;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public QouteDeriefFollowUp with4(String _4) {
        this._4 = _4;
        return this;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public QouteDeriefFollowUp with5(String _5) {
        this._5 = _5;
        return this;
    }

    public String get6() {
        return _6;
    }

    public void set6(String _6) {
        this._6 = _6;
    }

    public QouteDeriefFollowUp with6(String _6) {
        this._6 = _6;
        return this;
    }

    public String get7() {
        return _7;
    }

    public void set7(String _7) {
        this._7 = _7;
    }

    public QouteDeriefFollowUp with7(String _7) {
        this._7 = _7;
        return this;
    }

    public String get8() {
        return _8;
    }

    public void set8(String _8) {
        this._8 = _8;
    }

    public QouteDeriefFollowUp with8(String _8) {
        this._8 = _8;
        return this;
    }

    public String get9() {
        return _9;
    }

    public void set9(String _9) {
        this._9 = _9;
    }

    public QouteDeriefFollowUp with9(String _9) {
        this._9 = _9;
        return this;
    }

    public String get10() {
        return _10;
    }

    public void set10(String _10) {
        this._10 = _10;
    }

    public QouteDeriefFollowUp with10(String _10) {
        this._10 = _10;
        return this;
    }

    public String get11() {
        return _11;
    }

    public void set11(String _11) {
        this._11 = _11;
    }

    public QouteDeriefFollowUp with11(String _11) {
        this._11 = _11;
        return this;
    }

    public String get12() {
        return _12;
    }

    public void set12(String _12) {
        this._12 = _12;
    }

    public QouteDeriefFollowUp with12(String _12) {
        this._12 = _12;
        return this;
    }

    public String get13() {
        return _13;
    }

    public void set13(String _13) {
        this._13 = _13;
    }

    public QouteDeriefFollowUp with13(String _13) {
        this._13 = _13;
        return this;
    }

    public String get14() {
        return _14;
    }

    public void set14(String _14) {
        this._14 = _14;
    }

    public QouteDeriefFollowUp with14(String _14) {
        this._14 = _14;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public QouteDeriefFollowUp withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getQdBy() {
        return qdBy;
    }

    public void setQdBy(String qdBy) {
        this.qdBy = qdBy;
    }

    public QouteDeriefFollowUp withQdBy(String qdBy) {
        this.qdBy = qdBy;
        return this;
    }

    public String getQdTechWrittenQuoteCopyAttached() {
        return qdTechWrittenQuoteCopyAttached;
    }

    public void setQdTechWrittenQuoteCopyAttached(String qdTechWrittenQuoteCopyAttached) {
        this.qdTechWrittenQuoteCopyAttached = qdTechWrittenQuoteCopyAttached;
    }

    public QouteDeriefFollowUp withQdTechWrittenQuoteCopyAttached(String qdTechWrittenQuoteCopyAttached) {
        this.qdTechWrittenQuoteCopyAttached = qdTechWrittenQuoteCopyAttached;
        return this;
    }

    public String getQdVisitedNotGivenReason() {
        return qdVisitedNotGivenReason;
    }

    public void setQdVisitedNotGivenReason(String qdVisitedNotGivenReason) {
        this.qdVisitedNotGivenReason = qdVisitedNotGivenReason;
    }

    public QouteDeriefFollowUp withQdVisitedNotGivenReason(String qdVisitedNotGivenReason) {
        this.qdVisitedNotGivenReason = qdVisitedNotGivenReason;
        return this;
    }

    public String getQdDiscusWithCustomer() {
        return qdDiscusWithCustomer;
    }

    public void setQdDiscusWithCustomer(String qdDiscusWithCustomer) {
        this.qdDiscusWithCustomer = qdDiscusWithCustomer;
    }

    public QouteDeriefFollowUp withQdDiscusWithCustomer(String qdDiscusWithCustomer) {
        this.qdDiscusWithCustomer = qdDiscusWithCustomer;
        return this;
    }

    public String getQdSendToCust() {
        return qdSendToCust;
    }

    public void setQdSendToCust(String qdSendToCust) {
        this.qdSendToCust = qdSendToCust;
    }

    public QouteDeriefFollowUp withQdSendToCust(String qdSendToCust) {
        this.qdSendToCust = qdSendToCust;
        return this;
    }

    public String getQdCancelledNoAction() {
        return qdCancelledNoAction;
    }

    public void setQdCancelledNoAction(String qdCancelledNoAction) {
        this.qdCancelledNoAction = qdCancelledNoAction;
    }

    public QouteDeriefFollowUp withQdCancelledNoAction(String qdCancelledNoAction) {
        this.qdCancelledNoAction = qdCancelledNoAction;
        return this;
    }

    public String getQdCancelledReason() {
        return qdCancelledReason;
    }

    public void setQdCancelledReason(String qdCancelledReason) {
        this.qdCancelledReason = qdCancelledReason;
    }

    public QouteDeriefFollowUp withQdCancelledReason(String qdCancelledReason) {
        this.qdCancelledReason = qdCancelledReason;
        return this;
    }

    public String getQdRescheduleReq() {
        return qdRescheduleReq;
    }

    public void setQdRescheduleReq(String qdRescheduleReq) {
        this.qdRescheduleReq = qdRescheduleReq;
    }

    public QouteDeriefFollowUp withQdRescheduleReq(String qdRescheduleReq) {
        this.qdRescheduleReq = qdRescheduleReq;
        return this;
    }

    public String getQuoteInstnConver() {
        return quoteInstnConver;
    }

    public void setQuoteInstnConver(String quoteInstnConver) {
        this.quoteInstnConver = quoteInstnConver;
    }

    public QouteDeriefFollowUp withQuoteInstnConver(String quoteInstnConver) {
        this.quoteInstnConver = quoteInstnConver;
        return this;
    }

    public String getQdBookDate() {
        return qdBookDate;
    }

    public void setQdBookDate(String qdBookDate) {
        this.qdBookDate = qdBookDate;
    }

    public QouteDeriefFollowUp withQdBookDate(String qdBookDate) {
        this.qdBookDate = qdBookDate;
        return this;
    }

    public String getQdBookTime() {
        return qdBookTime;
    }

    public void setQdBookTime(String qdBookTime) {
        this.qdBookTime = qdBookTime;
    }

    public QouteDeriefFollowUp withQdBookTime(String qdBookTime) {
        this.qdBookTime = qdBookTime;
        return this;
    }

    public String getQdBookTech() {
        return qdBookTech;
    }

    public void setQdBookTech(String qdBookTech) {
        this.qdBookTech = qdBookTech;
    }

    public QouteDeriefFollowUp withQdBookTech(String qdBookTech) {
        this.qdBookTech = qdBookTech;
        return this;
    }

    public String getQdDate() {
        return qdDate;
    }

    public void setQdDate(String qdDate) {
        this.qdDate = qdDate;
    }

    public QouteDeriefFollowUp withQdDate(String qdDate) {
        this.qdDate = qdDate;
        return this;
    }

    public String getQdTime() {
        return qdTime;
    }

    public void setQdTime(String qdTime) {
        this.qdTime = qdTime;
    }

    public QouteDeriefFollowUp withQdTime(String qdTime) {
        this.qdTime = qdTime;
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
        dest.writeValue(qdBy);
        dest.writeValue(qdTechWrittenQuoteCopyAttached);
        dest.writeValue(qdVisitedNotGivenReason);
        dest.writeValue(qdDiscusWithCustomer);
        dest.writeValue(qdSendToCust);
        dest.writeValue(qdCancelledNoAction);
        dest.writeValue(qdCancelledReason);
        dest.writeValue(qdRescheduleReq);
        dest.writeValue(quoteInstnConver);
        dest.writeValue(qdBookDate);
        dest.writeValue(qdBookTime);
        dest.writeValue(qdBookTech);
        dest.writeValue(qdDate);
        dest.writeValue(qdTime);
    }

    public int describeContents() {
        return  0;
    }

}
