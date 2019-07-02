package com.android.lvtong.qqlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edAccount;
    private EditText edPassword;
    private ImageButton imgLogin;
    private TextView tvIgnore;
    private TextView tvAgreement;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //        //设置全屏
        getWindow().setFlags(flag,flag);
        findId();
        setOnClick();
    }

    private void findId() {
        edAccount = findViewById(R.id.ed_account);
        edPassword = findViewById(R.id.ed_password);
        imgLogin = findViewById(R.id.btn_login);
        tvIgnore = findViewById(R.id.tv_ignore);
        tvRegister = findViewById(R.id.tv_register);
        tvAgreement = findViewById(R.id.tv_agreement);
    }
    private void setOnClick(){
        imgLogin.setOnClickListener(this);
        tvIgnore.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvAgreement.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_login:
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.tv_ignore:
                Toast.makeText(this, "忘记密码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_register:
                Toast.makeText(this, "注册账号", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_agreement:
                Toast.makeText(this, "服务协议", Toast.LENGTH_SHORT).show();
                break;
                default:

        }

    }
}
