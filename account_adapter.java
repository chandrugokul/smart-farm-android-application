package com.example.saro.smartfarm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class account_adapter extends ArrayAdapter<Account>{
    List list = new ArrayList();



    public account_adapter(@NonNull Context context, List<Account> accs) {
        super(context,0, accs);
    }


    @Override
    public void add(@Nullable Account object) {
        list.add(object);
        super.add(object);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView =convertView;
        if(listitemView==null)
        listitemView= LayoutInflater.from(getContext()).inflate(R.layout.display_account,parent,false);

        Account acc=getItem(position);

        TextView name=(TextView)listitemView.findViewById(R.id.tname);
        TextView kg=(TextView)listitemView.findViewById(R.id.placing);

        name.setText(acc.getName());
        kg.setText(acc.getKg());

        return listitemView;
    }
}
