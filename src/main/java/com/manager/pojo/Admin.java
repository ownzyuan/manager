package com.manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    //主键，自增
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //权限
    private String perms;
}
