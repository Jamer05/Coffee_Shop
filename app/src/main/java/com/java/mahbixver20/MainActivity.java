/**
 * all the green comment is temporary because I have to decide something new by doing this thanks for the undestand
 */

package com.java.mahbixver20;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

/**
 * @author Hemerson G. Ramiro Jr.
 * Email: jamerkelly09877@gmail.com
 * @version 2.0.1
 * @since 03/01/2021
 *
 */
public class MainActivity extends AppCompatActivity{
    private RecyclerView mList1;
    private ArrayList<App> appList;
    private CustomAdaptor adapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imgview = (ImageView) findViewById(R.id.back_pack);
        imgview.bringToFront();
        imgview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, BagOrder.class);
                startActivity(myIntent);
            }
        });
        appList = new ArrayList<>();

        //start from this is to create the horizontal recycler viewer
        mList1 = findViewById(R.id.list1);
        appList.add(new App(R.drawable.youtube, "Youtube", (float) 40.00));
        appList.add(new App(R.drawable.maxplayer, "Max Player", (float) 50.00));
        appList.add(new App(R.drawable.messenger, "Messenger", (float) 60.00));
        appList.add(new App(R.drawable.twitter, "Twitter", (float) 70.00));
        appList.add(new App(R.drawable.vlc, "VLC Player", (float) 80.00));
        appList.add(new App(R.drawable.whatsapp, "Whatsapp", (float) 90.00));

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);
        adapter = new CustomAdaptor(this, appList);
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

        /*
         //to view with fragment
         NavigationView navigationView = findViewById(R.id.navigationMenu);
         navigationView.setItemIconTintList(null);

         NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
         NavigationUI.setupWithNavController(navigationView, navController);
         */

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
                filter(s.toString());
            }
        });
    }

    private void filter(String text) {
        ArrayList<App> filteredList = new ArrayList<>();
        for (App item : appList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        adapter.filterList(filteredList);
    }
}
