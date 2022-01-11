package kashif.jawed31.silentremover;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.widget.Toast;

public class change extends Activity {
	
    /** Called when the activity is first created. */
    
    private AudioManager maudio;
    
    @Override
	protected void onCreate(Bundle savedInstanceState) {
    	//Bundle bundle = getIntent().getExtras();
    	//String str = bundle.getString("str");
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		maudio=(AudioManager)getSystemService(AUDIO_SERVICE);
	       maudio.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
		AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		audioManager.setStreamVolume(AudioManager.STREAM_RING,
				audioManager.getStreamMaxVolume(AudioManager.STREAM_RING),
				   AudioManager.FLAG_PLAY_SOUND);
	       Toast msg = Toast.makeText(change.this,
	               "General mode activated!", Toast.LENGTH_LONG);
	              msg.show();
	              setContentView(R.layout .main_screen);
	             /* finish();
	              Intent startMain = new Intent(Intent.ACTION_MAIN);
	              startMain.addCategory(Intent.CATEGORY_HOME);
	              startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	              startActivity(startMain);*/
	              
	              
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		setContentView(R.layout.main_screen);
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setContentView(R.layout.main_screen);
	}
    
}