package com.example.firoonet.test;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView text;
    public ImageView img;
    public LinearLayout linearLayout;


    public ViewHolder(View itemView) {

        super(itemView);

        text = (TextView) itemView.findViewById(R.id.recycler_text_id);
        img = (ImageView) itemView.findViewById(R.id.recycler_img_id);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.recycler_item_id);

    }
}
