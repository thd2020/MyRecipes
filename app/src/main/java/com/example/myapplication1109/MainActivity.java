package com.example.myapplication1109;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    String[] vegetables = new String[]{"豆角", "苦瓜", "葫芦", "番茄", "青茄", "西兰花", "卷心菜", "甜椒", "胡萝卜", "花菜", "黄瓜", "木瓜", "土豆", "南瓜", "白萝卜"};
    String[] diseases = new String[]{"糖尿病", "高血压", "哮喘"};
    String[] prefers = new String[]{"完全随机推荐", "50%推荐我可能感兴趣的菜谱，50%随机推荐", "尽可能推荐我感兴趣的菜谱"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView portrait_imageView = findViewById(R.id.portrait);
        portrait_imageView.setImageResource(R.drawable.portrait);

        ImageView menu_imageView = findViewById(R.id.menu_show);
        menu_imageView.setImageResource(R.drawable.menu_show);

        Button like_btn = (Button) findViewById(R.id.like);
        like_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMultiChoiceItems(vegetables, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    }
                }).create();
                dialog.setPositiveButton("确定", null);
                dialog.show();
            }
        });
        Button avoid_btn = findViewById(R.id.avoid);
        avoid_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMultiChoiceItems(vegetables, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    }
                }).create();
                dialog.setPositiveButton("确定", null);
                dialog.show();
            }
        });
        Button disease_btn = findViewById(R.id.disease);
        disease_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMultiChoiceItems(diseases, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    }
                }).create();
                dialog.setPositiveButton("确定", null);
                dialog.show();
            }
        });
        Button prefer_btn = findViewById(R.id.recommend_prefer);
        prefer_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setMultiChoiceItems(prefers, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    }
                }).create();
                dialog.setPositiveButton("确定", null);
                dialog.show();
            }
        });

        ImageButton photoimageView = findViewById(R.id.photo_img);
        photoimageView.setImageResource(R.drawable.photo);
        photoimageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });
    }
}