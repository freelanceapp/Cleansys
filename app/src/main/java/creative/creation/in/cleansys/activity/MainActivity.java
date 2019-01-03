package creative.creation.in.cleansys.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import creative.creation.in.cleansys.AppPreference;
import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.retrofit_provider.RetrofitService;
import creative.creation.in.cleansys.utils.BaseActivity;
import creative.creation.in.cleansys.utils.FragmentUtils;

import static creative.creation.in.cleansys.utils.FragmentUtils.CREATE_CUSTOMER_FRAGMENT;
import static creative.creation.in.cleansys.utils.FragmentUtils.CREATE_CUSTOMER_ID;
import static creative.creation.in.cleansys.utils.FragmentUtils.FOLLOW_UP_FRAGMENT;
import static creative.creation.in.cleansys.utils.FragmentUtils.FOLLOW_UP_ID;
import static creative.creation.in.cleansys.utils.FragmentUtils.JOB_LIST_FRAGMENT;
import static creative.creation.in.cleansys.utils.FragmentUtils.JOB_LIST_ID;
import static creative.creation.in.cleansys.utils.FragmentUtils.JOB_SUMMARY_FRAGMENT;
import static creative.creation.in.cleansys.utils.FragmentUtils.JOB_SUMMARY_ID;
import static creative.creation.in.cleansys.utils.FragmentUtils.PRICE_LIST_FRAGMENT;
import static creative.creation.in.cleansys.utils.FragmentUtils.PRICE_LIST_ID;
import static creative.creation.in.cleansys.utils.FragmentUtils.SCHEDULER_FRAGMENT;
import static creative.creation.in.cleansys.utils.FragmentUtils.SCHEDULER_ID;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private boolean isPressedExit = false;
    private FragmentUtils fragmentUtils;
    private int currentPos = 0;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        cd = new creative.creation.in.cleansys.utils.ConnectionDetector(mContext);
        retrofitRxClient = RetrofitService.getRxClient();
        retrofitApiClient = RetrofitService.getRetrofit();

        initXml();
    }

    private void initXml() {
        mContext = this;

        fragmentUtils = FragmentUtils.initFragments(MainActivity.this);
        fragmentUtils.inflateFragment(null, SCHEDULER_ID, SCHEDULER_FRAGMENT, false);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

   /* @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_scheduler) {
            if (currentPos == 0)
                return true;
            currentPos = 0;
            item.setChecked(true);
            int backStackCount = fragmentUtils.manager.getBackStackEntryCount();
            for (int i = 0; i < backStackCount; i++) {
                fragmentUtils.manager.popBackStack();
            }
            setTitle("Scheduler");
            fragmentUtils.inflateFragment(null, SCHEDULER_ID, SCHEDULER_FRAGMENT, false);
        } else if (id == R.id.nav_jobsummary) {
            if (currentPos == 1)
                return true;
            item.setChecked(true);
            currentPos = 1;
            setTitle("Job Summary");
            fragmentUtils.inflateFragment(null, JOB_SUMMARY_ID, JOB_SUMMARY_FRAGMENT, false);
        } else if (id == R.id.nav_createcustomer) {
            if (currentPos == 2)
                return true;
            item.setChecked(true);
            currentPos = 2;
            setTitle("Create Customer");
            fragmentUtils.inflateFragment(null, CREATE_CUSTOMER_ID, CREATE_CUSTOMER_FRAGMENT, false);
        } else if (id == R.id.nav_joblist) {
            if (currentPos == 3)
                return true;
            item.setChecked(true);
            currentPos = 3;
            setTitle("Job List");
            fragmentUtils.inflateFragment(null, JOB_LIST_ID, JOB_LIST_FRAGMENT, false);
        } else if (id == R.id.nav_fellowup) {
            if (currentPos == 4)
                return true;
            item.setChecked(true);
            currentPos = 4;
            setTitle("Follow Up");
            fragmentUtils.inflateFragment(null, FOLLOW_UP_ID, FOLLOW_UP_FRAGMENT, false);
        } else if (id == R.id.nav_pricelist) {
            if (currentPos == 5)
                return true;
            item.setChecked(true);
            currentPos = 5;
            setTitle("Price List");
            fragmentUtils.inflateFragment(null, PRICE_LIST_ID, PRICE_LIST_FRAGMENT, false);
        } else if (id == R.id.nav_logout) {
            AppPreference.clearAllPreferences(getApplicationContext());
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (isPressedExit) {
                super.onBackPressed();
            } else {
                isPressedExit = true;
                Toast.makeText(mContext, "Press again to exit.", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isPressedExit = false;
                    }
                }, 3000);
            }
        }
    }
}
