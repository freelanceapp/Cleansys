package creative.creation.in.cleansys.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.activity.AttechmentActivity;
import creative.creation.in.cleansys.activity.UpdateActivity;
import creative.creation.in.cleansys.modal.api_modal.search_responce.JobList;
import creative.creation.in.cleansys.model.Jobs;

public class JobListAdapter extends RecyclerView.Adapter<JobListAdapter.MyHolder> {
    Context ctx;
    ArrayList<JobList> joblist;

    public JobListAdapter(Context ctx, ArrayList<JobList> joblist) {
        this.ctx = ctx;
        this.joblist = joblist;
        // we copy the original list to the filter list and use it for setting row values
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

        holder.header_tv.setText(joblist.get(position).getJldData());
        holder.id_tv.setText(joblist.get(position).getJobId());
        holder.estd_tv.setText(joblist.get(position).getEstPrice());
        holder.customer_tv.setText(joblist.get(position).getCustomer());
        holder.scedule_tv.setText(joblist.get(position).getPaymentStatus());
        holder.tv_customer_reference_number.setText(joblist.get(position).getCustomerReferenceNumber());
           /* List<String> array = joblist.get(position).getCrewMember();
            String member = array.get(0);
            holder.member_tv.setText(member);*/
        holder.edit_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ctx, UpdateActivity.class);
                intent.putExtra("job_id", joblist.get(position).getJobId());
                ctx.startActivity(intent);

            }
        });
        holder.bt_adpjoblist_attachment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ctx, AttechmentActivity.class);
                intent.putExtra("job_id", joblist.get(position).getJobId());
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != joblist ? joblist.size() : 0);
    }


    public interface JobAdapterListener {
        void onContactSelected(Jobs contact);
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView header_tv, id_tv, estd_tv, customer_tv, scedule_tv, member_tv, tv_customer_reference_number;
        Button edit_bt, bt_adpjoblist_attachment;

        public MyHolder(View itemView) {
            super(itemView);
            header_tv = itemView.findViewById(R.id.tv_adpjoblist_state);
            tv_customer_reference_number = itemView.findViewById(R.id.tv_customer_reference_number);
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
