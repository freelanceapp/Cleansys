
package creative.creation.in.cleansys.modal.api_modal.price_responce;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class _2Man implements Parcelable
{

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("amount")
    @Expose
    private String amount;
    public final static Creator<_2Man> CREATOR = new Creator<_2Man>() {


        @SuppressWarnings({
            "unchecked"
        })
        public _2Man createFromParcel(Parcel in) {
            return new _2Man(in);
        }

        public _2Man[] newArray(int size) {
            return (new _2Man[size]);
        }

    }
    ;

    protected _2Man(Parcel in) {
        this.time = ((String) in.readValue((String.class.getClassLoader())));
        this.amount = ((String) in.readValue((String.class.getClassLoader())));
    }

    public _2Man() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public _2Man withTime(String time) {
        this.time = time;
        return this;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public _2Man withAmount(String amount) {
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
