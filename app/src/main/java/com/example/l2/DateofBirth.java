package com.example.l2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateofBirth extends AppCompatActivity {

    EditText day = findViewById(R.id.Textday);
    EditText mounth = findViewById(R.id.Textmounth);
    EditText year = findViewById(R.id.Textyear);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dateof_birth);
    }
    public void OnClickDate(View view)
    {
        Bundle arguments = getIntent().getExtras();
        String UnitType = arguments.get("UnitType").toString();
        String Fullname = arguments.get("Fullname").toString();

        if(UnitType=="Listener")
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
            Intent intent = new Intent(this, StudentCourse.class);
            intent.putExtra("UnitType", UnitType);
            intent.putExtra("FullName", Fullname);
            intent.putExtra("Day", day.getText().toString());
            intent.putExtra("Mounth", mounth.getText().toString());
            intent.putExtra("Year", year.getText().toString());
            startActivity(intent);
        }

    }
}
