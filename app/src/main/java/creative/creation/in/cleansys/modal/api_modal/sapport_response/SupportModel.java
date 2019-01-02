
package creative.creation.in.cleansys.modal.api_modal.sapport_response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportModel implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<SupportModel> CREATOR = new Creator<SupportModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SupportModel createFromParcel(Parcel in) {
            return new SupportModel(in);
        }

        public SupportModel[] newArray(int size) {
            return (new SupportModel[size]);
        }

    }
    ;

    protected SupportModel(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SupportModel() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public SupportModel withError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SupportModel withMessage(String message) {
        this.message = message;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
