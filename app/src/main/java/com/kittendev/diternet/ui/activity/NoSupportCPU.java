package com.kittendev.diternet.ui.activity;
import android.support.v7.app.*;
import android.os.*;
import com.kittendev.diternet.R;
public class NoSupportCPU extends AppCompatActivity
{

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setTheme(R.style.ErrorTheme);
		setContentView(R.layout.nosupportcpu);
	}
}
