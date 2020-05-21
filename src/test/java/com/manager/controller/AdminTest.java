package com.manager.controller;

import com.manager.mapper.AdminMapper;
import com.manager.pojo.Admin;
import com.manager.pojo.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminTest {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    void insertAdmin(){
        Admin admin = new Admin();
        admin.setUsername("admin1");
        admin.setPassword("1234");
        adminMapper.insertAdmin(admin);
    }

    @Test
    void addEmp(){
        Employee employee = new Employee();
        employee.setAge(32);
        employee.setGender(2);
        employee.setName("啦啦");
        employee.setId_card("213214");
        int i = adminMapper.addEmp(employee);
    }
}
