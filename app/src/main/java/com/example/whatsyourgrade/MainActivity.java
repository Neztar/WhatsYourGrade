package com.example.whatsyourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText getname,getscore;
    Button findG,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getname = (EditText)findViewById(R.id.editText_name);
        getscore = (EditText)findViewById(R.id.editText_score);
        findG = (Button)findViewById(R.id.button_find_grade);
        exit = (Button)findViewById(R.id.button_exit);

        findG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = "";
                int Score = 0;
                if(getname.getText().toString().trim().equalsIgnoreCase("")){getname.setError("ป้อนชื่อ");}
                if(getscore.getText().toString().trim().equalsIgnoreCase("")){getscore.setError("ป้อนคะแนน");}
                else{
                    if(getname.getText().toString().trim().equalsIgnoreCase("")){getname.setError("ป้อนชื่อ");}
                    else{
                        Name = getname.getText().toString();
                        Score = Integer.valueOf(getscore.getText().toString());
                        String grade = calGrade(Score);
                        Intent page2 = new Intent(MainActivity.this,Main2Activity.class);
                        page2.putExtra("name-value",Name);
                        page2.putExtra("grade-value",grade);
                        startActivity(page2);
                    }

                }
            }
            private String calGrade(int score){
                if(score>=80){return "A";}
                else if(score>70){return "B";}
                else if(score>60){return "C";}
                else if(score>50){return "D";}
                else{return "F";}
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog_exit = new AlertDialog.Builder(MainActivity.this);
                dialog_exit.setTitle("Confirm Exit");
                dialog_exit.setMessage("แน่ใจว่าต้องการออกจากแอพ?");
                dialog_exit.setNegativeButton("ยกเลิก",null);
                dialog_exit.setPositiveButton("ออก", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                dialog_exit.show();
            }
        });
    }
}
