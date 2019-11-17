package com.example.saro.smartfarm;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class farmer_page extends AppCompatActivity {
    Button crop,update_crop,groups,nodif,shares;
    TextView ttext;
    boolean doubleBackToExitPressedOnce =false;
    String name;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_page);
        crop=(Button)findViewById(R.id.crop_details);
        update_crop=(Button)findViewById(R.id.updatecrop);
        groups=(Button)findViewById(R.id.group);
        ttext=(TextView)findViewById(R.id.name);


        db=openOrCreateDatabase("register6", Context.MODE_PRIVATE,null);

        Cursor cursor=db.rawQuery("select * from sessionfarm",null);
        if(cursor.getCount()==0)
        {

            Toast.makeText(this,"again",Toast.LENGTH_SHORT).show();

        }
        else {
            while (cursor.moveToNext()) {
                name=cursor.getString(0);
                ttext.setText("WELCOME "+name);
            }
        }

        crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movere = new Intent(farmer_page.this,crop_details.class);
                startActivity(movere);

            }
        });
        update_crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movere = new Intent(farmer_page.this,viewcrop.class);
                movere.putExtra("message",name);
                startActivity(movere);

            }
        });
        groups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                process_group();
                Intent movere = new Intent(farmer_page.this,grouping.class);
                startActivity(movere);

            }
        });

    }

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            finish();
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this,"click again to exit",Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
    public void process_group()
    {}

        public void logout1(View view) {
            db.rawQuery("Drop table sessionfarm ",null);
            Intent movere = new Intent(this,loginboth.class);
            startActivity(movere);

        }

    public void share(View view) {
        Intent movere = new Intent(this,share.class);
        startActivity(movere);
    }
}
