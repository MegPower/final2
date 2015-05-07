package com.power.finalexam_2;

import com.power.flickrsearch.MainActivity;
import com.power.flickrsearch.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioGroup radioGroup1, radioGroup2;
    private RadioButton radioFroFar, radioToFar, radioFroCel, radioToCel, radioFroKel, radioToKel;
    private Button convert;
    private TextView textView;
	
    private String first, far, cel, kel;
    private String second, farT, celT, kelT;
    private String farStr = "Fahrenheit";
    private String celStr = "Celsius";
    private String kelStr = "Kelvin";
    TextView textView2;
	TextView textView3;
    
    int convertNum = 0;
    
	private EditText editText1;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editText1 = (EditText) findViewById(R.id.editText1);
		editText1.addTextChangedListener(editTextWatcher);
		
		radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup1);
		radioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup group, int checkedId) {
					// TODO Auto-generated method stub
		            if(checkedId == R.id.radioFroFar) {
		            	first = far;
		            } else if(checkedId == R.id.radioFroCel) {
		            	first = cel;
		            } else {
		            	first = kel;
		            }
						
				}}});

		radioGroup2 = (RadioGroup) void findViewById(R.id.radioGroup2);
		radioGroup2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if(checkedId == R.id.radioFroFar) {
					second = far;
				} else if(checkedId == R.id.radioFroCel) {
					second = cel;
				} else {
					second = kel;
				}
				
			}});	
		
		radioFroFar = (RadioButton) findViewById(R.id.radioFroFar);
		radioToFar = (RadioButton) findViewById(R.id.radioToFar);
		radioFroCel = (RadioButton) findViewById(R.id.radioFroCel);
		radioToCel = (RadioButton) findViewById(R.id.radioToCel);
		radioFroKel = (RadioButton) findViewById(R.id.radioFroKel);
		radioToKel = (RadioButton) findViewById(R.id.radioToKel);
		
		Button covert = (Button)findViewById(R.id.convert);

	}
	
	private TextWatcher editTextWatcher = new TextWatcher()
	{
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count)
		{
			//cast s as a string
			int hourEntered = Integer.parseInt(s.toString());
		}

		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private void convert()
	{
		//convert stuff
		if(first.equals(farStr) && second.equals(farStr))
		{
			//dialog error
			//create a new AlertDialog builder
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			
			//set dialog's title and message to display
			builder.setMessage("ERROR! Choose Different Units");
			
			//provide an Ok button to dismiss dialog
			builder.setPositiveButton("OK", null);
			
			//create AlertDialog from AlertDialog builder
			AlertDialog errorDialog = builder.create();
			errorDialog.show();

		}
		if(first.equals(farStr) && second.equals(celStr))
		{
			//far to cel
			double cel = (double) ((convertNum - 32)/1.8);
			String result = cel + "degrees";
			textView2.setText("F - 32 / 1.8");
			textView3.setText(result);
		}
		if(first.equals(farStr) && second.equals(kelStr))
		{
			//far to kel
			double far = (double) (((convertNum - 32) * 5 / 9 ));
			String result = far + "degrees";
			textView2.setText("f - 32) * 5 / 9");
			textView3.setText(result);
		}
		if(first.equals(celStr) && second.equals(farStr))
		{
			//cel to far
			double far = (double) ((convertNum * 2)+30);
			String result = far + "degrees";
			textView2.setText("(c*2)+30");
			textView3.setText(result);
		}
		if(first.equals(celStr)&& second.equals(celStr))
		{
			//dialog error
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			
			//set dialog's title and message to display
			builder.setMessage("ERROR! Choose Different Units");
			
			//provide an Ok button to dismiss dialog
			builder.setPositiveButton("OK", null);
			
			//create AlertDialog from AlertDialog builder
			AlertDialog errorDialog = builder.create();
			errorDialog.show();
		}
		if(first.equals(celStr)&& second.equals(kelStr))
		{
			//cel to kel
			double far = (double) ((convertNum - 273.15));
			String result = far + "degrees";
			textView2.setText("k - 273.15");
			textView3.setText(result);
			
		}
		if(first.equals(kelStr)&& second.equals(farStr))
		{
			//kel to far
			double far = (double) (((convertNum * 9/5) - 459.67));
			String result = far + "degrees";
			textView2.setText("k * 9/5) - 459.67");
			textView3.setText(result);
			
		}
		if(first.equals(kelStr)&& second.equals(celStr))
		{
			//kel to cel
			double far = (double) ((convertNum + 273.15));
			String result = far + "degrees";
			textView2.setText("c + 273.15");
			textView3.setText(result);
		}
		if(first.equals(kelStr)&& second.equals(kelStr))
		{
		//throw dialog error
			AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
			
			//set dialog's title and message to display
			builder.setMessage("ERROR! Choose Different Units");
			
			//provide an Ok button to dismiss dialog
			builder.setPositiveButton("OK", null);
			
			//create AlertDialog from AlertDialog builder
			AlertDialog errorDialog = builder.create();
			errorDialog.show();
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
