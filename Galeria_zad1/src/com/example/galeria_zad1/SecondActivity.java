package com.example.galeria_zad1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;

public class SecondActivity extends Activity {

	Button b_back;
	ImageView selectedImage;
	int extras;
	private Integer[] mImageIds = { R.drawable.kon, R.drawable.koziol,
			R.drawable.mucha, R.drawable.niedzwiedz, R.drawable.pantera,
			R.drawable.puma, R.drawable.slon, R.drawable.wilk };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		b_back = (Button) findViewById(R.id.button1);
		b_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		extras = this.getIntent().getExtras().getInt(MainActivity.EXTRASNAME);
		Gallery gallery = (Gallery) findViewById(R.id.gallery1);
		gallery.setSpacing(100);
		gallery.setAdapter(new GalleryAdapter(this, extras));
		gallery.setSelection(extras);

	}
}