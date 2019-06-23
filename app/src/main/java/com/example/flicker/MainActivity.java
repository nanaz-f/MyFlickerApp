package com.example.flicker;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.flicker.Model.Photo;
import com.example.flicker.Presenter.Presenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements BaseView  {

    public ListAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;
    public RecyclerView recyclerView;
    public Presenter presenter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = findViewById(R.id.refresh);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new Presenter(this, this);
        presenter.downloadImage();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                presenter.downloadImage();
            }
        });
    }

    @Override
    public void updateUI(List<Photo> list) {
        if(adapter == null){
            adapter = new ListAdapter(list);
            recyclerView.setAdapter(adapter);
        }else{
            adapter.update(list);
        }
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }
}
