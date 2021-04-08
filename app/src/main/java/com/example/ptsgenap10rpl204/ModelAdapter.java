package com.example.ptsgenap10rpl204;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MahasiswaViewHolder> {

    private ArrayList<ModelView> dataList;

    public ModelAdapter(Context applicationContext, ArrayList<ModelView> dataList) {
        this.dataList = dataList;
    }

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);

        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MahasiswaViewHolder holder, int position) {
        // 0 : Ani , 1 : Budi
        holder.imgImage.setImageDrawable(dataList.get(position).getFoto());
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtInfo.setText(dataList.get(position).getInfo());
    }

    // data nya berapa = 2, index 0 dan 1
    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtTitle;
        private TextView txtInfo;
        private ImageView imgImage;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            imgImage = (ImageView) itemView.findViewById(R.id.image);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title);
            txtInfo = (TextView) itemView.findViewById(R.id.txt_info);
        }
    }
}
