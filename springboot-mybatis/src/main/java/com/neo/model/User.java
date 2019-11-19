package com.neo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final long serialVersionUID=1L;
    private long id;
    private String userName;
    private String passWord;
    private String user_sex;

    public User() {
        super();
    }

    public User(String userName, String passWord, String userSex) {
        super();
        this.passWord = passWord;
        this.userName = userName;
        this.user_sex = userSex;
    }

}
