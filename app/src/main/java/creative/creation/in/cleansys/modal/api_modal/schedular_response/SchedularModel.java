
package creative.creation.in.cleansys.modal.api_modal.schedular_response;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SchedularModel implements Parcelable
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
    public final static Creator<SchedularModel> CREATOR = new Creator<SchedularModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SchedularModel createFromParcel(Parcel in) {
            return new SchedularModel(in);
        }

        public SchedularModel[] newArray(int size) {
            return (new SchedularModel[size]);
        }

    }
    ;

    protected SchedularModel(Parcel in) {
        this.error = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.events, (Event.class.getClassLoader()));
    }

    public SchedularModel() {
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public SchedularModel withError(Boolean error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SchedularModel withMessage(String message) {
        this.message = message;
        return this;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public SchedularModel withEvents(List<Event> events) {
        this.events = events;
        return this;
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
