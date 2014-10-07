package com.example.galeria_zad3;

import com.example.jusitfyTools.TextViewEx;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Gallery;
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
		final CountIndicatorView indicatorView;
		Display display = getWindowManager().getDefaultDisplay();

		Gallery gallery;
		TextView tNameView; // name
		TextViewEx tLdView; // short description

		// set indicator
		indicatorView = (CountIndicatorView) findViewById(R.id.indicator);

		// set gallery
		GalleryAdapter galleryAdapter = new GalleryAdapter(this,
				receivedPicture);
		gallery = (Gallery) findViewById(R.id.gallery1);
		gallery.setAdapter(galleryAdapter);
		gallery.setSpacing(100);
		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				indicatorView.setNumberSelected(position);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
		// set name
		tNameView = (TextView) findViewById(R.id.item2_textView_name);
		tNameView.setText(receivedPicture.getName());

		// set long description
		tLdView = (TextViewEx) findViewById(R.id.item2_textView_longDescription);
		tLdView.setText(receivedPicture.getLongDescription(), true);
	}
}
