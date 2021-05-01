package com.example.ptsgenap10rpl204;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    Bundle bundle;
    String title, description;
    int image;
    int image_pin_1;
    int image_pin_2;
    int image_pin_3;

    TextView txt_title, txt_description;
    ImageView img_image;
    ImageView image_pin_detail_1;
    ImageView image_pin_detail_2;
    ImageView image_pin_detail_3;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        toolbar = findViewById(R.id.toolbar_detail);

        bundle = getIntent().getExtras();
        if (bundle != null){

            txt_title = findViewById(R.id.txt_titleDetail);
            txt_description = findViewById(R.id.txt_descriptionDetail);
            img_image = findViewById(R.id.img_imageDetail);
            image_pin_detail_1 = findViewById(R.id.image_pin_detail_1);
            image_pin_detail_2 = findViewById(R.id.image_pin_detail_2);
            image_pin_detail_3 = findViewById(R.id.image_pin_detail_3);

            title = bundle.getString("title");
            description =  bundle.getString("description");
            image = bundle.getInt("image");
            image_pin_1 = bundle.getInt("image_pin_1");
            image_pin_2 = bundle.getInt("image_pin_2");
            image_pin_3 = bundle.getInt("image_pin_3");

        }
        txt_title.setText(title);
        txt_description.setText(description);
        img_image.setImageResource(image);
        image_pin_detail_1.setImageResource(image_pin_1);
        image_pin_detail_2.setImageResource(image_pin_2);
        image_pin_detail_3.setImageResource(image_pin_3);
    }
}