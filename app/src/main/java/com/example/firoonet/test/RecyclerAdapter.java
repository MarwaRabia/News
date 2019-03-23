package com.example.firoonet.test;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<RecyclerUser> userlist ;
    private Context context;

    public RecyclerAdapter(List<RecyclerUser> userlist, Context context) {

        this.userlist = userlist;
        this.context = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return  new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        RecyclerUser sampleUser = userlist.get(position);
        holder.text.setText(sampleUser.recyclerText);
        holder.img.setImageResource(sampleUser.recyclerImage);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "item" + position + "clicked", Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public int getItemCount() {

        return userlist.size();

    }
}
