package creative.creation.in.cleansys.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.modal.api_modal.Sedular_Responce1.Event;
import creative.creation.in.cleansys.modal.api_modal.Sedular_Responce1.MemberName;

public class DateListAdapter extends RecyclerView.Adapter<DateListAdapter.MyHolder> {
    Context ctx;
    ArrayList<Event> priceModel1ArrayList;

    public DateListAdapter(Context ctx, ArrayList<Event> priceModel1ArrayList) {
        this.ctx = ctx;
        this.priceModel1ArrayList = priceModel1ArrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_date, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        String strName = priceModel1ArrayList.get(position).getName();
        String strPhone = priceModel1ArrayList.get(position).getPhone();
        String strAddress = priceModel1ArrayList.get(position).getLocation() + " " + priceModel1ArrayList.get(position).getCity() +
                " " + priceModel1ArrayList.get(position).getPostCode();

        String strCrewMember = "";

        for (int i = 0; i < priceModel1ArrayList.get(position).getMemberName().size(); i++) {
            MemberName memberName = priceModel1ArrayList.get(position).getMemberName().get(i);
            if (i == 0) {
                strCrewMember = memberName.getTitle();
            } else {
                strCrewMember = strCrewMember + " , " + memberName.getTitle();
            }
        }

        holder.tvName.setText(strName);
        holder.tvPhone.setText(strPhone);
        holder.tvAddress.setText(strAddress);
        holder.tvCrewMember.setText(strCrewMember);
    }

    @Override
    public int getItemCount() {
        return priceModel1ArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvPhone, tvAddress, tvCrewMember;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvCrewMember = itemView.findViewById(R.id.tvCrewMember);
        }
    }
}
