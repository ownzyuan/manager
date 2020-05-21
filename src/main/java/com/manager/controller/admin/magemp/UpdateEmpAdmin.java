package com.manager.controller.admin.magemp;

import com.manager.pojo.Employee;
import com.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/updateAdmin")
public class UpdateEmpAdmin {

    @Autowired
    private AdminService adminService;

    /**
     * 获取到待修改员工id后
     *  跳转到员工信息修改页面 admin/UpdateEmp.html
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/{id}")
    public String AdminUpdate(@PathVariable("id")Integer id, Model model){
        Employee employee_update = adminService.getEmpById(id);
        model.addAttribute("employee_update",employee_update);
        return "admin/magemp/UpdateEmp";
    }

    /**
     * 修改员工信息成功之后
     *  重定向到员工列表页面 admin/EmpList.html
     * @param employee
     * @return
     */
    @PostMapping("/update")
    public String AdminUpdateEmployee(Employee employee){
        adminService.updateEmp(employee);
        return "redirect:/managerAdmin/";
    }
}
