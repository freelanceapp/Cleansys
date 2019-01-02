
package creative.creation.in.cleansys.modal.api_modal.FellowUp_responce;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FellowUpModel implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private List<FellowupUser> user = new ArrayList<FellowupUser>();
    public final static Creator<FellowUpModel> CREATOR = new Creator<FellowUpModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FellowUpModel createFromParcel(Parcel in) {
            return new FellowUpModel(in);
        }

        public FellowUpModel[] newArray(int size) {
            return (new FellowUpModel[size]);
        }

    }
    ;

    protected FellowUpModel(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.user, (FellowupUser.class.getClassLoader()));
    }

    public FellowUpModel() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public FellowUpModel withError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FellowUpModel withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<FellowupUser> getUser() {
        return user;
    }

    public void setUser(List<FellowupUser> user) {
        this.user = user;
    }

    public FellowUpModel withUser(List<FellowupUser> user) {
        this.user = user;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(message);
        dest.writeList(user);
    }

    public int describeContents() {
        return  0;
    }

}
