package com.smartex.buyit;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.smartex.buyit.models.GrossaryItems;

import java.util.ArrayList;

public class GroceryItemAdapter extends RecyclerView.Adapter<GroceryItemAdapter.viewholder> {
    private static final String TAG = "GroceryItemAdapter";

    private Context context;
    private ArrayList<GrossaryItems> list;

    public GroceryItemAdapter(Context context, ArrayList<GrossaryItems> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewholder(LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_cardview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + list.get(position).toString());
        holder.itemName.setText(list.get(position).getName());
        holder.ItemDes.setText(list.get(position).getDes());
        holder.itemPrice.setText(Double.toString(list.get(position).getPrise()));
        holder.itemStock.setText(Integer.toString(list.get(position).getAvailableAmount()));
        holder.itemReview.setText("Review");
        Glide
                .with(context)
                .asBitmap()
                .load(list.get(position).getImgURL())
                .centerCrop()
                .into(holder.itemImage);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        private TextView itemName, ItemDes, itemPrice, itemStock, itemReview;
        private ImageView itemImage;
        private CardView parent;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            itemName = (TextView) itemView.findViewById(R.id.itemName);
            ItemDes = (TextView) itemView.findViewById(R.id.itemDes);
            itemPrice = (TextView) itemView.findViewById(R.id.itemPrice);
            itemStock = (TextView) itemView.findViewById(R.id.itemStock);
            itemReview = (TextView) itemView.findViewById(R.id.itemReview);
            itemImage = (ImageView) itemView.findViewById(R.id.itemImage);
            parent = (CardView) itemView.findViewById(R.id.grocery_cardview);
        }
    }
}
