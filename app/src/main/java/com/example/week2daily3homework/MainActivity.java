package com.example.week2daily3homework;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter rvAdapter;
    animalDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new animalDatabaseHelper(this);
        recyclerView = findViewById(R.id.rvMainRecyclerView);
        //RV
        rvAdapter = new RecyclerViewAdapter(listOfAnimals());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(rvAdapter);
    }

    public void onClick(View view){
        //Movies newMovie = new Movies("Pulp Fiction", "People get ....");
        //rvAdapter.addMovie(newMovie);
    }

    private ArrayList<Animal> listOfAnimals(){
        ArrayList<Animal> animalArrayList = new ArrayList<>();
        animalArrayList = databaseHelper.getAllAnimals();
        return animalArrayList;
    }
}
