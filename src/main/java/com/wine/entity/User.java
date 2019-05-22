package com.wine.entity;

import lombok.Data;
import lombok.ToString;

/**
 * Created by Administrator on 2019/5/4 0004.
 */
@Data
@ToString
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String phone;
    private Integer type;
    private Integer flag;
    private String email;
    private Integer sex;
    private String password;
    private String pname;
    private String qq;
    private String address;
}
