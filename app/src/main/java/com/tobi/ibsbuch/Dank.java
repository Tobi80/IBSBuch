package com.tobi.ibsbuch;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Tobi on 16.03.2016.
 */
public class Dank extends Activity {

    private VideoView videoplay;
    private ProgressDialog pDialog;
    String VideoURL = "http://172.25.40.26/ibs-buch/allgemein/zukunft";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.dank);

//        videoplay = (VideoView) findViewById(R.id.video);
        // Execute StreamVideo AsyncTask


        pDialog = new ProgressDialog(Dank.this);
        pDialog.setTitle("Video wird geladen. Bitte warten....");
        pDialog.setMessage("Buffering...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        try {

            videoplay = (VideoView) findViewById(R.id.video);
            videoplay.setMediaController(new MediaController(this));

            MediaController mediacontroller = new MediaController(
                    Dank.this);
            mediacontroller.setAnchorView(videoplay);


            Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.zukunft);
//            Uri video = Uri.parse(VideoURL);
            videoplay.setMediaController(mediacontroller);
            videoplay.setVideoURI(video);

        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        videoplay.requestFocus();
        videoplay.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                pDialog.dismiss();
                videoplay.start();
            }
        });

    }

}

//        videoplay = (VideoView) findViewById(R.id.video);
//
//        videoplay.setMediaController(new MediaController(this));
//        Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
//                + R.raw.zukunft);
//        videoplay.setVideoURI(video);
//        videoplay.getBufferPercentage();
//        videoplay.start();
//    }
//}