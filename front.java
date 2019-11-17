package com.example.saro.smartfarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class front extends AppCompatActivity {
    Button _btnlog,_btnreg,_btnreg2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);

        _btnlog=findViewById(R.id.btnlog);
        _btnreg=findViewById(R.id.btnreg);
        _btnreg2=findViewById(R.id.btnreg2);

        _btnlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movere = new Intent(front.this,loginboth.class);
                startActivity(movere);

            }
        });
        _btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movere = new Intent(front.this,loginActivity.class);
                startActivity(movere);

            }
        });
        _btnreg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent movere = new Intent(front.this,companyregister.class);
                startActivity(movere);

            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
