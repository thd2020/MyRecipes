package com.example.myapplication1109;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_info);

        // 菜谱名称
        TextView menu_name = (TextView) findViewById(R.id.menu_name);
        menu_name.setText("白萝卜豆腐汤");

        // 菜谱图片
        ImageView menu_img = (ImageView) findViewById(R.id.menu_pic);
        menu_img.setImageResource(R.drawable.camera_menu3);

        // 食材列表 IngredientsListView
        ListView listview = (ListView) findViewById(R.id.ingredients_detail);
        List<Ingredients> ingredientsList = new ArrayList<>();
        Ingredients Mooli = new Ingredients("白萝卜", "半根");
        ingredientsList.add(Mooli);
        Ingredients Doufu = new Ingredients("豆腐", "一块");
        ingredientsList.add(Doufu);
        Ingredients Chives = new Ingredients("香葱", "若干");
        ingredientsList.add(Chives);
        Ingredients DriedShrimp = new Ingredients("虾皮", "若干");
        ingredientsList.add(DriedShrimp);
        IngredientsAdapter adapter = new IngredientsAdapter(MenuActivity.this, R.layout.ingredients_item, ingredientsList);
        listview.setAdapter(adapter);
        Utility.setListViewHeightBasedOnChildren(listview);

        // 步骤文本 step_detail EditText
        String s = "1.把白萝卜去皮切成片、嫩豆腐切成块。\n" +
                "2.锅中倒入适量的水，然后白萝卜放入锅中，煮至萝卜变软，可以用筷子轻松刺穿。\n" +
                "3.把豆腐放入锅中煮开。\n" +
                "4.往锅中放入1勺盐、少许鸡精、少许白胡椒粉调味，然后将香葱碎、虾皮放入锅中，再次煮开即可关火\n" +
                "5.出锅前再淋一点点香油。";
        EditText step = (EditText) findViewById(R.id.step_detail);
        step.setText(s);

        // 推荐搭配
        ImageView img1 = (ImageView) findViewById(R.id.recmd_menu1);
        img1.setImageResource(R.drawable.rec1);
        img1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MenuActivity.this, CountActivity.class);
                startActivity(intent);
            }
        });
        ImageView img2 = (ImageView) findViewById(R.id.recmd_menu2);
        img2.setImageResource(R.drawable.rec2);
        ImageView img3 = (ImageView) findViewById(R.id.recmd_menu3);
        img3.setImageResource(R.drawable.rec3);
        ImageView img4 = (ImageView) findViewById(R.id.recmd_menu4);
        img4.setImageResource(R.drawable.rec4);
    }
}