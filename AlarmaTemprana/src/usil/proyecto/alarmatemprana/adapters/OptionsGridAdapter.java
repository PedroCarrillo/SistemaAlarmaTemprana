package usil.proyecto.alarmatemprana.adapters;

import usil.proyecto.alarmatemprana.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class OptionsGridAdapter extends BaseAdapter {
	
    private Context mContext;
 
    public OptionsGridAdapter(Context c) {
        mContext = c;
    } 
 
    public int getCount() { 
        return optionText.length;
    } 
 
    public Object getItem(int position) {
        return null; 
    } 
 
    public long getItemId(int position) {
        return 0; 
    } 
 
    // create a new ImageView for each item referenced by the Adapter 
    public View getView(int position, View convertView, ViewGroup parent) {        
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
              grid = new View(mContext);
              grid = inflater.inflate(R.layout.gridview_option_cell, null);
              grid.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, 230));
              TextView textView = (TextView) grid.findViewById(R.id.tv_option_text);
              ImageView imageView = (ImageView)grid.findViewById(R.id.iv_option_image);
              textView.setText(optionText[position]);
              imageView.setImageResource(Imageid[position]);
            } else {
              grid = (View) convertView;
            }
        return grid;
    } 
 
    // references to our images 
    private Integer[] Imageid = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
    }; 
    
    private String[] optionText = {
    		"text1","text2","text3","text4","text5","text6"
    };
} 