package com.example.ampproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class UpperBodyActivity extends AppCompatActivity {

  ImageView upper1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_upper_body);

    upper1 = findViewById(R.id.upper1);

    upper1.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(UpperBodyActivity.this, TimerActivity.class);
        intent.putExtra("title","Jumping Jacks");
        intent.putExtra("image","upper1_jumpingjacks");
        startActivity(intent);
      }
    });

  }
}
