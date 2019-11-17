package com.example.saro.smartfarm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class map_adapter extends ArrayAdapter<map> {
    public map_adapter(@NonNull Context context, List<map> maps) {
        super(context,0, maps);
    }

    int total,sum=0;
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listitemView =convertView;
        if(listitemView==null)
            listitemView= LayoutInflater.from(getContext()).inflate(R.layout.display_account,parent,false);

        map acc=getItem(position);

        TextView name=(TextView)listitemView.findViewById(R.id.tname);
        TextView place=(TextView)listitemView.findViewById(R.id.placing);
        TextView crop=(TextView)listitemView.findViewById(R.id.rcrop);
        TextView phone=(TextView)listitemView.findViewById(R.id.place);


        name.setText(acc.getName());
        place.setText(acc.getPlace());
        crop.setText(acc.getCrop());
        phone.setText(acc.getPhone());
        return listitemView;
    }
}
