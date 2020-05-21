package com.manager.controller.admin;

import com.manager.pojo.Employee;
import com.manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/managerAdmin")
public class ManagerAdmin {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 前往管理员工界面
     * @param model
     * @return
     */
    @RequestMapping("/")
    public String toManager(Model model){
        List<Employee> allEmployee = employeeService.queryAllEmp();

        System.out.println(allEmployee);
        model.addAttribute("allEmployee",allEmployee);
        return "admin/magemp/EmpList";
    }

}
