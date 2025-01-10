package com.example.ampproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class homepage extends AppCompatActivity {

  ImageView card1;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_homepage);

    card1 = findViewById(R.id.card1);
//    card2 = findViewById(R.id.card2);
//    card3 = findViewById(R.id.card3);

    card1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(homepage.this, upperbody.class);
        startActivity(intent);
//        finish();
      }
    });
  }
}