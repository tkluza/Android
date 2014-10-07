package com.example.galeria_zad3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryAdapter extends BaseAdapter {

	private Context mContext;
	public int[] mImageIds;

	public GalleryAdapter(Context context, Picture picture) {
		mContext = context;
		mImageIds = new int[] { picture.getIconID(), picture.getIcon2(),
				picture.getIcon3() };
	}

	public int getCount() {
		return mImageIds.length;
	}

	public int getIndexItemSelected(Gallery gallery) {
		return gallery.getSelectedItemPosition();
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
		i.setLayoutParams(new Gallery.LayoutParams(400, 300));
		i.setScaleType(ImageView.ScaleType.FIT_XY);
		return i;

	}
}
