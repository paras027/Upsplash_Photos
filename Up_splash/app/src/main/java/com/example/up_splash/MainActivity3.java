package com.example.up_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent=getIntent();
        String bio=intent.getStringExtra("a1");
        String llo=intent.getStringExtra("a3");
        String name=intent.getStringExtra("a8");

        String dp=intent.getStringExtra("a6");

        ImageView imageView=findViewById(R.id.imageView2);
        TextView textView=findViewById(R.id.textView2);
        TextView textView1=findViewById(R.id.textView3);
        TextView textView3=findViewById(R.id.textView4);

        Glide.with(MainActivity3.this)
                .load(dp)
                .centerCrop()
                .into(imageView);
        textView.setText(name);
        textView1.setText(llo);
        textView3.setText(bio);
    }
}