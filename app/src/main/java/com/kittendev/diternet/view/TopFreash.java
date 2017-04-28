package com.kittendev.diternet.view;
import android.support.v4.widget.*;
import android.view.*;
import android.content.*;
import android.util.*;

public class TopFreash extends SwipeRefreshLayout {

	private ViewGroup viewGroup ;
	public boolean isUse=true;

	public TopFreash(Context context) {
		super(context);
	}
	public TopFreash(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public ViewGroup getViewGroup() {
		return viewGroup;
	}
	public void setViewGroup(ViewGroup viewGroup) {
		this.viewGroup = viewGroup;
	}

	@Override
	public boolean onTouchEvent(MotionEvent arg0) {
		if(null!=viewGroup){
			if((viewGroup.getScrollY()> 1)||!isUse){
				//直接截断时间传播
				return false;
			}else{
				return super.onTouchEvent(arg0);
			}
		}
		return super.onTouchEvent(arg0);
	}
	}
