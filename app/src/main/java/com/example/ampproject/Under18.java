package com.example.ampproject;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Under18 extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_under18);

    LinearLayout clickableLayout = findViewById(R.id.clickable);

    if (clickableLayout != null) {
      clickableLayout.setOnClickListener(v ->
              Toast.makeText(this, "Layout clicked", Toast.LENGTH_SHORT).show()
      );
    } else {
      Toast.makeText(this, "Clickable layout not found", Toast.LENGTH_SHORT).show();
    }
  }
}
