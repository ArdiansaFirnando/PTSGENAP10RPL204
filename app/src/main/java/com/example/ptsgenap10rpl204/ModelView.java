package com.example.ptsgenap10rpl204;

import android.graphics.drawable.Drawable;

public class ModelView {
    private String title;
    private String info;
    private String description;
    private int foto;
    private int image_pin_1;
    private int image_pin_2;
    private int image_pin_3;

    public ModelView(int foto, String title, String info, String description, int image_pin_1, int image_pin_2, int image_pin_3) {
        this.foto = foto;
        this.title = title;
        this.description = description;
        this.info = info;
        this.image_pin_1 = image_pin_1;
        this.image_pin_2 = image_pin_2;
        this.image_pin_3 = image_pin_3;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage_pin_1() {
        return image_pin_1;
    }

    public void setImage_pin_1(int image_pin_1) {
        this.image_pin_1 = image_pin_1;
    }

    public int getImage_pin_2() {
        return image_pin_2;
    }

    public void setImage_pin_2(int image_pin_2) {
        this.image_pin_2 = image_pin_2;
    }

    public int getImage_pin_3() {
        return image_pin_3;
    }

    public void setImage_pin_3(int image_pin_3) {
        this.image_pin_3 = image_pin_3;
    }
}