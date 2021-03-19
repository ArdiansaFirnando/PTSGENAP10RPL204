package com.example.ptsgenap10rpl204;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DasboardActivity extends AppCompatActivity {

    Bundle extra;
    String email;
    TextView profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        profil = (TextView) findViewById(R.id.profil);
        extra = getIntent().getExtras();
        if (extra != null){
            email = extra.getString("Email");
            profil.setText(email);
        }


    }
}