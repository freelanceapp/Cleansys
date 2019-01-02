
package creative.creation.in.cleansys.modal.api_modal.price_responce;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceModel implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("1 man Basic Clearance")
    @Expose
    private List<creative.creation.in.cleansys.modal.api_modal.price_responce._1ManBasicClearance> _1ManBasicClearance = new ArrayList<creative.creation.in.cleansys.modal.api_modal.price_responce._1ManBasicClearance>();
    @SerializedName("1 Man Clear + Inspect/ Clean")
    @Expose
    private List<creative.creation.in.cleansys.modal.api_modal.price_responce._1ManClearInspectClean> _1ManClearInspectClean = new ArrayList<creative.creation.in.cleansys.modal.api_modal.price_responce._1ManClearInspectClean>();
    @SerializedName("2 Man")
    @Expose
    private List<creative.creation.in.cleansys.modal.api_modal.price_responce._2Man> _2Man = new ArrayList<creative.creation.in.cleansys.modal.api_modal.price_responce._2Man>();
    public final static Creator<PriceModel> CREATOR = new Creator<PriceModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PriceModel createFromParcel(Parcel in) {
            return new PriceModel(in);
        }

        public PriceModel[] newArray(int size) {
            return (new PriceModel[size]);
        }

    }
    ;

    protected PriceModel(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this._1ManBasicClearance, (creative.creation.in.cleansys.modal.api_modal.price_responce._1ManBasicClearance.class.getClassLoader()));
        in.readList(this._1ManClearInspectClean, (creative.creation.in.cleansys.modal.api_modal.price_responce._1ManClearInspectClean.class.getClassLoader()));
        in.readList(this._2Man, (creative.creation.in.cleansys.modal.api_modal.price_responce._2Man.class.getClassLoader()));
    }

    public PriceModel() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public PriceModel withError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PriceModel withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<creative.creation.in.cleansys.modal.api_modal.price_responce._1ManBasicClearance> get1ManBasicClearance() {
        return _1ManBasicClearance;
    }

    public void set1ManBasicClearance(List<creative.creation.in.cleansys.modal.api_modal.price_responce._1ManBasicClearance> _1ManBasicClearance) {
        this._1ManBasicClearance = _1ManBasicClearance;
    }

    public PriceModel with1ManBasicClearance(List<creative.creation.in.cleansys.modal.api_modal.price_responce._1ManBasicClearance> _1ManBasicClearance) {
        this._1ManBasicClearance = _1ManBasicClearance;
        return this;
    }

    public List<creative.creation.in.cleansys.modal.api_modal.price_responce._1ManClearInspectClean> get1ManClearInspectClean() {
        return _1ManClearInspectClean;
    }

    public void set1ManClearInspectClean(List<creative.creation.in.cleansys.modal.api_modal.price_responce._1ManClearInspectClean> _1ManClearInspectClean) {
        this._1ManClearInspectClean = _1ManClearInspectClean;
    }

    public PriceModel with1ManClearInspectClean(List<creative.creation.in.cleansys.modal.api_modal.price_responce._1ManClearInspectClean> _1ManClearInspectClean) {
        this._1ManClearInspectClean = _1ManClearInspectClean;
        return this;
    }

    public List<creative.creation.in.cleansys.modal.api_modal.price_responce._2Man> get2Man() {
        return _2Man;
    }

    public void set2Man(List<creative.creation.in.cleansys.modal.api_modal.price_responce._2Man> _2Man) {
        this._2Man = _2Man;
    }

    public PriceModel with2Man(List<creative.creation.in.cleansys.modal.api_modal.price_responce._2Man> _2Man) {
        this._2Man = _2Man;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(message);
        dest.writeList(_1ManBasicClearance);
        dest.writeList(_1ManClearInspectClean);
        dest.writeList(_2Man);
    }

    public int describeContents() {
        return  0;
    }

}
