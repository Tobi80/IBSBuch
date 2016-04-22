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
public class ICET7 extends AppCompatActivity {


    Button ICET5AsrSetzMaske, ICETemperaturen,ICET7MVB,ICET7ASR;
    SharedPreferences prefs;
    String Bildpfad;
    Animation scroll;
    ImageView fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if(prefs.getBoolean("theme", false)) {
            setTheme(R.style.AppTheme2);

        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ice7teiler);


        ICET5AsrSetzMaske = (Button) findViewById(R.id.ICET5AsrSetzMaske);
        ICETemperaturen = (Button) findViewById(R.id.ICETemperaturen);
        ICET7MVB = (Button) findViewById(R.id.ICET7MVB);
        ICET7ASR = (Button) findViewById(R.id.ICET7ASR);


        fab = (ImageView) findViewById(R.id.fab);
        fab.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_suche));

        scroll = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.scrollup);
        fab.startAnimation(scroll);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ICET7.this, Suche.class);
                startActivity(intent);
            }
        });


        ICET5AsrSetzMaske.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5AsrSetzMaske.jpg";
                Intent i = new Intent(ICET7.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);

            }
        });

        ICETemperaturen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice1/ICETemperaturen.jpg";
                Intent i = new Intent(ICET7.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICET7MVB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ICET7.this, ICET7MVB.class);
                startActivity(i);

            }
        });
        ICET7ASR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ICET7.this, ICET7ASR.class);
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
            Intent i = new Intent(ICET7.this, MainActivity.class);
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