package creative.creation.in.cleansys.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.activity.MainActivity;
import creative.creation.in.cleansys.fragment.CreateCustomerFragment;
import creative.creation.in.cleansys.fragment.FollowUpFragment;
import creative.creation.in.cleansys.fragment.JobListFragment;
import creative.creation.in.cleansys.fragment.JobSummaryFragment;
import creative.creation.in.cleansys.fragment.PriceListFragment;
import creative.creation.in.cleansys.fragment.SchedularFragment;
import creative.creation.in.cleansys.interfaces.FragmentChangeListener;
import creative.creation.in.cleansys.interfaces.FragmentService;

public class FragmentUtils implements FragmentService {

    public static final int SCHEDULER_ID = 0;
    public static final int JOB_SUMMARY_ID = 1;
    public static final int CREATE_CUSTOMER_ID = 2;
    public static final int JOB_LIST_ID = 3;
    public static final int FOLLOW_UP_ID = 4;
    public static final int PRICE_LIST_ID = 5;

    public static final String SCHEDULER_FRAGMENT = "SCHEDULER_FRAGMENT";
    public static final String JOB_SUMMARY_FRAGMENT = "JOB_SUMMARY";
    public static final String CREATE_CUSTOMER_FRAGMENT = "CREATE_CUSTOMER_FRAGMENT";
    public static final String JOB_LIST_FRAGMENT = "JOB_LIST_FRAGMENT";
    public static final String FOLLOW_UP_FRAGMENT = "FOLLOW_UP";
    public static final String PRICE_LIST_FRAGMENT = "PRICE_LIST_FRAGMENT";

    public static FragmentUtils mInstance;
    private static MainActivity mainActivity;
    public FragmentManager manager;
    private int lastCommit = -1;
    private RegisterFragmentHandler fragmentHandler;
    private Fragment fragmentArray[];
    private String[] tags = {SCHEDULER_FRAGMENT, JOB_SUMMARY_FRAGMENT, CREATE_CUSTOMER_FRAGMENT,
            JOB_LIST_FRAGMENT, FOLLOW_UP_FRAGMENT, PRICE_LIST_FRAGMENT};

    public static FragmentUtils initFragments(MainActivity act) {
        mInstance = new FragmentUtils();
        mainActivity = act;
        mInstance.showFragment(null, SCHEDULER_ID, SCHEDULER_FRAGMENT, false);
        return mInstance;
    }

    private void showFragment(Bundle bundle, int fragmentId, String tag, boolean isBackstack) {
        manager = mainActivity.getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (fragmentArray == null) {
            fragmentHandler = new RegisterFragmentHandler();

            fragmentArray = new Fragment[]{
                    new SchedularFragment(),
                    new JobSummaryFragment(),
                    new CreateCustomerFragment(),
                    new JobListFragment(),
                    new FollowUpFragment(),
                    new PriceListFragment()};

            for (int i = 0; i < fragmentArray.length; i++) {
                fragmentHandler.registerFragment((FragmentChangeListener) fragmentArray[i]);
                ft.add(R.id.container_main, fragmentArray[i], tags[i]);
                ft.hide(fragmentArray[i]);
            }
        }
        if (lastCommit != -1)
            ft.hide(fragmentArray[lastCommit]);
        ft.show(fragmentArray[fragmentId]);
        lastCommit = fragmentId;

        if (isBackstack)
            ft.addToBackStack(tag);

        if (bundle != null)
            fragmentArray[fragmentId].setArguments(bundle);

        ft.commit();
        fragmentHandler.notifyFragment(fragmentId);
    }

    public void showChildFragment(Fragment fragment, Bundle bundle, int container) {
        FragmentTransaction ft = manager.beginTransaction();
        fragment.setArguments(bundle);
        ft.add(container, fragment, null);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void inflateFragment(Bundle bundle, int fragmentId, String tag, boolean isBackstack) {
        showFragment(bundle, fragmentId, tag, isBackstack);
    }

    public class RegisterFragmentHandler {
        ArrayList<FragmentChangeListener> listeners = new ArrayList<>();

        public void registerFragment(FragmentChangeListener listener) {
            listeners.add(listener);
        }


        public void notifyFragment(int fragmentId) {
            listeners.get(fragmentId).onFragmentVisible("Fragment Visible");
        }

        public void notifyAllFragment(String tag) {
            for (FragmentChangeListener listener : listeners) {
                listener.onFragmentVisible(tag);
            }
        }
    }
}