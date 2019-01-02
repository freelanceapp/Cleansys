
package creative.creation.in.cleansys.modal.api_modal.price_responce;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _1ManClearInspectClean implements Parcelable
{

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("amount")
    @Expose
    private String amount;
    public final static Creator<_1ManClearInspectClean> CREATOR = new Creator<_1ManClearInspectClean>() {


        @SuppressWarnings({
            "unchecked"
        })
        public _1ManClearInspectClean createFromParcel(Parcel in) {
            return new _1ManClearInspectClean(in);
        }

        public _1ManClearInspectClean[] newArray(int size) {
            return (new _1ManClearInspectClean[size]);
        }

    }
    ;

    protected _1ManClearInspectClean(Parcel in) {
        this.time = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((String) in.readValue((String.class.getClassLoader())));
    }

    public _1ManClearInspectClean() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public _1ManClearInspectClean withTime(String time) {
        this.time = time;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public _1ManClearInspectClean withAmount(String amount) {
        this.amount = amount;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(time);
        dest.writeValue(amount);
    }

    public int describeContents() {
        return  0;
    }

}
