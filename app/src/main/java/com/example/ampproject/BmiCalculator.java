package com.example.ampproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BmiCalculator extends AppCompatActivity {

    EditText ediWeight, ediFeet, ediInch;
    Button buttonBmi;
    TextView tvResult;
    ImageView homeIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi_calculator);

        ediWeight = findViewById(R.id.ediWeight);
        ediFeet = findViewById(R.id.ediFeet);
        ediInch = findViewById(R.id.ediInch);
        buttonBmi = findViewById(R.id.buttonBmi);
        tvResult = findViewById(R.id.tvResult);
        homeIcon = findViewById(R.id.homeIcon);

        buttonBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sWeight = ediWeight.getText().toString();
                String sInch = ediInch.getText().toString();
                String sFeet = ediFeet.getText().toString();

                float weight = Float.parseFloat(sWeight);
                float inch = Float.parseFloat(sInch);
                float feet = Float.parseFloat(sFeet);

                float height = (float) (feet* 0.3048+ inch *0.0254); //kg & meter units
                float bmiIndex = weight / (height*height); //formula

                tvResult.setText("Your BMI Index is:" + bmiIndex+"\n\nBMI Categories:\n" +
                        "Underweight = <18.5\n" +
                        "Normal Weight = 18.5-24.9\n" +
                        "Overweight = 25-29.9\n" +
                        "Obesity = BMI if 30 or greater ");

            }
        });
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BmiCalculator.this, homepage.class);
                startActivity(intent);
            }
        });

    }
}