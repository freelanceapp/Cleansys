package creative.creation.in.cleansys.modal.api_modal.Customer_Detail;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerCrewData implements Parcelable
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
    @SerializedName("usr_id")
    @Expose
    private String usrId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_email")
    @Expose
    private String userEmail;
    @SerializedName("user_device")
    @Expose
    private String userDevice;
    @SerializedName("user_role")
    @Expose
    private String userRole;
    @SerializedName("user_rights")
    @Expose
    private String userRights;
    @SerializedName("user_joined_on")
    @Expose
    private String userJoinedOn;
    @SerializedName("user_work_start")
    @Expose
    private String userWorkStart;
    @SerializedName("user_work_finish")
    @Expose
    private String userWorkFinish;
    @SerializedName("user_date")
    @Expose
    private String userDate;
    @SerializedName("user_time")
    @Expose
    private String userTime;
    public final static Parcelable.Creator<CustomerCrewData> CREATOR = new Creator<CustomerCrewData>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CustomerCrewData createFromParcel(Parcel in) {
            return new CustomerCrewData(in);
        }

        public CustomerCrewData[] newArray(int size) {
            return (new CustomerCrewData[size]);
        }

    }
            ;

    protected CustomerCrewData(Parcel in) {
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
        this.usrId = ((String) in.readValue((String.class.getClassLoader())));
        this.userName = ((String) in.readValue((String.class.getClassLoader())));
        this.userEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.userDevice = ((String) in.readValue((String.class.getClassLoader())));
        this.userRole = ((String) in.readValue((String.class.getClassLoader())));
        this.userRights = ((String) in.readValue((String.class.getClassLoader())));
        this.userJoinedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.userWorkStart = ((String) in.readValue((String.class.getClassLoader())));
        this.userWorkFinish = ((String) in.readValue((String.class.getClassLoader())));
        this.userDate = ((String) in.readValue((String.class.getClassLoader())));
        this.userTime = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CustomerCrewData() {
    }

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public String get6() {
        return _6;
    }

    public void set6(String _6) {
        this._6 = _6;
    }

    public String get7() {
        return _7;
    }

    public void set7(String _7) {
        this._7 = _7;
    }

    public String get8() {
        return _8;
    }

    public void set8(String _8) {
        this._8 = _8;
    }

    public String get9() {
        return _9;
    }

    public void set9(String _9) {
        this._9 = _9;
    }

    public String get10() {
        return _10;
    }

    public void set10(String _10) {
        this._10 = _10;
    }

    public String getUsrId() {
        return usrId;
    }

    public void setUsrId(String usrId) {
        this.usrId = usrId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(String userDevice) {
        this.userDevice = userDevice;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRights() {
        return userRights;
    }

    public void setUserRights(String userRights) {
        this.userRights = userRights;
    }

    public String getUserJoinedOn() {
        return userJoinedOn;
    }

    public void setUserJoinedOn(String userJoinedOn) {
        this.userJoinedOn = userJoinedOn;
    }

    public String getUserWorkStart() {
        return userWorkStart;
    }

    public void setUserWorkStart(String userWorkStart) {
        this.userWorkStart = userWorkStart;
    }

    public String getUserWorkFinish() {
        return userWorkFinish;
    }

    public void setUserWorkFinish(String userWorkFinish) {
        this.userWorkFinish = userWorkFinish;
    }

    public String getUserDate() {
        return userDate;
    }

    public void setUserDate(String userDate) {
        this.userDate = userDate;
    }

    public String getUserTime() {
        return userTime;
    }

    public void setUserTime(String userTime) {
        this.userTime = userTime;
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
        dest.writeValue(usrId);
        dest.writeValue(userName);
        dest.writeValue(userEmail);
        dest.writeValue(userDevice);
        dest.writeValue(userRole);
        dest.writeValue(userRights);
        dest.writeValue(userJoinedOn);
        dest.writeValue(userWorkStart);
        dest.writeValue(userWorkFinish);
        dest.writeValue(userDate);
        dest.writeValue(userTime);
    }

    public int describeContents() {
        return 0;
    }

}