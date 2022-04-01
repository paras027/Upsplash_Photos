package com.example.up_splash;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RequestQueue queue;
    recadapter recadapter;
    RecyclerView recyclerView;
    ArrayList<Photoss> photosses;
    private static final String SAMPLE_JSON_RESPONSE = "https://api.unsplash.com/photos/?client_id=8634366274bd23efb9b023fb9b2c6502e67f7dd5d6a7962b3b49fbee170940f8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loaddata();
        Context context=getApplicationContext();
    }

    public  void loaddata(){
        queue= Volley.newRequestQueue(this);
        photosses=new ArrayList<>();
        RecyclerView recyclerView=findViewById(R.id.rv);
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, SAMPLE_JSON_RESPONSE, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for(int i=0;i<response.length();i++)
                    {
                        JSONObject pos =response.getJSONObject(i);


                    JSONObject ff= pos.getJSONObject("urls");
                    JSONObject n=pos.getJSONObject("user");
                    JSONObject img3=n.getJSONObject("profile_image");
                    String imgurl3= img3.getString("medium");
                        String urlim=ff.getString("full");
                        String desc=pos.getString("description");
                        String name=n.getString("name");
                        String bio=n.getString("bio");
                        String lo=n.getString("location");

                        Photoss photoss = new Photoss(urlim,desc,imgurl3,name, bio, lo);
                        photosses.add(photoss);
                        LinearLayoutManager lm= new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
                        recyclerView.setLayoutManager(lm);
                        recadapter=new recadapter(MainActivity.this,photosses);
                        recyclerView.setAdapter(recadapter);

                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });queue = Volley.newRequestQueue(this);
        queue.add(jsonArrayRequest);
    }
}