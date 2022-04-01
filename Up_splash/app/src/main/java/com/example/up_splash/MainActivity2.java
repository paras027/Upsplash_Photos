package com.example.up_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent=getIntent();
        String url=intent.getStringExtra("a1");
        String text=intent.getStringExtra("a3");

        ImageView imageView=findViewById(R.id.imageView);
        TextView textView=findViewById(R.id.textView);
        Glide.with(this)
                .load(url)
                .centerCrop()
                .into(imageView);
        textView.setText(text);
    }
}