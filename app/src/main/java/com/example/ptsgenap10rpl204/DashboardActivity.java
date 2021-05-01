package com.example.ptsgenap10rpl204;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ModelAdapter modelAdapter;
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
        mahasiswaArrayList.add(new ModelView(R.drawable.anime, "Anime", "Gambar di pin : 10", "Anime adalah kartun 2d atau dua dimensi garapan negara jepang. Anime umumnya sangat populer di kalangan anak remaja", R.drawable.anime, R.drawable.olahraga, R.drawable.otomotif));
        mahasiswaArrayList.add(new ModelView(R.drawable.olahraga,"Olahraga", "Gambar di pin : 8", "Olahraga adalah suatu kegiatan yang digunakan untuk melatih tubuh seseorang Secara jasmani maupun rohani.", R.drawable.olahraga, R.drawable.anime, R.drawable.otomotif));
        mahasiswaArrayList.add(new ModelView(R.drawable.otomotif, "Otomotif", "Gambar di pin : 13", "Teknik otomotif adalah salah satu cabang ilmu teknik mesin yang mempelajari tentang bagaimana merancang, membuat dan mengembangkan alat-alat transportasi darat yang menggunakan mesin, terutama sepeda motor, mobil, bis dan truk.", R.drawable.otomotif, R.drawable.anime, R.drawable.olahraga));


        modelAdapter = new ModelAdapter(mahasiswaArrayList, new ModelAdapter.Callback() {
            @Override
            public void onClick(int position) {

                Intent move = new Intent(getApplicationContext(), DetailActivity.class);
                ModelView model = mahasiswaArrayList.get(position);

                move.putExtra("image", model.getFoto());
                move.putExtra("title", model.getTitle());
                move.putExtra("description", model.getDescription());
                move.putExtra("image_pin_1", model.getImage_pin_1());
                move.putExtra("image_pin_2", model.getImage_pin_2());
                move.putExtra("image_pin_3", model.getImage_pin_3());
                startActivity(move);

            }
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DashboardActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(modelAdapter);

    }
}