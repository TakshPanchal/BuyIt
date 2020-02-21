package com.smartex.buyit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;


import com.google.android.material.navigation.NavigationView;
import com.smartex.buyit.MainFragment.MainFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    private androidx.appcompat.widget.Toolbar toolbar;
    private DrawerLayout drawer;
    private NavigationView navView;
    private FrameLayout frameLayout;
    private TextView tvUserName,tvEmailId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        navView.setNavigationItemSelectedListener(this);
        toggle.syncState();
     if (getIntent()!=null){
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("userInfo");
        assert bundle != null;
        try {
            tvUserName.setText(bundle.getString("userName"));
            tvEmailId.setText(bundle.getString("emailId"));
        } catch (Exception e){
            e.printStackTrace();
        }

     }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new MainFragment());
        transaction.commit();



    }

    private void initViews() {
        Log.d(TAG, "initViews: started");
        toolbar = findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        navView = (NavigationView) findViewById(R.id.navView);
        View headerView = navView.getHeaderView(0);
        tvUserName = (TextView) headerView.findViewById(R.id.tvUserName);
        tvEmailId = (TextView) headerView.findViewById(R.id.tvUserEmailId);

//        frameLayout = (FrameLayout) findViewById(R.id.fragment_container)
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onNavigationItemSelected: this item selectec"+ item.getTitle());
        switch (item.getItemId()) {
            case R.id.cart:
//                Intent intent = new Intent(MainActivity.this,CartActivity.class);
//                startActivity(intent);
                break;
            case R.id.Category:
                break;
            case R.id.aboutUs:
                break;
            case R.id.licence:
                break;

        }
        return false;
    }
}
