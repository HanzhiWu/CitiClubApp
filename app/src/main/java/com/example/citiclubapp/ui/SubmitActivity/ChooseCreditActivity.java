package com.example.citiclubapp.ui.SubmitActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.citiclubapp.R;

public class ChooseCreditActivity extends AppCompatActivity {

    Button positiveButton, negativeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_credit);
        positiveButton = findViewById(R.id.positive_button);
        negativeButton = findViewById(R.id.negative_button);
        positiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseCreditActivity.this, CommonSubmitSuccessAvtivity.class);
                intent.putExtra("type", CommonSubmitSuccessAvtivity.GENERATE);
                startActivity(intent);
                finish();
            }
        });
        negativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ChooseCreditActivity.this, "不进行信用担保",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}