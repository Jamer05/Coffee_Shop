package com.java.mahbixver20;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BagAdapter extends RecyclerView.Adapter<BagAdapter.MyViewHolder1> {
    private Context context;
    private ArrayList<App> apps;

    public BagAdapter(Context context, ArrayList<App> apps) {
        this.context = context;
        this.apps = apps;
    }


    public static class MyViewHolder1 extends RecyclerView.ViewHolder {

        TextView mName, mSize;
        ImageView mImage;


        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name_item);
            mSize = itemView.findViewById(R.id.prize_item);
            mImage = itemView.findViewById(R.id.list_item_coffee);
        }
    }

    @NonNull
    @Override
    public BagAdapter.MyViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.example_item, parent, false);
        return new BagAdapter.MyViewHolder1(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder1 holder, int position) {
        App app = apps.get(position);
        holder.mName.setText(app.getName());
        holder.mSize.setText("₱" + app.getSize());
        holder.mImage.setImageResource(app.getImage());
    }


    @Override
    public int getItemCount() {
        return apps.size();
    }

}

