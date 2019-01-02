package creative.creation.in.cleansys.modal;


import creative.creation.in.cleansys.modal.api_modal.login_response.LoginModal;

/**
 * Created by Natraj on 7/11/2017.
 */

public class User {

    public static LoginModal user;

    public static LoginModal getUser() {
        return user;
    }

    public static void setUser(LoginModal user) {
        User.user = user;
    }

}
