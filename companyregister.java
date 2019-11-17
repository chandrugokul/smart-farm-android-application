package com.example.saro.smartfarm;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class companyregister extends AppCompatActivity {

    SQLiteDatabase db;
    EditText _name, _email, _pass, _rpass, _phone;
    Button _btnreg;
    String name;
    int b1=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companyregister);


        _name = findViewById(R.id.name);
        _pass = findViewById(R.id.pass);
        _rpass = findViewById(R.id.rpass);
        _email = findViewById(R.id.email);
        _phone = findViewById(R.id.phone);
        _btnreg = findViewById(R.id.btnreg);
        db=openOrCreateDatabase("register6", Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS comp(name VARCHAR,pass VARCHAR,rpass VARCHAR,email VARCHAR,phone VARCHAR);");
        _btnreg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(_name.getText().toString().trim().length()==0||
                            _pass.getText().toString().trim().length()==0||_rpass.getText().toString().trim().length()==0||_email.getText().toString().trim().length()==0||_phone.getText().toString().trim().length()==0)
                    {
                        Toast.makeText(companyregister.this, "Enter all values", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        name=_name.getText().toString();
                        Cursor c=db.rawQuery("select name from farm where name=?",new String[] {name});
                        if(c.getCount()==0) {
                            move();
                        }
                        else
                        {
                            Toast.makeText(companyregister.this, "User Already Exit", Toast.LENGTH_SHORT).show();
                            _name.setText("");
                        }
                    }
            }
        });
    }
    public void move() {
        if(_pass.getText().toString().equals(_rpass.getText().toString())) {

            long b=Long.parseLong(_phone.getText().toString());
            while (b>0)
            {
                b=b/10;
                b1++;
            }

            if(b1==10) {
            db.execSQL("INSERT INTO comp VALUES('" + _name.getText() + "','" + _pass.getText() + "','" + _rpass.getText() + "','" + _email.getText() + "','" + _phone.getText() + "');");
            Toast.makeText(companyregister.this, "Registered", Toast.LENGTH_SHORT).show();
            Intent movelogin = new Intent(companyregister.this, loginboth.class);
            startActivity(movelogin);
        }
        else
            {
                Toast.makeText(companyregister.this, "Phone Number should 10 Digit Number", Toast.LENGTH_SHORT).show();
                b1=0;
            }
        }
        else{
            Toast.makeText(companyregister.this, "PASSWORD SHOULD BE SAME", Toast.LENGTH_SHORT).show();
        }
    }
}