package com.tobi.ibsbuch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by Tobi on 24.03.2016.
 */
public class ICET5Wagenuebergaenge extends AppCompatActivity {


    Button ICET5Wagenübergänge01, ICET5Wagenübergänge17, ICET5Wagenübergänge76, ICET5Wagenübergänge65;
    SharedPreferences prefs;
    String Bildpfad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if(prefs.getBoolean("theme", false)) {
            setTheme(R.style.AppTheme2);

        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wagenuebergaenge);


        ICET5Wagenübergänge01 = (Button) findViewById(R.id.ICET5Wagenübergänge01);
        ICET5Wagenübergänge17 = (Button) findViewById(R.id.ICET5Wagenübergänge17);
        ICET5Wagenübergänge76 = (Button) findViewById(R.id.ICET5Wagenübergänge76);
        ICET5Wagenübergänge65 = (Button) findViewById(R.id.ICET5Wagenübergänge65);

        ICET5Wagenübergänge01.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5Wagenübergänge01.jpg";
                Intent i = new Intent(ICET5Wagenuebergaenge.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });

        ICET5Wagenübergänge17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5Wagenübergänge17.jpg";
                Intent i = new Intent(ICET5Wagenuebergaenge.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });

        ICET5Wagenübergänge76.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5Wagenübergänge76.jpg";
                Intent i = new Intent(ICET5Wagenuebergaenge.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });

        ICET5Wagenübergänge65.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5Wagenübergänge65.jpg";
                Intent i = new Intent(ICET5Wagenuebergaenge.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.anfang) {
            Intent i = new Intent(ICET5Wagenuebergaenge.this, MainActivity.class);
            startActivity(i);


            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}