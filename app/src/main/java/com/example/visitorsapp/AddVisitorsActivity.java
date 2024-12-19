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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

public class AddVisitorsActivity extends AppCompatActivity {
    EditText et1,et2,et3,et4;
    String fname,lname,purpose,whomeet;
    Button b1,b2;
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
        b2=(Button) findViewById(R.id.backbt);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ob = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ob);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname=et1.getText().toString();
                lname=et2.getText().toString();
                purpose=et3.getText().toString();
                whomeet=et4.getText().toString();
                if(fname.isEmpty()||lname.isEmpty()||purpose.isEmpty()||whomeet.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All the fields are mandatory", Toast.LENGTH_LONG).show();
                }
                else{
                    callApi();
                }
            }

            private void callApi() {
                String apiUrl ="https://log-app-demo-api.onrender.com/addvisitor";
                JSONObject data=new JSONObject();
                try {
                    data.put("firstname",fname);
                    data.put("lastname",lname);
                    data.put("purpose",purpose);
                    data.put("whomToMeet",whomeet);
                    JsonObjectRequest request = new JsonObjectRequest(
                            Request.Method.POST,
                            apiUrl,
                            data,
                            response -> Toast.makeText(getApplicationContext(),"Successfully added",Toast.LENGTH_LONG).show(),
                            error -> Toast.makeText(getApplicationContext(), "Something went wrong!",Toast.LENGTH_LONG).show()
                    );
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    queue.add(request);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}