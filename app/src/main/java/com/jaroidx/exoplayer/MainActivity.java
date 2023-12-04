package com.jaroidx.exoplayer;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //    private final String BASE_URL = "https://www.youtube.com/embed/";
    private String videoID = "bsoP5D8xzss";
    private String videoID2 = "cNbqEHkiGqs";
    private PlayYTView wvDemo;
    private Button btnForward;
    private Button btnPlayOrPause;
    private Button btnPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initWebView(videoID);

    }

    private void initView() {
        wvDemo = findViewById(R.id.wvDemo);
        wvDemo.setAutoPlay(true);

        btnForward = findViewById(R.id.btnForward);
        btnPlayOrPause = findViewById(R.id.btnPlayOrPause);
        btnPrevious = findViewById(R.id.btnPrevious);

        btnPrevious.setOnClickListener(v -> wvDemo.onPrevious());
        btnPlayOrPause.setOnClickListener(v -> {
            wvDemo.changeState();
            btnPlayOrPause.setText(wvDemo.getState());
        });
        btnForward.setOnClickListener(v -> wvDemo.onForward());
    }

    private void initWebView(String videoID) {
        wvDemo.loadVideoID(videoID);
    }
}