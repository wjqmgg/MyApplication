package com.example.mac.testas;

import android.app.Application;
import android.os.Environment;

import com.xrz.test.R;

import org.xutils.DbManager;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.io.File;
import java.io.IOException;

/**
 * Created by mac on 17/7/30.
 */

public class BaseApplication extends Application {


    private  static BaseApplication baseApplication=null;
    private ImageOptions imageOptions;
    private DbManager.DaoConfig dbConfig;

    @Override
    public void onCreate() {
        super.onCreate();


        x.Ext.init(this);
        initImageOption();
        initDB();


        baseApplication=this;
    }

    public static BaseApplication getInstance(){

        return baseApplication;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        try {
            x.getDb(dbConfig).close();
            baseApplication=null;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initImageOption(){
        imageOptions=new ImageOptions.Builder()
                //设置加载过程中的图片
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                //设置加载失败后的图片
                .setFailureDrawableId(R.mipmap.ic_launcher)
                //设置使用缓存
                .setUseMemCache(true)
                //设置显示圆形图片
                .setCircular(true)
                //设置支持gif
                .setIgnoreGif(false)
                .build();
    }

    private void initDB(){
        File file=new File(Environment.getExternalStorageDirectory().getPath()+"/"+getPackageName());

        dbConfig=new DbManager.DaoConfig()
                    .setDbName("my.db")
                    .setDbDir(file)
                    .setDbVersion(1)
                    .setAllowTransaction(true)
                    .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                        @Override
                        public void onUpgrade(DbManager db, int oldVersion, int newVersion) {

                        }

                    });
    }

    public ImageOptions getImageOptions() {
        return imageOptions;
    }

    public DbManager.DaoConfig getDbConfig() {
        return dbConfig;
    }
}
