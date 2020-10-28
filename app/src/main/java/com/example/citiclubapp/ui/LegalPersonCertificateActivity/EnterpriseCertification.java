package com.example.citiclubapp.ui.LegalPersonCertificateActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.citiclubapp.R;
import com.example.citiclubapp.widgetLayout.ButtonChoosePhoto;
import com.example.citiclubapp.widgetLayout.EditorBar;
import com.example.citiclubapp.widgetLayout.InsideTitle;

import static com.example.citiclubapp.widgetLayout.ButtonChoosePhoto.CHOOSE_PHOTO;

public class EnterpriseCertification extends AppCompatActivity {

    private InsideTitle title;
    private EditorBar orgCodeEdit, businessRegistrationCodeEdit, companyName,
            businessRegistrationOfficeEdit, registrationStatusEdit, taxRegistrationCodeEdit,
            companyAddressEdit, companyPhoneEdit, legalPersonNameEdit, legalPersonCodeEdit,
            legalPersonPhoneEdit;
    private ButtonChoosePhoto licenseButton, IDButtonFront, IDButtonBack;
    private Button submit;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            Uri uri = data.getData();
            switch (requestCode) {
                case CHOOSE_PHOTO:
                    licenseButton.changeType(uri);
                    break;
                case CHOOSE_PHOTO + 1:
                    IDButtonFront.changeType(uri);
                    break;
                case CHOOSE_PHOTO + 2:
                    IDButtonBack.changeType(uri);
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(EnterpriseCertification.this, "未找到照片", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterprise_certification);
        setTitle();
        initializeEditBar();
        initializeButton();
    }

    private void setTitle() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        title = findViewById(R.id.title);
        title.setTitle("企业公司法人认证");
    }

    private void initializeEditBar() {
        orgCodeEdit = findViewById(R.id.org_code_edit);
        orgCodeEdit.setText("统一社会信用代码/注册号/组织结构代码");
        orgCodeEdit.setHint("请输入统一社会信用的代码");
        companyName = findViewById(R.id.company_name_edit);
        companyName.setText("公司名称");
        companyName.setHint("请输入公司名称");
        companyAddressEdit = findViewById(R.id.company_address_edit);
        companyAddressEdit.setText("公司地址");
        companyAddressEdit.setHint("请输入公司地址");
        companyPhoneEdit = findViewById(R.id.company_phoneNumber_edit);
        companyPhoneEdit.setText("公司电话");
        companyPhoneEdit.setHint("请输入公司电话");
        businessRegistrationCodeEdit = findViewById(R.id.business_registration_code_edit);
        businessRegistrationCodeEdit.setText("工商注册号");
        businessRegistrationCodeEdit.setHint("请输入工商注册号");
        businessRegistrationOfficeEdit = findViewById(R.id.business_registration_office_edit);
        businessRegistrationOfficeEdit.setText("工商登记机关");
        businessRegistrationOfficeEdit.setHint("请输入工商登记机关");
        legalPersonNameEdit = findViewById(R.id.legalPerson_name_edit);
        legalPersonNameEdit.setText("法人姓名");
        legalPersonNameEdit.setHint("请输入法人姓名");
        legalPersonCodeEdit = findViewById(R.id.legalPerson_code_edit);
        legalPersonCodeEdit.setText("法人证字号");
        legalPersonCodeEdit.setHint("请输入法人证字号");
        legalPersonPhoneEdit = findViewById(R.id.legalPerson_phoneNumber_edit);
        legalPersonPhoneEdit.setText("法人联系电话");
        legalPersonPhoneEdit.setHint("请输入法人联系电话");
        registrationStatusEdit = findViewById(R.id.registration_status_edit);
        registrationStatusEdit.setText("登记状态");
        registrationStatusEdit.setHint("请输入注册状态");
        taxRegistrationCodeEdit = findViewById(R.id.tax_registration_code_edit);
        taxRegistrationCodeEdit.setText("税务登记证号");
        taxRegistrationCodeEdit.setHint("请输入税务登记证号");
    }

    private void initializeButton() {
        licenseButton = findViewById(R.id.uploadLicense);
        licenseButton.setText("点击上传营业执照照片");
        licenseButton.setClick(0);
        IDButtonFront = findViewById(R.id.upload_front_IDphoto);
        IDButtonFront.setText("点击上传身份证照片\n（正面）");
        IDButtonFront.setClick(1);
        IDButtonBack = findViewById(R.id.upload_back_IDphoto);
        IDButtonBack.setText("点击上传身份证照片\n（反面）");
        IDButtonBack.setClick(2);

        submit = findViewById(R.id.submit_enter);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}