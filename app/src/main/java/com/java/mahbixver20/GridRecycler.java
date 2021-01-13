package com.java.mahbixver20;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aws on 28/01/2018.
 */

public class GridRecycler extends RecyclerView.Adapter<GridRecycler.MyViewHolder> {

    private Context mContext;
    private List<SuggestedCoffee> mData;
    TextView coffeeItem;

    public GridRecycler(Context mContext, TextView coffeeItem, ArrayList<SuggestedCoffee> mData) {
        this.coffeeItem = coffeeItem;
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_view_grid_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        SuggestedCoffee sc = mData.get(position);
        holder.tv_book_title.setText(sc.getTitle());
        holder.img_book_thumbnail.setImageResource(sc.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thumbnail;
        CardView cardView;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_book_title = (TextView) itemView.findViewById(R.id.coffee_name);
            img_book_thumbnail = (ImageView) itemView.findViewById(R.id.coffee_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);
        }
    }

    public void filterList1(ArrayList<SuggestedCoffee> filteredList1) {
        this.mData = filteredList1;
        notifyDataSetChanged();
    }
}