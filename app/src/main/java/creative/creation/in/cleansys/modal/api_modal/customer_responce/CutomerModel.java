
package creative.creation.in.cleansys.modal.api_modal.customer_responce;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CutomerModel implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<CutomerModel> CREATOR = new Creator<CutomerModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CutomerModel createFromParcel(Parcel in) {
            return new CutomerModel(in);
        }

        public CutomerModel[] newArray(int size) {
            return (new CutomerModel[size]);
        }

    }
    ;

    protected CutomerModel(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CutomerModel() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public CutomerModel withError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CutomerModel withMessage(String message) {
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
