package com.kittendev.diternet.ui.activity;
import android.view.*;
import android.os.*;
import com.kittendev.diternet.*;
import org.xwalk.core.XWalkView;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import org.xwalk.core.*;
import android.support.v7.widget.*;
import org.xwalk.core.internal.*;
import com.kittendev.diternet.view.*;
import android.support.v4.app.*;
public class WebView extends Fragment
{

	private XWalkView web;
private TopFreash top;
	private View view;
	private AppCompatEditText urltext;

	public void setClickable(boolean p0)
	{web.setClickable(p0);
		// TODO: Implement this method
	}
	

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		// TODO: Implement this method
		 view = inflater.inflate(com.kittendev.diternet.R.layout.fragment_webview, container, false);
		 top=(TopFreash)view.findViewById(com.kittendev.diternet.R.id.mainSwipeRefreshLayout1);
		 web=(XWalkView) view.findViewById(com.kittendev.diternet.R.id.web);
		XWalkPreferences.setValue(XWalkPreferences.ANIMATABLE_XWALK_VIEW, true);
		urltext =(AppCompatEditText) getActivity().findViewById(com.kittendev.diternet.R.id.url_editor);
		top.setViewGroup(web);
		top.setOnRefreshListener(new OnRefreshListener(){

				@Override
				public void onRefresh()
				{reload();
					// TODO: Implement this method
				}
			});
		//top.isUse=sp.getBoolean("useF",true);
		top.setColorScheme(com.kittendev.diternet.R.color.colorPrimary);
		web.setUIClient(new XWalkUIClient(web){
				public void  onPageLoadStopped(XWalkView view,String url,XWalkUIClient.LoadStatus status){
					top.setRefreshing(false);
					//urltext.setHint(web.getTitle());
				}	});
		return view;
	}
	public void load(String url){
		web.loadUrl(url);
	}
	public boolean canGoBack(){
		return web.getNavigationHistory().canGoBack();
	}
	public void goBack(){
		web.getNavigationHistory().navigate(
			XWalkNavigationHistory.Direction.BACKWARD, 1);
	}
	public void goforward(){	
		web.getNavigationHistory().navigate(
			XWalkNavigationHistory.Direction.FORWARD, 1);
	}
	public float scrollY(){
		return web.getScrollY();
	}
	public String getTitle(){
		return web.getTitle();
	}
	public String getUrl(){
		return web.getUrl();
	}
	public void reload()
	{//web.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.FORWARD, 0);
			//web.loadUrl(web.getOriginalUrl());
			web.reload(0);
		// TODO: Implement this method
	}
	@Override
	public void onDestroy()
	{
		// TODO: Implement this method
		super.onDestroy();
		XWalkPreferences.setValue(XWalkPreferences.ANIMATABLE_XWALK_VIEW, true);
	}
		
}
