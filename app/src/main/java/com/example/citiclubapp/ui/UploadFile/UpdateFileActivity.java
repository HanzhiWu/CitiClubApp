package com.example.citiclubapp.ui.UploadFile;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.citiclubapp.R;
import com.example.citiclubapp.ui.LegalPersonCertificateActivity.EnterpriceBankCertificationActivity;
import com.example.citiclubapp.widgetLayout.ButtonChoosePhoto;

public class UpdateFileActivity extends AppCompatActivity {

    ButtonChoosePhoto choosePhoto;
    Button submit;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ButtonChoosePhoto.CHOOSE_PHOTO)
            try {
                Uri uri = data.getData();
                choosePhoto.changeType(uri);
            } catch (Exception e) {
                Toast.makeText(UpdateFileActivity.this, "未找到文件",
                        Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadpic_activity_layout);
        choosePhoto = findViewById(R.id.choose_button);
        submit = findViewById(R.id.submit_button);
        Intent intent = getIntent();
        String fileName = intent.getStringExtra("file name");
        if (fileName != null)
            choosePhoto.setText("点击上传" + fileName);
        else
            choosePhoto.setText("点击上传文件");
        choosePhoto.setClick(0);
    }
}