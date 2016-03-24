package com.example.user.myapplication;

/**
 * Created by User on 23/03/2016.
 */
public class User {


    private String name;
    private String nickname;
    private String email;
    private String password;




    public User( String name,String nickname,String email,String password) {
        super();
        this.name = name;
        this.nickname = name;
        this.email = email;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
