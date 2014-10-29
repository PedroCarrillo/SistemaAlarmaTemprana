package usil.proyecto.alarmatemprana.activities;

import usil.proyecto.alarmatemprana.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class FlashlightActivity extends Activity{
	
	private ImageView iv_flashlight;
    private Camera camera;
    private boolean isFlashOn;
    private boolean hasFlash;
    Parameters params;
    MediaPlayer mp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flashlight);
		setupView();
	}
	
	@Override
	protected void onDestroy() {
	    super.onDestroy();
	}
	 
	@Override
	protected void onPause() {
	    super.onPause();
	    turnOffFlash();
	}
	 
	@Override
	protected void onRestart() {
	    super.onRestart();
	}
	 
	@Override
	protected void onResume() {
	    super.onResume();
	    if(hasFlash) turnOnFlash();
	}
	 
	@Override
	protected void onStart() {
	    super.onStart();
	    getCamera();
	}
	 
	@Override
	protected void onStop() {
	    super.onStop(); 
	    if (camera != null) {
	        camera.release();
	        camera = null;
	    }
	}
	
	private void setupView(){
		iv_flashlight = (ImageView) findViewById(R.id.btn_activate);
		iv_flashlight.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (isFlashOn) {
		            turnOffFlash();
		        } else {
		        	turnOnFlash();
		        }
			}
		});
		
		hasFlash = getApplicationContext().getPackageManager()
		        .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
		 
		if (!hasFlash) {
		    AlertDialog alert = new AlertDialog.Builder(FlashlightActivity.this)
		            .create();
		    alert.setTitle("Error");
		    alert.setMessage("Tu dispositivo no soporta usar la linterna");
		    alert.setButton("OK", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) {
		        }
		    });
		    alert.show();
		    return;
		}

	}
	
	private void getCamera() {
	    if (camera == null) {
	        try {
	            camera = Camera.open();
	            params = camera.getParameters();
	        } catch (RuntimeException e) {
	            Log.e("Camera Error. Failed to Open. Error: ", e.getMessage());
	        }
	    }
	}
	 
	private void turnOnFlash() {
	    if (!isFlashOn) {
	        if (camera == null || params == null) {
	            return;
	        } 
	        params = camera.getParameters();
	        params.setFlashMode(Parameters.FLASH_MODE_TORCH);
	        camera.setParameters(params);
	        camera.startPreview();
	        isFlashOn = true;
	         
	        toggleButtonImage();
	    }
	 
	}
	
	private void turnOffFlash() {
	    if (isFlashOn) {
	        if (camera == null || params == null) {
	            return;
	        }
	        params = camera.getParameters();
	        params.setFlashMode(Parameters.FLASH_MODE_OFF);
	        camera.setParameters(params);
	        camera.stopPreview();
	        isFlashOn = false;
	         
	        toggleButtonImage();
	    }
	}

	private void toggleButtonImage(){
	    if(isFlashOn){
	        iv_flashlight.setImageResource(R.drawable.flashlight_on);
	    }else{
	    	iv_flashlight.setImageResource(R.drawable.flashlight_off);
	    }
	}
	
}
