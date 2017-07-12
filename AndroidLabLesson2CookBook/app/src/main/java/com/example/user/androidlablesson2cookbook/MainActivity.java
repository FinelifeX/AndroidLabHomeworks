package com.example.user.androidlablesson2cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.OnRecipeClickListener{

    private RecyclerView recyclerView;
    private List<Recipe> recipeList;
    private RecipeAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecipes();
        layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        adapter = new RecipeAdapter(recipeList, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }
    private void initRecipes(){
        recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Ratatui", "1h", "Very delicious", "7/10"));
        recipeList.add(new Recipe("Golubci", "1h", "Very delicious", "7/10"));
        recipeList.add(new Recipe("Salatik", "1h", "Very delicious", "7/10"));
        recipeList.add(new Recipe("Pyureshka", "1h", "Very delicious", "7/10"));
        recipeList.add(new Recipe("Yayca", "1h", "Very delicious", "7/10"));
        recipeList.add(new Recipe("Bol'", "1h", "Very delicious", "7/10"));
        recipeList.add(new Recipe("Stradanie", "1h", "Very delicious", "7/10"));
    }

    @Override
    public void onRecipeClick(Recipe view) {
        String [] data = new String[] {view.getName(), view.getTime(), view.getDifficulty(), view.getDescription()};
        Intent intent = new Intent(MainActivity.this, FullRecipeActivity.class);
        intent.putExtra(FullRecipeActivity.DATA, data);
        startActivityForResult(intent, 1);
    }
}
