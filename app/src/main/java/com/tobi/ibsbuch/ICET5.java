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
 * Created by Tobi on 22.12.2015.
 */
public class ICET5 extends AppCompatActivity {


    Button ICET5AsrSetzMaske, ICET5Wagenuebergaenge, ICET5MVB,ICETemperaturen,ICET5ASR;
    SharedPreferences prefs;
    String Bildpfad;
    Animation scroll;
    ImageView fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if (prefs.getBoolean("theme", false)) {
            setTheme(R.style.AppTheme2);

        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ice5teiler);


        ICET5AsrSetzMaske = (Button) findViewById(R.id.ICET5AsrSetzMaske);
        ICET5Wagenuebergaenge = (Button) findViewById(R.id.ICET5Wagenuebergaenge);
        ICET5MVB = (Button) findViewById(R.id.ICET5MVB);
        ICETemperaturen = (Button) findViewById(R.id.ICETemperaturen);
        ICET5ASR = (Button) findViewById(R.id.ICET5ASR);

        fab = (ImageView) findViewById(R.id.fab);
        fab.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_suche));

        scroll = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.scrollup);
        fab.startAnimation(scroll);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ICET5.this, Suche.class);
                startActivity(intent);
            }
        });


        ICET5AsrSetzMaske.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5AsrSetzMaske.jpg";
                Intent i = new Intent(ICET5.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });


        ICET5Wagenuebergaenge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ICET5.this, com.tobi.ibsbuch.ICET5Wagenuebergaenge.class);
                startActivity(i);

            }
        });
        ICET5MVB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ICET5.this, com.tobi.ibsbuch.ICET5MVB.class);
                startActivity(i);

            }
        });
        ICETemperaturen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice1/ICETemperaturen.jpg";
                Intent i = new Intent(ICET5.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICET5ASR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ICET5.this, ICET5ASR.class);
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
            Intent i = new Intent(ICET5.this, MainActivity.class);
            startActivity(i);


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