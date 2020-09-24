package com.example.l2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.l2.EducationManager.IAction;
import com.example.l2.EducationManager.Manager;
import com.example.l2.Exception.EduException;
import com.example.l2.Stuff.Course;
import com.example.l2.Stuff.Stuff;
import com.example.l2.Units.Person;
import com.example.l2.Units.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stuff firstStuff = new Stuff();
        Manager man = new Manager("Alexander");
        try {
            firstStuff = man.generate(15, 15, 2);
            firstStuff.toString();
        } catch (EduException e) {
            e.printStackTrace();
        }
        man.Version(firstStuff);
        File f = getFilesDir();
        try
        {
            man.save(firstStuff, f);
            firstStuff.studlist = new ArrayList<Person>();
            Log.d("studlist: ", "Size: "+ firstStuff.studlist.size());
            firstStuff = man.createCourse(f);
            firstStuff.toString();
            Log.d("Inf","---------------------------------------------------------------");
            firstStuff.studlist = man.bubbleSort(firstStuff.studlist);
            firstStuff.toString();

        }
        catch (EduException e) {
            e.printStackTrace();
        }
        ////////Optional---------------------
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        Log.d("Optional empty: ", "OrElse: "+min.orElse(-1));
        numbers.addAll(Arrays.asList(new Integer[]{4,5,6,7,8,9}));
        min = numbers.stream().min(Integer::compare);
        Log.d("Optional empty: ", "OrElse: "+min.orElse(-1));

        numbers = new ArrayList<Integer>();
        min = numbers.stream().min(Integer::compare);
        Random rnd = new Random();
        Log.d("Optional: ", "OrElseGet: "+min.orElseGet(()->rnd.nextInt(100)));
    }

    public void OnClick1(View view)
    {
        RadioButton RadioListener = findViewById(R.id.lis);
        RadioButton RadioStudent = findViewById(R.id.stud);
        if(RadioListener.isChecked())
        {
            Intent intent = new Intent(this, NameInput.class);
            intent.putExtra("UnitType", "Listener");
            startActivity(intent);
        }
        else if(RadioStudent.isChecked())
        {
            Intent intent = new Intent(this, NameInput.class);
            intent.putExtra("UnitType", "Student");
            startActivity(intent);
        }
        else
        {
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("Choose one plz").setPositiveButton("No problem bro", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("Log_3","Missing argument");
            }

            });
            AlertDialog ad = b.create();
            ad.show();
        }
    }
}



