package com.example.saro.smartfarm;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class company extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce =false;
    TextView ttext;
    String name;
    SQLiteDatabase db;
    ListView account;
    ArrayList<String> listitem;
    ArrayAdapter adapter;
    String kg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        ttext=(TextView)findViewById(R.id.name);

        db=openOrCreateDatabase("register6", Context.MODE_PRIVATE,null);

        Cursor cursor=db.rawQuery("select * from sessioncomp",null);
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
    }
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this,"again",Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run()
            {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
    public void display(View view) {

        Intent movere = new Intent(company.this,companyview_group.class);
        startActivity(movere);
    }

    public void logout(View view) {
        db.rawQuery("Drop table sessioncomp ",null);
        Intent movere = new Intent(company.this,loginboth.class);
        startActivity(movere);

    }

    public void suggest(View view) {
        Intent movere = new Intent(company.this,suggest.class);
        startActivity(movere);

    }
}
