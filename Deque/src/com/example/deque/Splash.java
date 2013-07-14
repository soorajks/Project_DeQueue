package com.example.deque;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle startB) {
		// TODO Auto-generated method stub
		super.onCreate(startB);
		setContentView(R.layout.sp);
		Thread timer = new Thread() {
			public void run(){
				try{
					sleep(2000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally {
					Intent startPage = new Intent("com.example.deque.MainActivity");
					startActivity(startPage);
						
				}
			}
		};
		timer.start();
	
	}
//To kill the splash screen after completion

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
}
