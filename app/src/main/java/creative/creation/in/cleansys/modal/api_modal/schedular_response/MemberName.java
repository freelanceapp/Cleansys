
package creative.creation.in.cleansys.modal.api_modal.schedular_response;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MemberName implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    public final static Creator<MemberName> CREATOR = new Creator<MemberName>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MemberName createFromParcel(Parcel in) {
            return new MemberName(in);
        }

        public MemberName[] newArray(int size) {
            return (new MemberName[size]);
        }

    }
    ;

    protected MemberName(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
    }

    public MemberName() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MemberName withId(String id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MemberName withTitle(String title) {
        this.title = title;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
    }

    public int describeContents() {
        return  0;
    }

}
