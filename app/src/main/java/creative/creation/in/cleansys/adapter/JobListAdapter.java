package creative.creation.in.cleansys.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.activity.AttechmentActivity;
import creative.creation.in.cleansys.activity.UpdateActivity;
import creative.creation.in.cleansys.model.Jobs;

import static rx.plugins.RxJavaHooks.clear;

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.MyHolder> {
    Context ctx;
    ArrayList<Jobs> joblist;
    ArrayList<Jobs> filterList;

    public JobListAdapter(Context ctx, ArrayList<Jobs> joblist) {
        this.ctx = ctx;
        this.joblist = joblist;
        this.filterList = new ArrayList<Jobs>();
        // we copy the original list to the filter list and use it for setting row values
        this.filterList.addAll(this.joblist);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_joblist, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        holder.header_tv.setText(joblist.get(position).getData());
        holder.id_tv.setText(joblist.get(position).getId());
        holder.estd_tv.setText(joblist.get(position).getEstm_price());
        holder.customer_tv.setText(joblist.get(position).getCustomer());
        holder.scedule_tv.setText(joblist.get(position).getData());

        try {
            JSONArray array = new JSONArray(joblist.get(position).getCrew_memner());
            String member = array.getString(0);
            holder.member_tv.setText(member);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        holder.edit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,UpdateActivity.class);
                intent.putExtra("job_id",joblist.get(position).getId());
                ctx.startActivity(intent);

            }
        });
        holder.bt_adpjoblist_attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx,AttechmentActivity.class);
                intent.putExtra("job_id",joblist.get(position).getId());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != joblist ? joblist.size() : 0);    }


    public void filter(final String text) {

        // Searching could be complex..so we will dispatch it to a different thread...
        new Thread(new Runnable() {
            @Override
            public void run() {

                // Clear the filter list
                filterList.clear();

                // If there is no search value, then add all original list items to filter list
                if (TextUtils.isEmpty(text)) {

                    filterList.addAll(joblist);

                } else {
                    // Iterate in the original List and add it to filter list...
                    for (Jobs item : joblist) {
                        if (item.getCustomer().toLowerCase().contains(text.toLowerCase()) || item.getData().toLowerCase().contains(text.toLowerCase())) {
                            // Adding Matched items
                            filterList.add(item);
                        }
                    }
                }

                // Set on UI Thread
                ((Activity) ctx).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Notify the List that the DataSet has changed...
                        notifyDataSetChanged();
                    }
                });

            }
        }).start();

    }
    public interface JobAdapterListener {
        void onContactSelected(Jobs contact);
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView header_tv, id_tv, estd_tv, customer_tv, scedule_tv, member_tv;
        Button edit_bt,bt_adpjoblist_attachment;

        public MyHolder(View itemView) {
            super(itemView);
            header_tv = itemView.findViewById(R.id.tv_adpjoblist_state);
            id_tv = itemView.findViewById(R.id.tv_adpjoblist_id);
            estd_tv = itemView.findViewById(R.id.tv_adpjoblist_est_price);
            customer_tv = itemView.findViewById(R.id.tv_adpjoblist_customer);
            scedule_tv = itemView.findViewById(R.id.tv_adpjoblist_scdule);
            member_tv = itemView.findViewById(R.id.tv_adpjoblist_member);
            edit_bt = itemView.findViewById(R.id.bt_adpjoblist_edit);
            bt_adpjoblist_attachment = itemView.findViewById(R.id.bt_adpjoblist_attachment);
        }
    }


}
