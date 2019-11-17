package com.example.saro.smartfarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class farmer extends AppCompatActivity implements OnClickListener {
    Button crop,update_crop,groups,nodif,shares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.farmers);


        update_crop=(Button)findViewById(R.id.update);
        groups=(Button)findViewById(R.id.group);


        crop.setOnClickListener(this);
        update_crop.setOnClickListener(this);
        groups.setOnClickListener(this);
        nodif.setOnClickListener(this);
        shares.setOnClickListener(this);
    }
    @Override
    public void onClick(View view)
    {
        if(view==crop)
        {
            Intent movelogin = new Intent(farmer.this, crop_details.class);
            startActivity(movelogin);

        }
    }
}
