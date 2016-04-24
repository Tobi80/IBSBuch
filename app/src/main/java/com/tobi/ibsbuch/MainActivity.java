package com.tobi.ibsbuch;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Tobi on 18.12.2015.
 */
public class MainActivity extends AppCompatActivity {

//    GestureDetector gestureDetector;
    Button ice1, ice2, icet5, icet7, ice403, ice406, icetd, zugsicherung, identnummer;
    Animation scroll;
    ImageView fab;
    private com.tobi.ibsbuch.AutoUpdateApk aua;

    SharedPreferences prefs;
    private PreferenceChangeListener mPreferenceListener = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Preferences
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mPreferenceListener = new PreferenceChangeListener();
        prefs.registerOnSharedPreferenceChangeListener(mPreferenceListener);
        ApplySettings();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        aua = new AutoUpdateApk(getApplicationContext());

//        Intent i = new Intent(getApplicationContext(), MainActivity.class);
//        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | i.FLAG_ACTIVITY_CLEAR_TASK);

//        gestureDetector = new GestureDetector(getApplicationContext(), new GestureListener());

        ice1 = (Button) findViewById(R.id.ice1);
        ice2 = (Button) findViewById(R.id.ice2);
        ice403 = (Button) findViewById(R.id.ice403);
        ice406 = (Button) findViewById(R.id.ice406);
        icet5 = (Button) findViewById(R.id.icet5);
        icet7 = (Button) findViewById(R.id.icet7);
        icetd = (Button) findViewById(R.id.icetd);
        zugsicherung = (Button) findViewById(R.id.zugsicherung);
        identnummer = (Button) findViewById(R.id.identnummer);


        fab = (ImageView) findViewById(R.id.fab);
        fab.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_suche));

        scroll = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.scrollup);

        fab.startAnimation(scroll);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Suche.class);
                startActivity(intent);
            }
        });

        ice1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ICE1.class);
                startActivity(i);
                overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);

            }
        });
        ice2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ICE2.class);
                startActivity(i);
                overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);
            }
        });
        ice403.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ICE403.class);
                startActivity(i);
                overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);
            }
        });
        ice406.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ICE403.class);
                startActivity(i);
                overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);
            }
        });
        icet5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ICET5.class);
                startActivity(i);
                overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);
            }
        });
        icet7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ICET7.class);
                startActivity(i);
                overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);
            }
        });
        icetd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ICETD.class);
                startActivity(i);
                overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);
            }
        });
        zugsicherung.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Zugsicherung.class);
                startActivity(i);
                overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);
            }
        });
        identnummer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, Server.class);
//                startActivity(i);
//                overridePendingTransition(R.anim.activity_switch_in, R.anim.activity_out);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//         Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dank, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, Preferences.class));
        }

        if (id == R.id.dank) {
            Intent i = new Intent(MainActivity.this,
                    Dank.class);
            startActivity(i);


            return true;

        }
        return super.onOptionsItemSelected(item);

    }

    public void ApplySettings() {


        // Checkbox Bildschirm wach halten
        Boolean stay_awake = prefs.getBoolean("stay_awake", false);
        if (stay_awake) {
            getWindow()
                    .addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        } else {
            getWindow().clearFlags(
                    WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);


        }

        // Checkbox Theme
        Boolean theme = prefs.getBoolean("theme", false);
        if (theme) {

            setTheme(R.style.AppTheme2);

        } else {

            setTheme(R.style.AppTheme);
        }
    }


    // Preferences boolean true false überwachen
    private class PreferenceChangeListener implements
            SharedPreferences.OnSharedPreferenceChangeListener {

        @Override
        public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
            ApplySettings();
            // Startet Activity neu. Funktioniert, user fliegt aber sofort aus den einstellungen
            //ChangeTheme();

            //Funktioniert ruft allerdings alles neu ab
            recreate();
        }
    }

//    // CheckBox
//    private class PreferenceClickListener implements Preference.OnPreferenceClickListener {
//
//        @Override
//        public boolean onPreferenceClick(Preference preference) {
//            // Checkbox Theme
//            Boolean theme = prefs.getBoolean("theme", false);
//            if (theme) {
//
//                setTheme(R.style.AppTheme2);
//
//
//                Toast.makeText(getApplicationContext(), "t",
//                        Toast.LENGTH_SHORT).show();
//            } else {
//
//                setTheme(R.style.AppTheme);
//
//
//                Toast.makeText(getApplicationContext(), "tt",
//                        Toast.LENGTH_SHORT).show();
//
//            }
//            recreate();
//
//            return true;
//        }
//    }

//    private void ChangeTheme() {
//        Intent intent = getIntent();
//        finish();
//        startActivity(intent);
//    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

            // Dialog Titel
            alertDialog.setTitle("IBS-Buch");

            // Dialog Nachricht
            alertDialog.setMessage("Wirklich beenden ?");


            // Setting Positive "Yes" Button
            alertDialog.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    finish();
                }
            });

            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("Nein", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                    dialog.cancel();
                }
            });

            // Showing Alert Message
            alertDialog.show();


        }
        return super.onKeyDown(keyCode, event);
    }
}



//    private class GestureListener extends GestureDetector.SimpleOnGestureListener {
//
//        @Override
//        public boolean onDown(MotionEvent e) {
//            return true;
//        }
//
//        // event when double tap occurs
//        @Override
//        public boolean onDoubleTap(MotionEvent e) {
//
////            Intent i = new Intent(MainActivity.this,
////                    EasterEgg.class);
////            startActivity(i);
//
//            Toast.makeText(getApplicationContext(), "Double Tap",
//                    Toast.LENGTH_LONG).show();
//
//
//            return true;
//        }
//    }
//        }