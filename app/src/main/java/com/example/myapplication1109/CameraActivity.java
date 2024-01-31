package com.example.myapplication1109;

import com.example.myapplication1109.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.os.Build;
import android.net.Uri;
import android.provider.MediaStore;
import android.database.Cursor; 
import android.graphics.Bitmap; 
import android.graphics.BitmapFactory;
import android.util.Log;


import java.io.*;

public class CameraActivity extends AppCompatActivity {
    
    int TAKE_PHOTO = 1;
    String photoPath = "/sdcard/Download/1.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);

        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");  //调用手机拍照功能其实就是启动一个activity
        Button photo_button = (Button)findViewById(R.id.button);
        photo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转界面到系统自带的拍照界面
                //Uri photouri = Utility.getOutPutMediaFileUri(context)
                File photo = new File(photoPath);
                Uri photoUri;
                if (Build.VERSION.SDK_INT >= 24) {
                    //图片的url
                    photoUri = FileProvider.getUriForFile(CameraActivity.this, "com.example.takephoto.fileprovider", photo);
                } else {
                    photoUri = Uri.fromFile(photo);
                }
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);  //指定图片存放位置，指定后，在onActivityResult里得到的Data将为null
                startActivityForResult(intent, TAKE_PHOTO);  //开启相机
                }
            }
        );

        ImageView camera_imageView = (ImageView) findViewById(R.id.camera_pic);
        //camera_imageView.setImageResource(R.drawable.result);
        camera_imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                camera_imageView.setImageResource(R.drawable.result);
                LinearLayout ll = findViewById(R.id.recmd_menu);
                ll.setVisibility(View.VISIBLE);
            }
        });

        ImageView menu1 = findViewById(R.id.recmd_menu1);
        menu1.setImageResource(R.drawable.camera_menu1);
        menu1.setScaleType(ImageView.ScaleType.FIT_CENTER);
        menu1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CameraActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        ImageView menu2 = findViewById(R.id.recmd_menu2);
        menu2.setImageResource(R.drawable.camera_menu2);
        menu2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CameraActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        ImageView menu3 = findViewById(R.id.recmd_menu3);
        menu3.setImageResource(R.drawable.camera_menu3);
        menu3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CameraActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        ImageView menu4 = findViewById(R.id.recmd_menu4);
        menu4.setImageResource(R.drawable.camera_menu4);

        Button button = (Button) findViewById(R.id.jump);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CameraActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if (requestCode==TAKE_PHOTO){
            ImageView camera_imageView = (ImageView) findViewById(R.id.camera_pic);
            Bitmap bitmap = BitmapFactory.decodeFile(photoPath);
            camera_imageView.setImageBitmap(bitmap);
        }
    }
}