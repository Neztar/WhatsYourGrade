package com.example.whatsyourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView display_name,display_grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String Name="";
        String Grade="";
        Intent intent = getIntent();
        Name = intent.getStringExtra("name-value");
        Grade = intent.getStringExtra("grade-value");

        display_name = (TextView)findViewById(R.id.text_name);
        display_grade = (TextView)findViewById(R.id.text_grade);

        display_name.setText(Name);
        display_grade.setText(Grade);
    }
}
