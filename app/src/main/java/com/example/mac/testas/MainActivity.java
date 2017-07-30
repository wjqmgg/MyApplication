package com.example.mac.testas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mac.testas.com.example.mac.db.User;
import com.xrz.test.R;

import org.xutils.db.sqlite.WhereBuilder;
import org.xutils.ex.DbException;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;


@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity{

    @ViewInject(R.id.tv1)
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }


    @Event(value = {R.id.tv1,R.id.tv2,R.id.tv3},type = View.OnClickListener.class)
    private void  getEvent(View v) throws DbException {
        switch (v.getId()){
            case R.id.tv1:
                 User user=new User("a","123",false,5000,0,20);
                 x.getDb(BaseApplication.getInstance().getDbConfig()).saveOrUpdate(user);
                 Log.e("wj","save");
                break;
            case R.id.tv2:
                List<User> list=x.getDb(BaseApplication.getInstance().getDbConfig()).selector(User.class).where("userName","=","a").findAll();
                for (User u:list) {
                    Log.e("wj",u.toString());
                }
                break;
            case R.id.tv3:
                x.getDb(BaseApplication.getInstance().getDbConfig()).delete(User.class, WhereBuilder.b("userName","=","a"));
                Log.e("wj","delete");
                break;
        }
    }
}
