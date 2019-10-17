package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class setting extends AppCompatActivity {


    public final String PREFERENCE = "cal";
    public final String key04 = "key04";
    public final String key03 = "key03";
    public final String key02 = "key02";
    public final String key01 = "key01";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);
        final EditText inputInt1 = (EditText) findViewById(R.id.edit01);
        final EditText inputInt2 = (EditText) findViewById(R.id.edit02);
        final EditText inputInt3 = (EditText) findViewById(R.id.edit03);
        final EditText inputint4 = (EditText) findViewById(R.id.edit04);




        Button clear = (Button) findViewById(R.id.clear);
        Button nextbtn = (Button)findViewById(R.id.nextbtn);

        nextbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                setPreference(key01, Integer.parseInt(inputInt1.getText().toString()));
                setPreference(key02, Integer.parseInt(inputInt2.getText().toString()));
                setPreference(key03, Integer.parseInt(inputInt3.getText().toString()));
                setPreference(key04, Integer.parseInt(inputint4.getText().toString()));
                Intent intent = new Intent(setting.this,MainActivity.class);
                startActivity(intent);
            }


        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreferenceClear();
            }
        });
    }
    public void setPreference(String key, int value) {
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    // 데이터 한개씩 삭제하는 함수
    public void setPreferenceRemove(String key){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.remove(key);
        editor.commit();
    }
    // 모든 데이터 삭제
    public void setPreferenceClear(){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
    }

}