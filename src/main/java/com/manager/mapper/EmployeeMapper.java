package com.manager.mapper;

import com.manager.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface EmployeeMapper{

    //通过map，可以使用employee中若干属性查找对应员工
    Employee selectByAnyway(Map map);

    //更新员工资料
    int updateById(Employee employee);

    //查询全部员工
    List<Employee> queryAllEmp();
}
