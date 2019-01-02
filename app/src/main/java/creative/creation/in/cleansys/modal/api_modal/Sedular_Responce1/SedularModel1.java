
package creative.creation.in.cleansys.modal.api_modal.Sedular_Responce1;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SedularModel1 implements Parcelable
{

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("events")
    @Expose
    private List<Event> events = new ArrayList<Event>();
    public final static Creator<SedularModel1> CREATOR = new Creator<SedularModel1>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SedularModel1 createFromParcel(Parcel in) {
            return new SedularModel1(in);
        }

        public SedularModel1 [] newArray(int size) {
            return (new SedularModel1[size]);
        }

    }
    ;

    protected SedularModel1(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.events, (Event.class.getClassLoader()));
    }

    public SedularModel1() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(message);
        dest.writeList(events);
    }

    public int describeContents() {
        return  0;
    }

}
