package creative.creation.in.cleansys.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import creative.creation.in.cleansys.R;
import creative.creation.in.cleansys.modal.api_modal.customerlist_responce.CustomerUser;

public class CustomerListAdapter extends ArrayAdapter<CustomerUser> {

    private List<CustomerUser> originalList;
    private List<CustomerUser> DatumList;
    private DatumFilter filter;
    private Context context;

    public CustomerListAdapter(Context context, int textViewResourceId, List<CustomerUser> DatumList) {
        super(context, textViewResourceId, DatumList);
        this.DatumList = new ArrayList<CustomerUser>();
        this.DatumList.addAll(DatumList);
        this.originalList = new ArrayList<CustomerUser>();
        this.originalList.addAll(DatumList);
        this.context = context;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new DatumFilter();
        }
        return filter;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder holder = null;
        Log.v("ConvertView", String.valueOf(position));
        if (convertView == null) {

            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (vi != null) {
                convertView = vi.inflate(R.layout.row_customer_list, null);
            }
            holder = new ViewHolder();
            if (convertView != null) {
                holder.txtCityList = (TextView) convertView.findViewById(R.id.txtCustomerName);
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        CustomerUser Datum = DatumList.get(position);
        holder.txtCityList.setText(Datum.getNamePostcode());
        return convertView;
    }

    private class ViewHolder {
        TextView txtCityList;
    }

    private class DatumFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            if (constraint != null && constraint.toString().length() > 0) {
                ArrayList<CustomerUser> filteredItems = new ArrayList<CustomerUser>();

                for (int i = 0, l = originalList.size(); i < l; i++) {
                    CustomerUser Datum = originalList.get(i);
                    if (Datum.getNamePostcode().toLowerCase().contains(constraint))
                        filteredItems.add(Datum);
                }
                result.count = filteredItems.size();
                result.values = filteredItems;
            } else {
                synchronized (this) {
                    result.values = originalList;
                    result.count = originalList.size();
                }
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            DatumList = (ArrayList<CustomerUser>) results.values;
            notifyDataSetChanged();
            clear();
            for (int i = 0, l = DatumList.size(); i < l; i++)
                add(DatumList.get(i));
            notifyDataSetInvalidated();
        }
    }
}
