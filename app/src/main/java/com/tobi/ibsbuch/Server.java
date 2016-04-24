package com.tobi.ibsbuch;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Tobi on 04.02.2016.
 */
public class Server extends Activity {


    ProgressDialog mProgress;
    SharedPreferences prefs;
    WebView webView;
    WifiManager wifi;
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.server);

        // Preferences
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        // Wifi
        wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);

        // Progress Dialog
        mProgress = ProgressDialog.show(Server.this, "Daten werden vom Server geladen", "Bitte warten.... ");
        mProgress.setCanceledOnTouchOutside(false);
        mProgress.setCancelable(true);

        webView = (WebView) findViewById(R.id.webView1);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setInitialScale(1);


        ConnectivityManager connection_manager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkRequest.Builder request = new NetworkRequest.Builder();
        request.addTransportType(NetworkCapabilities.TRANSPORT_WIFI);

        connection_manager.registerNetworkCallback(request.build(), new ConnectivityManager.NetworkCallback() {

            @Override
            public void onAvailable(Network network) {
                ConnectivityManager.setProcessDefaultNetwork(network);

                new loadImage().execute();

            }
        });
    }


    private class loadImage extends AsyncTask<Void, String, String> {

        @Override
        protected void onPreExecute() {

        }


        @Override
        protected String doInBackground(Void... params) {

            return "";
        }

        @Override
        protected void onPostExecute(String result) {

            Intent intent = getIntent();

            String Dateipfad = intent.getStringExtra("Bildpfad_Server");
            if (Dateipfad != null)
                webView.loadUrl("http://172.25.40.26/ibs-buch/" + Dateipfad);


            new Handler().postDelayed(new Runnable() {
                //
                @Override
                public void run() {
                    mProgress.dismiss();
                }
            }, SPLASH_TIME_OUT);

        }
    }


    // WebView loading page again. Stop it!!
    // zB bei Hochformat, Querformat wechsel

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mProgress.dismiss();
        // Restore the state of the WebView
        webView.restoreState(savedInstanceState);
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
            Intent i = new Intent(Server.this, MainActivity.class);
            startActivity(i);


            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();

            return true;

        } else if ((keyCode == KeyEvent.KEYCODE_BACK) && !webView.canGoBack()) {

            try {

                Thread.sleep(200); // 1000 milliseconds is one second.

            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();

            }


            webView.clearCache(true);
            finish();
//            wifi.setWifiEnabled(false);
        }

        return super.onKeyDown(keyCode, event);

    }

}








