package com.ren.andk;

import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private RenPlayer mPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SurfaceView surfaceView = findViewById(R.id.surface_view);

        mPlayer = new RenPlayer();
        mPlayer.setSurfaceView(surfaceView);
        mPlayer.setDataSource("rtmp://live.hkstv.hk.lxdns.com/live/hks");
        mPlayer.setOnPrepareListener(new RenPlayer.OnPrepareListener() {
            @Override
            public void onPrepare() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "可以开始播放了", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }




}

