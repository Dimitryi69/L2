package com.example.l2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.lang.reflect.Array;

public class StudentCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_course);
        final Spinner spinner = findViewById(R.id.spinner2);
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.courses, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }
}
