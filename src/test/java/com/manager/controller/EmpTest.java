package com.manager.controller;

import com.manager.mapper.EmployeeMapper;
import com.manager.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

@SpringBootTest
public class EmpTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    void selectByAnyway(){
        String name = "张三";
        String idCard = "123";
        HashMap<String,String> map = new  HashMap<>();
        map.put("name",name);
        //map.put("idCard",idCard);
        Employee employee = employeeMapper.selectByAnyway(map);
        System.out.println(employee);
    }

    @Test
    void updateById(){
        Employee employee = new Employee();
        employee.setId(3);
        employee.setAge(88);
        employee.setDepartment_name("宣传部");
        int i = employeeMapper.updateById(employee);
        if (i != 0){
            System.out.println("成功");
        }else System.out.println("失败");
    }
}
