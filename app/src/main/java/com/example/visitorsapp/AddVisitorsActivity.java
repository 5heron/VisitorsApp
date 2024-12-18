package com.example.visitorsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddVisitorsActivity extends AppCompatActivity {
    EditText et1,et2,et3,et4;
    String fname,lname,purpose,whomeet;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_visitors);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et1=(EditText) findViewById(R.id.fname);
        et2=(EditText) findViewById(R.id.lname);
        et3=(EditText) findViewById(R.id.purpose);
        et4=(EditText) findViewById(R.id.whomeet);
        b1=(Button) findViewById(R.id.subbt);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname=et1.getText().toString();
                lname=et2.getText().toString();
                purpose=et3.getText().toString();
                whomeet=et4.getText().toString();
                Toast.makeText(getApplicationContext(),fname + lname + purpose + whomeet,Toast.LENGTH_LONG).show();
            }
        });
    }
}