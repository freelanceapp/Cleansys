package creative.creation.in.cleansys.adapter;

import android.app.DownloadManager;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.modal.api_modal.attechment_responce.AttechmentFile;

public class AttechmentAdapter extends RecyclerView.Adapter<AttechmentAdapter.MyHolder> {
    Context ctx;
    ArrayList<AttechmentFile> attechmentFileArrayList;
    String songName;
    private Uri Download_Uri;
    private DownloadManager downloadManager;
    private ArrayList<Long> list = new ArrayList<>();
    private long refid;
    private View.OnClickListener onClickListener;
    public AttechmentAdapter(Context ctx, ArrayList<AttechmentFile> fellowupUserArrayList, View.OnClickListener onClickListener) {
        this.ctx = ctx;
        this.attechmentFileArrayList = fellowupUserArrayList;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_attechment, parent, false);
        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        holder.tvAttechmentName.setText(""+attechmentFileArrayList.get(position).getJobId());
        Log.e("Adapter ","..."+attechmentFileArrayList.get(position).getJobId());
        //holder.ivAttechmentImg.setText(""+fellowupUserArrayList.get(position).getJobRefNum());
        Picasso.get().load("http://webintellect.co.uk/cleansys/"+attechmentFileArrayList.get(position).getAttachPath()).placeholder(R.drawable.image).into(holder.ivAttechmentImg);
        holder.ivAttechmentDown.setOnClickListener(onClickListener);
        holder.ivAttechmentDown.setTag(position);
        holder.ivAttechmentDelete.setOnClickListener(onClickListener);
        holder.ivAttechmentDelete.setTag(position);
    }
    @Override
    public int getItemCount() {
        return attechmentFileArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder  {
        TextView tvAttechmentName;
        ImageView ivAttechmentImg,ivAttechmentDown,ivAttechmentDelete;
        public MyHolder(View itemView) {
            super(itemView);
            tvAttechmentName = itemView.findViewById(R.id.tvAttechmentName);
            ivAttechmentImg = itemView.findViewById(R.id.ivAttechmentImg);
            ivAttechmentDown = itemView.findViewById(R.id.ivAttechmentDown);
            ivAttechmentDelete = itemView.findViewById(R.id.ivAttechmentDelete);
        }


    }






}
