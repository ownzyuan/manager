package com.manager.service.impl;

import com.manager.mapper.EmployeeMapper;
import com.manager.pojo.Employee;
import com.manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 通过map，可以使用employee中若干属性查找对应员工
     * @param map
     * @return
     */
    @Override
    public Employee selectByAnyway(Map map) {
        return employeeMapper.selectByAnyway(map);
    }

    /**
     * 更新员工资料
     * @param employee
     * @return
     */
    @Override
    public int updateById(Employee employee) {
        return employeeMapper.updateById(employee);
    }

    /**
     * 查询全部员工
     * @return
     */
    @Override
    public List<Employee> queryAllEmp() {
        return employeeMapper.queryAllEmp();
    }
}
