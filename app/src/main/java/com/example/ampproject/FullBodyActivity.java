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

public class FullBodyActivity extends AppCompatActivity {

  ImageView full1,full2,full3,full4,full5,full6;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_full_body);

    full1 = findViewById(R.id.full1);
    full2 = findViewById(R.id.full2);
    full3 = findViewById(R.id.full3);
    full4 = findViewById(R.id.full4);
    full5 = findViewById(R.id.full5);
    full6 = findViewById(R.id.full6);

    full1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(FullBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Alternative Reach");
        intent.putExtra("image","fullbody1_alternatingreach");
        startActivity(intent);
      }
    });

    full2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(FullBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Bicycle Crunch");
        intent.putExtra("image","fullbody2_bicyclecrunch");
        startActivity(intent);
      }
    });

    full3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(FullBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Side Plank");
        intent.putExtra("image","fullbody3_sideplank");
        startActivity(intent);
      }
    });

    full4.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(FullBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Forward Crawl");
        intent.putExtra("image","fullbody5_fowardcrawls");
        startActivity(intent);
      }
    });

    full5.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(FullBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Plank Kickbacks");
        intent.putExtra("image","fullbody6_plankkickbacks");
        startActivity(intent);
      }
    });

    full6.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(FullBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Back Row");
        intent.putExtra("image","fullbody4_backrow");
        startActivity(intent);
      }
    });
  }
}