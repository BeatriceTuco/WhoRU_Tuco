package com.uic.prelimexam.tuco.whoru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button button_WhoRUU, button_AboutMeM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        button_AboutMeM = (Button) findViewById(R.id.button_AboutMe2);
        button_WhoRUU = (Button) findViewById(R.id.button_WhoRU);

        button_AboutMeM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {
                Intent intent = new Intent(Menu.this, AboutMe.class);
                startActivity(intent);
            }

        });
        button_WhoRUU.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {
                Intent intent = new Intent(Menu.this, Main.class);
                startActivity(intent);
            }

        });
    }
}
