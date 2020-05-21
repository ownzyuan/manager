package com.manager.controller.emp;

import com.manager.pojo.Employee;
import com.manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/loginEmp")
/**
 * 员工登录跳转控制
 */
public class LoginEmp {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 跳转页面到员工登录页面 emp/EmployeeLogin.html
     * @return
     */
    @RequestMapping("/")
    public String goEmployeeLogin(){
        return "emp/EmployeeLogin";
    }

    /**
     * 员工登录验证
     * @param name
     * @param idCard
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String employeeLogin(@RequestParam("name") String name,
                                @RequestParam("idCard") String idCard,
                                Model model, HttpSession session){

        HashMap<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("idCard",idCard);
        Employee employee = employeeService.selectByAnyway(map);
        if (employee != null){
            session.setAttribute("login",name);
            model.addAttribute("employees",employee);
            return "emp/EmployeeList";
        }else {
            model.addAttribute("msg","员工不存在或身份证不正确");
            return "emp/EmployeeLogin";
        }

    }
}
