package com.example.user.androidlablesson2cookbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bulat Murtazin on 11.07.2017.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    OnRecipeClickListener listener;
    RelativeLayout relativeLayout;

    public List<Recipe> recipeList;
    public RecipeAdapter(List<Recipe> RecipeList, OnRecipeClickListener listener) {
        this.recipeList = RecipeList;
        this.listener = listener;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_layout,parent,false);
        return (new RecipeViewHolder(v));
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, final int position) {
        final Recipe recipe = recipeList.get(position);
        final String [] data;

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRecipeClick(recipeList.get(position));
            }
        });
        holder.name.setText(recipe.getName());
        holder.difficulty.setText(recipe.getDifficulty());
        holder.time.setText(recipe.getTime());
        holder.description.setText(recipe.getDescription());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        TextView difficulty;
        TextView time;
        TextView description;
        RelativeLayout relativeLayout;

        public RecipeViewHolder(View itemView) {
            super(itemView);

            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.rl);
            imageView = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
            difficulty = (TextView) itemView.findViewById(R.id.difficulty);
            time = (TextView) itemView.findViewById(R.id.time);
            description = (TextView) itemView.findViewById(R.id.description);

        }
    }

    public interface OnRecipeClickListener {
        void onRecipeClick(Recipe view);
    }
}
