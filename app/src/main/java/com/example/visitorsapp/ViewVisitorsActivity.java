package com.example.visitorsapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ViewVisitorsActivity extends AppCompatActivity {
    TextView fnametxt,lnametxt,purposetxt,whomeettxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_visitors);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        fnametxt=(TextView) findViewById(R.id.fname);
        lnametxt=(TextView) findViewById(R.id.lname);
        purposetxt=(TextView) findViewById(R.id.purpose);
        whomeettxt=(TextView) findViewById(R.id.whomeet);
    }
}