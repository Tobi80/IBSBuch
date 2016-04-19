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
 * Created by Tobi on 18.04.2016.
 */
public class ICET5MVB extends AppCompatActivity {


    Button ICET5_WTB,ICET5_0_MVB1,ICET5_0_MVB2,ICET5_1_MVB, ICET5_7_MVB,ICET5_6_MVB,ICET5_5_MVB1,ICET5_5_MVB2;
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
        setContentView(R.layout.icet5mvb);


        ICET5_WTB = (Button) findViewById(R.id.ICET5_WTB);
        ICET5_0_MVB1 = (Button) findViewById(R.id.ICET5_0_MVB1);
        ICET5_0_MVB2 = (Button) findViewById(R.id.ICET5_0_MVB2);
        ICET5_1_MVB = (Button) findViewById(R.id.ICET5_1_MVB);
        ICET5_7_MVB = (Button) findViewById(R.id.ICET5_7_MVB);
        ICET5_6_MVB = (Button) findViewById(R.id.ICET5_6_MVB);
        ICET5_5_MVB1 = (Button) findViewById(R.id.ICET5_5_MVB1);
        ICET5_5_MVB2 = (Button) findViewById(R.id.ICET5_5_MVB2);

        ICET5_WTB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5_WTB.jpg";
                Intent i = new Intent(ICET5MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });

        ICET5_0_MVB1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5_0_MVB1.jpg";
                Intent i = new Intent(ICET5MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });

        ICET5_0_MVB2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5_0_MVB2.jpg";
                Intent i = new Intent(ICET5MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });

        ICET5_1_MVB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5_1_MVB.jpg";
                Intent i = new Intent(ICET5MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET5_7_MVB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5_7_MVB.jpg";
                Intent i = new Intent(ICET5MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET5_6_MVB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5_6_MVB.jpg";
                Intent i = new Intent(ICET5MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET5_5_MVB1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5_5_MVB1.jpg";
                Intent i = new Intent(ICET5MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET5_5_MVB2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet5/ICET5_5_MVB2.jpg";
                Intent i = new Intent(ICET5MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.anfang) {
            Intent i = new Intent(ICET5MVB.this, MainActivity.class);
            startActivity(i);


            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}