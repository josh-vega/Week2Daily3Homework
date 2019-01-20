package com.example.week2daily3homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<Animal> animalArrayList;

    public RecyclerViewAdapter(ArrayList<Animal> animalArrayList) {
        this.animalArrayList = animalArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder viewHolder, int position) {
        Animal animal = animalArrayList.get(position);

        if(animal != null) {
            //Drawable image = viewHolder.itemView.getContext().getDrawable(R.drawable.image);
            String name = animal.getName();
            String type = animal.getType();
            String sound = animal.getSound();
            int resourceId = animal.getImage();
            String pop = Integer.toString(animal.getPopulation());

            viewHolder.setItemAnimal(animal);
            viewHolder.tvName.setText(name);
            viewHolder.tvType.setText(type);
            viewHolder.tvSound.setText(sound);
            viewHolder.imgImage.setImageResource(resourceId);
            viewHolder.tvPop.setText(pop);
        }
    }

    @Override
    public int getItemCount() {
        return animalArrayList != null ? animalArrayList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgImage;
        TextView tvType;
        TextView tvName;
        TextView tvSound;
        TextView tvPop;
        Animal itemAnimal;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imgImage = itemView.findViewById(R.id.imgViewImage);
            tvType = itemView.findViewById(R.id.tvType);
            tvName = itemView.findViewById(R.id.tvName);
            tvSound = itemView.findViewById(R.id.tvSound);
            tvPop = itemView.findViewById(R.id.tvPopulation);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), DisplayActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("animal", itemAnimal);
                    intent.putExtras(bundle);
                    view.getContext().startActivity(intent);
                }
            });
        }

        public void setItemAnimal(Animal itemAnimal){
            this.itemAnimal = itemAnimal;
        }
    }
}
