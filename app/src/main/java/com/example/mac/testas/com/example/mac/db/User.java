package com.example.mac.testas.com.example.mac.db;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by mac on 17/7/30.
 */

@Table(name="user")
public class User {

    @Column(name = "userName",isId = true)
    private String userName;//用户名

    @Column(name = "passWord")
    private String passWord;//密码

    @Column(name = "isLogin")
    private boolean isLogin;//是否登录

    @Column(name = "salary")
    private Integer salary;//薪水

    @Column(name = "sex")
    private Integer sex;//0 男，1 女

    @Column(name = "age")
    private Integer age;//年龄

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", isLogin='" + isLogin + '\'' +
                ", salary=" + salary +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }

    public User() {
    }

    public User(String userName, String passWord, boolean isLogin, Integer salary, Integer sex, Integer age) {
        this.userName = userName;
        this.passWord = passWord;
        this.isLogin = isLogin;
        this.salary = salary;
        this.sex = sex;
        this.age = age;
    }
}
