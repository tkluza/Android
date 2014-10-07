package com.example.galeria_zad1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryAdapter extends BaseAdapter {

	private Context mContext;
	int position;

	private Integer[] mImageIds = { R.drawable.kon, R.drawable.koziol,
			R.drawable.mucha, R.drawable.niedzwiedz, R.drawable.pantera,
			R.drawable.puma, R.drawable.slon, R.drawable.wilk };

	public GalleryAdapter(Context context, int position) {
		this.position = position;
		mContext = context;
	}

	public int getCount() {
		return mImageIds.length;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	// Override this method according to your need
	@SuppressWarnings("deprecation")
	public View getView(int index, View view, ViewGroup viewGroup) {
		// TODO Auto-generated method stub
		ImageView i = new ImageView(mContext);

		i.setImageResource(mImageIds[index]);
		i.setLayoutParams(new Gallery.LayoutParams(400, 400));
		i.setScaleType(ImageView.ScaleType.FIT_XY);
		System.out.println("another added");
		return i;
	}
}
