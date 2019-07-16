package com.android.lvtong.qqlogin;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IgnoreActivity extends AppCompatActivity {

    private TextView tv;

    private final static String TYPE = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ignore);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setElevation(0);
            actionBar.setTitle(R.string.ignore_password);
        }

        init();
        getInformationFromIntent();

    }

    private void init() {
        tv = findViewById(R.id.textView2);
    }

    private void getInformationFromIntent() {
        Intent intent = getIntent();
        String string = intent.getStringExtra("type");
        tv.setText(string);
    }
}
