package com.example.myapplication1109;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class IngredientsAdapter extends ArrayAdapter<Ingredients> {
    public IngredientsAdapter(@NonNull Context context, int resource, @NonNull List<Ingredients> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Ingredients ingredients = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.ingredients_item, parent, false);
        TextView ingredientsname = view.findViewById(R.id.ingredients_name);
        TextView ingredientsamount = view.findViewById(R.id.ingredients_amount);
        ingredientsname.setText(ingredients.getName());
        ingredientsamount.setText(ingredients.getAmount());
        return view;
    }
}
