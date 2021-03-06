package com.tobi.ibsbuch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Tobi on 21.12.2015.
 */
public class ICE1 extends AppCompatActivity {


    Button ICE1SaugkreisGTO, ICE1ZSIsoPruefung, ICE1Triebdrehgestellemessen, ICE1Neumon, ICE1Zwischenkreis, ICE1Erdschlusserfassung, ICETemperaturen;
    SharedPreferences prefs;
    String Bildpfad;
    Animation scroll;
    ImageView fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);
        if (prefs.getBoolean("theme", false)) {
            setTheme(R.style.AppTheme2);

        } else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.ice1);
//        onShouldStartActivity();

        ICE1SaugkreisGTO = (Button) findViewById(R.id.ICE1SaugkreisGTO);
        ICE1ZSIsoPruefung = (Button) findViewById(R.id.ICE1ZSIsoPruefung);
        ICE1Triebdrehgestellemessen = (Button) findViewById(R.id.ICE1Triebdrehgestellemessen);
        ICE1Neumon = (Button) findViewById(R.id.ICE1Neumon);
        ICE1Zwischenkreis = (Button) findViewById(R.id.ICE1Zwischenkreis);
        ICE1Erdschlusserfassung = (Button) findViewById(R.id.ICE1Erdschlusserfassung);
        ICETemperaturen = (Button) findViewById(R.id.ICETemperaturen);


        fab = (ImageView) findViewById(R.id.fab);
        fab.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_suche));

        scroll = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.scrollup);
        fab.startAnimation(scroll);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ICE1.this, Suche.class);
                startActivity(intent);

            }
        });


        ICE1SaugkreisGTO.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice1/ICE1SaugkreisGTO.jpg";
                Intent i = new Intent(ICE1.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);

            }
        });

        ICE1ZSIsoPruefung.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice1/ICE1ZSIsoPruefung.jpg";
                Intent i = new Intent(ICE1.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });

        ICE1Triebdrehgestellemessen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice1/ICE1Triebdrehgestellemessen.jpg";
                Intent i = new Intent(ICE1.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICE1Neumon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice1/ICE1Neumon.jpg";
                Intent i = new Intent(ICE1.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICE1Zwischenkreis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice1/ICE1Zwischenkreis.jpg";
                Intent i = new Intent(ICE1.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICE1Erdschlusserfassung.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice1/ICE1Erdschlusserfassung.jpg";
                Intent i = new Intent(ICE1.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICETemperaturen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice1/ICETemperaturen.jpg";
                Intent i = new Intent(ICE1.this, Server.class);
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
            Intent i = new Intent(ICE1.this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.activity_switch_out, R.anim.activity_in);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();

        overridePendingTransition(R.anim.activity_switch_out, R.anim.activity_in);
    }
}