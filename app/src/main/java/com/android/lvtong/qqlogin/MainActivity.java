package com.android.lvtong.qqlogin;
import	java.util.ArrayList;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //账号
    private EditText edAccount;
    //QQ头像
    private ImageView imgAvatar;
    //清空账号
    private TextView tvCleanAccount;
    //显示密码
    private TextView tvPasswordDisplay;
    //清空密码
    private TextView tvCleanPassword;
    //密码
    private EditText edPassword;
    //登录按钮
    private ImageButton btnLogin;
    //忘记密码
    private TextView tvIgnore;
    //用户注册
    private TextView tvRegister;
    //服务协议
    private TextView tvAgreement;
    private Boolean isShowPassword = false;


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
        setAccountInput();
        setPasswordInput();
        animationRotate();
    }

    private void animationRotate() {
        final RotateAnimation animation = new RotateAnimation(0.0f, 360.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration( 5000 );
        btnLogin.startAnimation( animation );
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animationRotate();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    private void findId() {
        edAccount = findViewById(R.id.ed_account);
        imgAvatar = findViewById(R.id.img_qq_avatar);
        tvCleanAccount = findViewById(R.id.clean_account);
        edPassword = findViewById(R.id.ed_password);
        tvPasswordDisplay = findViewById(R.id.display_password);
        tvCleanPassword = findViewById(R.id.clean_password);
        edPassword = findViewById(R.id.ed_password);
        btnLogin = findViewById(R.id.btn_login);
        tvIgnore = findViewById(R.id.tv_ignore);
        tvRegister = findViewById(R.id.tv_register);
        tvAgreement = findViewById(R.id.tv_agreement);
    }
    private void setOnClick(){
        edAccount.setOnClickListener(this);
        tvCleanAccount.setOnClickListener(this);
        edPassword.setOnClickListener(this);
        tvPasswordDisplay.setOnClickListener(this);
        tvCleanPassword.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        tvIgnore.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        tvAgreement.setOnClickListener(this);
    }
    private void setAccountInput(){
        edAccount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus& !TextUtils.isEmpty(edAccount.getText().toString())) {
                    tvCleanAccount.setVisibility(View.VISIBLE);
                } else {
                    tvCleanAccount.setVisibility(View.INVISIBLE);
                }
            }
        });
        edAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvCleanAccount.setVisibility(View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(edAccount.getText().toString())){
                    tvCleanAccount.setVisibility(View.INVISIBLE);
                }
                if (!TextUtils.isEmpty(edAccount.getText().toString()) & !TextUtils.isEmpty(edPassword.getText().toString())){
                    btnLogin.setEnabled(true);
                    btnLogin.setBackgroundResource(R.drawable.btn_login);
                }else {
                    btnLogin.setEnabled(false);
                    btnLogin.setBackgroundResource(R.drawable.btn_login_gray);
                }
            }
        });
    }

    private void setPasswordInput(){
        edPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    tvPasswordDisplay.setVisibility(View.VISIBLE);
                    if (TextUtils.isEmpty(edPassword.getText().toString())){
                        tvCleanPassword.setVisibility(View.INVISIBLE);
                    }else {
                        tvCleanPassword.setVisibility(View.VISIBLE);
                    }
                } else {
                    tvPasswordDisplay.setVisibility(View.INVISIBLE);
                    tvCleanPassword.setVisibility(View.INVISIBLE);
                }
            }
        });
        edPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tvCleanPassword.setVisibility(View.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(edPassword.getText().toString())){
                    tvCleanPassword.setVisibility(View.INVISIBLE);
                }
                if (!TextUtils.isEmpty(edAccount.getText().toString()) & !TextUtils.isEmpty(edPassword.getText().toString())){
                    btnLogin.setEnabled(true);
                    btnLogin.setBackgroundResource(R.drawable.btn_login);
                }else {
                    btnLogin.setEnabled(false);
                    btnLogin.setBackgroundResource(R.drawable.btn_login_gray);
                }
            }
        });
    }
    private void showBottomDialog(){
        //1、使用Dialog、设置style
        final Dialog dialog = new Dialog(this,R.style.DialogTheme);
        //2、设置布局
        View view = View.inflate(this,R.layout.dialog_ignore,null);
        dialog.setContentView(view);

        Window window = dialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.main_menu_animStyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

        dialog.findViewById(R.id.tv_retrieve_password).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent ignoreIntent = new Intent();
                ignoreIntent.setClass(MainActivity.this,IgnoreActivity.class);
                ignoreIntent.putExtra("type",getString(R.string.back_password));
               startActivity(ignoreIntent);
            }
        });

        dialog.findViewById(R.id.tv_SMS_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ignoreIntent = new Intent();
                ignoreIntent.setClass(MainActivity.this,IgnoreActivity.class);
                ignoreIntent.putExtra("type",getString(R.string.login_by_sms));
                startActivity(ignoreIntent);

            }
        });

        dialog.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.clean_account:
                edAccount.setText("");
                break;
            case R.id.display_password:
                if (isShowPassword){
                    edPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    edPassword.setSelection(edPassword.getText().length());
                    isShowPassword = false;
                }else {
                    edPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    edPassword.setSelection(edPassword.getText().length());
                    isShowPassword = true;
                }
                break;
            case R.id.clean_password:
                edPassword.setText("");
                break;
            case R.id.btn_login:
                Toast.makeText(this, "登录", Toast.LENGTH_SHORT).show();
                String account = edAccount.getText().toString();
                String password = edPassword.getText().toString();
                if (isMobile(account) & isPassword(password) & !TextUtils.isEmpty(password)){
                    Intent intent1=new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent1);
                    Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.tv_ignore:
                Toast.makeText(this, "忘记密码", Toast.LENGTH_SHORT).show();
                showBottomDialog();
                break;
            case R.id.tv_register:
                Toast.makeText(this, "注册账号", Toast.LENGTH_SHORT).show();
                Intent intent2=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent2);
                break;
            case R.id.tv_agreement:
                Intent intent3=new Intent(MainActivity.this,AgreementActivity.class);
                intent3.putExtra("type","agreement");
                startActivity(intent3);
                Toast.makeText(this, "服务协议", Toast.LENGTH_SHORT).show();
                break;
                default:

        }

    }
    //手机号在正则表达式的方法
    public static boolean isMobile(String number) {
    /*
    移动：134、135、136、137、138、139、150、151、152、157(TD)、158、159、178(新)、182、184、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、170、173、177、180、181、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String num = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[34578]"代表第二位可以为3、4、5、7、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }
    }
    //密码在正则表达式的方法
    public static boolean isPassword(String number) {

        String num = ".{6,16}";//'.' :  为产生任意字符；{6,16}：至少6位，最多16位；
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }
    }
}
