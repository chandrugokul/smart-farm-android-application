package com.example.saro.smartfarm;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class crop_details extends AppCompatActivity {

    SQLiteDatabase db;
    Spinner spint;
    EditText kilogram;
    Button submit;
    String crop[]={"wheat","sunflower","paddy"};
    ArrayAdapter<String> arrayAdapter;
    String name,crops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_details);

        submit=(Button)findViewById(R.id.submit);
        kilogram=(EditText)findViewById(R.id.kg);
        spint =(Spinner)findViewById(R.id.spin);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,crop);
        spint.setAdapter(arrayAdapter);

        spint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.print(crops=crop[i]);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
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
        submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kilogram.getText().toString().trim().length()!=0)
                {
                    Cursor c=db.rawQuery("select * from farm where name=?",new String[] {name});
                    if(c.moveToFirst()) {
                        db.execSQL("update farm set crop='"+crops+"',kilogram='" + kilogram.getText().toString()+ "' where name='" + name + "'");
                        Toast.makeText(crop_details.this, "submitted", Toast.LENGTH_SHORT).show();
                        Intent move = new Intent(crop_details.this, farmer_page.class);
                        startActivity(move);
                    }
                    }
            else
                {
                    Toast.makeText(crop_details.this,"Enter all values",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
