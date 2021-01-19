package com.java.mahbixver20;

import android.content.ContentResolver;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import static android.provider.BaseColumns._ID;

public class BagAdapter extends RecyclerView.Adapter<BagAdapter.MyViewHolder1> {
    private Context context;
    private ArrayList<PopularCoffeeData> apps;

    TextView txt1 = null;
    TextView txt2 = null;

    public BagAdapter(Context context, TextView txt1, TextView txt2, ArrayList<PopularCoffeeData> apps) {
        this.context = context;
        this.apps = apps;
        this.txt1 = txt1;
        this.txt2 = txt2;

    }


    public static class MyViewHolder1 extends RecyclerView.ViewHolder {

        TextView mName, mSize;
        ImageView mImage;


        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.name_item);
            mSize = itemView.findViewById(R.id.prize_item);
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

        PopularCoffeeData app = apps.get(position);
        holder.mName.setText(app.getName());
        holder.mSize.setText(app.getSize());

    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

}

