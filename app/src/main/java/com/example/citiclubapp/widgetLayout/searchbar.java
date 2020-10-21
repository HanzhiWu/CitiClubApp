package com.example.citiclubapp.widgetLayout;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.citiclubapp.R;

import static androidx.core.content.ContextCompat.startActivity;

public class searchbar extends LinearLayout {
    private EditText warrantNum;
    private ImageView search;
    public ImageView getSearch() {
        return search;
    }
    public searchbar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        warrantNum=findViewById(R.id.editTextWarrantNum);
        search=findViewById(R.id.search);
        LayoutInflater.from(context).inflate(R.layout.searchbar,this);
    }

}
