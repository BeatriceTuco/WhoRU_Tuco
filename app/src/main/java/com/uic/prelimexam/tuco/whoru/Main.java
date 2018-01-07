package com.uic.prelimexam.tuco.whoru;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    Button button_start, button_Result, MenuM;;
    EditText editText_username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MenuM = (Button) findViewById(R.id.Menu);
        button_Result = (Button) findViewById(R.id.button_result);
        editText_username = (EditText) findViewById(R.id.editText_username);
        editText_username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {  }

            @Override
            public void afterTextChanged(Editable editable) {  }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()>1){
                    button_start.setEnabled(true);
                }
            }
        });

        button_start = (Button) findViewById(R.id.button_start);
        button_start.setEnabled(false);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uicSetSharedPreferenceValue("userInfo", "username", editText_username.getText().toString());
                startActivity(new Intent(Main.this, WhoRUActivity.class));
            }
        });


        button_Result.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {
                Intent intent = new Intent(Main.this, ResultActivity.class);
                startActivity(intent);
            }

        });


        MenuM.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg) {
                Intent intent = new Intent(Main.this, Menu.class);
                startActivity(intent);
            }

        });

        if(uicGetSharedPreferenceValue("userInfo", "username").isEmpty()){
            button_start.setEnabled(false);
        }

    }

    public void uicToastMessage(String message){
        Toast.makeText(this, message ,Toast.LENGTH_SHORT).show();
    }

    public void uicSetSharedPreferenceValue(String sharedPrefName, String key, String value){
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String uicGetSharedPreferenceValue(String sharedPrefName, String key){
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE);
        String value = sharedPreferences.getString(key, "");
        return value;
    }
}

