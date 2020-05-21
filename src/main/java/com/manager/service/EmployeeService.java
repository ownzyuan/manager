package com.manager.service;


import com.manager.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService{

    //通过map，可以使用employee中若干属性查找对应员工
    Employee selectByAnyway(Map map);

    //更新员工资料
    int updateById(Employee employee);

    //查询全部员工
    List<Employee> queryAllEmp();
}
