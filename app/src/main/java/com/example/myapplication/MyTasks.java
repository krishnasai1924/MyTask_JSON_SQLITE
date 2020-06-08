package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyTasks extends AppCompatActivity {

    Button bt_task1,bt_task2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tasks);

        bt_task1=findViewById(R.id.bt_task1);
        bt_task2=findViewById(R.id.bt_task2);

        bt_task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyTasks.this,MainActivity.class));
                finish();
            }
        });

        bt_task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyTasks.this,MainActivity2.class));
                finish();
            }
        });

    }
}