
package creative.creation.in.cleansys.modal.api_modal.customerlist_responce;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerUser implements Parcelable
{

    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<CustomerUser> CREATOR = new Creator<CustomerUser>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CustomerUser createFromParcel(Parcel in) {
            return new CustomerUser(in);
        }

        public CustomerUser[] newArray(int size) {
            return (new CustomerUser[size]);
        }

    }
    ;

    protected CustomerUser(Parcel in) {
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CustomerUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerUser withName(String name) {
        this.name = name;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}