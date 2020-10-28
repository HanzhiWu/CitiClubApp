package com.example.citiclubapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.citiclubapp.Entity.Condition;
import com.example.citiclubapp.Entity.Warrant;
import com.example.citiclubapp.R;
import com.example.citiclubapp.ui.BusinessHallPage.MyWarrant.WarrantDetailActivity;

import java.io.Serializable;
import java.util.List;

public class MyWarrantAdapter extends ArrayAdapter{

    int resourceId;
    InsideView insideView;
    Warrant item;

    public MyWarrantAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        resourceId=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        item= (Warrant) getItem(position);
        View view;
        if(convertView==null){
            insideView=new MyWarrantAdapter.InsideView();
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            view.setTag(insideView);
            insideView.id=view.findViewById(R.id.id);
            insideView.type=view.findViewById(R.id.type);
            insideView.num=view.findViewById(R.id.num);
            insideView.status=view.findViewById(R.id.status);
            insideView.detail=view.findViewById(R.id.check_detail);
        }else{
            view=convertView;
            insideView=(MyWarrantAdapter.InsideView)convertView.getTag();
        }
        insideView.setValue(item);
        return view;
    }

    class InsideView{
        TextView id, type, num, status, detail;
        public void setValue(final Warrant item){
            Log.i("warrant id", item.getWarrantID()+"");
            id.setText(String.valueOf(item.getWarrantID()));
            type.setText(item.getCargoItem());
            num.setText(String.valueOf(item.getCargoWeight()));
            status.setText(Condition.getCondition(item.getConditionNode()));
            detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent(getContext(), WarrantDetailActivity.class);
                    intent.putExtra("warrant", (Serializable) item);
                    ((Activity)getContext()).startActivity(intent);
                }
            });
        }
    }
}
