package com.smartex.buyit.MainFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.smartex.buyit.GroceryItemAdapter;
import com.smartex.buyit.R;
import com.smartex.buyit.Utils;
import com.smartex.buyit.models.GrossaryItems;

public class MainFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainFragment";
    private BottomNavigationView bottomNavigationView;
    private RecyclerView recViewNewItem, recViewPopularItem, recViewSuggested;
    private Utils utils;
    private GroceryItemAdapter recViewNewItemAdp, recViewPopularItemAdp, recViewSuggestedAdp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: called");
        utils = new Utils();
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        initView(view);
        utils.initDatabase(getActivity());
        initBottomNavView();
        attachAdp(getContext());
        return view;
    }

    private void attachAdp(Context context) {
        Log.d(TAG, "attachAdp: called");
        recViewNewItemAdp = new GroceryItemAdapter(context, utils.getList(context));
        recViewNewItem.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        recViewNewItem.setAdapter(recViewNewItemAdp);
    }

    private void initBottomNavView() {
        Log.d(TAG, "initBottomNavView: called");
        bottomNavigationView.setSelectedItemId(R.id.bHome);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void initView(View view) {
        Log.d(TAG, "initView: called");
        bottomNavigationView = (BottomNavigationView) view.findViewById(R.id.bottomNavVIew);
        recViewNewItem = (RecyclerView) view.findViewById(R.id.recViewNewItem);
        recViewSuggested = (RecyclerView) view.findViewById(R.id.recViewSuggested);
        recViewPopularItem = (RecyclerView) view.findViewById(R.id.recViewPopularItem);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "onNavigationItemSelected: this item is selected " + item.getTitle());
        switch (item.getItemId()) {
            case R.id.bHome:
                //TODo write code to go to another fragment
                break;
            case R.id.search:
                break;
            case R.id.aboutUs:
                break;

        }
        return true;
    }
}
