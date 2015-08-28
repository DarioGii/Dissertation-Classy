package com.classy.project.dario.viewcontroller;

import com.classy.project.dario.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashView extends Activity
{
	private final int SPLASH_LENGTH = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);
		
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run()
			{
				Intent mainIntent = new Intent(SplashView.this, MainView.class);
				SplashView.this.startActivity(mainIntent);
				SplashView.this.finish();
			}
			
		}, SPLASH_LENGTH);
	}
}