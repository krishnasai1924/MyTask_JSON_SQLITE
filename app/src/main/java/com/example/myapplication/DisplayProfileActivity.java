package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DisplayProfileActivity extends AppCompatActivity {
    ListView listView;
    List<Pojo> pojos;
    Button ad,cart;
    String str;
    SQl_Db my;
    SQl_Db1 my1;
    byte[] image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profile);
        my = new SQl_Db(this);
        my1 = new SQl_Db1(this);
        listView = findViewById(R.id.list);

        pojos = new ArrayList<>();

        Cursor res = my.gettdata();
        if (res.getCount() == 0) {
            // show message
            // showMessage("Error","Nothing found");
            return;
        }

        // StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {

            image = res.getBlob(3);


            pojos.add(new Pojo(res.getString(0), res.getString(1), res.getString(2), image));


        }
        ListAdapter1 listAdapter = new ListAdapter1(this, pojos);
        listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(DisplayProfileActivity.this,MainActivity2.class);
        startActivity(intent);
        finish();
    }


}
