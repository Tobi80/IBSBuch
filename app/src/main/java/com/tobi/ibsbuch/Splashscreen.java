package com.tobi.ibsbuch;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

public class Splashscreen extends Activity {


    private WifiManager wifi;
    private WebView webView;
    private Snackbar snackbar, snackbar2;
    Thread thread;

    // private NetworkMonitorReceiver receiver;
    // ConnectivityManager connMan;
    // private static final int PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION = 0;
    // private static final int REQUEST_CODE = 0;
    // private ConnectivityManager connectivityManager;
    // private ConnectivityManager.NetworkCallback callback;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);

        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.coordinatorLayout);

        snackbar = Snackbar
                .make(parentLayout, "Verbinde mit IBS Wlan. Bitte warten", Snackbar.LENGTH_INDEFINITE);

        snackbar.show();


        webView = (WebView) findViewById(R.id.webView2);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setInitialScale(1); // Webview fit to screen size
        webView.getSettings().setRenderPriority(RenderPriority.HIGH);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        webView.loadUrl("file:///android_asset/ibs.gif");


        final WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifi.setWifiEnabled(true);

    }


    BroadcastReceiver MyBroadcastReceiver = new BroadcastReceiver() {


        @Override
        public void onReceive(Context context, Intent intent) {

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

                final ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkRequest.Builder builder;
                builder = new NetworkRequest.Builder();

                //set the transport type do WIFI
                builder.addTransportType(NetworkCapabilities.TRANSPORT_WIFI);

                manager.requestNetwork(builder.build(), new ConnectivityManager.NetworkCallback() {
                    @Override
                    public void onAvailable(final Network network) {


                        snackbar.dismiss();
                        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.coordinatorLayout);
                        snackbar2 = Snackbar
                                .make(parentLayout, "IBS Wlan verbunden. Starte IBS-Buch", Snackbar.LENGTH_LONG);
                        snackbar2.show();


                        thread = new Thread() {
                            @Override
                            public void run() {
                                try {
                                    synchronized (this) {
                                        wait(3000);
                                    }
                                } catch (InterruptedException ex) {
                                }

                                Intent i = new Intent(Splashscreen.this, MainActivity.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(i);

                                finish();
                            }
                        };

                        thread.start();

                        try {

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        manager.unregisterNetworkCallback(this);
                    }
                });
            }
        }
    };


    @Override
    protected void onResume() {
        registerReceiver(MyBroadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        super.onResume();
    }

    @Override
    protected void onPause() {
        try {

            unregisterReceiver(MyBroadcastReceiver);
        } catch (IllegalArgumentException e) {
            if (e.getMessage().contains("Receiver not registered")) {

            } else {

                throw e;
            }
        }

        super.onPause();

    }

}


////////////////////////////////////////////////////////////////////////////////////////


//    private NetworkMonitorReceiver receiver;

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.splash);
//
//        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.coordinatorLayout);
//
//        snackbar = Snackbar
//                .make(parentLayout, "Verbinde mit IBS Wlan. Bitte warten", Snackbar.LENGTH_INDEFINITE);
//
//        snackbar.show();
//
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//
//        webView = (WebView) findViewById(R.id.webView2);
//        webView.setWebViewClient(new WebViewClient());
//        webView.setWebChromeClient(new WebChromeClient());
//        webView.getSettings().setLoadsImagesAutomatically(true);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setUseWideViewPort(true);
//        webView.getSettings().setDomStorageEnabled(true);
//        webView.setInitialScale(1); // Webview fit to screen size
//        webView.getSettings().setRenderPriority(RenderPriority.HIGH);
//        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//        webView.loadUrl("file:///android_asset/ibs.gif");
//
//
//        final WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
//        wifi.setWifiEnabled(true);
//
//        this.receiver = new NetworkMonitorReceiver();
//
//        this.registerReceiver(this.receiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
//
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        this.unregisterReceiver(this.receiver);
//
//        if (connectivityManager != null) {
//            try {
//                connectivityManager.unregisterNetworkCallback(callback);
//            } catch (Exception e) {
//            }
//        }
//
//        if (snackbar != null) {
//            snackbar.dismiss();
//        }
//
//        if (snackbar2 != null) {
//            snackbar2.dismiss();
//        }
//    }
//
//    private class NetworkMonitorReceiver extends BroadcastReceiver {
//
//        private final String TAG = NetworkMonitorReceiver.class.getSimpleName();
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//
//            connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//            final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//
//            final NetworkRequest.Builder builder = new NetworkRequest.Builder();
//            builder.addTransportType(NetworkCapabilities.TRANSPORT_WIFI);
//
//            callback = new ConnectivityManager.NetworkCallback() {
//
//                @Override
//                public void onAvailable(Network network) {
//
//                    if (networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI && networkInfo.isConnected()) {
//
//
//                        snackbar.dismiss();
//                        snackbar = null;
//                        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.coordinatorLayout);
//                        snackbar2 = Snackbar
//                                .make(parentLayout, "IBS Wlan verbunden. Starte IBS-Buch", Snackbar.LENGTH_LONG);
//
//                        snackbar2.show();
//
//                        thread = new Thread() {
//                            @Override
//                            public void run() {
//                                try {
//                                    synchronized (this) {
//                                        wait(3000);
//                                    }
//                                } catch (InterruptedException ex) {
//                                }
//
//                                Intent i = new Intent(Splashscreen.this, MainActivity.class);
//                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                                startActivity(i);
//
//                                finish();
//                            }
//                        };
//
//                        thread.start();
//
//
//
//                    } else {
//                        Log.d(TAG, "Network is not available");
//
//                    }
//                }
//
//
//            };
//            connectivityManager.requestNetwork(builder.build(), callback);
//        }
//
//    }
//}





