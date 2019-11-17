package com.example.saro.smartfarm;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class grouping extends AppCompatActivity {
    TextView crops,quantity,sq;
    SQLiteDatabase db;
    String n1,n2,name,n3,n4;
    String place,cropp,phone,quantity1,quanti;
    String n,p,c,ph,q;
    String cropss,placex;
    int total=0,quant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grouping);
        crops=(TextView)findViewById(R.id.crop);
        sq=(TextView)findViewById(R.id.textView30);
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
            Cursor c=db.rawQuery("select crop,kilogram,district from farm where name=?",new String[] {name});
            while(c.moveToNext())
            {
                n1=c.getString(0);
                n2=c.getString(1);
                n3=c.getString(2);
                crops.setText(n1);
                sq.setText(n2);
            }

        }
       /* Cursor cc1=db.rawQuery("select crop,district from farm where name=?",new String[] {name});
        if(cc1.getCount()!=0)
        {
            while (cc1.moveToNext())
            {
                cropss = cc1.getString(0);
                placex=cc1.getString(1);
            }
        }
        Cursor c = db.rawQuery("select name,district,crop,phone,kilogram from farm where crop=? and district=?", new String[]{cropss,placex});
        if(c.getCount()!=0)
        {
            while (c.moveToNext()) {
                name = c.getString(0);
                place = c.getString(1);
                cropp = c.getString(2);
                phone = c.getString(3);
                quantity1=c.getString(4);

            }
      //      insert(name,place,cropp,phone,quantity1);
        }*/

    }
    public void groupdetails(View view) {
        Intent movere = new Intent(grouping.this,display_account.class);
        startActivity(movere);
    }
    /*public void insert(String name,String place,String cropp,String phone,String quantity1)
    {

        n=name;
        p=place;
        c=cropp;
        ph=phone;
        q=quantity1;
        Cursor cd = db.rawQuery("select kilogram from farm where crop=? and district=?", new String[]{cropss,placex});
        if(cd.getCount()!=0)
        {
            while(cd.moveToFirst())
            {
                quanti=cd.getString(0);
                quant=Integer.parseInt(quanti);
                total=quant;
            }
        }
        db.execSQL("CREATE TABLE IF NOT EXISTS "+c+"(name VARCHAR,crop VARCHAR,place VARCHAR,phone VARCHAR,quantity VARCHAR,total VARCHAR);");
        db.execSQL("INSERT INTO "+c+"(name,place,crop,phone,quantity,total)VALUES('" + n + "','" + p + "','" + c + "','" + ph + "','" + q + "','" + total + "');");
        Cursor cdd=db.rawQuery("select quantity from "+crops.getText()+" where place=?  ",new String[] {n3});
        if(cdd.getCount()!=0) {
            while (cdd.moveToNext()) {
                n3=cdd.getString(0);
                quantity.setText(n3);
            }
        }
    }*/
}
