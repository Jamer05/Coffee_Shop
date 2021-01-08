package com.java.mahbixver20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class OrderListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list_view);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //to make the status bar looks nice
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(OrderListView.this, R.color.colorPrimary));
        //To click the menu icon
        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setSelectedItemId(R.id.order_list);
        bottomnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.order_list:
                        return true;
                    case R.id.home_main:
                        startActivity(new Intent(getApplicationContext()
                                , MainActivity.class));
                        overridePendingTransition(3, 3);
                        return true;
                }
                return false;
            }
        });
        final DrawerLayout drawerLayout = findViewById(R.id.drawerLayout1);

        findViewById(R.id.imageMenu1).setOnClickListener(new View.OnClickListener() {
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

    boolean singleBack = false;

    @Override
    public void onBackPressed() {
        if (singleBack) {
            super.onBackPressed();
            return;
        }
        this.singleBack = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                singleBack = false;
            }
        }, 2000);
    }

}