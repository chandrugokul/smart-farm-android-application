package com.example.saro.smartfarm;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class editcrop extends AppCompatActivity {
    SQLiteDatabase db;
    Spinner spint;
    EditText kilogram;
    Button submit;
    String crop[]={"wheat","sunflower","paddy"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcrop);


        submit=(Button)findViewById(R.id.submit);
        kilogram=(EditText)findViewById(R.id.kg);
        spint =(Spinner)findViewById(R.id.spin);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,crop);
        spint.setAdapter(arrayAdapter);
        spint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String crop="+crop[i]".toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        db=openOrCreateDatabase("register6", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS farm(name VARCHAR,pass VARCHAR,cpass VARCHAR,adhaar VARCHAR,phone VARCHAR,area VARCHAR,crop VARCHAR,kilogram VARCHAR);");
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(kilogram.getText().toString().trim().length()!=0)
                {
                    db.execSQL("INSERT INTO farm (crop,kilogram)VALUES('"+crop+"','" +kilogram.getText() + "');");
                    Toast.makeText(editcrop.this,"submitted",Toast.LENGTH_SHORT).show();
                    Intent move = new Intent(editcrop.this, viewcrop.class);
                    startActivity(move);
                }
                else
                {
                    Toast.makeText(editcrop.this,"Enter all values",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
