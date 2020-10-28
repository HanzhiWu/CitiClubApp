package com.example.citiclubapp.ui.LegalPersonCertificateActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.citiclubapp.DataBase.DBUser;
import com.example.citiclubapp.R;
import com.example.citiclubapp.widgetLayout.ButtonChoosePhoto;
import com.example.citiclubapp.widgetLayout.EditorBar;
import com.example.citiclubapp.widgetLayout.InsideTitle;

import static com.example.citiclubapp.widgetLayout.ButtonChoosePhoto.CHOOSE_PHOTO;

public class EnterpriceBankCertificationActivity extends AppCompatActivity {
    private InsideTitle title;
    private ButtonChoosePhoto licenseButton;
    private EditorBar companyName, bankAccount, companyAddressEdit;
    private Button submit_bank;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            Uri uri = data.getData();
            switch (requestCode) {
                case CHOOSE_PHOTO:
                    licenseButton.changeType(uri);
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(EnterpriceBankCertificationActivity.this, "未找到照片",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprice_bank_certification);
        setTitle();
        initializeEditBar();
        initializeButton();
    }

    private void setTitle() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        title = findViewById(R.id.bank_certificate);
        title.setTitle("企业银行信息认证");
    }

    private void initializeEditBar() {
        bankAccount = findViewById(R.id.bankAccount);
        bankAccount.setText("银行卡账号");
        bankAccount.setHint("请输入银行卡账号");
        companyName = findViewById(R.id.bank_company_name);
        companyName.setText("公司名称");
        companyName.setHint("请输入公司名称");
        companyAddressEdit = findViewById(R.id.bank_company_address);
        companyAddressEdit.setText("公司地址");
        companyAddressEdit.setHint("请输入公司地址");

    }

    private void initializeButton(){
        DBUser dbUser=new DBUser();
        licenseButton=findViewById(R.id.uploadLicense_bank);
        licenseButton.setText("点击上传营业执照照片");
        licenseButton.setClick(0);
        submit_bank = findViewById(R.id.submit_bank);
        submit_bank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}