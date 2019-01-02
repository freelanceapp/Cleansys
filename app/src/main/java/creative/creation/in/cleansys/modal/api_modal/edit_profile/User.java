
package creative.creation.in.cleansys.modal.api_modal.edit_profile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable
{

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_fullname")
    @Expose
    private String userFullname;
    @SerializedName("user_profile_pic")
    @Expose
    private String userProfilePic;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("user_registration_date")
    @Expose
    private String userRegistrationDate;
    public final static Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
            "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
    ;

    protected User(Parcel in) {
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.userFullname = ((String) in.readValue((String.class.getClassLoader())));
        this.userProfilePic = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.userRegistrationDate = ((String) in.readValue((String.class.getClassLoader())));
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserFullname() {
        return userFullname;
    }

    public void setUserFullname(String userFullname) {
        this.userFullname = userFullname;
    }

    public User withUserFullname(String userFullname) {
        this.userFullname = userFullname;
        return this;
    }

    public String getUserProfilePic() {
        return userProfilePic;
    }

    public void setUserProfilePic(String userProfilePic) {
        this.userProfilePic = userProfilePic;
    }

    public User withUserProfilePic(String userProfilePic) {
        this.userProfilePic = userProfilePic;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public User withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(String userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    public User withUserRegistrationDate(String userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userId);
        dest.writeValue(userFullname);
        dest.writeValue(userProfilePic);
        dest.writeValue(email);
        dest.writeValue(phone);
        dest.writeValue(userRegistrationDate);
    }

    public int describeContents() {
        return  0;
    }

}
