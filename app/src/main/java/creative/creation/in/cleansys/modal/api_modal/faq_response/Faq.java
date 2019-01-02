
package creative.creation.in.cleansys.modal.api_modal.faq_response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Faq implements Parcelable
{

    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("answer")
    @Expose
    private String answer;
    public final static Creator<Faq> CREATOR = new Creator<Faq>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Faq createFromParcel(Parcel in) {
            return new Faq(in);
        }

        public Faq[] newArray(int size) {
            return (new Faq[size]);
        }

    }
    ;

    protected Faq(Parcel in) {
        this.question = ((String) in.readValue((String.class.getClassLoader())));
        this.answer = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Faq() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Faq withQuestion(String question) {
        this.question = question;
        return this;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Faq withAnswer(String answer) {
        this.answer = answer;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(question);
        dest.writeValue(answer);
    }

    public int describeContents() {
        return  0;
    }

}
