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

        String strStart = priceModel1ArrayList.get(position).getStart();
        String strName = priceModel1ArrayList.get(position).getName();
        String strTitle = priceModel1ArrayList.get(position).getTitle();
        String strEmail = priceModel1ArrayList.get(position).getEmail();
        String strCity = priceModel1ArrayList.get(position).getCity();
        String strPostCode = priceModel1ArrayList.get(position).getPostCode();
        String strPhone = priceModel1ArrayList.get(position).getPhone();
        if (strStart==null) {
            strStart = "";
        }
        if (strName==null) {
            strName = "";
        }
        if (strTitle==null) {
            strTitle = "";
        }
        if (strEmail==null) {
            strEmail = "";
        }
        if (strCity==null) {
            strCity = "";
        }
        if (strPostCode==null) {
            strPostCode = "";
        }
        if (strPhone==null) {
            strPhone = "";
        }


        holder.tv_start_date.setText(strStart);
        holder.tv_name.setText("" + strName);
        holder.tv_title.setText(strTitle);
        holder.start_email.setText("" + strEmail);
        holder.date_city.setText("" + strCity);
        holder.date_postal_code.setText("" + strPostCode);
        holder.date_street.setText(strStart);
        holder.date_phone.setText("" + strPhone);


    }

    @Override
    public int getItemCount() {
        return priceModel1ArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_start_date, tv_title, tv_name, start_email, date_phone, date_city, date_postal_code, date_street;

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
