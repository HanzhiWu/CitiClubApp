package com.example.citiclubapp.ui.SubmitActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.citiclubapp.R;
import com.example.citiclubapp.ui.BusinessHallPage.MyWarrant.MyWarrantActivity;

public class CommonSubmitSuccessAvtivity extends AppCompatActivity {

    static int GENERATE = 1, SUBMIT = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit_activity_layout);
        Intent intent = getIntent();
        TextView text = findViewById(R.id.submit_text);
        int type = intent.getIntExtra("type", SUBMIT);
        if (type == GENERATE)
            text.setText("已生成");
        Button submit = findViewById(R.id.submit_button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommonSubmitSuccessAvtivity.this,
                        MyWarrantActivity.class);
                startActivity(intent);
            }
        });
    }
}