package com.example.sharedprefhomework;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends Activity implements OnClickListener{

	//Не променяйте xml-a


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn = (Button) findViewById(R.id.button);
		btn.setOnClickListener(this);
	}

	//int value = seekBar.getProgress(); се използва за да проверите каква е стойността зададена в слайдъра
	//seekBar.setProgress(progress); се използва за да се зададе първоначална стойност на слайдера

	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences pref = getPreferences(0);
		SharedPreferences.Editor editor = pref.edit();
		int redVal = pref.getInt("red", -1);
		int greenVal = pref.getInt("green", -1);
		int blueVal = pref.getInt("blue", -1);
		if(redVal!=-1 && greenVal!=-1 && blueVal!=-1){
			LinearLayout container = (LinearLayout) findViewById(R.id.container);
			container.setBackgroundColor(Color.rgb(redVal,greenVal,blueVal));

			SeekBar redBar = (SeekBar) findViewById(R.id.red);
			SeekBar greenBar = (SeekBar) findViewById(R.id.green);
			SeekBar blueBar = (SeekBar) findViewById(R.id.blue);
			redBar.setProgress(redVal);
			greenBar.setProgress(greenVal);
			blueBar.setProgress(blueVal);
		}
	}

	@Override
	public void onClick(View v) {
		SharedPreferences pref = getPreferences(0);
		SharedPreferences.Editor editor = pref.edit();
		SeekBar redBar = (SeekBar) findViewById(R.id.red);
		SeekBar greenBar = (SeekBar) findViewById(R.id.green);
		SeekBar blueBar = (SeekBar) findViewById(R.id.blue);
		int redVal = redBar.getProgress();
		int greenVal = greenBar.getProgress();
		int blueVal = blueBar.getProgress();

		LinearLayout container = (LinearLayout) findViewById(R.id.container);
		container.setBackgroundColor(Color.rgb(redVal,greenVal,blueVal));

		editor.putInt("red", redVal);
		editor.putInt("green", greenVal);
		editor.putInt("blue", blueVal);
		editor.commit();
	}
}
