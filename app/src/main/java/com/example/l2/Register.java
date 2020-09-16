package com.example.l2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.l2.Exception.EduException;
import com.example.l2.Stuff.Stuff;
import com.example.l2.Units.Listener;
import com.example.l2.Units.Person;
import com.example.l2.Units.Student;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;

public class Register extends AppCompatActivity {

    final String TAG ="Activity";
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "MainActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "MainActivity: onStop()");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Bundle arguments = getIntent().getExtras();
        String UnitTyper = arguments.get("UnitType").toString();
        TextView FullName = findViewById(R.id.name);
        TextView Date = findViewById(R.id.DOB);
        TextView UnitType = findViewById(R.id.Unit);
        TextView Course = findViewById(R.id.Textcourse);
        TextView Org = findViewById(R.id.textorg);
        if(UnitTyper.equals("Listener"))
        {
            String Fullname = arguments.get("FullName").toString();
            String day = arguments.get("Day").toString();
            String mounth = arguments.get("Mounth").toString();
            String year = arguments.get("Year").toString();
            FullName.setText("Full Name: "+Fullname);
            Date.setText("Date of birth: "+day+"."+mounth+"."+ year);
            UnitType.setText("Unit Type: "+UnitTyper);
            Course.setText("Course: Only for students");
            Org.setText("Organization: Only for Students");

        }
        else if(UnitTyper.equals("Student"))
        {
            String Fullname = arguments.get("FullName").toString();
            String day = arguments.get("Day").toString();
            String mounth = arguments.get("Mounth").toString();
            String year = arguments.get("Year").toString();
            String course = arguments.get("Course").toString();
            String org = arguments.get("Org").toString();
            FullName.setText("Full Name: "+Fullname);
            Date.setText("Date of birth: "+day+"."+mounth+"."+ year);
            UnitType.setText("Unit Type: "+UnitTyper);
            Course.setText("Course: "+course);
            Org.setText("Organization: "+org);
        }
    }
    public void Save(View view) {
        CheckBox check = findViewById(R.id.yes);
        CheckBox check1 = findViewById(R.id.yes2);
        if (check.isChecked() || check1.isChecked())
        {
            Bundle arguments = getIntent().getExtras();
        String UnitTyper = arguments.get("UnitType").toString();
        TextView FullName = findViewById(R.id.name);
        TextView Date = findViewById(R.id.DOB);
        TextView UnitType = findViewById(R.id.Unit);
        TextView Course = findViewById(R.id.Textcourse);
        TextView Org = findViewById(R.id.textorg);
        String Fullname = arguments.get("FullName").toString();
        String day = arguments.get("Day").toString();
        String mounth = arguments.get("Mounth").toString();
        String year = arguments.get("Year").toString();
        String course = arguments.get("Course").toString();
        String org = arguments.get("Org").toString();

        if (UnitTyper.equals("Student")) {
            Student stud = new Student();
            stud.Course = Integer.parseInt(course);
            stud.Year = Integer.parseInt(year);
            stud.Day = Integer.parseInt(day);
            stud.Mounth = Integer.parseInt(mounth);
            stud.FullName = Fullname;
            stud.org = org;
            File f = getFilesDir();
            try {
                saveStudentsJson(stud, f);
            } catch (EduException e) {
            }
        } else {
            Listener listener = new Listener();
            listener.Year = Integer.parseInt(year);
            listener.Day = Integer.parseInt(day);
            listener.Mounth = Integer.parseInt(mounth);
            listener.FullName = Fullname;
            File f = getFilesDir();
            try {
                saveStudentsJson(listener, f);
            } catch (EduException e) {
            }
        }
    }
        else
        {
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("Choose one plz").setPositiveButton("No problem bro", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Log.d("Log_3","You must choose at least one variant");
                }

            });
            AlertDialog ad = b.create();
            ad.show();
        }

    }
    public void saveStudentsJson(Person p, File path) throws EduException {
        Gson gson = new Gson();
        File file = new File(path,"Person.json");
        try {
            try(FileWriter writer = new FileWriter(file,false)){
                writer.write(gson.toJson(p));
            }
        } catch (IOException e) {
            Log.d("Serial",e.getMessage());
        }
        System.out.println(file.exists());
    }
}
