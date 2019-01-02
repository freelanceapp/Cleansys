
package creative.creation.in.cleansys.modal.api_modal.faq_response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FaqModel implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("faq")
    @Expose
    private List<Faq> faq = new ArrayList<Faq>();
    public final static Creator<FaqModel> CREATOR = new Creator<FaqModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FaqModel createFromParcel(Parcel in) {
            return new FaqModel(in);
        }

        public FaqModel[] newArray(int size) {
            return (new FaqModel[size]);
        }

    }
    ;

    protected FaqModel(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.faq, (Faq.class.getClassLoader()));
    }

    public FaqModel() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public FaqModel withError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public FaqModel withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Faq> getFaq() {
        return faq;
    }

    public void setFaq(List<Faq> faq) {
        this.faq = faq;
    }

    public FaqModel withFaq(List<Faq> faq) {
        this.faq = faq;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(message);
        dest.writeList(faq);
    }

    public int describeContents() {
        return  0;
    }

}
