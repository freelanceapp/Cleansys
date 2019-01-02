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
import creative.creation.in.cleansys.modal.DateEvent;
import creative.creation.in.cleansys.modal.api_modal.Sedular_Responce1.Event;
import creative.creation.in.cleansys.modal.api_modal.schedular_response.SchedularModel;
import creative.creation.in.cleansys.model.PriceModel1;

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
        holder.tv_start_date.setText(priceModel1ArrayList.get(position).getStart());
        holder.tv_start_date.setText(priceModel1ArrayList.get(position).getStart());
        holder.tv_name.setText(""+priceModel1ArrayList.get(position).getName());
        holder.tv_title.setText(priceModel1ArrayList.get(position).getTitle());
        holder.start_email.setText(""+priceModel1ArrayList.get(position).getEmail());
        holder.date_city.setText(""+priceModel1ArrayList.get(position).getCity());
        holder.date_postal_code.setText(""+priceModel1ArrayList.get(position).getPostCode());
        holder.date_street.setText(priceModel1ArrayList.get(position).getStart());
        holder.date_phone.setText(""+priceModel1ArrayList.get(position).getPhone());


    }

    @Override
    public int getItemCount() {
        return priceModel1ArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_start_date,tv_title,tv_name,start_email,date_phone,date_city,date_postal_code,date_street;

        public MyHolder(View itemView) {
            super(itemView);
            tv_start_date = itemView.findViewById(R.id.start_date);
            tv_title = itemView.findViewById(R.id.date_title);
            tv_name = itemView.findViewById(R.id.date_name);
            start_email = itemView.findViewById(R.id.start_email);
            date_phone = itemView.findViewById(R.id.date_phone);
            date_city = itemView.findViewById(R.id.date_city);
            date_postal_code = itemView.findViewById(R.id.date_postal_code);
            date_street = itemView.findViewById(R.id.date_street);

        }
    }
}
