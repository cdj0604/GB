package com.example.myapplication;


import android.app.TabActivity;
import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;


import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity{ // 상속이 TabActivity이다. 주의할 것!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //첫번째 탭 만들기
        TabHost tabHost = getTabHost();
        TabHost.TabSpec spec;
        Intent intent = new Intent().setClass(this, main.class);

        spec = tabHost.newTabSpec("main").setIndicator("1").setContent(intent);
        tabHost.addTab(spec);

        //두번째 탭 만들기
         intent = new Intent().setClass(this, icebox.class);

        spec = tabHost.newTabSpec("icebox").setIndicator("2").setContent(intent);
        tabHost.addTab(spec);


        //세번째 탭 만들기
        intent = new Intent().setClass(this,myinfor.class);

        spec = tabHost.newTabSpec("myinfor").setIndicator("3").setContent(intent);
        tabHost.addTab(spec);

        //네번째 탭 만들기
        intent = new Intent().setClass(this,setting.class);

        spec = tabHost.newTabSpec("setting").setIndicator("설정").setContent(intent);
        tabHost.addTab(spec);

        //처음 앱 실행시 탭 활성화 지정하기
        tabHost.setCurrentTab(0);


    }
}