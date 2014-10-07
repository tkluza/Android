package com.example.quiz_zad6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

	int step = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		showResults();
	}

	public void startOnClickSecondActivity(View v) {
		if (step == 1) {
			step++;
			Intent intent = new Intent(this, SecondActivity.class);
			startActivity(intent);
		} else {
			Intent intent = new Intent(this, SecondActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
			startActivity(intent);
			finish();
		}
	}

	public void showResults() {
		TextView item_start = (TextView) findViewById(R.id.item_start);
		item_start.setText("Analizuj odpowiedzi");
	}
}
