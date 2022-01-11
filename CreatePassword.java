package kashif.jawed31.silentremover;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreatePassword extends Activity{
	EditText mesg1;
	EditText mesg2;
	String mesgstr1,mesgstr2;
    Button create;
    public static String file = "data";
	SharedPreferences data;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_password);
		mesg1=(EditText)findViewById(R.id.secretmsg);
		mesg2=(EditText)findViewById(R.id.cnfrmsecretmsg);
		create=(Button)findViewById(R.id.bsave);
		create.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			mesgstr1=mesg1.getText().toString();
			mesgstr2=mesg2.getText().toString();
			if(mesgstr1.equals(mesgstr2)){
				SharedPreferences prefs = getSharedPreferences(file, MODE_PRIVATE);
				  SharedPreferences.Editor editor = prefs.edit();
				  editor.putString("sharedString", mesgstr1);
				  editor.commit(); 
				  Intent openpage=new Intent("kashif.jawed31.silentremover.SAVETEXT");
					startActivity(openpage);
			
			}
			else{
				mesg1.setText("");
				mesg2.setText("");
				 Toast msg = Toast.makeText(CreatePassword.this,
			               "Password Not Matched!", Toast.LENGTH_LONG);
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
