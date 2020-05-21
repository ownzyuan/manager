package com.manager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    //主键，自增
    private Integer id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //性别，0男 1女
    private Integer gender;
    //生日
    private Date birth;
    //身份证
    private String id_card;
    //部门名
    private String department_name;

}
