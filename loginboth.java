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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class loginboth extends AppCompatActivity {
    Button _btnlog;
    EditText _txtfname, _txtpass;
    SQLiteDatabase db;
    Spinner spin;
    String dis;
    String name[]={"FARMER","COMPANY"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginboth);


        spin =(Spinner)findViewById(R.id.spinname);
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,name);
        spin.setAdapter(arrayAdapter);
        _btnlog=(Button)findViewById(R.id.btnlog);
        _txtfname=(EditText)findViewById(R.id.txtfname);
        _txtpass=(EditText)findViewById(R.id.txtpass);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(dis=name[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        db=openOrCreateDatabase("register6", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS farm(name VARCHAR,pass VARCHAR,cpass VARCHAR,adhaar VARCHAR,phone VARCHAR,area VARCHAR,crop,VARCHAR,kilogram VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS sessionfarm(session_name VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS sessioncomp(session_name VARCHAR);");

        _btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(dis.equals("FARMER"))
                {
                    farmeropen();
                }
                else if(dis.equals("COMPANY"))
                {
                    companyopen();
                }
                else
                {

                }



            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent movelogin = new Intent(loginboth.this, front.class);
        startActivity(movelogin);

    }
    public void farmeropen()
    {
        String name =_txtfname.getText().toString();
        String pass =_txtpass.getText().toString();


        if(_txtfname.getText().toString().trim().length()==0||_txtpass.getText().toString().trim().length()==0)
        {
            Toast.makeText(loginboth.this,"ENTER ALL VALUES",Toast.LENGTH_SHORT).show();
        }
        Cursor cc = db.rawQuery("select * from farm where name=? and pass=? ",new String[]{name,pass});
        if(cc.getCount()!=0) {
            db.execSQL("INSERT INTO sessionfarm(session_name)VALUES('" + _txtfname.getText() + "');");
            Intent movelogin = new Intent(loginboth.this, farmer_page.class);
            startActivity(movelogin);
        }
        else
        {
            Toast.makeText(loginboth.this,"ENTER correct values",Toast.LENGTH_SHORT).show();
            clear();
        }
    }
    public void companyopen()
    {
        String name =_txtfname.getText().toString();
        String pass =_txtpass.getText().toString();

        if(_txtfname.getText().toString().trim().length()==0||_txtpass.getText().toString().trim().length()==0)
        {
            Toast.makeText(loginboth.this,"ENTER ALL VALUES2",Toast.LENGTH_SHORT).show();
        }
        Cursor c = db.rawQuery("select * from comp where name=? and pass=? ",new String[]{name,pass});
        if(c.getCount()!=0) {
            db.execSQL("INSERT INTO sessioncomp(session_name)VALUES('" + _txtfname.getText() + "');");
            Intent movelogin = new Intent(loginboth.this, company.class);
            startActivity(movelogin);
        }
        else
        {
            Toast.makeText(loginboth.this,"ENTER correct values",Toast.LENGTH_SHORT).show();
            clear();
        }

    }
    public void clear()
    {
        _txtfname.setText("");
        _txtpass.setText("");
    }
}
