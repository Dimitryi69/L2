package com.example.l2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.time.Year;

public class Register extends AppCompatActivity {

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
            FullName.setText(Fullname);
            Date.setText(day+"."+mounth+"."+ year);
            UnitType.setText(UnitTyper);

        }
        else if(UnitTyper.equals("Student"))
        {
            String Fullname = arguments.get("FullName").toString();
            String day = arguments.get("Day").toString();
            String mounth = arguments.get("Mounth").toString();
            String year = arguments.get("Year").toString();
            String course = arguments.get("Course").toString();
            String org = arguments.get("Org").toString();
            FullName.setText("Full Name:"+Fullname);
            Date.setText("Date of birth"+day+"."+mounth+"."+ year);
            UnitType.setText("Unit Type:"+UnitTyper);
            Course.setText(course);
            Org.setText(org);
        }
    }
}
