package com.example.week2daily3homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    TextView tvNa, tvTy, tvSo, tvPop;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvNa = findViewById(R.id.tvNa);
        tvTy = findViewById(R.id.tvTy);
        tvSo = findViewById(R.id.tvSo);
        tvPop = findViewById(R.id.tvPop);
        img = findViewById(R.id.imgPic);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Animal animal = bundle.getParcelable("animal");
        tvNa.setText("Name: " + animal.getName());
        tvTy.setText("Type: " + animal.getType());
        tvSo.setText("Sound: " + animal.getSound());
        img.setImageResource(animal.getImage());
        tvPop.setText("Population: " + animal.getPopulation());
    }

    public void onClick(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
