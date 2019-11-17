package com.example.saro.smartfarm;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;


public class loginActivity extends AppCompatActivity {
    SQLiteDatabase db;
    String dis,dis1,name;
    Button _btnreg;
    EditText _txtfname,adhaar,_txtpass,_txtcpass,_txtphone,_area;
    Spinner spind,spint;
    String District[]={"vellore","madurai","Krishnagiri"};
    String taluk[]={"gudiyatham","ambur","ranipet","Tirupattur"};
    String taluk1[]={"thirumangalam","koodakovil"};
    String taluk2[]={"Hosur","soolagiri"};
    ArrayAdapter<String>arrayAdapter;
    ArrayAdapter<String>arrayAdapter1;
    ArrayAdapter<String>arrayAdapter2;
    ArrayAdapter<String>arrayAdapter3;
    int a1=0,b1=0;
    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        spind =(Spinner)findViewById(R.id.spindis);
        spint =(Spinner)findViewById(R.id.spintaluk);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,District);
        arrayAdapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,taluk);
        arrayAdapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,taluk1);
        arrayAdapter3=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,taluk2);
        spind.setAdapter(arrayAdapter);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        _btnreg=(Button)findViewById(R.id.btnreg);
        _txtfname=(EditText)findViewById(R.id.txtfname);
        adhaar=(EditText)findViewById(R.id.adhaar);
        _area=(EditText)findViewById(R.id.area);
        _txtpass=(EditText)findViewById(R.id.txtpass);
        _txtcpass=(EditText)findViewById(R.id.txtcpass);
        _txtphone=(EditText)findViewById(R.id.txtphone);
        spind.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dis=spind.getSelectedItem().toString();
                if(dis.equals("vellore"))
                {
                    spint.setAdapter(arrayAdapter1);
                }
                if(dis.equals("madurai"))
                {
                    spint.setAdapter(arrayAdapter2);
                }

                if(dis.equals("Krishnagiri"))
                {
                    spint.setAdapter(arrayAdapter3);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spint.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dis1=spint.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        db=openOrCreateDatabase("register6", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS farm(name VARCHAR,pass VARCHAR,cpass VARCHAR,adhaar VARCHAR,phone VARCHAR,area VARCHAR,district VARCHAR,taluk VARCHAR,crop VARCHAR,kilogram VARCHAR);");



        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if(_txtfname.getText().toString().trim().length()==0||
                        _txtpass.getText().toString().trim().length()==0||_txtcpass.getText().toString().trim().length()==0||adhaar.getText().toString().trim().length()==0||_txtphone.getText().toString().trim().length()==0||_area.getText().toString().trim().length()==0) {
                    Toast.makeText(loginActivity.this, "Enter all values", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    name=_txtfname.getText().toString();
                    Cursor c=db.rawQuery("select name from farm where name=?",new String[] {name});
                    if(c.getCount()==0) {
                        move();
                    }
                    else
                    {
                        Toast.makeText(loginActivity.this, "User Already Exit", Toast.LENGTH_SHORT).show();
                        _txtfname.setText("");
                    }
                }
            }
        });
    }
    public void move() {
        if (_txtpass.getText().toString().equals(_txtcpass.getText().toString())) {
            long a=Long.parseLong(adhaar.getText().toString());
            while (a>0)
            {
                a=a/10;
                a1++;
            }
            long b=Long.parseLong(_txtphone.getText().toString());
            while (b>0)
            {
                b=b/10;
                b1++;
            }
            if(a1==12&&b1==10) {
                db.execSQL("INSERT INTO farm (name,pass,cpass,adhaar,phone,area,district,taluk)VALUES('" + _txtfname.getText() + "','" + _txtpass.getText() + "','" + _txtcpass.getText() + "','" + adhaar.getText() + "','" + _txtphone.getText() + "','" + _area.getText() + "','" + dis + "','" + dis1 + "');");
                Toast.makeText(loginActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                Intent movelogin = new Intent(loginActivity.this, loginboth.class);
                startActivity(movelogin);
            }
            else
            {
                Toast.makeText(this, "Enter 12 digit Adhaar number and 10 digit Phone number", Toast.LENGTH_SHORT).show();
                a1=0;
                b1=0;
            }
        }
        else {
            Toast.makeText(this, "password should be equal", Toast.LENGTH_SHORT).show();
        }
    }
}
