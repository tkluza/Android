package com.example.galeria_zad2;

import android.os.Parcel;
import android.os.Parcelable;

public class Picture implements Parcelable {

	String name;
	int iconID;
	String shortDescription;
	String longDescription;

	public Picture(String name, int iconID, String shortDescripton,
			String longDescription) {
		this.name = name;
		this.iconID = iconID;
		this.shortDescription = shortDescripton;
		this.longDescription = longDescription;

	}

	public Picture(Parcel in) {
		readFromParcel(in);
	}

	public String getName() {
		return name;
	}

	public int getIconID() {
		return iconID;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public static final Parcelable.Creator<Picture> CREATOR = new Parcelable.Creator<Picture>() {
		public Picture createFromParcel(Parcel in) {
			return new Picture(in);
		}

		public Picture[] newArray(int size) {
			return new Picture[size];
		}
	};

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		dest.writeString(name);
		dest.writeInt(iconID);
		dest.writeString(shortDescription);
		dest.writeString(longDescription);
	}

	public void readFromParcel(Parcel in) {
		name = in.readString();
		iconID = in.readInt();
		shortDescription = in.readString();
		longDescription = in.readString();
	}
}
