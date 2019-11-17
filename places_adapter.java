package com.example.saro.smartfarm;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class places_adapter extends ArrayAdapter<places>{
    public places_adapter(@NonNull Context context, List<places> placelist) {
        super(context,0, placelist);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView =convertView;
        if(listitemView==null)
            listitemView= LayoutInflater.from(getContext()).inflate(R.layout.viewcompanygroup,parent,false);

        places acc=getItem(position);

        TextView name=(TextView)listitemView.findViewById(R.id.places1);
        TextView place=(TextView)listitemView.findViewById(R.id.totalq1);
        TextView crop=(TextView)listitemView.findViewById(R.id.cropname);
        RelativeLayout r=(RelativeLayout)listitemView.findViewById(R.id.rel);
        TextView mob1=(TextView)listitemView.findViewById(R.id.mob);

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        name.setText(acc.getPlaces());
        place.setText(acc.getTotal());
        crop.setText(acc.getCropname());
        mob1.setText(acc.getMob_no());
        return listitemView;

    }
}
