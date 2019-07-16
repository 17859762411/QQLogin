package com.android.lvtong.qqlogin;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {
    private TextView fuwu;
    private TextView yinsi;
    private EditText et_phone;
    private EditText yaoqingma;
    private CheckBox checkBox;
    private LinearLayout hide_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setElevation(0);
            actionBar.setTitle(R.string.user_register);
        }
        init();

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    hide_layout.setVisibility(View.VISIBLE);
                } else {
                    hide_layout.setVisibility(View.GONE);
                }
            }
        });
    }

    private void init() {
        fuwu = findViewById(R.id.fuwuxieyi);
        yinsi = findViewById(R.id.yinsizhengce);
        et_phone = findViewById(R.id.telephone);
        yaoqingma = findViewById(R.id.yaoqingma);
        checkBox = findViewById(R.id.checkbox);
        hide_layout = findViewById(R.id.hide_layout);
    }
}
