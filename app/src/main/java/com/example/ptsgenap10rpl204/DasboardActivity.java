package com.example.ptsgenap10rpl204;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import java.util.ArrayList;

public class DasboardActivity extends AppCompatActivity {
 
    Bundle extra;
    String email;
    TextView profil;

    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> mahasiswaArrayList;
    // we user ArrayList to populate data in RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        profil = findViewById(R.id.profil);
        extra = getIntent().getExtras();
        if (extra != null){
            email = extra.getString("Email");
            profil.setText(email);
        }


        recyclerView = (RecyclerView) findViewById(R.id.rvdata);

        addData();

        adapter = new MahasiswaAdapter(mahasiswaArrayList);
        //selesai ngatur data dari adapter, kemudian di tempel ke Recyclerview nya
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DasboardActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    void addData(){
        mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Mahasiswa("Dimas", "111", "081222","dimas@gmail.com"));
        mahasiswaArrayList.add(new Mahasiswa("Budi", "000", "081222", "budi@gmail.com"));
        mahasiswaArrayList.add(new Mahasiswa("Ani", "222", "083333", "ani@gmail.com"));
        mahasiswaArrayList.add(new Mahasiswa("Lintang", "555", "08312889", "lintang@gmail.com"));
    }
}