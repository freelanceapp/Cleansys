
package creative.creation.in.cleansys.modal.api_modal.schedular_response;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Event implements Parcelable
{

    @SerializedName("Member Name")
    @Expose
    private List<MemberName> memberName = new ArrayList<MemberName>();
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
    public final static Creator<Event> CREATOR = new Creator<Event>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        public Event[] newArray(int size) {
            return (new Event[size]);
        }

    }
    ;

    protected Event(Parcel in) {
        in.readList(this.memberName, (creative.creation.in.cleansys.modal.api_modal.schedular_response.MemberName.class.getClassLoader()));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.start = ((String) in.readValue((String.class.getClassLoader())));
        this.end = ((String) in.readValue((String.class.getClassLoader())));
        this.crewJobId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Event() {
    }

    public List<MemberName> getMemberName() {
        return memberName;
    }

    public void setMemberName(List<MemberName> memberName) {
        this.memberName = memberName;
    }

    public Event withMemberName(List<MemberName> memberName) {
        this.memberName = memberName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Event withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Event withStart(String start) {
        this.start = start;
        return this;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Event withEnd(String end) {
        this.end = end;
        return this;
    }

    public String getCrewJobId() {
        return crewJobId;
    }

    public void setCrewJobId(String crewJobId) {
        this.crewJobId = crewJobId;
    }

    public Event withCrewJobId(String crewJobId) {
        this.crewJobId = crewJobId;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(memberName);
        dest.writeValue(title);
        dest.writeValue(start);
        dest.writeValue(end);
        dest.writeValue(crewJobId);
    }

    public int describeContents() {
        return  0;
    }

}
