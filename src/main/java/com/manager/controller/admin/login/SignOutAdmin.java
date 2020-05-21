package com.manager.controller.admin.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signOut")
public class SignOutAdmin {

    /**
     * 注销，退回至index页面
     * @return
     */
    @RequestMapping("/")
    public String SignOut(){
        return "redirect:/index.html";
    }

}
