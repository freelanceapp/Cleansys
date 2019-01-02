
package creative.creation.in.cleansys.modal.api_modal.schedular_response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("resourceId")
    @Expose
    private String resourceId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("crew_job_id")
    @Expose
    private String crewJobId;
    public final static Creator<User> CREATOR = new Creator<User>() {


        @SuppressWarnings({
            "unchecked"
        })
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return (new User[size]);
        }

    }
    ;

    protected User(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.resourceId = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.start = ((String) in.readValue((String.class.getClassLoader())));
        this.end = ((String) in.readValue((String.class.getClassLoader())));
        this.crewJobId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User withId(String id) {
        this.id = id;
        return this;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public User withResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public User withStart(String start) {
        this.start = start;
        return this;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public User withEnd(String end) {
        this.end = end;
        return this;
    }

    public String getCrewJobId() {
        return crewJobId;
    }

    public void setCrewJobId(String crewJobId) {
        this.crewJobId = crewJobId;
    }

    public User withCrewJobId(String crewJobId) {
        this.crewJobId = crewJobId;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(resourceId);
        dest.writeValue(title);
        dest.writeValue(start);
        dest.writeValue(end);
        dest.writeValue(crewJobId);
    }

    public int describeContents() {
        return  0;
    }

}
