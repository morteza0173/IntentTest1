package com.intent.test.intenttest;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.VideoView;

public class ThirdActivity extends AppCompatActivity {
    public int videoStop;
    public boolean resume= false;
    public boolean play = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ImageView btnStop = (ImageView)findViewById(R.id.imgViwe_thirdAcctivity_stopButton);
        ImageView btnPlay = (ImageView)findViewById(R.id.imgViwe_thirdAcctivity_playButton);
        ImageView btnPause = (ImageView)findViewById(R.id.imgViwe_thirdAcctivity_PauseButton);
        final SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar_thirdActivity_seekBarVideo);
        final VideoView videoPlay = (VideoView)findViewById(R.id.videoViwe_thirdActivity_video);

        final Uri uri =Uri.parse("android.resource://"+G.name+"/"+R.raw.video);
        videoPlay.setVideoURI(uri);
        videoPlay.start();


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int videoDuretion = videoPlay.getDuration();
                float progress = i/100.0f;
                float time=videoDuretion*progress;
                videoPlay.seekTo((int)time);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoPlay.seekTo(0);
                seekBar.setProgress(0);
                videoPlay.stopPlayback();
                play = true;
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoStop = videoPlay.getCurrentPosition();
                videoPlay.pause();
                resume=true;
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resume) {
                    videoPlay.seekTo(videoStop);
                    videoPlay.start();
                    resume=false;
                }if(play){
                    videoPlay.setVideoURI(uri);
                    videoPlay.start();
                    play=false;
                }
            }
        });

    }
}
