package com.example.explicitintent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityA extends Activity {

	private static final int request_code = 5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity, menu);
		return true;
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if ((requestCode == request_code) && 
		                     (resultCode == RESULT_OK)) {
				
				TextView textView1 = (TextView) findViewById(R.id.textView1);
					
				String returnString = 
		                     data.getExtras().getString("returnData");
					
				textView1.setText(returnString);	
		}
	}

	
    public void onClick(View view) {
    	
    	Intent i = new Intent(this, ActivityB.class);   	
    	//if we want the result then we need the four last
    	//lines, but if we do not care about the result
    	//we can use one line of code:
    	//startActivity(i);
    	final EditText editText1 = (EditText)  
                    findViewById(R.id.editText1);
    	String myString = editText1.getText().toString();
    	i.putExtra("qString", myString);
    	startActivityForResult(i, request_code);
    }	
}
