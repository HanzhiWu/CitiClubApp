package com.example.citiclubapp.ui.BusinessHallPage.MyWarrant;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.citiclubapp.Adapter.MyWarrantAdapter;
import com.example.citiclubapp.DataBase.DBUser;
import com.example.citiclubapp.Entity.Warrant;
import com.example.citiclubapp.R;
import com.example.citiclubapp.widgetLayout.InsideTitle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyWarrantActivity extends AppCompatActivity {

    InsideTitle title;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_warrant);
        title = findViewById(R.id.title);
        listView = findViewById(R.id.list);
        title.setTitle("我的业务");
        setList();
    }

    private void setList() {
        DBUser dbUser=new DBUser();
        List<Warrant> warrantList = Arrays.asList(dbUser.returnAllWarrant(
                MyWarrantActivity.this));
        if(warrantList.isEmpty()){
            TextView error=findViewById(R.id.no_warrant);
            error.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        }else {
            MyWarrantAdapter adapter = new MyWarrantAdapter(MyWarrantActivity.this,
                    R.layout.my_warrant_item, warrantList);
            listView.setAdapter(adapter);
        }
    }
}