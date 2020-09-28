package com.example.l2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateofBirth extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateof_birth);
        Bundle arguments = getIntent().getExtras();
        String UnitType = arguments.get("UnitType").toString();
        String Fullname = arguments.get("Fullname").toString();
        TextView inf = findViewById(R.id.Inf);
        inf.setText("Info: "+ UnitType+", "+ Fullname);
    }
    public void OnClickDate(View view)
    {
        EditText day = findViewById(R.id.Textday);
        EditText mounth = findViewById(R.id.Textmounth);
        EditText year = findViewById(R.id.Textyear);
        Bundle arguments = getIntent().getExtras();
        String UnitType = arguments.get("UnitType").toString();
        String Fullname = arguments.get("Fullname").toString();

        if(UnitType.equals("Listener"))
        {
            Intent intent = new Intent(this, Register.class);
            intent.putExtra("UnitType", UnitType);
            intent.putExtra("FullName", Fullname);
            intent.putExtra("Day", day.getText().toString());
            intent.putExtra("Mounth", mounth.getText().toString());
            intent.putExtra("Year", year.getText().toString());
            startActivity(intent);
        }
        else
        {
            String Day = day.getText().toString();
            String Mounth = mounth.getText().toString();
            String Year = year.getText().toString();
            Intent intent = new Intent(this, StudentCourse.class);
            intent.putExtra("UnitType", UnitType);
            intent.putExtra("FullName", Fullname);
            intent.putExtra("Day", Day);
            intent.putExtra("Mounth", Mounth);
            intent.putExtra("Year", Year);
            startActivity(intent);
        }

    }
}
