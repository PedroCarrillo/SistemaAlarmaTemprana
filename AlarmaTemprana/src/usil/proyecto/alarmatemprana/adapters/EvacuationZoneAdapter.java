package usil.proyecto.alarmatemprana.adapters;

import java.util.List;

import usil.proyecto.alarmatemprana.R;
import usil.proyecto.alarmatempranoa.models.EvacuationLocation;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class EvacuationZoneAdapter extends BaseAdapter{

    private Context context;
    private List<EvacuationLocation> mItems;
    private int row;
    
    public EvacuationZoneAdapter(Context ctx, int resource, List<EvacuationLocation> mItems ){
        super();
        this.context = ctx;
        this.row = resource;
        this.mItems = mItems;
    }

    public class ViewHolder {
        private TextView tv_location_address;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public EvacuationLocation getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position,final View convertView, final ViewGroup parent) {
        EvacuationLocation location = mItems.get(position);
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row, parent, false);
            holder = new ViewHolder();
            holder.tv_location_address = (TextView) view.findViewById(R.id.tv_location_address);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
       
        if (holder.tv_location_address != null) {
            holder.tv_location_address.setText(location.getAddress());
        }
        int backgroundColor;
        backgroundColor = (position % 2 == 0) ? Color.rgb(240, 240, 240) : Color.rgb(248, 248, 248);
        view.setBackgroundColor(backgroundColor);
        return view;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public void notifyDataSetChanged() // Create this function in your adapter class
    {
        super.notifyDataSetChanged();
    }
}
