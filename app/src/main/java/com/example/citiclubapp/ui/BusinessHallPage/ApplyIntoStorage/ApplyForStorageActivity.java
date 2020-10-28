package com.example.citiclubapp.ui.BusinessHallPage.ApplyIntoStorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.citiclubapp.R;
import com.example.citiclubapp.widgetLayout.EditorBar;
import com.example.citiclubapp.widgetLayout.InsideTitle;

import java.util.ArrayList;
import java.util.List;

/**
 * 申请入库页面
 */
public class ApplyForStorageActivity extends AppCompatActivity {

    private InsideTitle title;
    private EditorBar type, num, address,expand;
    private Button submit;
    private Spinner company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_for_storage);
        setTitle();
        initializeEditBar();
        initializeButton();
        initializeSpinner();
    }

    private void setTitle(){
        title=findViewById(R.id.title);
        title.setTitle("入库申请");
    }

    private void initializeEditBar(){
        type=findViewById(R.id.type);
        type.setText("货物种类");
        type.setHint("请输入入库货物种类");
        num=findViewById(R.id.num);
        num.setText("货物数量");
        num.setHint("请输入货物数量");
        address=findViewById(R.id.address);
        address.setText("现存地址");
        address.setHint("请输入当前货物存放地址");
        expand=findViewById(R.id.expand);
        expand.setText("存储期限");
        expand.setHint("请输入存储期限（年/月/日）");
    }

    private void initializeButton(){
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initializeSpinner(){
        company=findViewById(R.id.company);
        List<String> companyList=new ArrayList<>();
        companyList.add("大连仓储公司");
        companyList.add("中运物流仓储公司");
        companyList.add("上海基森仓储公司");
        ArrayAdapter<String> adapter=new ArrayAdapter<>(ApplyForStorageActivity.this,
                R.layout.spinner_item, companyList);
        company.setAdapter(adapter);
    }
}