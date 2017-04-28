package com.kittendev.diternet.ui.activity;

import android.support.v7.app.*;
import android.os.*;
import android.content.*;
import android.app.*;
import com.kittendev.diternet.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;

public class StartActivity extends AppCompatActivity
{
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity);
		if((((Build.CPU_ABI).indexOf("arm"))!=-1)&(Build.CPU_ABI).indexOf("x86")==-1){
		startActivity(new Intent(this, MainActivity.class));}
		else{
			startActivity(new Intent(this,NoSupportCPU.class));
		}
		finish();
	}
}
