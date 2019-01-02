
package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaymentDetails implements Parcelable
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
    @SerializedName("job_id")
    @Expose
    private String jobId;
    @SerializedName("payd_date_deposti_recieve")
    @Expose
    private String paydDateDepostiRecieve;
    @SerializedName("payd_deposit_amount")
    @Expose
    private String paydDepositAmount;
    @SerializedName("payd_invoice_number")
    @Expose
    private String paydInvoiceNumber;
    @SerializedName("payd_status")
    @Expose
    private String paydStatus;
    @SerializedName("payd_compl_payment_recieve")
    @Expose
    private String paydComplPaymentRecieve;
    @SerializedName("payd_compl_payment_recieve_date")
    @Expose
    private String paydComplPaymentRecieveDate;
    @SerializedName("payd_nonPayment_reason")
    @Expose
    private String paydNonPaymentReason;
    @SerializedName("payd_method")
    @Expose
    private String paydMethod;
    @SerializedName("payd_card_auth_code")
    @Expose
    private String paydCardAuthCode;
    @SerializedName("payd_invoice_status")
    @Expose
    private String paydInvoiceStatus;
    @SerializedName("payd_date")
    @Expose
    private String paydDate;
    @SerializedName("payd_time")
    @Expose
    private String paydTime;
    public final static Creator<PaymentDetails> CREATOR = new Creator<PaymentDetails>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PaymentDetails createFromParcel(Parcel in) {
            return new PaymentDetails(in);
        }

        public PaymentDetails[] newArray(int size) {
            return (new PaymentDetails[size]);
        }

    }
    ;

    protected PaymentDetails(Parcel in) {
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
        this.jobId = ((String) in.readValue((String.class.getClassLoader())));
        this.paydDateDepostiRecieve = ((String) in.readValue((String.class.getClassLoader())));
        this.paydDepositAmount = ((String) in.readValue((String.class.getClassLoader())));
        this.paydInvoiceNumber = ((String) in.readValue((String.class.getClassLoader())));
        this.paydStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.paydComplPaymentRecieve = ((String) in.readValue((String.class.getClassLoader())));
        this.paydComplPaymentRecieveDate = ((String) in.readValue((String.class.getClassLoader())));
        this.paydNonPaymentReason = ((String) in.readValue((String.class.getClassLoader())));
        this.paydMethod = ((String) in.readValue((String.class.getClassLoader())));
        this.paydCardAuthCode = ((String) in.readValue((String.class.getClassLoader())));
        this.paydInvoiceStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.paydDate = ((String) in.readValue((String.class.getClassLoader())));
        this.paydTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PaymentDetails() {
    }

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public PaymentDetails with0(String _0) {
        this._0 = _0;
        return this;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public PaymentDetails with1(String _1) {
        this._1 = _1;
        return this;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public PaymentDetails with2(String _2) {
        this._2 = _2;
        return this;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public PaymentDetails with3(String _3) {
        this._3 = _3;
        return this;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public PaymentDetails with4(String _4) {
        this._4 = _4;
        return this;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public PaymentDetails with5(String _5) {
        this._5 = _5;
        return this;
    }

    public String get6() {
        return _6;
    }

    public void set6(String _6) {
        this._6 = _6;
    }

    public PaymentDetails with6(String _6) {
        this._6 = _6;
        return this;
    }

    public String get7() {
        return _7;
    }

    public void set7(String _7) {
        this._7 = _7;
    }

    public PaymentDetails with7(String _7) {
        this._7 = _7;
        return this;
    }

    public String get8() {
        return _8;
    }

    public void set8(String _8) {
        this._8 = _8;
    }

    public PaymentDetails with8(String _8) {
        this._8 = _8;
        return this;
    }

    public String get9() {
        return _9;
    }

    public void set9(String _9) {
        this._9 = _9;
    }

    public PaymentDetails with9(String _9) {
        this._9 = _9;
        return this;
    }

    public String get10() {
        return _10;
    }

    public void set10(String _10) {
        this._10 = _10;
    }

    public PaymentDetails with10(String _10) {
        this._10 = _10;
        return this;
    }

    public String get11() {
        return _11;
    }

    public void set11(String _11) {
        this._11 = _11;
    }

    public PaymentDetails with11(String _11) {
        this._11 = _11;
        return this;
    }

    public String get12() {
        return _12;
    }

    public void set12(String _12) {
        this._12 = _12;
    }

    public PaymentDetails with12(String _12) {
        this._12 = _12;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public PaymentDetails withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getPaydDateDepostiRecieve() {
        return paydDateDepostiRecieve;
    }

    public void setPaydDateDepostiRecieve(String paydDateDepostiRecieve) {
        this.paydDateDepostiRecieve = paydDateDepostiRecieve;
    }

    public PaymentDetails withPaydDateDepostiRecieve(String paydDateDepostiRecieve) {
        this.paydDateDepostiRecieve = paydDateDepostiRecieve;
        return this;
    }

    public String getPaydDepositAmount() {
        return paydDepositAmount;
    }

    public void setPaydDepositAmount(String paydDepositAmount) {
        this.paydDepositAmount = paydDepositAmount;
    }

    public PaymentDetails withPaydDepositAmount(String paydDepositAmount) {
        this.paydDepositAmount = paydDepositAmount;
        return this;
    }

    public String getPaydInvoiceNumber() {
        return paydInvoiceNumber;
    }

    public void setPaydInvoiceNumber(String paydInvoiceNumber) {
        this.paydInvoiceNumber = paydInvoiceNumber;
    }

    public PaymentDetails withPaydInvoiceNumber(String paydInvoiceNumber) {
        this.paydInvoiceNumber = paydInvoiceNumber;
        return this;
    }

    public String getPaydStatus() {
        return paydStatus;
    }

    public void setPaydStatus(String paydStatus) {
        this.paydStatus = paydStatus;
    }

    public PaymentDetails withPaydStatus(String paydStatus) {
        this.paydStatus = paydStatus;
        return this;
    }

    public String getPaydComplPaymentRecieve() {
        return paydComplPaymentRecieve;
    }

    public void setPaydComplPaymentRecieve(String paydComplPaymentRecieve) {
        this.paydComplPaymentRecieve = paydComplPaymentRecieve;
    }

    public PaymentDetails withPaydComplPaymentRecieve(String paydComplPaymentRecieve) {
        this.paydComplPaymentRecieve = paydComplPaymentRecieve;
        return this;
    }

    public String getPaydComplPaymentRecieveDate() {
        return paydComplPaymentRecieveDate;
    }

    public void setPaydComplPaymentRecieveDate(String paydComplPaymentRecieveDate) {
        this.paydComplPaymentRecieveDate = paydComplPaymentRecieveDate;
    }

    public PaymentDetails withPaydComplPaymentRecieveDate(String paydComplPaymentRecieveDate) {
        this.paydComplPaymentRecieveDate = paydComplPaymentRecieveDate;
        return this;
    }

    public String getPaydNonPaymentReason() {
        return paydNonPaymentReason;
    }

    public void setPaydNonPaymentReason(String paydNonPaymentReason) {
        this.paydNonPaymentReason = paydNonPaymentReason;
    }

    public PaymentDetails withPaydNonPaymentReason(String paydNonPaymentReason) {
        this.paydNonPaymentReason = paydNonPaymentReason;
        return this;
    }

    public String getPaydMethod() {
        return paydMethod;
    }

    public void setPaydMethod(String paydMethod) {
        this.paydMethod = paydMethod;
    }

    public PaymentDetails withPaydMethod(String paydMethod) {
        this.paydMethod = paydMethod;
        return this;
    }

    public String getPaydCardAuthCode() {
        return paydCardAuthCode;
    }

    public void setPaydCardAuthCode(String paydCardAuthCode) {
        this.paydCardAuthCode = paydCardAuthCode;
    }

    public PaymentDetails withPaydCardAuthCode(String paydCardAuthCode) {
        this.paydCardAuthCode = paydCardAuthCode;
        return this;
    }

    public String getPaydInvoiceStatus() {
        return paydInvoiceStatus;
    }

    public void setPaydInvoiceStatus(String paydInvoiceStatus) {
        this.paydInvoiceStatus = paydInvoiceStatus;
    }

    public PaymentDetails withPaydInvoiceStatus(String paydInvoiceStatus) {
        this.paydInvoiceStatus = paydInvoiceStatus;
        return this;
    }

    public String getPaydDate() {
        return paydDate;
    }

    public void setPaydDate(String paydDate) {
        this.paydDate = paydDate;
    }

    public PaymentDetails withPaydDate(String paydDate) {
        this.paydDate = paydDate;
        return this;
    }

    public String getPaydTime() {
        return paydTime;
    }

    public void setPaydTime(String paydTime) {
        this.paydTime = paydTime;
    }

    public PaymentDetails withPaydTime(String paydTime) {
        this.paydTime = paydTime;
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
        dest.writeValue(jobId);
        dest.writeValue(paydDateDepostiRecieve);
        dest.writeValue(paydDepositAmount);
        dest.writeValue(paydInvoiceNumber);
        dest.writeValue(paydStatus);
        dest.writeValue(paydComplPaymentRecieve);
        dest.writeValue(paydComplPaymentRecieveDate);
        dest.writeValue(paydNonPaymentReason);
        dest.writeValue(paydMethod);
        dest.writeValue(paydCardAuthCode);
        dest.writeValue(paydInvoiceStatus);
        dest.writeValue(paydDate);
        dest.writeValue(paydTime);
    }

    public int describeContents() {
        return  0;
    }

}
