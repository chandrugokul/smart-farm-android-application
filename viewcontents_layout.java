package com.example.saro.smartfarm;

import android.accounts.Account;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class viewcontents_layout extends AppCompatActivity {
    String name,kg;
    ListView listView;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcontents_layout);


        ArrayList<Account> thelist=new ArrayList<>();

        Cursor cc=db.rawQuery("select * from farm where name=?",new String[] {name});
        if(cc.getCount()!=0){

            Cursor c=db.rawQuery("select name from farm where name=?",new String[] {name});
            while(c.moveToNext())
            {

            }

        }

    }
}
