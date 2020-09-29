package com.example.l2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class ShowImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image);

        ImageView imageview = (ImageView)findViewById(R.id.ImageShow);
        Bundle arguments = getIntent().getExtras();
        Bitmap bit = (Bitmap)arguments.get("img");
        imageview.setImageBitmap(bit);
    }
}
