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
 * Created by Tobi on 19.04.2016.
 */
public class ICET7MVB extends AppCompatActivity {


    Button ICET7_WTB1,ICET7_WTB2,ICET7_0_MVB1,ICET7_0_MVB2,ICET7_1_MVB,ICET7_2_MVB,ICET7_8_MVB,ICET7_7_MVB,ICET7_6_MVB,ICET7_5_MVB1,ICET7_5_MVB2;
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
        setContentView(R.layout.icet7mvb);


        ICET7_WTB1 = (Button) findViewById(R.id.ICET7_WTB1);
        ICET7_WTB2 = (Button) findViewById(R.id.ICET7_WTB2);
        ICET7_0_MVB1 = (Button) findViewById(R.id.ICET7_0_MVB1);
        ICET7_0_MVB2 = (Button) findViewById(R.id.ICET7_0_MVB2);
        ICET7_1_MVB = (Button) findViewById(R.id.ICET7_1_MVB);
        ICET7_2_MVB = (Button) findViewById(R.id.ICET7_2_MVB);
        ICET7_8_MVB = (Button) findViewById(R.id.ICET7_8_MVB);
        ICET7_7_MVB = (Button) findViewById(R.id.ICET7_7_MVB);
        ICET7_6_MVB = (Button) findViewById(R.id.ICET7_6_MVB);
        ICET7_5_MVB1 = (Button) findViewById(R.id.ICET7_5_MVB1);
        ICET7_5_MVB2 = (Button) findViewById(R.id.ICET7_5_MVB2);


        ICET7_WTB1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_WTB1.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });

        ICET7_WTB2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_WTB2.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });

        ICET7_0_MVB1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_0_MVB1.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });

        ICET7_0_MVB2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_0_MVB2.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET7_1_MVB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_1_MVB.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET7_2_MVB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_2_MVB.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET7_8_MVB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_8_MVB.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET7_7_MVB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_7_MVB.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET7_6_MVB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_6_MVB.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET7_5_MVB1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_5_MVB1.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
                i.putExtra("Bildpfad_Server", "" + Bildpfad);
                startActivity(i);
            }
        });
        ICET7_5_MVB2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Bildpfad = "icet7/ICET7_5_MVB2.jpg";
                Intent i = new Intent(ICET7MVB.this, Server.class);
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
            Intent i = new Intent(ICET7MVB.this, MainActivity.class);
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