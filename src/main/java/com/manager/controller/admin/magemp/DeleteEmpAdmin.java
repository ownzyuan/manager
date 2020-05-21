package com.manager.controller.admin.magemp;

import com.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deleteAdmin")
public class DeleteEmpAdmin {

    @Autowired
    private AdminService adminService;

    /**
     * 通过获得到的员工id删除员工
     *  之后重定向到员工列表页面 admin/EmpList.html
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public String AdminDelete(@PathVariable("id")Integer id){
        adminService.deleteEmp(id);
        return "redirect:/managerAdmin/";
    }
}
