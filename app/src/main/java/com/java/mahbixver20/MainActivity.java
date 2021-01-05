/**
 * all the green comment is temporary because I have to decide something new by doing this thanks for the undestand
 */

package com.java.mahbixver20;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mList1, mList2;
    List<App> appList;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //start from this is to create the horizontal recycler viewer
        mList1 = findViewById(R.id.list1);
        // mList2 = findViewById(R.id.list2);
        appList = new ArrayList<>();

        appList.add(new App(R.drawable.youtube, "Youtube", 40));
        appList.add(new App(R.drawable.maxplayer, "Max Player", 30));
        appList.add(new App(R.drawable.messenger, "Messenger", 20));
        appList.add(new App(R.drawable.twitter, "Twitter", 22));
        appList.add(new App(R.drawable.vlc, "VLC Player", 40));
        appList.add(new App(R.drawable.whatsapp, "Whatsapp", 34));

        LinearLayoutManager manager1 = new LinearLayoutManager(this);
        manager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mList1.setLayoutManager(manager1);

/**
 * I will change this into the box image
 //LinearLayoutManager manager2 = new LinearLayoutManager(this);
 //manager2.setOrientation(LinearLayoutManager.HORIZONTAL);
 //mList2.setLayoutManager(manager2);
 */

        CustomAdaptor adaptor1 = new CustomAdaptor(this, appList);
        mList1.setAdapter(adaptor1);
/**
 //CustomAdaptor adaptor2 = new CustomAdaptor(this,appList);
 //mList2.setAdapter(adaptor2);
 */

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


        //to view with fragment
        NavigationView navigationView = findViewById(R.id.navigationMenu);
        navigationView.setItemIconTintList(null);

        NavController navController = Navigation.findNavController(this, R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    //for sliding the menu drawer
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //sample for menu with three dots
    /**
     @Override public boolean onOptionsItemSelected(@NonNull MenuItem item) {

     switch (item.getItemId()) {
     case R.id.about_menu_itm:
     Toast.makeText(this, "Developed By Jamer05", Toast.LENGTH_SHORT).show();
     return true;
     }
     return super.onOptionsItemSelected(item);
     }
     */

}
