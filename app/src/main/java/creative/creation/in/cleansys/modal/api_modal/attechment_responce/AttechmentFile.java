
package creative.creation.in.cleansys.modal.api_modal.attechment_responce;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AttechmentFile implements Parcelable
{

    @SerializedName("attach_id")
    @Expose
    private String attachId;
    @SerializedName("job_id")
    @Expose
    private String jobId;
    @SerializedName("attach_path")
    @Expose
    private String attachPath;
    public final static Creator<AttechmentFile> CREATOR = new Creator<AttechmentFile>() {


        @SuppressWarnings({
            "unchecked"
        })
        public AttechmentFile createFromParcel(Parcel in) {
            return new AttechmentFile(in);
        }

        public AttechmentFile[] newArray(int size) {
            return (new AttechmentFile[size]);
        }

    }
    ;

    protected AttechmentFile(Parcel in) {
        this.attachId = ((String) in.readValue((String.class.getClassLoader())));
        this.jobId = ((String) in.readValue((String.class.getClassLoader())));
        this.attachPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public AttechmentFile() {
    }

    public String getAttachId() {
        return attachId;
    }

    public void setAttachId(String attachId) {
        this.attachId = attachId;
    }

    public AttechmentFile withAttachId(String attachId) {
        this.attachId = attachId;
        return this;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public AttechmentFile withJobId(String jobId) {
        this.jobId = jobId;
        return this;
    }

    public String getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    public AttechmentFile withAttachPath(String attachPath) {
        this.attachPath = attachPath;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(attachId);
        dest.writeValue(jobId);
        dest.writeValue(attachPath);
    }

    public int describeContents() {
        return  0;
    }

}
