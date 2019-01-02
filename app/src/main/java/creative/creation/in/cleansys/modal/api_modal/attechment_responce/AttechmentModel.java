
package creative.creation.in.cleansys.modal.api_modal.attechment_responce;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttechmentModel implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("file")
    @Expose
    private List<AttechmentFile> file = new ArrayList<AttechmentFile>();
    public final static Creator<AttechmentModel> CREATOR = new Creator<AttechmentModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AttechmentModel createFromParcel(Parcel in) {
            return new AttechmentModel(in);
        }

        public AttechmentModel[] newArray(int size) {
            return (new AttechmentModel[size]);
        }

    }
    ;

    protected AttechmentModel(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.file, (creative.creation.in.cleansys.modal.api_modal.attechment_responce.AttechmentFile.class.getClassLoader()));
    }

    public AttechmentModel() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public AttechmentModel withError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AttechmentModel withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<AttechmentFile> getFile() {
        return file;
    }

    public void setFile(List<AttechmentFile> file) {
        this.file = file;
    }

    public AttechmentModel withFile(List<AttechmentFile> file) {
        this.file = file;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(message);
        dest.writeList(file);
    }

    public int describeContents() {
        return  0;
    }

}
