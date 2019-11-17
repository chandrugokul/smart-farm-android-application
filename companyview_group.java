package com.example.saro.smartfarm;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class companyview_group extends AppCompatActivity {
    SQLiteDatabase db;
    String name,place,crop,nam,mob_no;
    private ListView listViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companyview_group);
        listViews=(ListView)findViewById(R.id.display_accounts);
        db=openOrCreateDatabase("register6", Context.MODE_PRIVATE,null);
        ArrayList<places> placelist=new ArrayList<>();
        Cursor c = db.rawQuery("select district,kilogram,crop,name,phone from farm ", null);
        if(c.getCount()!=0) {
            while (c.moveToNext()) {
                name = c.getString(0);
                place = c.getString(1);
                crop=c.getString(2);
                nam=c.getString(3);
                mob_no=c.getString(4);
                placelist.add(new places(name,place,crop,nam,mob_no));
            }
            places_adapter adapter = new places_adapter(this, placelist);
            listViews.setAdapter(adapter);
        }
    }
}
