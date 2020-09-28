package com.example.l2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.l2.EducationManager.Manager;
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

    Manager m;
    Stuff stuff;

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

        m = new Manager("Manager");
        stuff = new Stuff();
    }
    public void Save(View view) {
        CheckBox check = findViewById(R.id.yes);
        CheckBox check1 = findViewById(R.id.yes2);
        Bundle arguments = getIntent().getExtras();
        String UnitTyper = arguments.get("UnitType").toString();
        if (check.isChecked() || check1.isChecked())
        {
            File f = new File(getFilesDir(),"Students.txt") ;
            File f1 = new File(getFilesDir(),"Listeners.txt") ;
            try {
                if (f.createNewFile())
                    System.out.println("File created");
                else
                    System.out.println("File already exists");
                if (f1.createNewFile())
                    System.out.println("File created");
                else
                    System.out.println("File already exists");
                stuff = m.createCourse(getFilesDir());
            }
            catch (IOException e)
            {
            }
            catch (EduException e)
            {
            }

        if (UnitTyper.equals("Student")) {
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
            Student stud = new Student();
            stud.UnitType="Student";
            stud.Course = Integer.parseInt(course);
            stud.Year = Integer.parseInt(year);
            stud.Day = Integer.parseInt(day);
            stud.Mounth = Integer.parseInt(mounth);
            stud.FullName = Fullname;
            stud.org = org;

            try {
                stuff.add(new Student(0, Integer.parseInt(course), org, Fullname, Integer.parseInt(day), Integer.parseInt(mounth),Integer.parseInt(year)));
                m.save(stuff, getFilesDir());
            } catch (EduException e) {
            }

        } else {
            TextView FullName = findViewById(R.id.name);
            TextView Date = findViewById(R.id.DOB);
            TextView UnitType = findViewById(R.id.Unit);
            String Fullname = arguments.get("FullName").toString();
            String day = arguments.get("Day").toString();
            String mounth = arguments.get("Mounth").toString();
            String year = arguments.get("Year").toString();
            Listener listener = new Listener();
            listener.UnitType = "Listener";
            listener.Year = Integer.parseInt(year);
            listener.Day = Integer.parseInt(day);
            listener.Mounth = Integer.parseInt(mounth);
            listener.FullName = Fullname;


            try {
                stuff.add(new Listener(0, 0, "Listener", Fullname, Integer.parseInt(day), Integer.parseInt(mounth), Integer.parseInt(year)));
                m.save(stuff, getFilesDir());
            } catch (EduException e) {
            }

        }
            TextView t = findViewById(R.id.Inf);
            t.setText("Info: "+ stuff.toString());
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
}
