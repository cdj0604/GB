package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class main extends AppCompatActivity {
    public final String PREFERENCE = "cal";
    public final String key01 = "key01";
    public final String key02 = "key02";
    public final String key03 = "key03";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final TextView result = (TextView) findViewById(R.id.result);
        final int sum = (getPreferenceInt(key02)+getPreferenceInt(key03)) * getPreferenceInt(key01);
        //값불러오기

        result.setText("이번달 월급 : " +""+ + sum + "원");
    }

    // 데이터 불러오기 함수
    public int getPreferenceInt(String key){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        return pref.getInt(key, 0);
    }
}
