package com.example.lenovo.recylerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int[] images={R.drawable.ds,R.drawable.ds,R.drawable.ds,R.drawable.ds,R.drawable.ds};
    MyAdapter myAdapter;

    String[] title,des;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv);

        title=getResources().getStringArray(R.array.country_name);
        des=getResources().getStringArray(R.array.country_name1);

        myAdapter =new MyAdapter(this,title,des,images);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.setOnItemClickListener(new MyAdapter.ClickListener() {
            @Override
            public void OnItemClick(int position, View v) {

                Toast.makeText(getApplicationContext(), "Onitem"+position, Toast.LENGTH_LONG).show();

            }

            @Override
            public void OnItemLongClick(int position, View v) {
                Toast.makeText(getApplicationContext(), "OnitemLobg"+position, Toast.LENGTH_LONG).show();

            }
        });



    }
}
