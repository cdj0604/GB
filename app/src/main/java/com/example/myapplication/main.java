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
    public final String key04 = "key04";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

         TextView result = (TextView) findViewById(R.id.result);
         int sum = getPreferenceInt(key02)+getPreferenceInt(key03);
         int sum1 = sum* getPreferenceInt(key01);
         int sum2 = sum1 + getPreferenceInt(key04);
        //값불러오기

        result.setText("이번달 월급 : " +""+ + sum2 + "원");
    }

    // 데이터 불러오기 함수
    public int getPreferenceInt(String key){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        return pref.getInt(key, 0);
    }
}
