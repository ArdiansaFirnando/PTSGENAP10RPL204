package com.example.ptsgenap10rpl204;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ModelAdapter adapter;
    private ArrayList<ModelView> mahasiswaArrayList;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        toolbar = findViewById(R.id.toolbar);

        addData();

    }

    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new ModelView(getResources().getDrawable(R.drawable.anime), "Anime", "Gambar di pin : 10"));
        mahasiswaArrayList.add(new ModelView(getResources().getDrawable(R.drawable.olahraga),"Olahraga", "Gambar di pin : 8"));
        mahasiswaArrayList.add(new ModelView(getResources().getDrawable(R.drawable.otomotif), "Otomotif", "Gambar di pin : 13"));

        adapter = new ModelAdapter(getApplicationContext(), mahasiswaArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DashboardActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}