package com.example.lenovo.recylerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyView> {

    static  ClickListener clickListener;

    Context context;
    String[] title,des;
    int[] images;

    public MyAdapter(Context context, String[] title, String[] des, int[] images) {
        this.context = context;
        this.title = title;
        this.des = des;
        this.images = images;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater=LayoutInflater.from(context);
         View view=inflater.inflate(R.layout.sample,viewGroup,false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView myView, int i) {

        myView.textView.setText(title[i]);
        myView.textView1.setText(des[i]);
        myView.imageView.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class MyView extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener{

        TextView textView,textView1;
        ImageView imageView;

        public MyView(@NonNull View itemView) {
            super(itemView);

            textView=itemView.findViewById(R.id.tx1);
            textView1=itemView.findViewById(R.id.tx2);
            imageView=itemView.findViewById(R.id.iv);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View view) {
            clickListener.OnItemClick(getAdapterPosition(),view);

        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.OnItemLongClick(getAdapterPosition(),view);
            return false;
        }


    }

    public interface  ClickListener {

        void OnItemClick(int position,View v);
        void  OnItemLongClick(int position,View v);

    }

    public  void  setOnItemClickListener(ClickListener clickListener)
    {
        MyAdapter.clickListener=clickListener;
    }



}
