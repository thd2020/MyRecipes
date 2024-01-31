package com.example.myapplication1109;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<Menu> {
    public MenuAdapter(@NonNull Context context, int resource, @NonNull List<Menu> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        Menu menu = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.menu_item, parent, false);
        ImageView menu_img = view.findViewById(R.id.count_menu_img);
        TextView menu_txt = view.findViewById(R.id.count_menu_name);
        menu_img.setImageResource(menu.getPic_id());
        menu_txt.setText(menu.getMenu_name());
        return view;
    }
}
