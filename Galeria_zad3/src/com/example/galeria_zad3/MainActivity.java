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
				"Hiena -  gatunek drapie¿nego ssaka z rodziny hienowatych, jedyny przedstawiciel rodzaju Crocuta, najwiêksza ze wspó³czesnie ¿yj¹cych hien "));
		pictures.add(new Picture(
				"Koñ",
				R.drawable.kon,
				R.drawable.kon2,
				R.drawable.kon3,
				"Waga: 50 - 200 kg",
				"Koñ (Equus caballus) – ssak nieparzystokopytny z rodziny koniowatych. Koñ zosta³ udomowiony prawdopodobnie na terenie pó³nocnego Kazachstanu w okresie kultury Botai tj. oko³o 3,5 tys. lat p.n.e."));
		pictures.add(new Picture(
				"Kozio³",
				R.drawable.koziol,
				R.drawable.koziol2,
				R.drawable.koziol3,
				"Waga: 30 - 120 kg",
				"Kozio³ (Oreamnos americanus) - gatunek du¿ego ssaka z rodziny krêtorogich (Bovidae)"));
		pictures.add(new Picture(
				"Lampart",
				R.drawable.lampart,
				R.drawable.lampart2,
				R.drawable.lampart3,
				"Waga: 60 - 90 kg",
				"Lampart (Panthera pardus) – gatunek ssaka z rodziny kotowatych (Felidae). Czwarty pod wzglêdem wielkoœci kot œwiata (po tygrysie, lwie i jaguarze)."));
		pictures.add(new Picture(
				"Mucha",
				R.drawable.mucha,
				R.drawable.mucha2,
				R.drawable.mucha3,
				" Waga: 0.001 - 0.02 kg",
				"Mucha - pospolita mucha domowa jest owadem wystêpuj¹cym na ca³ym œwiecie. Jest niewielka (samica jest wiêksza od samca – osi¹ga do 7,5 mm d³ugoœci), na ciemnoszarym tu³owiu widoczne s¹ pod³u¿ne paski."));
		pictures.add(new Picture(
				"NiedŸwiedŸ",
				R.drawable.niedzwiedz,
				R.drawable.niedzwiedz2,
				R.drawable.niedzwiedz3,
				"Waga: 200 - 780 kg",
				"NiedŸwiedŸ -  gatunek drapie¿nego ssaka z rodziny niedŸwiedziowatych. Zamieszkuje Azjê, Europê Pó³nocn¹ i Amerykê Pó³nocn¹. Niezagro¿ony wyginiêciem."));
		pictures.add(new Picture(
				"Puma",
				R.drawable.puma,
				R.drawable.puma2,
				R.drawable.puma3,
				"Waga: 35 - 75 kg",
				"Puma  (Puma concolor) – gatunek drapie¿nego ssaka z rodziny kotowatych (Felidae) zamieszkuj¹cy Amerykê od Kanady po Patagoniê (choæ w wielu regionach zosta³a wytêpiona)."));
		pictures.add(new Picture(
				"S³oñ afrykañski",
				R.drawable.slon,
				R.drawable.slon2,
				R.drawable.slon3,
				"Waga: 3200 - 6000 kg",
				"S³oñ afrykañski (Loxodonta africana) – gatunek ssaka z rodziny s³oniowatych, najwiêksze wspó³czeœnie ¿yj¹ce zwierzê l¹dowe. Wczeœniej uznawany jako jeden gatunek wraz z afrykañskim s³oniem leœnym (Loxodonta cyclotis)."));
		pictures.add(new Picture(
				"Tygrys",
				R.drawable.tygrys,
				R.drawable.tygrys2,
				R.drawable.tygrys3,
				"Waga: 100 - 250 kg",
				"Tygrys (Panthera tigris) – gatunek du¿ego, drapie¿nego ssaka ³o¿yskowego z rodziny kotowatych (Felidae), najwiêkszy z ¿yj¹cych wspó³czeœnie[6] czterech wielkich."));
		pictures.add(new Picture(
				"Wilk",
				R.drawable.wilk,
				R.drawable.wilk2,
				R.drawable.wilk3,
				"Waga: 60 - 85 kg",
				"Wilk (Canis lupus) – gatunek drapie¿nego ssaka z rodziny psowatych (Canidae), zamieszkuj¹cego lasy, równiny, tereny bagienne oraz góry Eurazji i Ameryki Pó³nocnej. Gatunek o sk³onnoœciach terytorialnych. "));
		pictures.add(new Picture(
				"¯ubr",
				R.drawable.zubr,
				R.drawable.zubr2,
				R.drawable.zubr3,
				"Waga: 320 - 700 kg",
				"¯ubr (Bison bonasus) – gatunek ³o¿yskowca z rodziny krêtorogich, rzêdu parzystokopytnych. W 2012 roku œwiatowe zasoby gatunku wynosi³y oko³o 4663 osobników, z czego 1552 z nich przebywa w hodowlach zamkniêtych, a 3111 ¿yje w wolnych i w pó³wolnych stadach."));
		pictures.add(new Picture(
				"¯yrafa",
				R.drawable.zyrafa,
				R.drawable.zyrafa2,
				R.drawable.zyrafa3,
				"Waga: 500 - 1600 kg",
				"¯yrafa (Giraffa camelopardalis) – afrykañski ssak parzystokopytny z rodziny ¿yrafowatych, najwy¿sze zwierzê l¹dowe i najwiêkszy z prze¿uwaczy ¿yj¹cych w XXI wieku. Jego epitet gatunkowy odnosi siê do przypominaj¹cego wielb³¹da wygl¹du i ³at na futrze, w³aœciwych lampartowi (leopardowi, Panthera pardus)."));

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
