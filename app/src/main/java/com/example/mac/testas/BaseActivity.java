package com.example.mac.testas;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by mac on 17/7/29.
 */

public  abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    public  boolean isMatch=false;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initView();
    }

    public abstract void initView();

    public boolean isLogin(){
        return false;
    };

    @Override
    public void onClick(View v) {
        if (isMatch){
            if(isLogin()){

            }else{

            }
        }else{

        }
    }


}
