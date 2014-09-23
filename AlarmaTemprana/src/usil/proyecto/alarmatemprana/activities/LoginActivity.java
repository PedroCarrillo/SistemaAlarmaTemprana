package usil.proyecto.alarmatemprana.activities;

import usil.proyecto.alarmatemprana.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		setupView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		switch(id){
			case R.id.news_setting:
			    break;
			case R.id.recommendations_setting:
			    break;
			case R.id.directory_setting:
			    break;
			case R.id.evacuation_zones_setting:
			    break;
			case R.id.flashlight_setting:
			    break;
			case R.id.evacuation_routes_setting:
			    break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void setupView(){
		final EditText et_user = (EditText)findViewById(R.id.et_username);
		final EditText et_pass = (EditText)findViewById(R.id.et_password);
		Button btn_login = (Button)findViewById(R.id.btn_login);
		
		btn_login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String st_username = et_user.getText().toString();
				String st_password = et_pass.getText().toString();
				if(validInput(st_username)){
					et_user.setError(getString(R.string.obligatory_string));
				}else if(validInput(st_password)){
					et_pass.setError(getString(R.string.obligatory_string));
				}
				if(validInput(st_username) && validInput(st_password)){
					//TODO Login async 
					Intent intent = new Intent(LoginActivity.this, MainActivity.class);
					startActivity(intent);
					finish();
				}
			}
		});
	}
	
	public boolean validInput(String input){
		if(input == null){
			return false;
		}
		if(input.isEmpty()){
			return false;
		}
		return true;
	}
}
