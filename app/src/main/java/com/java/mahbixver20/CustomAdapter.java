package com.java.mahbixver20;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.BindException;
import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Dialog myDialog;
    private Context context;
    private ArrayList<App> appList1;
    private List<App> apps;
    TextView numOfReserve = null;
    BagAdapter adapter;


    public CustomAdapter(Context context, ArrayList<App> apps) {
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
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_custom_function_dialog);

        vHolder.itemView.setOnClickListener(new View.OnClickListener() {
            /**
             * This part sir below in  this area this code cause some error of "NullPointerException attemp to invoke virtual method"
             * @param v
             */

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {//starts the bug here
                numOfReserve = (TextView) myDialog.findViewById(R.id.num_of_items_in_cart);
                @SuppressLint("CutPasteId") Button qtyOrder = myDialog.findViewById(R.id.reserve);
                qtyOrder.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(View v) {
                        try {
                            String bagItems = numOfReserve.getText().toString();
                            int startCount = Integer.parseInt((bagItems));
                            startCount++;
                            numOfReserve.setText("" + startCount);
                        } catch (NullPointerException e) {
                            Toast.makeText(context, "Added to Bag " + e.toString(), Toast.LENGTH_SHORT).show();
                            myDialog.dismiss();
                        }
                    }
                });

                v.setBackgroundResource(android.R.color.transparent);
                TextView dialog_name = (TextView) myDialog.findViewById(R.id.coffe_selected);
                TextView dialog_prize = (TextView) myDialog.findViewById(R.id.prize);
                ImageView exit = (ImageView) myDialog.findViewById(R.id.exit);
                ImageView dialog_image = (ImageView) myDialog.findViewById(R.id.coffee_image);
                dialog_prize.setText("₱" + apps.get(vHolder.getAdapterPosition()).getSize());
                dialog_name.setText(apps.get(vHolder.getAdapterPosition()).getName());
                dialog_image.setImageResource(apps.get(vHolder.getAdapterPosition()).getImage());
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button btn = myDialog.findViewById(R.id.proceed);
                Button btnInsert = (Button) myDialog.findViewById(R.id.reserve);

                exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), BillingOrders.class);
                        context.startActivity(intent);
                    }
                });


                myDialog.show();
            }

        });
        return vHolder;
    }

    public void insertItem(int position) {
        appList1.add(position, new App(R.drawable.youtube, "Youtube" + position, (int) 40.00));
        adapter.notifyItemInserted(position);
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
            coffee_items = (LinearLayout) itemView.findViewById(R.id.drawerLayout);
        }
    }

    public void filterList(ArrayList<App> filteredList) {
        this.apps = filteredList;
        notifyDataSetChanged();
    }

}
