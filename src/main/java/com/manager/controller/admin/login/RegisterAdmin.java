package com.manager.controller.admin.login;

import com.manager.pojo.Admin;
import com.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/regAdmin")
/**
 * 管理员注册控制
 */
public class RegisterAdmin {

    @Autowired
    private AdminService adminService;

    /**
     * 跳转到管理员注册页面
     * @return
     */
    @RequestMapping("/goReg")
    public String goAdminRegister(){
        return "admin/AdminRegister";
    }

    /**
     * 进行管理员注册，只需要填写用户名，密码
     * @param username
     * @param password
     * @param model
     * @param admin
     * @return
     */
    @PostMapping("/register")
    public String AdminRegister(@RequestParam("username")String username,
                                @RequestParam("password")String password,
                                Model model, Admin admin){
        //用户名不存在就可以注册
        if (adminService.selectUsername(username)==null){
            admin.setUsername(username);
            admin.setPassword(password);
            adminService.insertAdmin(admin);
            return "redirect:/index.html";
        }else {
            //用户名存在
            model.addAttribute("msg","用户名已存在");
            return "admin/AdminRegister";
        }
    }
}
