package com.example.visitorsapp;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViewVisitorsActivity extends AppCompatActivity {
    TextView fnametxt,lnametxt,purposetxt,whomeettxt,Txt;
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
        Txt=(TextView) findViewById(R.id.txt);
        fnametxt=(TextView) findViewById(R.id.fname);
        lnametxt=(TextView) findViewById(R.id.lname);
        purposetxt=(TextView) findViewById(R.id.purpose);
        whomeettxt=(TextView) findViewById(R.id.whomeet);
        callApi();
    }

    private void callApi() {
        String apiUrl ="https://log-app-demo-api.onrender.com/getvistors";
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                apiUrl,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        StringBuilder result = new StringBuilder();
                        for(int i = 0; i < response.length(); i++){
                            try {
                                JSONObject ob = response.getJSONObject(i);
                                String getfirstName = ob.getString("firstname");
                                String getlastName = ob.getString("lastname");
                                String getPurpose = ob.getString("purpose");
                                String getWhomeet = ob.getString("whomToMeet");
                                result.append("First name:").append(getfirstName).append("\n");
                                result.append("Last name:").append(getlastName).append("\n");
                                result.append("Purpose:").append(getPurpose).append("\n");
                                result.append("WHom to meet:").append(getWhomeet).append("\n");
                                result.append("-----------------------------\n").append("\n");
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        Txt.setText(result.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
                    }
                }
        );
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(request);
    }
}