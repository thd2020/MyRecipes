package com.example.myapplication1109;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.count);

        // 购物菜品列表
        ListView menu_listview = (ListView) findViewById(R.id.menu_list);
        List<Menu> menu_list = new ArrayList<>();
        Menu menu1 = new Menu(R.drawable.camera_menu3, "白萝卜豆腐汤");
        menu_list.add(menu1);
        Menu menu2 = new Menu(R.drawable.menu_count2, "黑椒牛肉炒芦笋");
        menu_list.add(menu2);
        MenuAdapter adapter1 = new MenuAdapter(CountActivity.this, R.layout.menu_item, menu_list);
        menu_listview.setAdapter(adapter1);
        Utility.setListViewHeightBasedOnChildren(menu_listview);

        // 购物材料列表
        ListView ing_listview = (ListView) findViewById(R.id.total_list);
        List<Ingredients> ing_list = new ArrayList<>();
        Ingredients Mooli = new Ingredients("白萝卜", "1根");
        ing_list.add(Mooli);
        Ingredients Doufu = new Ingredients("豆腐", "1块");
        ing_list.add(Doufu);
        Ingredients Chives = new Ingredients("香葱", "若干");
        ing_list.add(Chives);
        Ingredients DriedShrimp = new Ingredients("虾皮", "若干");
        ing_list.add(DriedShrimp);
        Ingredients item5 = new Ingredients("牛肉", "200克");
        ing_list.add(item5);
        Ingredients item6 = new Ingredients("芦笋", "250克");
        ing_list.add(item6);
        IngredientsAdapter adapter2 = new IngredientsAdapter(CountActivity.this, R.layout.ingredients_item, ing_list);
        ing_listview.setAdapter(adapter2);
        Utility.setListViewHeightBasedOnChildren(ing_listview);
    }
}