package com.kittendev.diternet.ui.activity;

import android.content.*;
import android.graphics.*;
import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.view.View.*;
import android.view.inputmethod.*;
import android.widget.*;
import com.kittendev.diternet.*;

public class MainActivity extends AppCompatActivity
{private WebView web;
private AppCompatEditText urlInputer;
	private AppCompatImageButton refreash,go,back;
	private long exitTime;
	InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		urlInputer = (AppCompatEditText)this.findViewById(R.id.url_editor);
		refreash=(AppCompatImageButton)this.findViewById(R.id.ref);
		go=(AppCompatImageButton)this.findViewById(R.id.go);
		go.setOnClickListener(OnclickListener);
		back=(AppCompatImageButton)this.findViewById(R.id.back);
		back.setOnClickListener(OnclickListener);
		refreash.setOnClickListener(OnclickListener);
		web = (WebView) getSupportFragmentManager().findFragmentById(R.id.id_fragment_title);
		web.load("http://fir.im/Diternet");
		web.setClickable(true);    
		h.postDelayed(r,3000);
		urlInputer.setHint("Diternet");
		urlInputer.setOnFocusChangeListener(new OnFocusChangeListener(){

				@Override
				public void onFocusChange(View p1, boolean p2)
				{if(p2){
					urlInputer.setText(web.getUrl());		
					imm.showSoftInput(p1, InputMethodManager.SHOW_IMPLICIT);
					web.setClickable(false);
					urlInputer.setSelection(web.getUrl().length());
				}
				else{
					web.setClickable(true);
					urlInputer.setText("");
					urlInputer.setHint(web.getTitle());
//					InputMethodManager imm = (InputMethodManager)
//						getSystemService(Context.INPUT_METHOD_SERVICE);
//					imm.showSoftInput(p1, InputMethodManager.HIDE_IMPLICIT_ONLY);
				}
					// TODO: Implement this method
				}
			});
		}

	View.OnClickListener OnclickListener=new OnClickListener(){

		@Override
		public void onClick(View p1)
		{		// TODO: Implement this method
		switch(p1.getId()){
		case R.id.ref:
			web.reload();
			urlInputer.clearFocus();
			break;
		case R.id.go:
			web.goforward();
			break;
		case R.id.back:
			web.goBack();
		}
		}
	};
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			if(web.canGoBack()){
				web.goBack();
			}else{
				if ((System.currentTimeMillis() - exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
				{
					Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();                                
					exitTime = System.currentTimeMillis();
				}
				else
				{
					finish();
				}
			}}
		return true;

	}
	public void setmHint(String title){
		urlInputer.setHint(title);
	}
	Runnable r=new Runnable(){

		@Override
		public void run()
		{
			// TODO: Implement this method
			h.sendEmptyMessage(0);
		}
	};
	Handler h=new Handler(){
		@Override
		public void handleMessage(Message msg)
		{
			// TODO: Implement this method
			super.handleMessage(msg);
		}};
}
