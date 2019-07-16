package com.android.lvtong.qqlogin;

import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView fuwu;
    private TextView yinsi;
    private TextView countries;
    private EditText et_phone;
    private EditText yaoqingma;
    private CheckBox checkBox;
    private LinearLayout hide_layout;

    private String[] items;

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
        items = this.getResources().getStringArray(R.array.dialog_countries_num);
        countries.setOnClickListener(this);
    }

    private void init() {
        fuwu = findViewById(R.id.fuwuxieyi);
        yinsi = findViewById(R.id.yinsizhengce);
        countries = findViewById(R.id.textView9);
        et_phone = findViewById(R.id.telephone);
        yaoqingma = findViewById(R.id.yaoqingma);
        checkBox = findViewById(R.id.checkbox);
        hide_layout = findViewById(R.id.hide_layout);
    }

    @Override
    public void onClick(View v) {
        switch ((v.getId())){
            case R.id.textView9:
                showDialogCountries();
                default:
        }
    }

    private void showDialogCountries() {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
        builder.setTitle("选择国家和地区");
        builder.setItems(R.array.dialog_countries, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                countries.setText(items[which] + "∨");
                Toast.makeText(RegisterActivity.this, "clicked:" + which, Toast.LENGTH_LONG).show();
            }
        });
        builder.create();
        builder.show();
    }
}
