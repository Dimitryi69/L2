package com.example.l2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class StudentCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_course);
        final Spinner spinner = findViewById(R.id.Textcourse);
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        Bundle arguments = getIntent().getExtras();
        String UnitType = arguments.get("UnitType").toString();
        String Fullname = arguments.get("FullName").toString();
        String day = arguments.get("Day").toString();
        String mounth = arguments.get("Mounth").toString();
        String year = arguments.get("Year").toString();
        String date = day+"."+mounth+"."+year;
        TextView inf = findViewById(R.id.Inf);
        inf.setText("Info: "+ UnitType+", "+ Fullname+ ", "+date);
    }
    public void OnClickCourse(View view)
    {
        Spinner sp = (Spinner) findViewById(R.id.Textcourse);
        String result = "";
        result = sp.getSelectedItem().toString();
        if(result != "" && result != null) {

            Bundle arguments = getIntent().getExtras();
            String UnitType = arguments.get("UnitType").toString();
            String Fullname = arguments.get("FullName").toString();
            String day = arguments.get("Day").toString();
            String mounth = arguments.get("Mounth").toString();
            String year = arguments.get("Year").toString();
            Intent intent = new Intent(this, StudentOrg.class);
            intent.putExtra("UnitType", UnitType);
            intent.putExtra("FullName", Fullname);
            intent.putExtra("Day", day);
            intent.putExtra("Mounth", mounth);
            intent.putExtra("Year", year);
            intent.putExtra("Course", result);
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
