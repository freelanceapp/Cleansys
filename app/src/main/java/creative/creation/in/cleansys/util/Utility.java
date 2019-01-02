package creative.creation.in.cleansys.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;
import android.widget.Toast;


public class Utility {
    static String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
    private static ProgressDialog dialog;


    public static void toastView(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }


    public static void setFragment(android.support.v4.app.Fragment fragment, Context ctx) {

//        FragmentTransaction fragmenttransction = ((FragmentActivity)ctx).getSupportFragmentManager().beginTransaction();
//        fragmenttransction.replace(R.id.fl_main_framelayout,fragment);
//        fragmenttransction.addToBackStack("");
//        fragmenttransction.commit();
    }


    public static void showLoader(Context ctx) {

        dialog = new ProgressDialog(ctx);
        dialog.setCancelable(false);
        dialog.setMessage("loading..");
        dialog.show();
    }

    public static void hideLoader() {

        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    public static boolean emailCheck(String email) {
        if (email.matches(emailPattern)) {
            return true;
        } else {
            return false;
        }
    }
}
