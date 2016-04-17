package com.tobi.ibsbuch;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Tobi on 14.02.2016.
 */
public class Suche extends AppCompatActivity {

    SharedPreferences prefs;
    private ListView lv;
    ArrayAdapter<String> adapter;
    EditText inputSearch;
    String Bildpfad;

    String[] products = {"Saugkreis ICE1", "ZSIsoPruefung ICE1", "Skizze ICE403", "Wagenuebergaenge ICE403", "AsrSetzMaske ICET5", "Wagenuebergaenge ICET5", "Triebdrehgestelle Messen ICE1"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Preferences
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if (prefs.getBoolean("theme", false)) {
            setTheme(R.style.AppTheme2);

        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suche);

        // Listview Data
        lv = (ListView) findViewById(R.id.listview);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        // Adding items to listview
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, products);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new ListClickHandler());


        //Enabling Search Filter
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                Suche.this.adapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {

            }
        });
    }

    public class ListClickHandler implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapter, View view, int position, long arg3) {
            // Get Value + Position
            int itemPosition = position;
            String itemValue = (String) lv.getItemAtPosition(position);
//            Toast.makeText(getApplicationContext(),
//                    "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
//                    .show();


            if (itemValue.contains("Saugkreis ICE1")) {
                Bildpfad = "ice1/ICE1SaugkreisGTO.jpg";
                Intent i = new Intent(Suche.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }

            if (itemValue.contains("ZSIsoPruefung ICE1")) {
                Bildpfad = "ice1/ICE1ZSIsoPruefung.jpg";
                Intent i = new Intent(Suche.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }

            if (itemValue.contains("Skizze ICE403")) {
                Bildpfad = "ice403/ICE3Skizze.jpg";
                Intent i = new Intent(Suche.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }

            if (itemValue.contains("Wagenuebergaenge ICE403")) {
                Bildpfad = "ice403/ICE3Wagenuebergaenge.jpg";
                Intent i = new Intent(Suche.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }

            if (itemValue.contains("AsrSetzMaske ICET5")) {
                Bildpfad = "icet5/ICET5AsrSetzMaske.jpg";
                Intent i = new Intent(Suche.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
            if (itemValue.contains("Wagenuebergaenge ICET5")) {
                Intent i = new Intent(Suche.this, Wagenuebergaenge.class);
                startActivity(i);
            }
            if (itemValue.contains("Triebdrehgestelle Messen ICE1")) {
                Bildpfad = "ice1/ICE1Triebdrehgestellemessen.jpg";
                Intent i = new Intent(Suche.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }

//            if (itemPosition == 40) {
//
//                Intent intent = new Intent(Suche.this, MainActivity.class);
//                startActivity(intent);
//
//
//            }
        }

    }
}
