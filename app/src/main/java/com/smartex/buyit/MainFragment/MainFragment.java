package com.smartex.buyit.MainFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smartex.buyit.R;

public class MainFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener

{
    private static final String TAG = "MainFragment";
    private BottomNavigationView bottomNavigationView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: called");
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        initView(view);

        initBottomNavView();
        return view;
    }

    private void initBottomNavView() {
        bottomNavigationView.setSelectedItemId(R.id.bHome);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initView(View view) {
        Log.d(TAG, "initView: called");
        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.bottomNavVIew);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onNavigationItemSelected: this item is selected " + item.getTitle() );
        switch (item.getItemId()){
            case R.id.bHome :
                //TODo write code to go to another fragment
                break;
            case R.id.search:
                break;
            case R.id.aboutUs :
                break;

        }
        return true;
    }
}
