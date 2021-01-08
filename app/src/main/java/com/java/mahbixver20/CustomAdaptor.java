package com.java.mahbixver20;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdaptor extends RecyclerView.Adapter<CustomAdaptor.MyViewHolder> {
    Dialog myDialog;
    private Context context;
    private List<App> apps;


    public CustomAdaptor(Context context, ArrayList<App> apps) {
        this.context = context;
        this.apps = apps;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
 
        TextView mName, mSize;
        ImageView mImage;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name);
            mSize = itemView.findViewById(R.id.size);
            mImage = itemView.findViewById(R.id.image);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        myDialog = new Dialog (context);
        myDialog.setContentView(R.layout.dialog_service);

        vHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView dialog_name = (TextView) myDialog.findViewById(R.id.coffe_selected);
                TextView dialog_prize = (TextView) myDialog.findViewById(R.id.prize);
                ImageView dialog_image = (ImageView) myDialog.findViewById(R.id.coffee_image);
                dialog_prize.setText(apps.get(vHolder.getAdapterPosition()).getName());
                dialog_name.setText(apps.get(vHolder.getAdapterPosition()).getName());
                dialog_image.setImageResource(apps.get(vHolder.getAdapterPosition()).getImage());
                myDialog.show();
            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        App app = apps.get(position);
        holder.mName.setText(app.getName());
        holder.mSize.setText("₱" + app.getSize());
        holder.mImage.setImageResource(app.getImage());
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

   public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private LinearLayout coffee_items;
        private TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.name);
            coffee_items = (LinearLayout)itemView.findViewById(R.id.drawerLayout);
        }
    }

    public void filterList(ArrayList<App> filteredList) {
        this.apps = filteredList;
        notifyDataSetChanged();
    }

}
