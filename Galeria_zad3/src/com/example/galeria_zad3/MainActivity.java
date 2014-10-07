package com.example.galeria_zad3;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	List<Picture> pictures = new ArrayList<Picture>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		createListView();
	}

	public void addPictures() {
		pictures.add(new Picture(
				"Hiena",
				R.drawable.hiena,
				R.drawable.hiena2,
				R.drawable.hiena3,
				"Waga: 10 - 30 kg",
				"Hiena -  gatunek drapie�nego ssaka z rodziny hienowatych, jedyny przedstawiciel rodzaju Crocuta, najwi�ksza ze wsp�czesnie �yj�cych hien "));
		pictures.add(new Picture(
				"Ko�",
				R.drawable.kon,
				R.drawable.kon2,
				R.drawable.kon3,
				"Waga: 50 - 200 kg",
				"Ko� (Equus caballus) � ssak nieparzystokopytny z rodziny koniowatych. Ko� zosta� udomowiony prawdopodobnie na terenie p�nocnego Kazachstanu w okresie kultury Botai tj. oko�o 3,5 tys. lat p.n.e."));
		pictures.add(new Picture(
				"Kozio�",
				R.drawable.koziol,
				R.drawable.koziol2,
				R.drawable.koziol3,
				"Waga: 30 - 120 kg",
				"Kozio� (Oreamnos americanus) - gatunek du�ego ssaka z rodziny kr�torogich (Bovidae)"));
		pictures.add(new Picture(
				"Lampart",
				R.drawable.lampart,
				R.drawable.lampart2,
				R.drawable.lampart3,
				"Waga: 60 - 90 kg",
				"Lampart (Panthera pardus) � gatunek ssaka z rodziny kotowatych (Felidae). Czwarty pod wzgl�dem wielko�ci kot �wiata (po tygrysie, lwie i jaguarze)."));
		pictures.add(new Picture(
				"Mucha",
				R.drawable.mucha,
				R.drawable.mucha2,
				R.drawable.mucha3,
				" Waga: 0.001 - 0.02 kg",
				"Mucha - pospolita mucha domowa jest owadem wyst�puj�cym na ca�ym �wiecie. Jest niewielka (samica jest wi�ksza od samca � osi�ga do 7,5 mm d�ugo�ci), na ciemnoszarym tu�owiu widoczne s� pod�u�ne paski."));
		pictures.add(new Picture(
				"Nied�wied�",
				R.drawable.niedzwiedz,
				R.drawable.niedzwiedz2,
				R.drawable.niedzwiedz3,
				"Waga: 200 - 780 kg",
				"Nied�wied� -  gatunek drapie�nego ssaka z rodziny nied�wiedziowatych. Zamieszkuje Azj�, Europ� P�nocn� i Ameryk� P�nocn�. Niezagro�ony wygini�ciem."));
		pictures.add(new Picture(
				"Puma",
				R.drawable.puma,
				R.drawable.puma2,
				R.drawable.puma3,
				"Waga: 35 - 75 kg",
				"Puma  (Puma concolor) � gatunek drapie�nego ssaka z rodziny kotowatych (Felidae) zamieszkuj�cy Ameryk� od Kanady po Patagoni� (cho� w wielu regionach zosta�a wyt�piona)."));
		pictures.add(new Picture(
				"S�o� afryka�ski",
				R.drawable.slon,
				R.drawable.slon2,
				R.drawable.slon3,
				"Waga: 3200 - 6000 kg",
				"S�o� afryka�ski (Loxodonta africana) � gatunek ssaka z rodziny s�oniowatych, najwi�ksze wsp�cze�nie �yj�ce zwierz� l�dowe. Wcze�niej uznawany jako jeden gatunek wraz z afryka�skim s�oniem le�nym (Loxodonta cyclotis)."));
		pictures.add(new Picture(
				"Tygrys",
				R.drawable.tygrys,
				R.drawable.tygrys2,
				R.drawable.tygrys3,
				"Waga: 100 - 250 kg",
				"Tygrys (Panthera tigris) � gatunek du�ego, drapie�nego ssaka �o�yskowego z rodziny kotowatych (Felidae), najwi�kszy z �yj�cych wsp�cze�nie[6] czterech wielkich."));
		pictures.add(new Picture(
				"Wilk",
				R.drawable.wilk,
				R.drawable.wilk2,
				R.drawable.wilk3,
				"Waga: 60 - 85 kg",
				"Wilk (Canis lupus) � gatunek drapie�nego ssaka z rodziny psowatych (Canidae), zamieszkuj�cego lasy, r�wniny, tereny bagienne oraz g�ry Eurazji i Ameryki P�nocnej. Gatunek o sk�onno�ciach terytorialnych. "));
		pictures.add(new Picture(
				"�ubr",
				R.drawable.zubr,
				R.drawable.zubr2,
				R.drawable.zubr3,
				"Waga: 320 - 700 kg",
				"�ubr (Bison bonasus) � gatunek �o�yskowca z rodziny kr�torogich, rz�du parzystokopytnych. W 2012 roku �wiatowe zasoby gatunku wynosi�y oko�o 4663 osobnik�w, z czego 1552 z nich przebywa w hodowlach zamkni�tych, a 3111 �yje w wolnych i w p�wolnych stadach."));
		pictures.add(new Picture(
				"�yrafa",
				R.drawable.zyrafa,
				R.drawable.zyrafa2,
				R.drawable.zyrafa3,
				"Waga: 500 - 1600 kg",
				"�yrafa (Giraffa camelopardalis) � afryka�ski ssak parzystokopytny z rodziny �yrafowatych, najwy�sze zwierz� l�dowe i najwi�kszy z prze�uwaczy �yj�cych w XXI wieku. Jego epitet gatunkowy odnosi si� do przypominaj�cego wielb��da wygl�du i �at na futrze, w�a�ciwych lampartowi (leopardowi, Panthera pardus)."));

	}

	public void createListView() {
		addPictures();
		ArrayAdapter<Picture> adapter = new MainActivity_Adapter();
		ListView listView = (ListView) findViewById(R.id.picturesListView);
		listView.setAdapter(adapter);
		listView.setClickable(true);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				Intent intent = new Intent(MainActivity.this,
						SecondActivity.class).putExtra("picture",
						pictures.get(position));
				startActivity(intent);
			}

		});
	}

	public class MainActivity_Adapter extends ArrayAdapter<Picture> {

		public MainActivity_Adapter() {
			super(MainActivity.this, R.layout.item_view, pictures);

		}

		private class ViewHolder {
			ImageView iView;
			TextView tNameView;
			TextView tSdTextView;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			ViewHolder holder = null;
			LayoutInflater inflater = (LayoutInflater) MainActivity.this
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			if (v == null) {
				v = inflater.inflate(R.layout.item_view, null);
				holder = new ViewHolder();
				holder.iView = (ImageView) v.findViewById(R.id.item_imageView);
				holder.tNameView = (TextView) v
						.findViewById(R.id.item_textView_name);
				holder.tSdTextView = (TextView) v
						.findViewById(R.id.item_textView_shortDescription);
				v.setTag(holder);
			} else
				holder = (ViewHolder) v.getTag();

			// fill the view
			Picture currentPicture = pictures.get(position);
			holder.iView.setImageResource(currentPicture.getIconID());
			holder.tNameView.setText(currentPicture.getName());
			holder.tSdTextView.setText(currentPicture.getShortDescription());

			return v;
		}

	}

}
