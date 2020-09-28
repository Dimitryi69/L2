package com.example.l2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NameInput extends AppCompatActivity {


    String n = "undefined";
    final static String Namevarkey = "NAME_VARIABLE";
    final static String TextNamevarkey = "TEXT_VIEW";

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        outState.putString(Namevarkey, n);
        EditText NameView = findViewById(R.id.Textname);
        outState.putString(TextNamevarkey, NameView.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        n = savedInstanceState.getString(TextNamevarkey);
        String textTextView = savedInstanceState.getString(Namevarkey);
        EditText e = findViewById(R.id.Textname);
        e.setText(textTextView);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);
        Bundle arguments = getIntent().getExtras();
        String UnitType = arguments.get("UnitType").toString();
        TextView inf = findViewById(R.id.Inf);
        inf.setText("Info: "+ UnitType);
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
