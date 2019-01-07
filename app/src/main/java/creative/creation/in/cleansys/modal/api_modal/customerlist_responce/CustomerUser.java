
package creative.creation.in.cleansys.modal.api_modal.customerlist_responce;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerUser implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("name_postcode")
    @Expose
    private String namePostcode;
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
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.namePostcode = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CustomerUser() {
    }

    public String getName() {
        return name;
    }

    public String getNamePostcode() {
        return namePostcode;
    }

    public void setNamePostcode(String namePostcode) {
        this.namePostcode = namePostcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerUser withName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(namePostcode);
    }

    public int describeContents() {
        return  0;
    }

}
