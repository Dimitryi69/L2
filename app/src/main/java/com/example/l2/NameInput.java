package com.example.l2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NameInput extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

    }

    public void OnClickname(View view)
    {
        EditText ename = findViewById(R.id.Textname);
        EditText esurname = findViewById(R.id.Textsurname);
        EditText ethirdname = findViewById(R.id.Textthird);
        Intent intent = new Intent(this, DateofBirth.class);
        String FullName = esurname.getText().toString()+" "+ename.getText().toString()+" "+ethirdname.getText().toString();
        intent.putExtra("Fullname", FullName);
        Bundle arguments = getIntent().getExtras();
        String UnitType = arguments.get("UnitType").toString();
        intent.putExtra("UnitType", UnitType);
        startActivity(intent);
    }
}
