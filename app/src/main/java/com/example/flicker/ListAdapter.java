package com.example.flicker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flicker.Model.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.FrameHolder> {

    public List<Photo> photoList = new ArrayList<>();

    public ListAdapter(List<Photo> list) {
       this.photoList = list;
    }

    @NonNull
    @Override
    public FrameHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.picture_frame, viewGroup, false);
        FrameHolder holder = new FrameHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.FrameHolder frameHolder, int i) {
        Photo photo = photoList.get(i);
        frameHolder.bind(photo.getTitle(),photo.getOwner(),photo.getUrlS());
    }

    public void update(List<Photo> list){
        this.photoList = list;
    }

    @Override
    public int getItemCount() {
        return this.photoList.size();
    }

    public class FrameHolder extends RecyclerView.ViewHolder{

      public TextView titleText;
      public TextView ownerText;
      public ImageView imageView;

      public FrameHolder(View v){
          super(v);
          titleText = v.findViewById(R.id.title);
          ownerText = v.findViewById(R.id.owner);
          imageView = v.findViewById(R.id.picture);
      }

      public void bind(String title, String owner, String url){

          this.titleText.setText(title);
          this.ownerText.setText(owner);
          Picasso.get().load(url).placeholder(R.drawable.ic_sand_clock).error(R.drawable.ic_not_available_circle).into(imageView);
      }

    }

}
