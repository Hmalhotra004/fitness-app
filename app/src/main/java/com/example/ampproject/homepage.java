package com.example.ampproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class homepage extends AppCompatActivity {

  ImageView card1,card2,card3;
  ImageView bmiCard,homeIcon,bmiIcon;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_homepage);

    card1 = findViewById(R.id.card1);
    bmiCard = findViewById(R.id.bmiCard);
    homeIcon = findViewById(R.id.homeIcon);
    bmiIcon = findViewById(R.id.bmiIcon);
    card2 = findViewById(R.id.card2);
    card3 = findViewById(R.id.card3);

    card1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(homepage.this, UpperBodyActivity.class);
        startActivity(intent);
      }
    });

    bmiCard.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(homepage.this, BmiCalculator.class);
        startActivity(intent);
      }
    });


    bmiIcon.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(homepage.this, BmiCalculator.class);
        startActivity(intent);
      }
    });

    card2.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(homepage.this, LowerBodyActivity.class);
        startActivity(intent);
      }
    });

    card3.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(homepage.this, FullBodyActivity.class);
        startActivity(intent);
      }
    });
  }
}