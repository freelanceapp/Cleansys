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
import creative.creation.in.cleansys.model.PriceModel1;

public class PriceListAdapter extends RecyclerView.Adapter<PriceListAdapter.MyHolder> {
    Context ctx;
    ArrayList<PriceModel1> priceModel1ArrayList;

    public PriceListAdapter(Context ctx, ArrayList<PriceModel1> priceModel1ArrayList) {
        this.ctx = ctx;
        this.priceModel1ArrayList = priceModel1ArrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_pricelist, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        holder.tv_price_time.setText(priceModel1ArrayList.get(position).getPrice_time());
        holder.tv_price.setText("£ "+priceModel1ArrayList.get(position).getPrice_amount());

    }

    @Override
    public int getItemCount() {
        return priceModel1ArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tv_price_time,tv_price;

        public MyHolder(View itemView) {
            super(itemView);
            tv_price_time = itemView.findViewById(R.id.tv_price);
            tv_price = itemView.findViewById(R.id.tv_price_time);

        }
    }
}
