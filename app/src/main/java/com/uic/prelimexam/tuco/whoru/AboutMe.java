package com.uic.prelimexam.tuco.whoru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutMe extends AppCompatActivity {

    Button MenuM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);
        MenuM = (Button) findViewById(R.id.Menu);

        MenuM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {
                Intent intent = new Intent(AboutMe.this, Menu.class);
                startActivity(intent);
            }

        });
    }
}

