package com.example.ampproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LowerBodyActivity extends AppCompatActivity {
  ImageView lower1,lower2,lower3,lower4,lower5,lower6;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lower_body);

    lower1 = findViewById(R.id.lower1);
    lower2 = findViewById(R.id.lower2);
    lower3 = findViewById(R.id.lower3);
    lower4 = findViewById(R.id.lower4);
    lower5 = findViewById(R.id.lower5);
    lower6 = findViewById(R.id.lower6);

    lower1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(LowerBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Forward Lunge");
        intent.putExtra("image","lower1_lunges");
        startActivity(intent);
      }
    });

    lower2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(LowerBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Bodyweight Squats");
        intent.putExtra("image","lower2_squats");
        startActivity(intent);
      }
    });

    lower3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(LowerBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Reverse Lunges");
        intent.putExtra("image","lower3_reverselunges");
        startActivity(intent);
      }
    });

    lower4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(LowerBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Glute Bridge");
        intent.putExtra("image","lower4_glutebridge");
        startActivity(intent);
      }
    });

    lower5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(LowerBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Pike Pushups");
        intent.putExtra("image","lower5_donkeykicks");
        startActivity(intent);
      }
    });

    lower6.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(LowerBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Commando Plank");
        intent.putExtra("image","lower6_commandoplank");
        startActivity(intent);
      }
    });
  }
}