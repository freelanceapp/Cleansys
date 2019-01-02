package creative.creation.in.cleansys.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.modal.crew_modal.CrewUserList;

public class CrewSpinnerAdapter extends ArrayAdapter<CrewUserList> {

    private final LayoutInflater mInflater;
    private final Context mContext;
    private final List<CrewUserList> items;
    private final int mResource;

    public CrewSpinnerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<CrewUserList> objects) {
        super(context, 0, objects);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        items = objects;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull
    View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent) {
        final View view = mInflater.inflate(mResource, parent, false);

        TextView tvUsername = (TextView) view.findViewById(R.id.tvUsername);
        TextView tvAvailable = (TextView) view.findViewById(R.id.tvAvailable);

        CrewUserList urlModal = items.get(position);

        if (urlModal.getAvailable().contains("Available")) {
            tvUsername.setTextColor(mContext.getResources().getColor(R.color.green));
            tvAvailable.setTextColor(mContext.getResources().getColor(R.color.green));
        } else {
            tvUsername.setTextColor(mContext.getResources().getColor(R.color.black));
            tvAvailable.setTextColor(mContext.getResources().getColor(R.color.black));
        }
        tvUsername.setText(urlModal.getUserName());
        tvAvailable.setText(urlModal.getAvailable());
        return view;
    }
}





/*public class CrewSpinnerAdapter extends ArrayAdapter<UrlModal> {

    private List<UrlModal> spinnerList;
    private Context mContext;

    public CrewSpinnerAdapter(Context context, int resouceId,List<UrlModal> list) {
        super(context, resouceId, list);
        this.spinnerList = list;
        this.mContext = context;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater flatter = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (flatter != null) {
            convertView = flatter.inflate(R.layout.spinner_url_layout, null);
        }

        TextView txtMchId = (TextView) convertView.findViewById(R.id.txtMchId);
        TextView txtBaseUrl = (TextView) convertView.findViewById(R.id.txtBaseUrl);
        txtMchId.setText(spinnerList.get(position).get_name());
        txtBaseUrl.setText(spinnerList.get(position).get_url());
        return convertView;
    }
}*/
