package com.tobi.ibsbuch;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

import java.util.prefs.PreferenceChangeListener;

/**
 * Created by Tobi on 21.03.2015.
 */
public class Preferences extends PreferenceActivity {


    SharedPreferences prefs;
    private PreferenceChangeListener mPreferenceListener = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Preferences
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        if (prefs.getBoolean("theme", false)) {
            setTheme(R.style.AppTheme2);

        } else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        // Preferences
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());


    }


    protected void onResume() {
        super.onResume();
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

    }

    protected void onPause() {
        super.onPause();
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

    }


}





