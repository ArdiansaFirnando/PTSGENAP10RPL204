package com.example.ptsgenap10rpl204;

import android.graphics.drawable.Drawable;

public class ModelView {
    private String title;
    private String info;
    private Drawable foto;

    public ModelView(Drawable foto, String title, String info) {
        this.foto = foto;
        this.title = title;
        this.info = info;
    }

    public Drawable getFoto() {
        return foto;
    }

    public void setFoto(Drawable foto) {
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

}