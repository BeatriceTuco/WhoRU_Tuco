package com.uic.prelimexam.tuco.whoru;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    Button button_testAgain;
    ListView listView_report;

    ArrayList<String> listData;
    ListAdapter adapter;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        listView_report = (ListView) findViewById(R.id.listView_report);
        databaseHelper = new DatabaseHelper(this);

        button_testAgain = (Button) findViewById(R.id.button_testAgain);
        button_testAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WhoRU.currentQuestion = 0;
                startActivity(new Intent(ResultActivity.this, Main.class));
            }
        });

        populateListView();
    }

    public void populateListView(){
        listData = new ArrayList<>();

        Cursor data = databaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            listData.add(data.getString(2) + " - " + data.getString(1));
        }
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        listView_report.setAdapter(adapter);


    }
}

