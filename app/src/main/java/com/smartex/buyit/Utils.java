package com.smartex.buyit;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.smartex.buyit.models.GrossaryItems;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {
    public static int ID = 0;
    public static final String DATABASE_NAME = "fake_database";

    public Utils() {

    }

    public static int getId() {
        return ID++;
    }

    public ArrayList<GrossaryItems> getList(Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(DATABASE_NAME, context.MODE_PRIVATE);
        Gson gson = new Gson();
        return gson.fromJson(sharedPreferences.getString("allItems", null), new TypeToken<ArrayList<GrossaryItems>>() {
        }.getType());
    }

    public void initDatabase(Context context) {
        SharedPreferences db = context.getSharedPreferences(DATABASE_NAME, context.MODE_PRIVATE);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<GrossaryItems>>() {
        }.getType();
        ArrayList<GrossaryItems> arrayList = gson.fromJson(db.getString("allItems", ""), type);
        if (arrayList == null) {
            addItems(context);
        }

//        SharedPreferences db = context.getSharedPreferences(DATABASE_NAME, context.MODE_PRIVATE);

    }

    private void addItems(Context context) {
        ArrayList<GrossaryItems> allItems = new ArrayList<>();
        allItems.add(new GrossaryItems("cheese", "Best cheese possible",
                "https://amp.businessinsider.com/images/5b8592ba89c8a1d6218b4a36-750-563.jpg", "food", 3, 4.45));
        allItems.add(new GrossaryItems("Cucumber", "it is fresh",
                "https://cdn1.medicalnewstoday.com/content/images/articles/283/283006/cucumber-slices.jpg", "vegetables", 10, 0.8));
        allItems.add(new GrossaryItems("Coca cola", "it is a tasty drink",
                "https://www.myamericanmarket.com/873-large_default/coca-cola-classic.jpg", "drinks", 100, 1));
        allItems.add(new GrossaryItems("Spaghetti", "it is an easy to cook meal",
                "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/barilla-rotini-pasta-1527694739.jpg", "food", 16, 2.5));
        allItems.add(new GrossaryItems("Chicken nugget", "usually enough for 4 person",
                "https://www.seriouseats.com/images/2014/01/20140122-taste-test-nuggets-banquet.jpg", "food", 15, 10.8));
        allItems.add(new GrossaryItems("Clear Shampoo", "you won't experience hair fall with this",
                "https://100comments.com/wp-content/uploads/2018/02/Untitled-10-3.jpg", "hygiene", 42, 12.3));
        allItems.add(new GrossaryItems("Axe body spray", "is hot and sweaty? not any more",
                "https://pics.drugstore.com/prodimg/519930/900.jpg", "hygiene", 9, 8.5));
        allItems.add(new GrossaryItems("Kleenex", "soft and famous!",
                "https://images-na.ssl-images-amazon.com/images/I/91ZyGoGBMAL._SY355_.jpg", "hygiene", 12, 3.2));

        Gson gson = new Gson();
        String allItem = gson.toJson(allItems);
        SharedPreferences db = context.getSharedPreferences(DATABASE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = db.edit();
        editor.putString("allItems", allItem).commit();
    }
}

//    SharedPreferences db = getActivity().getSharedPreferences("fake_database",getActivity().MODE_PRIVATE);
//    String string = db.getString("butter","");
//    Gson gson = new Gson();
//    GrossaryItems items = gson.fromJson(string, GrossaryItems.class);
//        Toast.makeText(getActivity(), "item name is "+items.getPrise(), Toast.LENGTH_SHORT).show();
//                return view;