package com.manager.controller.admin.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/loginAdmin")
/**
 * 管理员登录控制
 */
public class LoginAdmin {

    /**
     * 管理员登录，使用Shiro进行验证
     * @param username
     * @param password
     * @param model
     * @param httpSession
     * @return
     */
    @PostMapping("/login")
    public String ApplyLogin(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             Model model, HttpSession httpSession) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            httpSession.setAttribute("loginAdmin", username);

            return "redirect:/AdminMain.html";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在，请注册成为管理员");
            return "index";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "index";
        }

    }


}
