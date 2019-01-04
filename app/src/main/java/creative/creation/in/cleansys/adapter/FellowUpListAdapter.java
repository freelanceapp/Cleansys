package creative.creation.in.cleansys.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.modal.api_modal.FellowUp_responce.FellowupUser;

public class FellowUpListAdapter extends RecyclerView.Adapter<FellowUpListAdapter.MyHolder> {
    Context ctx;
    List<FellowupUser> fellowupUserArrayList;

    public FellowUpListAdapter(Context ctx, List<FellowupUser> fellowupUserArrayList) {
        this.ctx = ctx;
        this.fellowupUserArrayList = fellowupUserArrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_fellowup, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        holder.tv_customer_id.setText("" + fellowupUserArrayList.get(position).getCustomerRefUmber());
        holder.tv_job_ref_num_scdule.setText("" + fellowupUserArrayList.get(position).getJobRefNum());
        holder.tv_Customer_full_Name.setText("" + fellowupUserArrayList.get(position).getCustomerFullName());
        holder.tv_Customer_Email.setText("" + fellowupUserArrayList.get(position).getCustomerEmail());
        holder.tv_job_detail.setText("" + fellowupUserArrayList.get(position).getJobDetails());
        holder.tv_customer_phone.setText("" + fellowupUserArrayList.get(position).getCustomerPhone());
    }

    @Override
    public int getItemCount() {
        return fellowupUserArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_customer_id, tv_job_ref_num_scdule, tv_Customer_full_Name, tv_Customer_Email, tv_job_detail, tv_customer_phone;

        public MyHolder(View itemView) {
            super(itemView);
            tv_customer_id = itemView.findViewById(R.id.tv_customer_id);
            tv_job_ref_num_scdule = itemView.findViewById(R.id.tv_job_ref_num_scdule);
            tv_Customer_full_Name = itemView.findViewById(R.id.tv_Customer_full_Name);
            tv_Customer_Email = itemView.findViewById(R.id.tv_Customer_Email);
            tv_job_detail = itemView.findViewById(R.id.tv_job_detail);
            tv_customer_phone = itemView.findViewById(R.id.tv_customer_phone);
        }
    }
}
