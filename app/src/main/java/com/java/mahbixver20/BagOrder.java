package com.java.mahbixver20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class BagOrder extends AppCompatActivity {
    private RecyclerView mList1;
    private ArrayList<PopularCoffeeData> appList1 = new ArrayList<>();
    private BagAdapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button btnInsert;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bag_order);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        TextView itmName = (TextView) findViewById(R.id.name_item);
        TextView prize = (TextView) findViewById(R.id.prize_item);
        ImageView image = (ImageView)findViewById(R.id.list_item_coffee);
        mList1 = findViewById(R.id.list_order);

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.VERTICAL);
        mList1.setLayoutManager(manager1);

        adapter = new BagAdapter(this, itmName,prize,appList1);
        mList1.setAdapter(adapter);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(BagOrder.this, R.color.colorPrimary));

        //TODO: STARTS HERE
        /**
         * The cursor below is the targeting error
         */


        Cursor cursor = new DBManager(this).readAllData();
        while (cursor.moveToNext()) {

            //This is the error sir
            //TODO:         Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'boolean java.util.ArrayList.add(java.lang.Object)' on a null object reference
            PopularCoffeeData obj = new PopularCoffeeData(cursor.getString(1), cursor.getString(2));
            appList1.add(obj);
        }
        //****************************************************************************************************************************************

        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout2);

        findViewById(R.id.imageMenu2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        NavigationView navigationView;
        navigationView = (NavigationView) findViewById(R.id.navigationMenu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (item.isChecked()) {
                    drawerLayout.closeDrawer(GravityCompat.START);
                    return false;
                }
                if (id == R.id.menuNotification) {
                    startActivity(new Intent(getApplicationContext(), NotificationCore.class));
                } else if (id == R.id.menuOrder) {
                    startActivity(new Intent(getApplicationContext(), OrderCore.class));
                } else if (id == R.id.menuInbox) {
                    startActivity(new Intent(getApplicationContext(), InboxCore.class));
                } else if (id == R.id.menuInfo) {
                    startActivity(new Intent(getApplicationContext(), InformationCore.class));
                } else if (id == R.id.menuHome) {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}