package com.example.saro.smartfarm;

import android.accounts.Account;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class display_account extends AppCompatActivity {
    SQLiteDatabase db;
    String name,kg,name1,crops,cropp,phone,place,placex,quantity;
    private ListView listView;
    int quant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_account);

      listView=(ListView)findViewById(R.id.display_account);
      ViewGroup headerView=(ViewGroup)getLayoutInflater().inflate(R.layout.headers,listView,false);
      listView.addHeaderView(headerView);
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
        ArrayList<map> maps=new ArrayList<>();
        Cursor cc=db.rawQuery("select crop,district from farm where name=?",new String[] {name});
        if(cc.getCount()!=0)
        {
            while (cc.moveToNext())
            {
                crops = cc.getString(0);
                placex=cc.getString(1);
            }
        }
            Cursor c = db.rawQuery("select name,district,crop,phone,kilogram from farm where crop=? and district=?", new String[]{crops,placex});
        if(c.getCount()!=0)
        {
            while (c.moveToNext()) {
                name1 = c.getString(0);
                place = c.getString(1);
                cropp = c.getString(2);
                phone = c.getString(3);
                quantity=c.getString(4);
                quant=Integer.parseInt(quantity);
                maps.add(new map(name1, place,cropp,phone,quant));
            }
            map_adapter adapter = new map_adapter(this, maps);
            listView.setAdapter(adapter);
        }
    }
}
