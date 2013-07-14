package com.example.deque;





import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	
	WebView BrowSer;
	
	
	
	private class MyWebViewClient extends WebViewClient {
	     @Override
	     public boolean shouldOverrideUrlLoading(WebView view, String url) {
	         view.loadUrl(url);
	         return true;
	     }
	 }
	
	private boolean isNetworkConnected() {
		  ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		  NetworkInfo ni = cm.getActiveNetworkInfo();
		  if (ni == null) {
		   // There are no active networks.
		   return false;
		  } else
		   return true;
		 }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		BrowSer = (WebView)findViewById(R.id.webEng);
		if(isNetworkConnected()){	
		
		//Enable javascript
				BrowSer.getSettings().setJavaScriptEnabled(true);
		try{
                	    BrowSer.loadUrl("http://192.168.1.2");
                	    BrowSer.setWebViewClient(new MyWebViewClient()); //redirecting links within browser
                	    
                				}catch(Exception e){
                					e.printStackTrace();
                				
                				}         
                } else {
                    // Internet connection is not present
                    Intent startPage = new Intent("com.example.deque.ErrorScr");
					startActivity(startPage);
					System.exit(0);	
                }
        
	}
	
	private static final long DOUBLE_PRESS_INTERVAL = 1000000000;
	private long lastPressTime;
	
	@Override
	public void onBackPressed()
	{
	     //put code here to do things
		BrowSer.goBack();
		//Check back key double pressed ,if yes exit. 
		long pressTime = System.nanoTime();
	    if(pressTime - lastPressTime <= DOUBLE_PRESS_INTERVAL) {
	    	finish();
            System.exit(0);
	    }
	    lastPressTime = pressTime;
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		//return super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		//return super.onMenuItemSelected(featureId, item);
		switch (item.getItemId()) {
		case R.id.aboutUs:
			Intent i = new Intent("com.example.deque.AboutUs");
			startActivity(i);
			break;
		case R.id.help:
			Intent in = new Intent("com.example.deque.Help");
			startActivity(in);
			
			break;
			
		case R.id.exit:
			finish();
            System.exit(0);	
			break;

		
		}
		return false;
	}

}
