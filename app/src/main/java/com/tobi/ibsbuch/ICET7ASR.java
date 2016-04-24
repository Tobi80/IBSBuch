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
public class ICET7ASR extends AppCompatActivity {

    SharedPreferences prefs;
    Button ICET7T,ICET7SR,ICET7FMR,ICET7M,ICET7FM;
    String Bildpfad;
    Animation scroll;
    ImageView fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);
        if(prefs.getBoolean("theme", false)) {
            setTheme(R.style.AppTheme2);

        } else {
            setTheme(R.style.AppTheme);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.icetd);

        ICET7T = (Button) findViewById(R.id.ICET7T);
        ICET7SR = (Button) findViewById(R.id.ICET7SR);
        ICET7FMR = (Button) findViewById(R.id.ICET7FMR);
        ICET7M = (Button) findViewById(R.id.ICET7M);
        ICET7FM = (Button) findViewById(R.id.ICET7FM);


        fab = (ImageView) findViewById(R.id.fab);
        fab.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_suche));

        scroll = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.scrollup);
        fab.startAnimation(scroll);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ICET7ASR.this, Suche.class);
                startActivity(intent);

            }
        });

        ICET7T.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_T_ASR.jpg";
                Intent i = new Intent(ICET7ASR.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICET7SR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_SR_ASR.jpg";
                Intent i = new Intent(ICET7ASR.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICET7FMR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_FMR_ASR.jpg";
                Intent i = new Intent(ICET7ASR.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICET7M.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_M_ASR.jpg";
                Intent i = new Intent(ICET7ASR.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICET7FM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_FM_ASR.jpg";
                Intent i = new Intent(ICET7ASR.this, Server.class);
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
            Intent i = new Intent(ICET7ASR.this, MainActivity.class);
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