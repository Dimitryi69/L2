package com.example.l2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.l2.EducationManager.IAction;
import com.example.l2.EducationManager.Manager;
import com.example.l2.Exception.EduException;
import com.example.l2.Organization.Organizations;
import com.example.l2.Stuff.Course;
import com.example.l2.Stuff.Stuff;
import com.example.l2.Units.Person;
import com.example.l2.Units.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.Random;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;
import static java.net.Proxy.Type.HTTP;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Stuff firstStuff = new Stuff();
//        Manager man = new Manager("Alexander");
//        File f = getFilesDir();
//        Student st = new Student(7, 2, Organizations.GloruHL, "First stud", 8, 2, 1997);
//        Student st1 = new Student(7, 2, Organizations.GloruHL, "Second stud", 8, 2, 1997);

    }

    static final int REQUEST_IMAGE_CAPTURE = 1;
/////////////////////CAMERA
    public void onClick6(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    public void buttonCameraOpen(View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            Intent Show = new Intent(this, ShowImage.class);
            Show.putExtra("img", photo);
            startActivity(Show);
        }
    }
    ///////////////////////-Camera
    public void OnClick2(View view) {
        Uri number = Uri.parse("tel:+375447395190");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    public void OnClick3(View view) {
        Uri webpage = Uri.parse("https://vk.com/d.chaley");
        Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(webIntent);
    }

    public void onClick4(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"d.chaley@mail.ru"}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message text");
        startActivity(emailIntent);
    }


    public void OnClick1(View view) {
        RadioButton RadioListener = findViewById(R.id.lis);
        RadioButton RadioStudent = findViewById(R.id.stud);
        if (RadioListener.isChecked()) {
            Intent intent = new Intent(this, NameInput.class);
            intent.putExtra("UnitType", "Listener");
            startActivity(intent);
        } else if (RadioStudent.isChecked()) {
            Intent intent = new Intent(this, NameInput.class);
            intent.putExtra("UnitType", "Student");
            startActivity(intent);
        } else {
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("Choose one plz").setPositiveButton("No problem bro", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Log.d("Log_3", "Missing argument");
                }

            });
            AlertDialog ad = b.create();
            ad.show();
        }
    }
}



