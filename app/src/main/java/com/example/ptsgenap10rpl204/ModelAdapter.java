package com.example.ptsgenap10rpl204;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MahasiswaViewHolder> {

    private ArrayList<ModelView> dataList;
    Callback callback;
    int posku;
    View viewku;

    interface Callback{
        void onClick(int position);
    }

    public ModelAdapter(ArrayList<ModelView> dataList, Callback callback) {
        this.dataList = dataList;
        this.callback = callback;
    }

    @Override
    public MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        return new MahasiswaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MahasiswaViewHolder holder, int position) {

        holder.imgImage.setImageResource(dataList.get(position).getFoto());
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtInfo.setText(dataList.get(position).getInfo());
        holder.txtDescriptin.setText(dataList.get(position).getDescription());
        holder.imgImagePin1.setImageResource(dataList.get(position).getImage_pin_1());
        holder.imgImagePin2.setImageResource(dataList.get(position).getImage_pin_2());
        holder.imgImagePin3.setImageResource(dataList.get(position).getImage_pin_3());

    }


    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder implements OnCreateContextMenuListener{
        private TextView txtTitle;
        private TextView txtInfo;
        private TextView txtDescriptin;
        private ImageView imgImage;
        private ImageView imgImagePin1;
        private ImageView imgImagePin2;
        private ImageView imgImagePin3;
        private CardView cdCardview;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);

            viewku = itemView;
            itemView.setOnCreateContextMenuListener(this);
            
            imgImage = itemView.findViewById(R.id.image);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtInfo =  itemView.findViewById(R.id.txt_info);
            txtDescriptin = itemView.findViewById(R.id.txt_description);
            imgImagePin1 = itemView.findViewById(R.id.image_pin_1);
            imgImagePin2 = itemView.findViewById(R.id.image_pin_2);
            imgImagePin3 = itemView.findViewById(R.id.image_pin_3);
            cdCardview = itemView.findViewById(R.id.cd_cardview);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onClick(getAdapterPosition());
                }
            });
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Edit = menu.add(Menu.NONE, 1, 1, "Edit");
            MenuItem Delete = menu.add(Menu.NONE, 2, 2, "Delete");
            posku = getAdapterPosition();
            Edit.setOnMenuItemClickListener(onlickcontextmenu);
            Delete.setOnMenuItemClickListener(onlickcontextmenu);
        }
    }

    private final MenuItem.OnMenuItemClickListener onlickcontextmenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch (item.getItemId()) {
                case 1:
                    //Do stuff
                    Toast.makeText(viewku.getContext(), "Edit data di posisi "+posku, Toast.LENGTH_LONG).show();
                    break;

                case 2:
                    //Delete data, butuh konfirmasi dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(viewku.getContext());
                    builder.setMessage("Are you sure you want to delete data?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dataList.remove(posku);
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            //Set your icon here
                            .setTitle("Delete data")
                            .setIcon(R.mipmap.ic_launcher);
                    AlertDialog alert = builder.create();
                    alert.show();//showing the dialog

                    break;
            }
            return true;
        }
    };
}
