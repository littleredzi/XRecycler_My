package com.example.dzh.xrecycler_my;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DZH on 2017/11/10.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {
    List<String> listdata;
    Context context;
    public MyAdapter(MainActivity mainActivity, List<String> listdata) {
        this.listdata=listdata;
        context=mainActivity;
    }

    @Override
    public MyAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyHolder myHolder = new MyHolder(inflate);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyHolder holder, int position) {
        holder.text.setText(listdata.get(position));
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView text;
        public MyHolder(View itemView) {
            super(itemView);
             text = itemView.findViewById(R.id.textView);

        }
    }
}
