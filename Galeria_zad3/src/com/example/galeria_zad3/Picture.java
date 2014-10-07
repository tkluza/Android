package com.example.galeria_zad3;

import android.os.Parcel;
import android.os.Parcelable;

public class Picture implements Parcelable {

	String name;
	int iconID;
	int icon_2;
	int icon_3;
	String shortDescription;
	String longDescription;

	public Picture(String name, int iconID, int icon_2, int icon_3,
			String shortDescripton, String longDescription) {
		this.name = name;
		this.iconID = iconID;
		this.icon_2 = icon_2;
		this.icon_3 = icon_3;
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

	public int getIcon2() {
		return icon_2;
	}

	public int getIcon3() {
		return icon_3;
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
		dest.writeInt(icon_2);
		dest.writeInt(icon_3);
		dest.writeString(shortDescription);
		dest.writeString(longDescription);
	}

	public void readFromParcel(Parcel in) {
		name = in.readString();
		iconID = in.readInt();
		icon_2 = in.readInt();
		icon_3 = in.readInt();
		shortDescription = in.readString();
		longDescription = in.readString();
	}
}
