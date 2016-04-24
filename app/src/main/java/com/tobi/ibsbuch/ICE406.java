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
public class ICE406 extends AppCompatActivity {


    Button ICE403Wagenuebergaenge,ICETemperaturen,ICE3ASR;
    SharedPreferences prefs;
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
        setContentView(R.layout.ice406);



        ICE403Wagenuebergaenge = (Button) findViewById(R.id.ICE403Wagenuebergaenge);
        ICETemperaturen = (Button) findViewById(R.id.ICETemperaturen);
        ICE3ASR = (Button) findViewById(R.id.ICE3ASR);

        fab = (ImageView) findViewById(R.id.fab);
        fab.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_suche));

        scroll = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.scrollup);
        fab.startAnimation(scroll);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ICE406.this, Suche.class);
                startActivity(intent);

            }
        });

        ICE403Wagenuebergaenge.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice403/ICE403Wagenuebergaenge.jpg";
                Intent i = new Intent(ICE406.this, Server.class);
                //i.putExtra("ICE403Wagenuebergaenge", toString());
                i.putExtra("Bildpfad_Server", ""+Bildpfad);
                startActivity(i);


            }
        });
        ICETemperaturen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice1/ICETemperaturen.jpg";
                Intent i = new Intent(ICE406.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICE3ASR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(ICE406.this, ICE3ASR.class);
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
            Intent i = new Intent(ICE406.this, MainActivity.class);
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