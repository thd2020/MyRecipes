package com.example.myapplication1109;

import android.view.View;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.net.Uri;
import android.content.Context;
import android.os.Environment;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;

public class Utility {
        public static Uri getOutputMediaFileUri(Context context) {
        File mediaFile = null;
        String cameraPath;
        try {
            File mediaStorageDir = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (!mediaStorageDir.exists()) {
                if (!mediaStorageDir.mkdirs()) {
                    return null;
                }
            }
            mediaFile = new File(mediaStorageDir.getPath()
                    + File.separator
                    + "Pictures/temp.jpg");//注意这里需要和filepaths.xml中配置的一样
            cameraPath = mediaFile.getAbsolutePath();

        } catch (Exception e) {
            e.printStackTrace();
        }
      
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {// sdk >= 24  android7.0以上
            Uri contentUri = FileProvider.getUriForFile(context,
                    context.getApplicationContext().getPackageName() + ".provider",//与清单文件中android:authorities的值保持一致
                    mediaFile);//FileProvider方式或者ContentProvider。也可使用VmPolicy方式
            return contentUri;

        } else {
            return Uri.fromFile(mediaFile);//或者 Uri.isPaise("file://"+file.toString()

        }
    }
    
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
//        int desiredWidth = MeasureSpec.makeMeasureSpec(listView.getWidth(), MeasureSpec.AT_MOST);
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            View listItem = listAdapter.getView(i, null, listView);
//            listItem.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
//        params.height = (totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1)))/2-1;
        params.height = totalHeight + listView.getDividerHeight() * (listAdapter.getCount() - 1);
//        params.height = totalHeight;
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}