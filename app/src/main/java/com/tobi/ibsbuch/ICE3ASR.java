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
public class ICE3ASR extends AppCompatActivity {

    SharedPreferences prefs;
    Button ICE3EW, ICE3TW, ICE3SR, ICE3MW4, ICE3MW5;
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
        setContentView(R.layout.ice3asr);

        ICE3EW = (Button) findViewById(R.id.ICE3EW);
        ICE3TW = (Button) findViewById(R.id.ICE3TW);
        ICE3SR = (Button) findViewById(R.id.ICE3SR);
        ICE3MW4 = (Button) findViewById(R.id.ICE3MW4);
        ICE3MW5 = (Button) findViewById(R.id.ICE3MW5);


        fab = (ImageView) findViewById(R.id.fab);
        fab.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_suche));

        scroll = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.scrollup);
        fab.startAnimation(scroll);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ICE3ASR.this, Suche.class);
                startActivity(intent);
            }
        });

        ICE3EW.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice403/ICE403_EW_ASR.jpg";
                Intent i = new Intent(ICE3ASR.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICE3TW.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice403/ICE403_TW_ASR.jpg";
                Intent i = new Intent(ICE3ASR.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICE3SR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice403/ICE403_SR_ASR.jpg";
                Intent i = new Intent(ICE3ASR.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICE3MW4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice403/ICE403_MW4_ASR.jpg";
                Intent i = new Intent(ICE3ASR.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);


            }
        });
        ICE3MW5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "ice403/ICE403_MW5_ASR.jpg";
                Intent i = new Intent(ICE3ASR.this, Server.class);
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
            Intent i = new Intent(ICE3ASR.this, MainActivity.class);
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