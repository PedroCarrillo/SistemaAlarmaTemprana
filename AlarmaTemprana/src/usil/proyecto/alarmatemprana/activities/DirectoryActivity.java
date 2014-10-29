package usil.proyecto.alarmatemprana.activities;

import java.util.ArrayList;
import java.util.List;

import usil.proyecto.alarmatemprana.R;
import usil.proyecto.alarmatemprana.adapters.ContactAdapter;
import usil.proyecto.alarmatempranoa.models.Contact;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class DirectoryActivity extends Activity{
	
	private ListView contactListListView;
	private List<Contact> contactList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_directory);
		createData();
		setupView();
	}
	
	private void createData(){
		contactList = new ArrayList<Contact>();
		Contact c;
		c = new Contact(1, "contacto 1", "123456","911","Direccion 1");
		contactList.add(c);
		c = new Contact(2, "contacto 2", "123456","444","Direccion 2");
		contactList.add(c);
		c = new Contact(3, "contacto 3", "123456","123","Direccion 3");
		contactList.add(c);
		c = new Contact(4, "contacto 4", "123456","667","Direccion 4");
		contactList.add(c);
	}
	
	private void setupView(){
		contactListListView = (ListView)findViewById(R.id.lv_contacts);
		ContactAdapter contactAdapter = new ContactAdapter(this, R.layout.contact_cell, contactList);
		contactListListView.setAdapter(contactAdapter);
	}
}
