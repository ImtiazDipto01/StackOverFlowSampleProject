package com.example.dipto.stackoverflowsampleproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sakib on 1/1/2018.
 */

public class SampleRecylerAdapter extends RecyclerView.Adapter<SampleRecylerAdapter.SampleRecylerViewHolder> {

    private final LayoutInflater inflater;
    private Context context ;
    private  List<String> name = Collections.emptyList() ;


    public SampleRecylerAdapter(Context context, List<String> name){
        this.context = context ;
        this.name = name ;
        inflater = LayoutInflater.from(context) ;
    }

    @Override
    public SampleRecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_names, parent, false) ;
        SampleRecylerViewHolder sampleRecylerViewHolder = new SampleRecylerViewHolder(view);
        return sampleRecylerViewHolder;
    }

    @Override
    public void onBindViewHolder(SampleRecylerViewHolder holder, int position) {
        holder.textView.setText(name.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class SampleRecylerViewHolder extends RecyclerView.ViewHolder{

        TextView textView ;
        public SampleRecylerViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.mynames) ;
        }
    }

    public void setFilter(List<String> mynames){
        name = new ArrayList<>() ;
        name.addAll(mynames) ;
        notifyDataSetChanged();
    }
}
