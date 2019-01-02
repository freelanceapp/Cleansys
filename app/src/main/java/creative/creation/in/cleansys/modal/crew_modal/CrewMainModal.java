package creative.creation.in.cleansys.modal.crew_modal;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CrewMainModal implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private List<CrewUserList> user = new ArrayList<CrewUserList>();
    public final static Parcelable.Creator<CrewMainModal> CREATOR = new Creator<CrewMainModal>() {


        @SuppressWarnings({
                "unchecked"
        })
        public CrewMainModal createFromParcel(Parcel in) {
            return new CrewMainModal(in);
        }

        public CrewMainModal[] newArray(int size) {
            return (new CrewMainModal[size]);
        }

    }
            ;

    protected CrewMainModal(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.user, (CrewUserList.class.getClassLoader()));
    }

    public CrewMainModal() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public CrewMainModal withError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CrewMainModal withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<CrewUserList> getUser() {
        return user;
    }

    public void setUser(List<CrewUserList> user) {
        this.user = user;
    }

    public CrewMainModal withUser(List<CrewUserList> user) {
        this.user = user;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(message);
        dest.writeList(user);
    }

    public int describeContents() {
        return 0;
    }

}