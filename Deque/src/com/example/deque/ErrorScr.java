package com.example.deque;

import android.app.Activity;
import android.os.Bundle;

public class ErrorScr extends Activity {

	@Override
	protected void onCreate(Bundle scr) {
		// TODO Auto-generated method stub
		super.onCreate(scr);
		setContentView(R.layout.erscr);
		Thread timer = new Thread() {
			public void run(){
				try{
					sleep(5000);
				}catch (InterruptedException e){
					e.printStackTrace();
				}finally {
					System.exit(0);
						
				}
			}
		};
		timer.start();
	}
	

}
