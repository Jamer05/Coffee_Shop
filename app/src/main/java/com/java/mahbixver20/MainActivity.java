/**
 * all the green comment is temporary because I have to decide something new by doing this thanks for the undestand
 */

package com.java.mahbixver20;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hemerson G. Ramiro Jr.
 * Email: jamerkelly09877@gmail.com
 * @version 2.0.1
 * @since 03/01/2021
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView mList1;
    private ArrayList<PopularCoffee> appList;
    private CustomAdapter adapter;
    private RecyclerView grid;
    private GridRecycler gridAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<SuggestedCoffee> gridCoffee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridCoffee = new ArrayList<>();
        grid = findViewById(R.id.grid_recycler_view);
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("WhatsApp", "BlackCoffee", 40, R.drawable.whatsapp));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));
        gridCoffee.add(new SuggestedCoffee("Messenger", "BlackCoffee", 40, R.drawable.messenger));

        TextView coffeeItem = (TextView) findViewById(R.id.coffee_name);
        gridAdapter = new GridRecycler(this, coffeeItem, gridCoffee);
        grid.setLayoutManager(new GridLayoutManager(this, 3));
        grid.setAdapter(gridAdapter);

        ImageView imgview = (ImageView) findViewById(R.id.back_pack);
        imgview.bringToFront();
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, BagOrder.class);
                startActivity(myIntent);
            }
        });

        //Starting count For bag
        TextView numOfReserve = (TextView) findViewById(R.id.num_of_items_in_cart);
        ImageView imageView = (ImageView)findViewById(R.id.list_item_coffee);
        appList = new ArrayList<>();

        //start from this is to create the horizontal recycler viewer
        mList1 = findViewById(R.id.list1);
        appList.add(new PopularCoffee(R.drawable.youtube, "Youtube", "40"));
        appList.add(new PopularCoffee(R.drawable.maxplayer, "Max Player", "40"));
        appList.add(new PopularCoffee(R.drawable.messenger, "Messenger", "23"));
        appList.add(new PopularCoffee(R.drawable.twitter, "Twitter", "400"));
        appList.add(new PopularCoffee(R.drawable.vlc, "VLC Player", "3200"));
        appList.add(new PopularCoffee(R.drawable.whatsapp, "Whatsapp", "2131"));

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);
        adapter = new CustomAdapter(this,imageView, numOfReserve, appList);

        mList1.setAdapter(adapter);

        //hiding actionbar panel
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        //to make the status bar looks nice
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
        //To click the menu icon


        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        //Bottom navigation actions
        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setSelectedItemId(R.id.home_main);
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.order_list:
                        startActivity(new Intent(getApplicationContext()
                                , OrderListView.class));
                        overridePendingTransition(3, 3);
                        return true;
                    case R.id.home_main:
                        return true;
                }
                return false;
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
                    return false;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        EditText theFilter = findViewById(R.id.editTextTextPersonName);
        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter1(s.toString());
                filter(s.toString());
            }
        });
    }

    private void filter(String text) {
        ArrayList<PopularCoffee> filteredList = new ArrayList<>();
        for (PopularCoffee item : appList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }

    private void filter1(String text) {
        ArrayList<SuggestedCoffee> filteredList1 = new ArrayList<>();
        for (SuggestedCoffee item : gridCoffee) {
            if (item.getTitle().toLowerCase().contains(text.toLowerCase())) {
                filteredList1.add(item);
            }
        }
        gridAdapter.filterList1(filteredList1);
    }

    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                        quit();
                        System.exit(0);
                    }
                }).create().show();
    }


    public void quit() {
        Intent start = new Intent(Intent.ACTION_MAIN);
        start.addCategory(Intent.CATEGORY_HOME);
        start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(start);
    }
}

