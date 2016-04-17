package com.example.a.who;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText E_usename,E_pasword;
    private Button B_deng;
    private SharedPreferences mySharedPreferences;//定义SharedPreferences对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        B_deng= (Button) findViewById(R.id.D_deng);
        E_pasword= (EditText) findViewById(R.id.E_pasword);
        E_usename= (EditText) findViewById(R.id.E_usename);
        //获得一个SharedPreferences对象
        mySharedPreferences=getSharedPreferences("SETTING_INFOS",0);
        //取出保存的数据
        String useNameStr=mySharedPreferences.getString("E_usename","");
        String pasWordStr=mySharedPreferences.getString("E_pasword","");
        E_usename.setText(useNameStr);
        E_pasword.setText(pasWordStr);
        B_deng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mySharedPreferences=getSharedPreferences("SETTING_INFOS",0);
        //使SharedPreferences处于编辑状态
        SharedPreferences.Editor editor=mySharedPreferences.edit();
        editor.putString("pasword",E_pasword.getText().toString())
                .putString("usename", E_usename.getText().toString());
        //使用commit方法提交修改的数据
        editor.commit();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("登录成功").setPositiveButton("确定",null).show();
    }


   /* //系统通知暂停，可以保存设置
    @Override
    protected void onStop()
    {
        super.onStop();
        mySharedPreferences=getSharedPreferences("SETTING_INFOS",0);
        //使SharedPreferences处于编辑状态
        SharedPreferences.Editor editor=mySharedPreferences.edit();
        editor.putStrinug("pasword",E_pasword.getText().toString())
                .putString("usename", E_usename.getText().toString());
        //使用commit方法提交修改的数据
        editor.commit();
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("登录成功").setPositiveButton("确定",null).show();
    }*/
}
