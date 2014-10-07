package com.example.galeria_zad2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		createView();
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void createView() {
		Picture receivedPicture = getIntent().getExtras().getParcelable(
				"picture");
		ImageView iView;
		TextView tNameView; // name
		TextView tLdView; // short description

		// set image
		iView = (ImageView) findViewById(R.id.item2_imageView);
		iView.setImageResource(receivedPicture.getIconID());

		// set name
		tNameView = (TextView) findViewById(R.id.item2_textView_name);
		tNameView.setText(receivedPicture.getName());

		// set long description
		tLdView = (TextView) findViewById(R.id.item2_textView_longDescription);
		tLdView.setText(receivedPicture.getLongDescription());

	}
}
