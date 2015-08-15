package com.example.iyad.materialdesign01_g2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by iyad on 7/30/2015.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>{
    Context context;
    List<Employee> list;
    RecyclerViewListener listener;

    public MyRecyclerViewAdapter(Context context, List<Employee> list){
        this.context =context;
        this.list = list;
    }
    public void setOnRecyclerViewListener(RecyclerViewListener listener){
        this.listener = listener;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.recycler_view_layout, parent, false);
        final MyViewHolder vh = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null)
                    listener.itemSelected(v, vh.getAdapterPosition());
            }
        });
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(list.get(position).getName());
        holder.im.setImageResource(list.get(position).getPhotoId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView im;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView.findViewById(R.id.textView);
            im = (ImageView)itemView.findViewById(R.id.imageView);
        }
    }

    public interface RecyclerViewListener{
        public void itemSelected(View view, int position);
    }
}
