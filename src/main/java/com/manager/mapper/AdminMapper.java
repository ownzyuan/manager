package com.manager.mapper;

import com.manager.pojo.Admin;
import com.manager.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminMapper {

    //通过用户名查询到相应管理员
    Admin selectUsername(String username);

    //添加管理员
    int insertAdmin(Admin admin);

    //管理员工：添加
    int addEmp(Employee employee);

    //管理员工：通过id查找到对应员工
    Employee getEmpById(int id);

    //管理员工：修改
    int updateEmp(Employee employee);

    //管理员工：删除
    int deleteEmp(int id);

}
