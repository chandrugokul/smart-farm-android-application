package com.example.saro.smartfarm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class suggest extends AppCompatActivity {
    EditText suggests;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest);

        suggests=(EditText)findViewById(R.id.suggest);
        btn=(Button)findViewById(R.id.submitsuggest);
    }

    public void sug(View view) {

        Toast.makeText(this,"submitted",Toast.LENGTH_SHORT).show();
        Intent movere = new Intent(this,farmer_page.class);
        startActivity(movere);

    }
}
