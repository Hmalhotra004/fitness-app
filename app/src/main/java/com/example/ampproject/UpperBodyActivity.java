package com.example.ampproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class UpperBodyActivity extends AppCompatActivity {

  ImageView upper1,upper2,upper3,upper4,upper5,upper6;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_upper_body);

    upper1 = findViewById(R.id.upper1);
    upper2 = findViewById(R.id.upper2);
    upper3 = findViewById(R.id.upper3);
    upper4 = findViewById(R.id.upper4);
    upper5 = findViewById(R.id.upper5);
    upper6 = findViewById(R.id.upper6);

    upper1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(UpperBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Jumping Jacks");
        intent.putExtra("image","upper1_jumpingjacks");
        startActivity(intent);
      }
    });

    upper2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(UpperBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Knee Pushups");
        intent.putExtra("image","upper2_kneepushups");
        startActivity(intent);
      }
    });

    upper3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(UpperBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Single Leg Raises");
        intent.putExtra("image","upper3_singlelegraise");
        startActivity(intent);
      }
    });

    upper4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(UpperBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Lateral Raise");
        intent.putExtra("image","upper4_lateralraise");
        startActivity(intent);
      }
    });

    upper5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(UpperBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Overhead Extention");
        intent.putExtra("image","upper5_tricep");
        startActivity(intent);
      }
    });

    upper6.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(UpperBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Bow & Row Arrow Pull");
        intent.putExtra("image","upper6_bowarrowpull");
        startActivity(intent);
      }
    });
  }
}
