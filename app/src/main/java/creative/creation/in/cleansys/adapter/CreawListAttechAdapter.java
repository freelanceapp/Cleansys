package creative.creation.in.cleansys.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.modal.DateEvent;
import creative.creation.in.cleansys.modal.Model;

public class CreawListAttechAdapter extends RecyclerView.Adapter<CreawListAttechAdapter.MyHolder> {
    Context ctx;
    ArrayList<Model> itemModelList;

    public CreawListAttechAdapter(Context ctx, ArrayList<Model> priceModel1ArrayList) {
        this.ctx = ctx;
        this.itemModelList = priceModel1ArrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {

        holder.tvName.setText(itemModelList.get(position).getName());
        holder.imgRemove.setImageResource(R.drawable.add);
// click listiner for remove button
        holder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemModelList.remove(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView imgRemove;

        public MyHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            imgRemove = itemView.findViewById(R.id.imgRemove);

        }
    }
}
