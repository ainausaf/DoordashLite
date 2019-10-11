package com.example.doordashlite.restaurantsList;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.doordashlite.R;
import com.example.doordashlite.model.Example;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class restaurantListAdapter extends RecyclerView.Adapter<restaurantListAdapter .ViewHolder> {

    private Context context;
    private List<Example> restaurantList;


    public restaurantListAdapter (Context context, List<Example> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cardview_feed)
        ConstraintLayout cardViewFeed;
        @BindView(R.id.iv_restaurant_image)
        ImageView restaurantImage;
        @BindView(R.id.restaurant_name)
        TextView restaurantName;
        @BindView(R.id.restaurant_cuisine)
        TextView restaurantCuisine;
        @BindView(R.id.restaurant_status)
        TextView restaurantStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @Override
    public restaurantListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_feed, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(restaurantListAdapter.ViewHolder viewHolder, int position) {

        Example restaurant = restaurantList.get(position);

        String restaurantImageUrl = restaurant.getCoverImgUrl();
        Glide.with(context).load(restaurantImageUrl).placeholder(
                R.drawable.layout_placeholder).error(
                R.drawable.layout_placeholder).into(viewHolder.restaurantImage);

        viewHolder.restaurantName.setText(restaurant.getBusiness().getName());
        viewHolder.restaurantCuisine.setText(restaurant.getDescription());

        if(restaurant.getStatusType().equalsIgnoreCase("open"))
        {
            viewHolder.restaurantStatus.setText(restaurant.getStatus());
        }else{
            viewHolder.restaurantStatus.setText(restaurant.getStatusType());
        }

    }

    @Override
    public int getItemCount() {
        if(restaurantList!=null) {
            return restaurantList.size();
        }
        return 0;
    }

    public void addAll(List<Example> restaurantList) {
        this.restaurantList.addAll(restaurantList);
        notifyDataSetChanged();

    }

}
