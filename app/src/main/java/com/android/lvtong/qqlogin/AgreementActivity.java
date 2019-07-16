package com.android.lvtong.qqlogin;
import	java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import	java.io.Reader;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class AgreementActivity extends AppCompatActivity {

    private TextView tvAgreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setElevation(0);
            actionBar.setTitle(R.string.service_agreement);
        }
        String string = "";
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        switch (type){
            case "agreement":
                string = getString(R.string.text_agreement);
                break;
            case "yinsi":
                string = getString(R.string.text_yinsi);
                break;
                default:
        }
        tvAgreement = findViewById(R.id.text_agreement);
        tvAgreement.setText(string);


    }

}
