package com.example.saro.smartfarm;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class viewcrop extends AppCompatActivity {
    Button updates;
    TextView names,kgs;
    SQLiteDatabase db;
    String name,kg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcrop);

        updates=(Button)findViewById(R.id.update);
        names=(TextView)findViewById(R.id.name);
        kgs=(TextView)findViewById(R.id.kg);

        Intent movelogin=getIntent();
        name=movelogin.getStringExtra("message");

        db=openOrCreateDatabase("register6", Context.MODE_PRIVATE,null);
        Cursor cursor=db.rawQuery("select * from sessionfarm",null);
        if(cursor.getCount()==0)
        {

            Toast.makeText(this,"again",Toast.LENGTH_SHORT).show();

        }
        else {

            while (cursor.moveToNext()) {
                name = cursor.getString(0);
            }
        }
        Cursor cc=db.rawQuery("select * from farm where name=?",new String[] {name});
        if(cc.getCount()!=0){

            Cursor c=db.rawQuery("select crop,kilogram from farm where name=?",new String[] {name});
            while(c.moveToNext())
            {
                name=c.getString(0);
                kg=c.getString(1);
                names.setText(name);
                kgs.setText(kg);
            }
        }

        updates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movere = new Intent(viewcrop.this,crop_details.class);
                startActivity(movere);
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent movelogin = new Intent(this, farmer_page.class);
        startActivity(movelogin);
    }
}
