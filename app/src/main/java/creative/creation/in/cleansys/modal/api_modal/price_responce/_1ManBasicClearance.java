
package creative.creation.in.cleansys.modal.api_modal.price_responce;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _1ManBasicClearance implements Parcelable
{

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("amount")
    @Expose
    private String amount;
    public final static Creator<_1ManBasicClearance> CREATOR = new Creator<_1ManBasicClearance>() {



        @SuppressWarnings({
            "unchecked"
        })
        public _1ManBasicClearance createFromParcel(Parcel in) {
            return new _1ManBasicClearance(in);
        }

        public _1ManBasicClearance[] newArray(int size) {
            return (new _1ManBasicClearance[size]);
        }

    }
    ;

    public _1ManBasicClearance(String time, String amount) {
        this.time = time;
        this.amount = amount;
    }

    protected _1ManBasicClearance(Parcel in) {
        this.time = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((String) in.readValue((String.class.getClassLoader())));
    }

    public _1ManBasicClearance() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public _1ManBasicClearance withTime(String time) {
        this.time = time;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public _1ManBasicClearance withAmount(String amount) {
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
