package usil.proyecto.alarmatemprana.activities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import usil.proyecto.alarmatemprana.R;
import usil.proyecto.alarmatemprana.adapters.EvacuationZoneAdapter;
import usil.proyecto.alarmatempranoa.models.EvacuationLocation;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class EvacuationZonesActivity extends Activity implements OnItemClickListener{

	private List<EvacuationLocation> locationsList;
	private ListView lv_evacuation_zone; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evacuation_zone);
		createData();
		setupView();
	}
	
	
	private void createData(){
		locationsList = new ArrayList<EvacuationLocation>();
		EvacuationLocation l;
		l = new EvacuationLocation(1, "Lord Byron", "zone",-12.082958,-56.906863);
		locationsList.add(l);
		l = new EvacuationLocation(2, "Antonio Raimondi", "zone",-12.074424,-76.951703);
		locationsList.add(l);
		l = new EvacuationLocation(3, "Alpamayo", "zone",-12.0633658,-76.9385596);
		locationsList.add(l);
		l = new EvacuationLocation(4, "San Pedro", "zone",-12.098828,-76.920731);
		locationsList.add(l);
	}
	
	private void setupView(){
		lv_evacuation_zone = (ListView)findViewById(R.id.lv_evacuation_zones);
		EvacuationZoneAdapter evacuationZoneAdapter = new EvacuationZoneAdapter(this, R.layout.evacuation_location_cell, locationsList);
		lv_evacuation_zone.setAdapter(evacuationZoneAdapter);
		lv_evacuation_zone.setOnItemClickListener(this);
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
	  EvacuationLocation location = locationsList.get(arg2);
	  Log.d("a",location.getLatitude()+","+location.getLongitude());      
	  String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", location.getLatitude(),location.getLongitude(),location.getAddress());
      Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
      i.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
      startActivity(i);
    }

}
