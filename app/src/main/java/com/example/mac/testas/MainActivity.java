package com.example.mac.testas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;
import com.xrz.test.R;


@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity{

    @ViewInject(R.id.tv1)
    private TextView tv1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        tv1.setText("aaaa");


    }


}
