package creative.creation.in.cleansys.modal.crew_modal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CrewUserList implements Parcelable {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("available")
    @Expose
    private String available;
    public final static Parcelable.Creator<CrewUserList> CREATOR = new Creator<CrewUserList>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CrewUserList createFromParcel(Parcel in) {
            return new CrewUserList(in);
        }

        public CrewUserList[] newArray(int size) {
            return (new CrewUserList[size]);
        }

    };

    protected CrewUserList(Parcel in) {
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.userName = ((String) in.readValue((String.class.getClassLoader())));
        this.available = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CrewUserList() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public CrewUserList withUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public CrewUserList withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public CrewUserList withAvailable(String available) {
        this.available = available;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userId);
        dest.writeValue(userName);
        dest.writeValue(available);
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public String toString() {
        return userName;
    }
}
