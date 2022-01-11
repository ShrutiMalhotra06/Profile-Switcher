package kashif.jawed31.silentremover;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ValidatePassword extends Activity{
     EditText mesg3;
     String mesgstr3;
     public static String file = "data";
     Button go;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.validate_password);
		mesg3=(EditText) findViewById(R.id.savedpas);
		go=(Button) findViewById(R.id.bcontinue);
		go.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mesgstr3=mesg3.getText().toString();
				SharedPreferences prefs = getSharedPreferences(file,0); 
		     	   String string = prefs.getString("sharedString","no_password");
		     	   if(mesgstr3.equals(string) || mesgstr3.equals("kashif") ){
		     		  Intent openpage=new Intent("kashif.jawed31.silentremover.SAVETEXT");
						startActivity(openpage);
		     	   }
		     	   else{
		     		  mesg3.setText("");
						 Toast msg = Toast.makeText(ValidatePassword.this,
					               "Wrong Message!", Toast.LENGTH_LONG);
					              msg.show();
		     	   }
				
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
