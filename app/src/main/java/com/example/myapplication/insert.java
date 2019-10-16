package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class insert extends AppCompatActivity {


    public final String PREFERENCE = "com.studio572.samplesharepreference";
    public final String key01 = "key01";
    public final String key02 = "key02";
    public final String key03 = "key03";
    public final String key04 = "key04";
    public final String key05 = "key05";
    private boolean isBoolean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result = (TextView) findViewById(R.id.result);

        final EditText inputString = (EditText) findViewById(R.id.edit01);
        final Button inputBooleanTrue = (Button) findViewById(R.id.edit02_1);
        final Button inputBooleanFalse = (Button) findViewById(R.id.edit02_2);
        final EditText inputInt = (EditText) findViewById(R.id.edit03);
        final EditText inputFlaot = (EditText) findViewById(R.id.edit04);
        final EditText inputLong = (EditText) findViewById(R.id.edit05);

        Button saveString = (Button) findViewById(R.id.save01);
        Button saveBoolean = (Button) findViewById(R.id.save02);
        Button saveInt = (Button) findViewById(R.id.save03);
        Button saveFloat = (Button) findViewById(R.id.save04);
        Button saveLong = (Button) findViewById(R.id.save05);

        Button loadString = (Button) findViewById(R.id.load01);
        Button loadBoolean = (Button) findViewById(R.id.load02);
        Button loadInt = (Button) findViewById(R.id.load03);
        Button loadFloat = (Button) findViewById(R.id.load04);
        Button loadLong = (Button) findViewById(R.id.load05);

        Button clear = (Button) findViewById(R.id.clear);

        inputBooleanTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isBoolean = true;
            }
        });
        inputBooleanFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isBoolean = false;
            }
        });

        saveString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreference(key01, inputString.getText().toString());
            }
        });
        saveBoolean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreference(key02, isBoolean);
            }
        });
        saveInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreference(key03, Integer.parseInt(inputInt.getText().toString()));
            }
        });
        saveFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreference(key04, Float.parseFloat(inputFlaot.getText().toString()));
            }
        });
        saveLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreference(key05, Long.parseLong(inputLong.getText().toString()));
            }
        });

        loadString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("String: " + getPreferenceString(key01));
            }
        });
        loadBoolean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Boolean: " + getPreferenceBoolean(key02));
            }
        });
        loadInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Int: " + getPreferenceInt(key03));
            }
        });
        loadFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Float: " + getPreferenceFloat(key04));
            }
        });
        loadLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText("Long: " + getPreferenceLong(key05));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPreferenceClear();
            }
        });
    }


    // 데이터 저장 함수
    public void setPreference(String key, boolean value){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
    public void setPreference(String key, String value){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.commit();
    }
    public void setPreference(String key, int value){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.commit();
    }
    public void setPreference(String key, float value){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public void setPreference(String key, long value){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(key, value);
        editor.commit();
    }


    // 데이터 불러오기 함수
    public boolean getPreferenceBoolean(String key){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        return pref.getBoolean(key, false);
    }
    public String getPreferenceString(String key){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        return pref.getString(key, "");
    }
    public int getPreferenceInt(String key){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        return pref.getInt(key, 0);
    }
    public float getPreferenceFloat(String key){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        return pref.getFloat(key, 0f);
    }
    public long getPreferenceLong(String key){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        return pref.getLong(key, 0l);
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