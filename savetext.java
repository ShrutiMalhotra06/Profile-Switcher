package kashif.jawed31.silentremover;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public  class savetext extends Activity {
	Button save;
	EditText mess;
	public static String file = "data";
	SharedPreferences data;
	String changestr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_screen);
		data= getSharedPreferences(file,0);
		save=(Button) findViewById(R.id.bchange);
		mess=(EditText) findViewById(R.id.changetxt);
	    save.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				changestr=mess.getText().toString();
				SharedPreferences prefs = getSharedPreferences(file, MODE_PRIVATE);
				  SharedPreferences.Editor editor = prefs.edit();
				  editor.putString("sharedString", changestr);
				  editor.commit(); 
				  Toast msg = Toast.makeText(savetext.this,
			               "Message Saved Successfully!", Toast.LENGTH_LONG);
			              msg.show();
				
			}
		});
		}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	}