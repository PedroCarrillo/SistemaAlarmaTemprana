package usil.proyecto.alarmatemprana.adapters;

import java.util.List;

import usil.proyecto.alarmatemprana.R;
import usil.proyecto.alarmatempranoa.models.Contact;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ContactAdapter extends BaseAdapter{

    private Context context;
    private List<Contact> mItems;
    private int row;
    
    public ContactAdapter(Context ctx, int resource, List<Contact> mItems ){
        super();
        this.context = ctx;
        this.row = resource;
        this.mItems = mItems;
    }

    public class ViewHolder {
        private TextView tv_contact_address, tv_contact_phone, tv_contact_name;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Contact getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position,final View convertView, final ViewGroup parent) {
        Contact contact = mItems.get(position);
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(row, parent, false);
            holder = new ViewHolder();
            holder.tv_contact_name = (TextView) view.findViewById(R.id.tv_contact_name);
            holder.tv_contact_address = (TextView) view.findViewById(R.id.tv_contact_address);
            holder.tv_contact_phone = (TextView) view.findViewById(R.id.tv_contact_phone);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
       
        if (holder.tv_contact_name != null) {
            holder.tv_contact_name.setText(contact.getName());
        }
        if (holder.tv_contact_address != null) {
            holder.tv_contact_address.setText(contact.getAddress());
        }if (holder.tv_contact_phone != null) {
            holder.tv_contact_phone.setText(contact.getPhoneNumber());
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