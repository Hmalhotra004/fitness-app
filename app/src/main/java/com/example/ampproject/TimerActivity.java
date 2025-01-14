package com.example.ampproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Locale;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class TimerActivity extends AppCompatActivity {

  TextView countdownTimer;
  CountDownTimer timer;
  Button start;
  GifImageView gif;
  TextView toolbarTitle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_timer);
    Intent i = getIntent();
    String title = i.getStringExtra("title");
    String image = i.getStringExtra("image");

    countdownTimer = findViewById(R.id.countdownTimer);
    start = findViewById(R.id.start);
    gif = findViewById(R.id.gifImageView);

    toolbarTitle = findViewById(R.id.toolbar_title);

    toolbarTitle.setText(title);

    int gifResId = getResources().getIdentifier(image, "drawable", getPackageName());
    if (gifResId != 0) {
      gif.setImageResource(gifResId);
    } else {
      Toast.makeText(this, "Image not found", Toast.LENGTH_SHORT).show();
    }


    start.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startTime();
      }
    });
  }

  private void startTime() {
    timer = new CountDownTimer(30000 ,1000) {
      @Override
      public void onTick(long millisUntilFinished) {
        long hours = (millisUntilFinished/1000) / 3600;
        long minutes = ((millisUntilFinished/1000) % 3600) / 60;
        long seconds = ((millisUntilFinished/1000) % 60);
        String timeFormatted = String.format(Locale.getDefault(),"%02d:%02d:%02d",hours,minutes,seconds);
        countdownTimer.setText(timeFormatted);
      }

      @Override
      public void onFinish() {
        countdownTimer.setText("00:00:00");
        Toast.makeText(TimerActivity.this, "", Toast.LENGTH_SHORT).show();
        MediaPlayer alarm = MediaPlayer.create(TimerActivity.this,R.raw.alarm);
        alarm.start();
      }
    }.start();
  }
}