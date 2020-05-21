package com.manager.service.impl;

import com.manager.mapper.AdminMapper;
import com.manager.pojo.Admin;
import com.manager.pojo.Employee;
import com.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 通过用户名查询到相应管理员
     * @param username
     * @return
     */
    @Override
    public Admin selectUsername(String username) {
        return adminMapper.selectUsername(username);
    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insertAdmin(admin);
    }

    /**
     * 管理员工：添加
     * @param employee
     * @return
     */
    @Override
    public int addEmp(Employee employee) {
        return adminMapper.addEmp(employee);
    }

    /**
     * 管理员工：通过id查找到对应员工
     * @param id
     * @return
     */
    @Override
    public Employee getEmpById(int id) {
        return adminMapper.getEmpById(id);
    }

    /**
     * 管理员工：修改
     * @param employee
     * @return
     */
    @Override
    public int updateEmp(Employee employee) {
        return adminMapper.updateEmp(employee);
    }

    /**
     * 管理员工：删除
     * @param id
     * @return
     */
    @Override
    public int deleteEmp(int id) {
        return adminMapper.deleteEmp(id);
    }
}
