
package creative.creation.in.cleansys.modal.api_modal.customerlist_responce;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CutomerModel1 implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("user")
    @Expose
    private List<CustomerUser> user = new ArrayList<CustomerUser>();
    public final static Creator<CutomerModel1> CREATOR = new Creator<CutomerModel1>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CutomerModel1 createFromParcel(Parcel in) {
            return new CutomerModel1(in);
        }

        public CutomerModel1 [] newArray(int size) {
            return (new CutomerModel1[size]);
        }

    }
    ;

    protected CutomerModel1(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.user, (CustomerUser.class.getClassLoader()));
    }

    public CutomerModel1() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public CutomerModel1 withError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CutomerModel1 withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<CustomerUser> getUser() {
        return user;
    }

    public void setUser(List<CustomerUser> user) {
        this.user = user;
    }

    public CutomerModel1 withUser(List<CustomerUser> user) {
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
