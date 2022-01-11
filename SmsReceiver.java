package kashif.jawed31.silentremover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsMessage;
 
public class SmsReceiver extends BroadcastReceiver 
{
	public static String file = "data";
    @Override
    public void onReceive(Context context, Intent intent) 
    {
        //---get the SMS message passed in---
    	
        Bundle bundle = intent.getExtras();        
        SmsMessage[] msgs = null;
        String str="";            
        if (bundle != null)
        {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];            
            for (int i=0; i<msgs.length; i++)
            {
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);                
                str += msgs[i].getMessageBody().toString();        
            }
            SharedPreferences prefs = context.getSharedPreferences(file,0); 
     	   String string = prefs.getString("sharedString","default_value_here_if_string_is_missing");
            	
            //---display the new SMS message---
            if(str.equals(string)){
            	 Intent i = new Intent(context, change.class);  
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
                // i.putExtra("str",str);
                  context.startActivity(i);}
  
         
        }                         
    }
}