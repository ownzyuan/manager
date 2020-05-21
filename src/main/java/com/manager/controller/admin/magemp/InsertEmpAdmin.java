package com.manager.controller.admin.magemp;

import com.manager.pojo.Employee;
import com.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/insertAdmin")
public class InsertEmpAdmin {

    @Autowired
    private AdminService adminService;

    /**
     * 前往添加员工页面 admin/InsertEmp.html
     * @return
     */
    @RequestMapping("/")
    public String ToInsert(){
        return "admin/magemp/InsertEmp";
    }

    /**
     * 进行添加员工操作
     *  成功后重定向到员工列表页面 admin/EmpList.html
     * @param employee
     * @return
     */
    @PostMapping("/insert")
    public String insertEmployee(Employee employee){
        adminService.addEmp(employee);
        return "redirect:/managerAdmin/";
    }
}
