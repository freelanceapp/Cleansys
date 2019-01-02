package creative.creation.in.cleansys.activity;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.adapter.JobListAdapter;
import creative.creation.in.cleansys.modal.api_modal.search_responce.JobList;
import creative.creation.in.cleansys.model.Jobs;
import creative.creation.in.cleansys.util.ConnectionDetector;
import creative.creation.in.cleansys.util.Utility;
import creative.creation.in.cleansys.util.WebApi;

public class JobListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    Context ctx;
    ImageView back_iv;
    RecyclerView recyclerView;
    private SearchView searchView, mSearchView;
    ConnectionDetector connectionDetector;
    ArrayList<JobList> list = new ArrayList<>();
    JobListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // toolbar fancy stuff
        if (getSupportActionBar() == null)
            return;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(R.string.toolbar_title);

        initXml();
        boolean internet = connectionDetector.isConnected();
        if (internet) {
            getJobs();
        } else {
            Utility.toastView(ctx, ctx.getString(R.string.no_internet));
        }

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new JobListAdapter(this, list);
        recyclerView.setAdapter(adapter);
        setupSearchView();
    }

    private void getJobs() {
        Utility.showLoader(ctx);
        AndroidNetworking.get(WebApi.API_JOB_LIST)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                        Utility.hideLoader();
                        //setResponse(response);
                    }

                    @Override
                    public void onError(ANError error) {
                        Utility.hideLoader();
                    }
                });
    }

  /*  private void setResponse(JSONObject response) {
        try {
            boolean error = response.getBoolean("error");
            String msg = response.getString("message");
            if (!error) {
                JSONArray array = response.getJSONArray("job_list");
                if (array.length() > 0) {
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        String job_id = object.getString("job_id");
                        String data = object.getString("jld_data");
                        String customer = object.getString("customer");
                        String estm_price = object.getString("est_price");
                        String assets = object.getString("assets");
                        JSONArray member_array = object.getJSONArray("crew_member");
                        list.add(new Jobs(job_id, data, customer, estm_price, assets, member_array.toString()));
                    }
                    adapter.notifyDataSetChanged();
                    //MyApplication.getInstance().addToRequestQueue(array);
                }
            } else {
                Utility.toastView(ctx, msg);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
*/
    private void initXml() {
        ctx = this;
        mSearchView = (SearchView) findViewById(R.id.search_view);
        recyclerView = findViewById(R.id.rv_joblist_recyclerview);
        // white background notification bar
        whiteNotificationBar(recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
             /*   adapter.getFilter().filter(query);
                adapter.notifyDataSetChanged();*/

                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                // adapter.getFilter().filter(query);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        } else if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // close search view on back button pressed
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        finish();
        super.onBackPressed();
    }

    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint("Search Here");
    }


    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getWindow().setStatusBarColor(Color.WHITE);
        }
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        //adapter.filter(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
