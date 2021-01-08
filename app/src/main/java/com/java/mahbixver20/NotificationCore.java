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
        import android.view.MenuItem;
        import android.view.View;

        import com.google.android.material.navigation.NavigationView;

public class NotificationCore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_core);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setStatusBarColor(ContextCompat.getColor(NotificationCore.this, R.color.colorPrimary));
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
                    return false;
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
        if(singleBack) {
            super.onBackPressed();
            return;
        }
        this.singleBack = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                singleBack = false;
            }
        },2000);
    }
}